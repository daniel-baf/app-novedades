package Controller.Sells;

import Model.CurrentUser;
import Model.DB.DAO.Inventario.InventarioSucursalDAO;
import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

import java.util.ArrayList;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Esta clase sirve para manejar la seccion de tablas de la pestaña de ventas
 *
 * @author jefe_mayoneso
 */
public class SellsTable {

    /**
     * Agrega items a la tabla
     *
     * @param view
     * @param model
     */
    public void addRowsToTable(VentaJDialog view, SellsModel model) {
        // obtenemos el modelo de la tabla y borramos su contenido
        DefaultTableModel tableModel = (DefaultTableModel) view.productsResultJTable.getModel();
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        // configuramos la tabla por cada consulta nueva
        for (InventarioSucursal item : model.getAvailableProductos()) {
            // agregamos elementos
            try {
                tableModel.addRow(new Object[]{
                        item.getInventory().getId(), // id del inventario, identifica la pieza, talla y color
                        item.getInventory().getColor().getColor(), // color
                        item.getInventory().getProductoTalla().getProduct().getName(), // el nombre de la pieza
                        item.getInventory().getProductoTalla().getSize().getSize(), // la talla
                        item.getInventory().getProductoTalla().getPrice(), // precio normal
                        item.getInventory().getProductoTalla().getSpecialPrice(), // precio clientes especiales
                        item.getSucursal().getDirection() // la tienda donde se encuentra, en esta ventana solo mostrara items de CurrentUser.SalesDep   
                });
                // agregamos un sroter para la tabla
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
                view.productsResultJTable.setRowSorter(sorter);
                // Ordenamos por defecto por ID PIEZA
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // usaremos el Id Pieza para recuperar la info   
                sorter.setSortKeys(sortKeys);
                // NOTA: para recuperar el elemento seleccionado si se ha hecho un sort, con el siguiente metodo
                // int selected = this.view.productsResultJTable.convertRowIndexToModel(this.view.productsResultJTable.getSelectedRow());
            } catch (Exception e) {
                System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
            }
            view.productsResultJTable.setModel(tableModel);
        }
    }

    /**
     * Carga mas elementos de la base de datos a la tabla con los productos
     * @param view
     * @param model 
     */
    public void loadMoreIntoTable(VentaJDialog view, SellsModel model) {
        try {
            // recibimos la nueva lista
            model.getAvailableProductos().addAll(new InventarioSucursalDAO().select(CurrentUser.getSalesDepartment(), true, true, true, model.getOffset(), model.getLimit()));
            model.setOffset(model.getOffset() + model.getLimit());
            // actualizamos la tabla
            this.addRowsToTable(view, model);
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }
}
