package Model.DB.DAO.Usuario;

import Model.DB.DAO.SQL.*;
import Model.DB.DBConnection;
import Model.DB.Domain.Usuario.Usuario;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Clase usada para generar consultas relacionadas con la entidad Usuario
 *
 * @author colaborativo
 */
public class UsuarioDAO {

    /**
     * Inserta un usuario en la base de datos
     *
     * @param usuario el usuario como Objeto
     * @return el numero de filas afectadas
     * @throws Exception en caso exista un error es lanzado para ser manejado
     */
    public int insert(Usuario usuario) throws Exception {
        // Intenta actualizar la BD, si hay error, devuelve una excepcion
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_INSERT.USER.getSentence())) {
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getArea());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Selecciona un usuario de la base de datos
     *
     * @param username el usuario es la PK de la BD
     * @return el usuario encontrado, en caso es encontrado, nulo si no encuentra nada
     * @throws Exception el error en caso ocurra
     */
    public Usuario select(String username) throws Exception {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.USER.getSentence())) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? getUserFromRS(rs) : null;
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Actualiza la información en la base de datos del Usuario user
     *
     * @param user el usuario a modificar
     * @return el numero de filas afectadas
     * @throws Exception en caso exista un error
     */
    public int update(Usuario user) throws Exception {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_UPDATE.USER.getSentence())) {
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getArea());
            ps.setString(4, user.getUsuario()); // WHERE
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Convierte un REsultSet en <Usuario>Objeto</Usuario>
     *
     * @param rs ResultSet
     * @return el valor de la BD como objeto
     */
    private Usuario getUserFromRS(ResultSet rs) {
        try {
            return new Usuario(
                    rs.getString("id"),
                    rs.getString("nombre"),
                    rs.getString("password"),
                    rs.getString("Area_id"),
                    false
            );
        } catch (Exception e) {
            System.out.printf("No se ha encontrado un atributo, ERROR: %1$s\nEn: %2$s%n", e.getMessage(), this.getClass());
            return null;
        }
    }

    public int delete(String usuario) throws Exception {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_DELETE.USER.getSentence())) {
            ps.setString(1, usuario);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), e.getClass()));
        }
    }
}
