package Model.DB.Domain.Inventario;

/**
 * Representacion de la entidad Conjunto como objeto de Java
 *
 * @author jefe_mayoneso
 */
public class Conjunto {

    private Inventario conjunto;
    private Inventario pieza;

    public Conjunto(Inventario conjunto, Inventario pieza) {
        this.conjunto = conjunto;
        this.pieza = pieza;
    }

    public Inventario getConjunto() {
        return conjunto;
    }

    public void setConjunto(Inventario conjunto) {
        this.conjunto = conjunto;
    }

    public Inventario getPieza() {
        return pieza;
    }

    public void setPieza(Inventario pieza) {
        this.pieza = pieza;
    }

    @Override
    public String toString() {
        return "Conjunto{" +
                "conjunto=" + conjunto +
                ", pieza=" + pieza +
                '}';
    }
}
