package Model.DB.Domain.Venta;

import Model.DB.Domain.Inventario.InventarioSucursal;

import java.util.ArrayList;

/**
 * Esta clase sirve para almacenar los items en compra
 */
public class ShoppingCart {

    private ArrayList<CartItem> list;
    private double total;

    public ShoppingCart() {
        this.list = new ArrayList<>();
        this.total = 0;
    }

    /**
     * Agrega un elemento a la lista de compra
     *
     * @param item     el item a agregar
     * @param cuantity la cantidad
     */
    public void add(InventarioSucursal item, int cuantity) {
        if (cuantity < 1) // revisamos que la cantidad sea mayor a 1
            return;
        if (item.getStock() < 1) // no agregamos si no hay existencia
            return;
        int index = search(item); // valor que usaremos para saber si ya existe el elemento
        if (index == -1) { // agregamos el item si no existe
            list.add(new CartItem(item, cuantity));
        } else { // actualizamos el elemento si ya existe
            list.get(index).setCuantity(list.get(index).getCuantity() + cuantity);
        }
    }

    /**
     * Busca si un elemento ya ha sido agregado en el carrito, devuelve -1 si no encuentra nada, y si encuentra, el index en el array
     *
     * @param item el item a buscar
     * @return la posicion en el arreglo del item
     */
    public int search(InventarioSucursal item) {
        for (int i = 0; i < this.list.size(); i++) {
            if (list.get(i).getProduct().getInventory().getId() == item.getInventory().getId())
                return i;
        }
        return -1;
    }

    public void reset() {
        this.list = new ArrayList<>();
    }

    public ArrayList<CartItem> getList() {
        return list;
    }

    public void setList(ArrayList<CartItem> list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cart=" + list +
                '}';
    }
}
