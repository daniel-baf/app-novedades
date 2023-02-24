package Model.DB.Domain.Inventario;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representa la entidad Inventario como objeto de java
 *
 * @author jefe_mayoneso
 */
public class Inventario {

    private int id;
    private Color color;
    private ProductoTalla productoTalla;
    private ArrayList<Inventario> conjList;

    public Inventario(int id, Color color) {
        this(id, color, null);
    }

    public Inventario(int id, Color color, ProductoTalla productoTalla) {
        this.id = id;
        this.color = color;
        this.productoTalla = productoTalla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ProductoTalla getProductoTalla() {
        return productoTalla;
    }

    public void setProductoTalla(ProductoTalla productoTalla) {
        this.productoTalla = productoTalla;
    }

    public ArrayList<Inventario> getConjList() {
        return conjList;
    }

    public void setConjList(ArrayList<Inventario> conjList) {
        this.conjList = conjList;
    }

    @Override
    public String toString() {
        // TODO revisar si el implementar que el objeto almacene el listado no genera un stackoverflow
        String msg = "Inventario{" +
                "id=" + id +
                ", color=" + color.getColor() +
                ", productoTalla=" + productoTalla.toString();

        if (this.conjList != null) {
            msg += ", Compuesto={";
            for (Inventario inv : this.conjList)
                msg += inv.toString() + ", ";
            msg += "}";
        }
        return msg;
    }
}
