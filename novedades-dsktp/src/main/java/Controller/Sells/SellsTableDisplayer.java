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
        DefaultTableModel model = (DefaultTableModel) this.view.productsResultJTable.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        // configuramos la tabla por cada consulta nueva
        this.model.getAvailableProductos().forEach(_item -> {
            try { // agregamos los elementos en la vista
                model.addRow(new Object[]{
                        _item.getInventory().getId(), // id del inventario, identifica la pieza, talla y color
                        _item.getInventory().getColor().getColor(), // color
                        _item.getInventory().getProductoTalla().getProduct().getName(), // el nombre de la pieza
                        _item.getInventory().getProductoTalla().getSize().getSize(), // la talla
                        _item.getInventory().getProductoTalla().getPrice(), // precio normal
                        _item.getInventory().getProductoTalla().getSpecialPrice(), // precio clientes especiales
                        _item.getSucursal().getDirection(), // la tienda donde se encuentra, en esta ventana solo mostrara items de CurrentUser.SalesDep
                        _item.getStock() // la cantidad disponible para venta
                });
            } catch (Exception e) {
                System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
            }
        });
        // actualizamos la tabla
        this.view.productsResultJTable.setModel(model); // actualizamos el modelo
        this.addSortKeyToTable(model, this.view.productsResultJTable); // agregamos sortkey para que se pueda filtrar la tabla
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
        this.model.getCart().setTotal(0); // reiniciamos contador
        DefaultTableModel model = (DefaultTableModel) this.view.cartlistJTable.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        // mostramos los datos que estan en el carrito de compras
        this.model.getCart().getList().forEach(_item -> {
            try { // agregamos el elemento
                double tmpPrice = this.model.getSpecialClient() != null ? _item.getProduct().getInventory().getProductoTalla().getSpecialPrice() : _item.getProduct().getInventory().getProductoTalla().getPrice();
                this.model.getCart().setTotal(this.model.getCart().getTotal() + tmpPrice * _item.getCuantity());
                // actualizamos total
                model.addRow(new Object[]{
                        _item.getProduct().getInventory().getId(),
                        _item.getProduct().getInventory().getProductoTalla().getProduct().getName(),
                        _item.getProduct().getInventory().getProductoTalla().getSize().getSize(),
                        _item.getProduct().getInventory().getColor().getColor(),
                        tmpPrice,
                        _item.getCuantity(),
                        _item.getCuantity() * tmpPrice
                });
            } catch (Exception e) {
                System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
            }
        });
        // mostramos los datos finales
        this.view.cartlistJTable.setModel(model);
        this.addSortKeyToTable(model, this.view.cartlistJTable);
        this.view.totalJLabel.setText(String.format("Total: Q%1$s",this.model.getCart().getTotal()));
    }

    /**
     * COnfigura un SortKey para una tabla a partir d eun tableModel
     *
     * @param tableModel el modelo al que queremos agregar sortkey
     * @param table      la tabla a la que se le pondra el sortkey
     */
    private void addSortKeyToTable(DefaultTableModel tableModel, JTable table) {
        // agregamos un sroter para la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);
        // Ordenamos por defecto por ID PIEZA
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // usaremos el Id Pieza para recuperar la info
        sorter.setSortKeys(sortKeys);
        // NOTA: para recuperar el elemento seleccionado si se ha hecho un sort, con el siguiente metodo
        // int selected = this.view.productsResultJTable.convertRowIndexToModel(this.view.productsResultJTable.getSelectedRow());
    }
}
