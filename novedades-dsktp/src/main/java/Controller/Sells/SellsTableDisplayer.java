package Controller.Sells;

import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.Sells.SellsModel;
import Utils.CustomException;
import View.Ventas.VentaJDialog;

import java.util.ArrayList;

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
        this.view.displayProducts(this.model.getAvailableProductos());
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
            this.view.displayProducts(this.model.getAvailableProductos());
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Este metodo muestra en la tabla de lista de compra los productos mostrados
     */
    public void displayOnShoppingCartTable() {
        this.model.getCart().setTotal(0); // reiniciamos contador
        this.view.displayOnShoppingCartTable(this.model.getCart().getList(), this.model.getSpecialClient(), this.model.getCart());
    }
}
