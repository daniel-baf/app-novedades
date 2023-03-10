package Model.DB.DAO.Usuario;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DBConnection;
import Model.DB.Domain.Usuario.ClienteEspecial;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteEspecialDAO {

    /**
     * Selecikona un CLiente Especial de la base de datos, retorna nulo si no encuentra nada
     *
     * @param id el id del CLiente especial, ej: esp1
     * @return el valor encontrado o nulo
     */
    public ClienteEspecial select(String id) {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.SPECIAL_USER.getSentence())) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return getClienteEspecialFromRS(rs);
        } catch (SQLException e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
        return null;
    }

    /**
     * Genera un objeto de tipo CLiente Especial a aprtir de un result set
     *
     * @param rs resultset
     * @return objeto o nulo
     */
    private ClienteEspecial getClienteEspecialFromRS(ResultSet rs) {
        try {
            return new ClienteEspecial(rs.getString("id"), rs.getString("nombre"), rs.getString("nit"));
        } catch (Exception e) {
            return null;
        }
    }
}
