package Model.DB.DAO.Inventario;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DBConnection;
import Model.DB.Domain.Inventario.Inventario;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * DAO para entidad Conjunto
 */
public class ConjuntoDAO {

    public ArrayList<Inventario> select(int idConjunto) {
        ArrayList<Inventario> list = new ArrayList<>();
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.CONJUNTO.getSentence() + SQL_SELECT.CONJUNTO_ADD_ID.getSentence())) {
            ps.setInt(1, idConjunto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(getConjuntoPiecesFromRS(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    private Inventario getConjuntoPiecesFromRS(ResultSet rs) throws Exception {
        try {
            return new InventarioDAO().select(rs.getInt("Inventario_id_pieza"));
        } catch (Exception e) {
            throw new Exception(CustomException.formatError("No se ha podido encontrar la piea del conjunto", this.getClass()));
        }
    }

}
