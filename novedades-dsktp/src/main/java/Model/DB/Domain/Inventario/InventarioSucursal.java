package Model.DB.Domain.Inventario;

import Model.DB.Domain.Sucursal.Sucursal;

/**
 * Representa la entidad Inventario_Sucursal como objeto java
 *
 * @author jefe_mayoneso
 */
public class InventarioSucursal {

    private Inventario inventory;
    private Sucursal sucursal;
    private int stock;

    public InventarioSucursal(int stock) {
        this(null, null, stock);
    }

    public InventarioSucursal(Inventario inventory, Sucursal sucursal, int stock) {
        this.inventory = inventory;
        this.sucursal = sucursal;
        this.stock = stock;
    }

    public Inventario getInventory() {
        return inventory;
    }

    public void setInventory(Inventario inventory) {
        this.inventory = inventory;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "InventarioSucursal{" +
                "inventory=" + inventory.toString() +
                ", sucursal=" + sucursal.toString() +
                ", stock=" + stock +
                '}';
    }
}
