package Model.DB.Domain.Venta;

import Model.DB.Domain.Usuario.ClienteEspecial;
import Model.DB.Domain.Usuario.Usuario;

import java.time.LocalDate;

/**
 * Clase que representa la entidad Venta en la base de datos
 * notese que el atributo Usuario y Cliente Especial son objetos que solamente hacen
 * referencia a un ID, pero para facilitar operaciones y evitar posteriormente hacer
 * sentencias SQL para saber la ifnormacion de ese usuario, almacenamos el objeto
 * De cualquier manera, si se desea NO hacer una llamada a BD del usuario, se puede crear
 * ub objeto Usuario que tenga un ID y el resto de valores nulos
 */
public class Venta {

    private int id;
    private LocalDate date;
    private String nit;
    private String name;
    private double total;
    private Usuario user;
    private ClienteEspecial specialClient;
    private boolean isListed;

    public Venta() {
    }

    public Venta(LocalDate date, String nit, String name, double total, Usuario user, ClienteEspecial specialClient, boolean isListed) {
        this(-1, date, nit, name, total, user, specialClient, isListed);
    }

    public Venta(int id, LocalDate date, String nit, String name, double total, Usuario user, ClienteEspecial specialClient, boolean isListed) {
        this.id = id;
        this.date = date;
        this.nit = nit;
        this.name = name;
        this.total = total;
        this.user = user;
        this.specialClient = specialClient;
        this.isListed = isListed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public ClienteEspecial getSpecialClient() {
        return specialClient;
    }

    public void setSpecialClient(ClienteEspecial specialClient) {
        this.specialClient = specialClient;
    }

    public boolean isListed() {
        return isListed;
    }

    public void setListed(boolean listed) {
        isListed = listed;
    }
}
