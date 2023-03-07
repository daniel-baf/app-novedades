package Model.DB.Domain.Usuario;

/**
 * Esta clase representa  a la entidad CLiente_Especial en la base de datos
 *
 * @author jefe_mayoneso
 */
public class ClienteEspecial {

    private String id;
    private String name;

    public ClienteEspecial() {
        this(null, null);
    }

    public ClienteEspecial(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
