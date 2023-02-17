package Backend.DB.Domain.Usuario;

import Backend.Utils.AES256Encrypter;
import Backend.Utils.CustomException;

/**
 * Representación de un Usuario de la BD en Objeto de java
 *
 * @author jefe_mayoneso
 */
public class Usuario {
    private String usuario;
    private String nombre;
    private String password;
    // Area deberia ser un objeto, pero como no contiene atributos mas allá de un texto simple, no creamos un objeto
    private String area;

    public Usuario() {
        this(null, null, null, null, false);
    }

    /**
     * Este constructor sirve para crear un usuario a nivel BD, nota, al crear un objeto
     * La contraseña deberá ser texto plano, el constructor se encargará de encriptarla
     * automáticamente, no debemos llamar al metodo para encriptar
     *
     * @param usuario  el usuario, no encriptado, se encriptará en el constructor
     * @param nombre   el nombre
     * @param password la contraseña, no encriptado, se encriptará en el construcotr
     * @param area     el area a la que pretenece
     */
    public Usuario(String usuario, String nombre, String password, String area, boolean encrypt) {
        try {
            this.usuario = usuario;
            this.nombre = nombre;
            this.password = encrypt? AES256Encrypter.encrypt(password): password;
            this.area = area;
        } catch (Exception ignored) {
            System.out.println(CustomException.formatError(ignored.getMessage(), this.getClass()));
        }
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
