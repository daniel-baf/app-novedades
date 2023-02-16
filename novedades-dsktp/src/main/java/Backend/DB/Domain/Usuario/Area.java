package Backend.DB.Domain.Usuario;

/**
 * Representación de la entidad Area como objeto en Java
 * @author jefe_mayoneso
 */
public class Area {

    private String area;

    public Area() {
        this(null);
    }

    public Area(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Area{" +
                "area='" + area + '\'' +
                '}';
    }
}
