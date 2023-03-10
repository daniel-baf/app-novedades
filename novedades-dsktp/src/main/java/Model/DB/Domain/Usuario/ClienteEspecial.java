package Model.DB.Domain.Usuario;

/**
 * Esta clase representa  a la entidad CLiente_Especial en la base de datos
 *
 * @author jefe_mayoneso
 */
public class ClienteEspecial extends Client {

    private String id;

    public ClienteEspecial(String id, String name, String nit) {
        super(name, nit);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
