package Controller.Sells;

import Model.CurrentUser;
import Model.DB.DAO.Inventario.InventarioSucursalDAO;
import Model.DB.DAO.Inventario.SearchFilters;
import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jefe_mayoneso
 */
public final class SellsSearchController {

    private final VentaJDialog view;
    private final SellsModel model;
    private int limit;
    private int offset;

    /**
     * Constructor que inicializa el modelo y la vista, como hace uso de objetos, entonces cualquier cambio es reflejado al origen pues usa punteros
     *
     * @param view  donde se muestran los resultados
     * @param model contiene los datos manipulables para la vista
     */
    public SellsSearchController(VentaJDialog view, SellsModel model) {
        this.view = view;
        this.model = model;
        resetParameters();
    }

    /**
     * Busca elementos y los despliega en la vista
     *
     * @param sellsTableDisplayerController controlador de ventas para ejecutar sus metodos
     * @param reset                true si se desea reiniciar el limit y offset de las sentencias SQL
     */
    public void search(SellsTableDisplayer sellsTableDisplayerController, Boolean reset) {
        // actualizar los elementos
        this.model.setAvailableProductos(this.search(reset));
        // mostrar en pantalla
        sellsTableDisplayerController.displayOnProductTable();
    }

    /**
     * Metodo principal para generar una busqueda
     * BY SIZE
     *
     * @param reset true si se quiere reinicar los valores
     * @return la lista de los inventario sque pertenecen a la sucursal
     */
    private ArrayList<InventarioSucursal> search(Boolean reset) {
        // variables
        if (reset) this.resetParameters(); // reinicia los valores
        Boolean byShop = !this.view.sortAllShopsJMenuButotn.isSelected(); // se busca por sucursal
        // obtiene el inventario
        ArrayList<InventarioSucursal> inventory = new ArrayList<>(new InventarioSucursalDAO().select(CurrentUser.getSalesDepartment(), byShop, true, true, this.offset, this.limit));
        inventory.removeAll(Collections.singleton(null)); // borramos todos los posibles nulos
        this.offset += this.limit; // aumenta el limite para la siguiente consulta SQL
        configResult(inventory); // elimina los elementos que no sean correspondientes con el tipo de filtrado
        return inventory;
    }

    /**
     * Reinicia los parametros para las consultas de busqueda
     */
    public void resetParameters() {
        this.limit = 50;
        this.offset = 0;
    }

    /**
     * Filtra segun colores o elementos
     *
     * @param inventory el valor del inventario
     */
    private void configResult(ArrayList<InventarioSucursal> inventory) {
        try {
            String data = this.view.searchJTextField.getText().trim().toLowerCase(); // el valor a buscar
            // obtenemos el tipo de busqueda
            SearchFilters sqlFilter = SearchFilters.values()[view.searchTypeJComboBox.getSelectedIndex()];
            if (!data.equals("")) {
                switch (sqlFilter) {
                    case BY_COLOR -> // POR COLOR
                            inventory.removeIf(item -> !item.getInventory().getColor().getColor().contains(data));
                    case BY_NAME -> // POR NOMBRE
                            inventory.removeIf(item -> !item.getInventory().getProductoTalla().getProduct().getName().contains(data));
                    case BY_SIZE -> // POR TALLA
                            inventory.removeIf(item -> !item.getInventory().getProductoTalla().getSize().getSize().equals(data));
                    default -> {
                    } // no hacer nada
                }
            }
        } catch (Exception e) {
            //TODO modificar CustomException para que muestre los errores en una consola con GUI
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }
}
