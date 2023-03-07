package Model.DB.Domain.Venta;

import Model.DB.Domain.Inventario.InventarioSucursal;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<CartItem> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void add(InventarioSucursal item, int cuantity) {
        // revisamos que la cantidad sea mayor a 1
        if (cuantity < 1)
            return;
        // revisa si no existe el item en la lista
        int index = search(item);
        if (index == -1) {
            // agregamos el item
            cart.add(new CartItem(item, cuantity));
        } else {
            // actualizamos la cantidad
            cart.get(index).setCuantity(cart.get(index).getCuantity() + cuantity);
        }
    }

    public int search(InventarioSucursal item) {
        for (int i = 0; i < this.cart.size(); i++) {
            if (cart.get(i).getProduct().getInventory().getId() == item.getInventory().getId())
                return i;
        }
        return -1;
    }

    public void reset() {
        this.cart = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cart=" + cart +
                '}';
    }
}
