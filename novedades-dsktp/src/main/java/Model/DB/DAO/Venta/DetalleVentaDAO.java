package Model.DB.DAO.Venta;

import Model.DB.DAO.SQL.SQL_INSERT;
import Model.DB.DBConnection;
import Model.DB.Domain.Venta.DetalleVenta;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetalleVentaDAO {

    public int insert(DetalleVenta detail) {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_INSERT.SELL_DETAIL.getSentence())) {
            // configuramos el PS
            ps.setInt(1, detail.getISinventarioId());
            ps.setInt(2, detail.getISsucursalId());
            ps.setInt(3, detail.getVenta_id());
            ps.setInt(4, detail.getCantidad());
            ps.setDouble(5, detail.getUnitPrice());
            ps.setDouble(6, detail.getSubtotal());
            return ps.executeUpdate(); // ejecutamos el insert
        } catch (SQLException e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
            return 0;
        }
    }
}
