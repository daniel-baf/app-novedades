package Controller.Sells;

import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase sirve para manejar la seccion de tablas de la pestaña de ventas
 *
 * @author jefe_mayoneso
 */
public class SellsTableDisplayer {

    private final VentaJDialog view;
    private final SellsModel model;

    public SellsTableDisplayer(VentaJDialog view, SellsModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Agrega items a la tabla
     */
    public void displayOnProductTable() {
        // obtenemos el modelo de la tabla y borramos su contenido
        DefaultTableModel tableModel = (DefaultTableModel) this.view.productsResultJTable.getModel();
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        // configuramos la tabla por cada consulta nueva
        for (InventarioSucursal item : this.model.getAvailableProductos()) {
            try { // agregamos los elementos en la vista
                tableModel.addRow(new Object[]{
                        item.getInventory().getId(), // id del inventario, identifica la pieza, talla y color
                        item.getInventory().getColor().getColor(), // color
                        item.getInventory().getProductoTalla().getProduct().getName(), // el nombre de la pieza
                        item.getInventory().getProductoTalla().getSize().getSize(), // la talla
                        item.getInventory().getProductoTalla().getPrice(), // precio normal
                        item.getInventory().getProductoTalla().getSpecialPrice(), // precio clientes especiales
                        item.getSucursal().getDirection(), // la tienda donde se encuentra, en esta ventana solo mostrara items de CurrentUser.SalesDep   
                        item.getStock() // la cantidad disponible para venta
                });
                this.addSortKeyToTable(tableModel); // agregamos sortkey para que se pueda filtrar la tabla
            } catch (Exception e) {
                System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
            }
            this.view.productsResultJTable.setModel(tableModel); // actualizamos el modelo
        }
    }

    /**
     * Carga mas elementos de la base de datos a la tabla con los productos
     */
    public void loadRowsOffsetToProductTable(SellsSearchController searchController) {
        try {
            // recibimos la nueva lista
            ArrayList<InventarioSucursal> backup = this.model.getAvailableProductos();
            searchController.search(this, false);
            this.model.getAvailableProductos().addAll(backup);
            // actualizamos la tabla
            this.displayOnProductTable();
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Este metodo muestra en la tabla de lista de compra los productos mostrados
     */
    public void displayOnShoppingCartTable() {
        DefaultTableModel tableModel = (DefaultTableModel) this.view.cartlistJTable.getModel();
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        // mostramos los datos que estan en el carrito de compras
//        for (CartItem)
    }

    private void addSortKeyToTable(DefaultTableModel tableModel) {
        // agregamos un sroter para la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        view.productsResultJTable.setRowSorter(sorter);
        // Ordenamos por defecto por ID PIEZA
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // usaremos el Id Pieza para recuperar la info
        sorter.setSortKeys(sortKeys);
        // NOTA: para recuperar el elemento seleccionado si se ha hecho un sort, con el siguiente metodo
        // int selected = this.view.productsResultJTable.convertRowIndexToModel(this.view.productsResultJTable.getSelectedRow());
    }
}
