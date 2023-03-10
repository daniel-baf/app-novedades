package Model.Sells;

import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.DB.Domain.Usuario.ClienteEspecial;
import Model.DB.Domain.Venta.ShoppingCart;

import java.util.ArrayList;

/**
 * Modelo para MVC de la seccion de ventas (Generacion de facturas)
 *
 * @author jefe_mayoneso
 */
public class SellsModel {

    private ArrayList<InventarioSucursal> availableProductos;
    private final ShoppingCart cart;
    private ClienteEspecial specialClient;
    private String NIT;

    private final int offset; // sirve para saber la posicion actual de la consulta SQL
    private int limit;

    public SellsModel() {
        this.offset = 0; // iniciamos las consultas SQL en 0 para ir incrementando, asi no tendremos consultar largas suponiendo existan miles de productos
        this.limit = 50;
        this.cart = new ShoppingCart();
        this.specialClient = null;
        this.NIT = "CF";
    }

    /**
     * Obtiene los productos disponibles al iniciar la applicacion, usa limites y offset para no argar la RAM
     * en caso existan demasiados productos
     *
     * @return el listado de productos
     */
    public ArrayList<InventarioSucursal> getAvailableProductos() {
        return this.availableProductos;
    }

    public void setAvailableProductos(ArrayList<InventarioSucursal> availableProductos) {
        this.availableProductos = availableProductos;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ShoppingCart getCart() {
        return this.cart;
    }

    public ClienteEspecial getSpecialClient() {
        return specialClient;
    }

    public void setSpecialClient(ClienteEspecial specialClient) {
        this.specialClient = specialClient;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
}
