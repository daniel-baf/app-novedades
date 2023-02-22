package Model.DB.Domain.Sucursal;

public class Sucursal {
    private int id;
    private String name;
    private String phone;
    private String direction;

    /**
     * Constructor
     */
    public Sucursal() {
        this(-1, null, null, null);
    }

    public Sucursal(int id, String name, String phone, String direction) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.direction = direction;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
