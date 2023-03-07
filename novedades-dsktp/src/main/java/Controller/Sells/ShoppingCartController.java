package Controller.Sells;

import Model.DB.DAO.Usuario.ClienteEspecialDAO;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author jefe_mayoneso
 */
public class ShoppingCartController {

    private final VentaJDialog view;
    private final SellsModel model;


    public ShoppingCartController(VentaJDialog view, SellsModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Este metodo agrega elementos a la lista de compras, si el elemento ya existe, aumenta su cantidad, si la cantidad es menor a 1, la ignora,
     */
    public void add(SellsTableDisplayer displayer) {
        try {
            // obtenemos los items seleccionados
            Arrays.stream(view.productsResultJTable.getSelectedRows()).forEach(_index -> this.model.getCart().add(model.getAvailableProductos().get(view.productsResultJTable.convertRowIndexToModel(_index)), Integer.parseInt(view.cuantityAddJTextField.getText())));
            displayer.displayOnShoppingCartTable(); // mostramos los items
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Configura el cliente especial para generar la venta
     */
    public void setupSpecialClient(SellsTableDisplayer displayer) {
        try {
            // obtenemos el id y lo buscamos en la base de datos
            String result = this.view.showPopUp("Ingresa el codigo del cliente especial: ", "CLIENTE ESPECIAL", JOptionPane.QUESTION_MESSAGE).trim();
            this.model.setSpecialClient(new ClienteEspecialDAO().select(result));
            // actualizamos los datos
            this.view.specialClientJLabel.setText(this.model.getSpecialClient() != null ? String.format("Cliente especial: %1$s [%2$s]", this.model.getSpecialClient().getName(), this.model.getSpecialClient().getId()): "Cliente especial: ");
            displayer.displayOnShoppingCartTable(); // siempre actualizamos la tabla
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }

    }
}
