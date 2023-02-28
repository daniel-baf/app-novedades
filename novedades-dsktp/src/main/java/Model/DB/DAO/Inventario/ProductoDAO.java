package Model.DB.DAO.Inventario;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DBConnection;
import Model.DB.Domain.Inventario.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase sirve para hacer consultas de productos en la base de datos
 *
 * @author jefe_mayoneso
 */
public class ProductoDAO {

    public Producto select(int id) {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.PRODUCTO.getSentence() + SQL_SELECT.PRODUCTO_ADD_ID.getSentence())) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return getProductoFromRS(rs);
        } catch (Exception e) {
            System.out.println("No se ha podido seleccionar un producto");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Genera un objeto de tipo Producto a partir de un Result Set
     *
     * @param rs
     * @return
     */
    private Producto getProductoFromRS(ResultSet rs) {
        try {
            return new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getInt("compuesto"));
        } catch (SQLException e) {
            System.out.println("No se ha encontrado un producto " + e.getMessage());
            return null;
        }
    }
}
