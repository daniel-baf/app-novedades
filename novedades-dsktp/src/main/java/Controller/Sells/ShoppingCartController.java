package Controller.Sells;

import Model.DB.Domain.Venta.ShoppingCart;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

/**
 * @author jefe_mayoneso
 */
public class ShoppingCartController {

    private final VentaJDialog view;
    private final SellsModel model;
    private final ShoppingCart cart;

    public ShoppingCartController(VentaJDialog view, SellsModel model) {
        this.view = view;
        this.model = model;
        this.cart = new ShoppingCart();
    }

    /**
     * Este metodo agrega elementos a la lista de compras, si el elemento ya existe, aumenta su cantidad, si la cantidad es menor a 1, la ignora,
     *
     */
    public void add() {
        try {
            // obtenemos los items seleccionados
            int[] indexes = view.productsResultJTable.getSelectedRows();
            for (int index : indexes) {
                // cast SortKey to int
                int selected = view.productsResultJTable.convertRowIndexToModel(index);
                this.cart.add(model.getAvailableProductos().get(selected), Integer.parseInt(view.cuantityAddJTextField.getText()));
            }
            // mostramos los items

        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }
}
