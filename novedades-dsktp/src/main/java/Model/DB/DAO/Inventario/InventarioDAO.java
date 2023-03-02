package Model.DB.DAO.Inventario;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DBConnection;
import Model.DB.Domain.Inventario.Color;
import Model.DB.Domain.Inventario.Inventario;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase sirve para controlar las consultas a base de datos de un Inventario
 *
 * @author jefe_mayoneso
 */
public class InventarioDAO {

    public Inventario select(int id) {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.INVENTARIO.getSentence() + SQL_SELECT.WHERE +  SQL_SELECT.INVENTARIO_ADD_ID.getSentence())) {
            // configuramos el PS en caso sea por id
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getInventarioFromRs(rs);
            }
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
        return null;
    }

    private Inventario getInventarioFromRs(ResultSet rs) {
        try {
            Inventario inventarioTmp = new Inventario(rs.getInt("id"), new Color(rs.getString("color")));
            inventarioTmp.setProductoTalla(new ProductoTallaDAO().select(rs.getInt("Prod_Talla_Producto_id"), rs.getString("Prod_Talla_talla")));
            // revisar si el articulo en el inventario es un conjunto
            if (inventarioTmp.getProductoTalla().getProduct().isComposed())
                inventarioTmp.setConjList(new ConjuntoDAO().select(inventarioTmp.getId()));
            return inventarioTmp;
        } catch (SQLException e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
            return null;
        }
    }
}
