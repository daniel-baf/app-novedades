package Backend.Login;

import Backend.DB.DAO.Usuario.UsuarioDAO;
import Backend.DB.Domain.Usuario.Usuario;

public class LoginChecker {

    public LoginChecker() {
    }

    public boolean checkLogin(String user, String password) {
        Usuario inUser = new Usuario(user, password, true); // usuario temporal para checkear login
        try {
            Usuario dbUser = new UsuarioDAO().select(user);
            if (inUser.getPassword().equals(dbUser.getPassword())) {
                System.out.printf("Usuario valido [%1$s], redirigir a %2$s%n", inUser.getUsuario(), dbUser.getArea());
                return true;
            }
        } catch (Exception e) {
            System.out.println("No se puede hacer login, revisa tus credenciales");
        }
        return false;
    }

}
