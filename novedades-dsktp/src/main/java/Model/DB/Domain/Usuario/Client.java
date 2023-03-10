package Model.DB.Domain.Usuario;

/**
 * Clase usada para generar facturas en caso no sea un cliente especial
 *
 * @author jefe_mayoneso
 */
public class Client {

    private String name;
    private String nit;

    public Client() {
    }
    public Client(String name, String nit) {
        this.name = name;
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
