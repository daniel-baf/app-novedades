package Model.Login;

import Model.DB.DAO.Sucursal.SucursalDAO;
import Model.DB.DAO.Usuario.UsuarioDAO;
import Model.DB.Domain.Sucursal.Sucursal;
import Model.DB.Domain.Usuario.Usuario;

import java.util.ArrayList;

/**
 * Sirve como modelo para la vista de Login
 *
 * @author jefe_mayoneso
 */
public class LoginModel {

    // attributes
    ArrayList<Sucursal> salesDepratments;
    private Usuario currentUser;

    public LoginModel() {
        setup();
    }

    /**
     * Get all data needed for Login view
     */
    private void setup() {
        try {
            this.salesDepratments = new SucursalDAO().selectAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checa si el usuario ingresado es valido o no
     *
     * @param user     el usuario ingresado
     * @param password la contraseña ingresada
     * @return true o false si las credenciales son correctas o no
     */
    public boolean login() {
        try {
            Usuario dbUser = new UsuarioDAO().select(this.currentUser.getUsuario());
            if (dbUser != null && this.currentUser.getPassword().equals(dbUser.getPassword())) {
                this.currentUser = dbUser; // update data
                return true;
            }
        } catch (Exception e) {
            System.out.println("No se puede hacer login, revisa tus credenciales");
        }
        return false;
    }

    public ArrayList<Sucursal> getSalesDepratments() {
        return salesDepratments;
    }

    public void setUser(Usuario user) {
        this.currentUser = user;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }
}
