package Controller.Sells;

import Model.CurrentUser;
import Model.DB.DAO.Usuario.ClienteEspecialDAO;
import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

import javax.swing.*;
import java.util.Arrays;

/**
 * Controlador de las acciones relacionadas con la lista de compras
 *
 * @author jefe_mayoneso
 */
public class ShoppingCartController {

    private final VentaJDialog view;
    private final SellsModel model;
    private final SellsTableDisplayer displayer;


    public ShoppingCartController(VentaJDialog view, SellsModel model, SellsTableDisplayer displayer) {
        this.view = view;
        this.model = model;
        this.displayer = displayer;
        // configura el listener de la tabla
        new ShoppingCartPropertyChangeListener().configCartTable(this.view, this.model, this.displayer);
    }

    /**
     * Este metodo agrega elementos a la lista de compras, si el elemento ya existe, aumenta su cantidad, si la cantidad es menor a 1, la ignora,
     */
    public void add() {
        try {
            // obtenemos los items seleccionados
            final InventarioSucursal[] product = new InventarioSucursal[1]; // lo convertimos a arreglo para poder usarlo en la expresion lambda
            Arrays.stream(view.productsResultJTable.getSelectedRows()).forEach(_index -> {
                product[0] = this.model.getAvailableProductos().get(this.view.productsResultJTable.convertRowIndexToModel(_index));
                // revisamos que el producto sea de la tienda actual y lo agregamos si lo es
                if (product[0].getSucursal().getId() == CurrentUser.getSalesDepartment().getId())
                    this.model.getCart().add(product[0], Integer.parseInt(this.view.cuantityAddJTextField.getText()));
                else
                    this.view.showPopUp(
                            String.format("No puedes agregar este producto [%1$s]\nno pertenece a tu tienda\npuedes solicitar un traslado del producto [%2$s]\nDe la tienda \"%3$s\" a \"%4$s\"",
                                    product[0].getInventory().getId(),
                                    product[0].getInventory().getProductoTalla().getProduct().getName(),
                                    product[0].getSucursal().getDirection().trim(),
                                    CurrentUser.getSalesDepartment().getDirection()),
                            "Producto en otra tienda",
                            JOptionPane.INFORMATION_MESSAGE);
            });
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
            String result = this.view.showInputPopUp("Ingresa el codigo del cliente especial: ", "CLIENTE ESPECIAL", JOptionPane.QUESTION_MESSAGE).trim();
            this.model.setSpecialClient(new ClienteEspecialDAO().select(result));
            // guardamos los nuevos valores en la tabla
            this.model.setNIT(this.model.getSpecialClient() != null ? this.model.getSpecialClient().getNit() : "CF");
            this.model.setBillName(this.model.getSpecialClient() != null ? this.model.getSpecialClient().getName() : "");
            // actualizamos los datos
            this.view.displayBillData(this.model.getNIT(), this.model.getBillName(), this.model.getSpecialClient());
            // configuramos el nombre y NIT en automatico si estos existen
            displayer.displayOnShoppingCartTable(); // siempre actualizamos la tabla para los nuevos posibles precios
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Configura el NIT para la venta
     */
    public void setupNit() {
        // solicitamos el nit
        this.model.setNIT(this.view.setupNIT());
        // revisamos si no es CF
        if (!this.model.getNIT().equalsIgnoreCase("CF")) {
            this.model.setBillName(this.view.showInputPopUp("Ingresa el nombre", "Nombre", JOptionPane.QUESTION_MESSAGE));
        }
        // actualizamos los datos
        this.view.displayBillData(this.model.getNIT(), this.model.getBillName(), this.model.getSpecialClient());
    }
}
