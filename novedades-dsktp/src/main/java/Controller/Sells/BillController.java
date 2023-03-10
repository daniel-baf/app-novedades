package Controller.Sells;

import Model.DB.DAO.SQL.SQL_INSERT;
import Model.DB.DAO.Venta.Venta;
import Model.DB.DBConnection;
import Model.Sells.SellsModel;
import Utils.CustomException;
import Utils.Parser;
import View.Ventas.VentaJDialog;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Esta clase es la que se encargara de generar
 *
 * @author jefe_mayoneso
 */
public class BillController {

    private final SellsModel model;
    private final VentaJDialog view;

    public BillController(SellsModel model, VentaJDialog view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Genera una venta en base a los datos que se encuentran en la aplicacion
     * Para realizar esto, deshabilitara el autocommit y generara  un commit
     * nuevo si la operacion es exitosa, de lo contrario, hara un rollback
     */
    public void create() {
        // creamos el objeto venta que servira para el SQL
        Venta sell = new Venta();
        sell.setDate(LocalDate.now()); // la venta se realiza hoy
        sell.setNit(this.model.getNIT());
        boolean success;
        // generamos un PS para la insercion
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_INSERT.SELL.getSentence())){
            DBConnection.getConnection().setAutoCommit(false); // deshabilitamos el autocomit para operar con transacciones
            // insertamos la venta
            Parser parser = new Parser();
//            ps.setString(parser.);
            // operaciones SQL
        } catch (SQLException e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }
}
