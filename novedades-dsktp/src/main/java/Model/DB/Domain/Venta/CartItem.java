package Model.DB.Domain.Venta;

import Model.DB.Domain.Inventario.InventarioSucursal;

public class CartItem {

    private InventarioSucursal product;
    private int cuantity;

    public CartItem() {
    }

    public CartItem(InventarioSucursal product, int cuantity) {
        this.product = product;
        this.cuantity = cuantity;
    }

    public InventarioSucursal getProduct() {
        return product;
    }

    public void setProduct(InventarioSucursal product) {
        this.product = product;
    }

    public int getCuantity() {
        return cuantity;
    }

    public void setCuantity(int cuantity) {
        this.cuantity = cuantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", cuantity=" + cuantity +
                '}';
    }
}
