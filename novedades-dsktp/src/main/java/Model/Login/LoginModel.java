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
     * Obtiene toda la informacion ecesaria para la vista de LOgin
     */
    private void setup() {
        try {
            this.salesDepratments = new SucursalDAO().select();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checa si el usuario ingresado es valido o no
     *
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
