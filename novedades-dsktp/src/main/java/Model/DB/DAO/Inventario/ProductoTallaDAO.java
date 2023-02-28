package Model.DB.DAO.Inventario;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DBConnection;
import Model.DB.Domain.Inventario.ProductoTalla;
import Model.DB.Domain.Inventario.Talla;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase sirve para hacer consultas relacionadas con la entidad Producto_Talla
 *
 * @author jefe_mayoneso
 */
public class ProductoTallaDAO {

    public ProductoTalla select(int productoId, String talla) {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.PRODUCTO_TALLA.getSentence() + SQL_SELECT.PRODUCTO_TALLA_ADD_ID.getSentence())) {
            ps.setInt(1, productoId);
            ps.setString(2, talla);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return getProductoFromRS(rs);
        } catch (Exception e) {
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
    private ProductoTalla getProductoFromRS(ResultSet rs) {
        try {
            ProductoTalla prodTallaTmp = new ProductoTalla(new Talla(rs.getString("talla")), rs.getDouble("precio"), rs.getDouble("precio_especial"));
            prodTallaTmp.setProduct(new ProductoDAO().select(rs.getInt("Producto_id")));
            return prodTallaTmp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
