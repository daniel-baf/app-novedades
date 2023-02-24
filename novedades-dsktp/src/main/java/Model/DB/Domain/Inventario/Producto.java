package Model.DB.Domain.Inventario;

/**
 * Representacion de la entidad Producto como objeto en java
 *
 * @author jefe_mayoneso
 */
public class Producto {

    private int id;
    private String name;
    private boolean isComposed;

    public Producto() {
        this(-1, null, 0);
    }

    public Producto(int id, String name, int isComposed) {
        this.id = id;
        this.name = name;
        this.isComposed = isComposed == 1; // true if 1
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComposed() {
        return isComposed;
    }

    public void setComposed(boolean composed) {
        isComposed = composed;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isComposed=" + isComposed +
                '}';
    }
}
