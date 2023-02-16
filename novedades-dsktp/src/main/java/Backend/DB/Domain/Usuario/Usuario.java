package Backend.DB.Domain.Usuario;

/**
 * Representación de un Usuario de la BD en Objeto de java
 * @author jefe_mayoneso
 */
public class Usuario {
    private String usuario;
    private String nombre;
    private String password;
    // Area deberia ser un objeto, pero como no contiene atributos mas allá de un texto simple, no creamos un objeto
    private String area;

    public Usuario() {
        this(null, null, null, null);
    }

    public Usuario(String usuario, String nombre, String password, String area) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
        this.area = area;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
