import Controller.Sells.SellsController;
import Model.CurrentUser;
import Model.DB.DAO.Sucursal.SucursalDAO;
import Model.DB.DAO.Usuario.UsuarioDAO;
import Model.Sells.SellsModel;
import View.Ventas.VentaJDialog;

public class Main {
    public static void main(String[] args) {
        try {
            // emulamos login
            CurrentUser.setUSER(new UsuarioDAO().select("vnt1"));
            CurrentUser.setSalesDepartment(new SucursalDAO().select(1));
            // trabajamos sobre ventas
            SellsModel model = new SellsModel();
            VentaJDialog view = new VentaJDialog();
            SellsController controller = new SellsController(view, model);
            controller.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
