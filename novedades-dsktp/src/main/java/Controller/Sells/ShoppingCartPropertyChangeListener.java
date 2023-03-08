package Controller.Sells;

import Model.DB.Domain.Venta.CartItem;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author jefe_mayoneso
 */
public class ShoppingCartPropertyChangeListener {

    /**
     * Genera un listener para la tabla de lista de compra, pues se puede ingresar
     * manualmente la cantidad de poductos que son , hac euna llamada a un submetodo que se
     * encarga de gestionar todos las acciones a tomer
     */
    public void configCartTable(VentaJDialog view, SellsModel model, SellsTableDisplayer dipslayer) {
        view.cartlistJTable.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                try {
                    if ("tableCellEditor".equals(evt.getPropertyName())) {
                        int row = view.cartlistJTable.getEditingRow();
                        int column = view.cartlistJTable.getEditingColumn();
                        if (row >= 0 && column >= 0) {
                            // si quisieramos recuperar el valor de la linea seleccionada usamos
                            // int oldValue = (int) evt.getOldValue();
                            int newValue = (int) view.cartlistJTable.getValueAt(row, column); // recuperamos el valor viejo por si se necesita un backup
                            updateCuantity(model, view, newValue, dipslayer); // ejecutamos el codigo que actualice todo
                        }
                    }
                } catch (Exception e) {
                    System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
                }
            }
        });
    }

    private void updateCuantity(SellsModel model, VentaJDialog view, int newValue, SellsTableDisplayer displayer) {
        // obtenemos el elemento seleccionado
        int index = view.cartlistJTable.convertRowIndexToModel(view.cartlistJTable.getSelectedRow());
        CartItem tmp = new CartItem(model.getCart().getList().get(index).getProduct(), newValue);
        // revisar que haya stock
        if (tmp.getCuantity() <= model.getAvailableProductos().get(index).getStock()) {
            model.getCart().update(tmp);
        }
        // actualiza lista
        displayer.displayOnShoppingCartTable();
    }
}
