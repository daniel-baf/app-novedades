package Model.DB.DAO.Venta;

import Model.DB.DAO.SQL.SQL_INSERT;
import Model.DB.DBConnection;
import Model.DB.Domain.Venta.DetalleVenta;
import Model.DB.Domain.Venta.Venta;
import Utils.CustomException;
import Utils.Parser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VentaDAO {

    /**
     * Inserta una venta en la base de datos, para esto hara uso de transacciones, el procedimiento es el siguiente
     * 1. Deshabilita el autocommit
     * 2. Inserta la venta
     * 2.1. Verifica la existencia de un producto
     * 2.2. Si hay existencia, inserta un detalle de venta
     * 2.3. Resta la existencia del producto en la BD
     * 2.3.1 repite hasta terminar todas los items de sellsDetail
     * 2.3.1.1. Si no hay existencia, aborta la venta y almacena el producto que no se ha podido vender
     * 3. si todo es correcto, realiza un commit de la venta
     * 4. reactiva el autocomit
     * 5. devuelve 1 si todo fue exitoso
     *
     * @param sell        la venta
     * @param sellDetails lo que lleva la venta
     * @return 1 si todo es correcto
     */
    public int insert(Venta sell, ArrayList<DetalleVenta> sellDetails) {
        boolean success = false;
        // generamos un PS para la inserción
        DBConnection.setAutoCommit(false); // deshabilitamos el autocommit por si necesitamos hacer rollabck
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_INSERT.SELL.getSentence(), Statement.RETURN_GENERATED_KEYS)) {
            // insertamos la venta
            Parser parser = new Parser();
            ps.setDate(1, parser.toDate(sell.getDate()));
            ps.setString(2, sell.getNit());
            ps.setString(3, sell.getName());
            ps.setDouble(4, sell.getTotal());
            ps.setString(5, sell.getUser().getUsuario());
            ps.setString(6, sell.getSpecialClient() == null ? null : sell.getSpecialClient().getId());
            ps.setBoolean(7, sell.isListed());
            // ejecutamos el insert y si fue exitoso, procedemos a insertar los detalles de venta
            if (ps.executeUpdate() > 0) {
                // recuperamos el ID de la venta y si existe, procedemos a insertar el detalle
                ResultSet generatedKey = ps.getGeneratedKeys();
                if (generatedKey.next()) {
                    int genId = generatedKey.getInt(1);
                    DetalleVentaDAO dvDAO = new DetalleVentaDAO();
                    // insertamos los detalles de la venta
                    for (DetalleVenta detail: sellDetails) {
                        detail.setVenta_id(genId); // actualizamos el objeto con la venta insertada
                        if (dvDAO.insert(detail) == 0) throw new Exception("No se ha podidio generar la venta");
                    }
                    success = true;
                    return 1;
                }
            }
        } catch (Exception e) {
            // si entra aqui, no se pudo generar la venta y se debe hacer rollbakc
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
            success = false;
            DBConnection.rollback();
        } finally {
            if(success) DBConnection.commit();
            else DBConnection.rollback();
            // siempre reactivamos el rollback
            DBConnection.setAutoCommit(true);
        }
        return 0;
    }
}
