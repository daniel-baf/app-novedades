package Model.DB.Domain.Inventario;

/**
 * Esta clase representa la entidad Talla en la BD como
 * Objeto de java
 *
 * @author jefe_mayoneso
 */
public class Talla {

    private String size;

    public Talla(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
