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
 *
 * @author jefe_mayoneso
 */
public final class SellsSearchController {

    private int limit;
    private int offset;

    public SellsSearchController() {
        resetParameters();
    }

    public void search(VentaJDialog view, SellsModel model, SellsTable sellsTableController, Boolean reset) {
        // actualizar los elementos
        model.setAvailableProductos(this.search(view, model, reset));
        // mostrar en pantalla
        sellsTableController.addRowsToTable(view, model);
    }

    /**
     * Metodo principal para generar una busqueda
     *
     * @param view
     * @param model
     * @param reset
     * @return
     */
    private ArrayList<InventarioSucursal> search(VentaJDialog view, SellsModel model, Boolean reset) {
        // variables
        ArrayList<InventarioSucursal> inventory = new ArrayList<>();
        if (reset) {
            this.resetParameters();
        }
        Boolean byShop = !view.sortAllShopsJMenuButotn.isSelected(); // se busca por sucursal
        inventory.addAll(new InventarioSucursalDAO().select(CurrentUser.getSalesDepartment(), byShop, true, true, this.offset, this.limit));
        inventory.removeAll(Collections.singleton(null)); // borramos todos los posibles nulos
        this.offset += this.limit;
        configResult(inventory, view);
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
     * @param inventory
     * @param view
     */
    private void configResult(ArrayList<InventarioSucursal> inventory, VentaJDialog view) {
        try {
            String data = view.searchJTextField.getText().trim().toLowerCase(); // el valor a buscar
            // obtenemos el tipo de busqueda
            SearchFilters sqlFilter = SearchFilters.values()[view.searchTypeJComboBox.getSelectedIndex()];
            if (!data.equals("")) {
                switch (sqlFilter) {
                    case BY_COLOR -> {
                        // BY COLOR
                        inventory.removeIf(item -> !item.getInventory().getColor().getColor().contains(data));
                    }
                    case BY_NAME -> {
                        // BY NAME
                        inventory.removeIf(item -> !item.getInventory().getProductoTalla().getProduct().getName().contains(data));
                    }
                    case BY_SIZE -> {
                        // BY SIZE
                        inventory.removeIf(item -> !item.getInventory().getProductoTalla().getSize().getSize().equals(data));
                    }
                    default -> {
                    } // no hacer nada
                    }
            }
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }
}
