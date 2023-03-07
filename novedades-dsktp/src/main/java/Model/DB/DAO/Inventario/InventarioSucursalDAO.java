package Model.DB.DAO.Inventario;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DAO.SQL.SQL_SENTENCE;
import Model.DB.DAO.Sucursal.SucursalDAO;
import Model.DB.DBConnection;
import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.DB.Domain.Sucursal.Sucursal;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Esta clase sirve para hacer consultas a la base de datos respecto a la entidad InventarioSucursal
 *
 * @author jefe_mayoneso
 */
public class InventarioSucursalDAO {

    /**
     * Selecciona una lista de inventario por sucursal
     *
     * @param salesDepartment   la tienda a la que se desea filtrar, null si bySalesDeprtment es false
     * @param bySalesDepartment true si se desea filtrar por tienda
     * @return la lista de productos disponibles
     */
    public ArrayList<InventarioSucursal> select(Sucursal salesDepartment, Boolean bySalesDepartment) {
        return this.select(salesDepartment, bySalesDepartment, false, false, 0, 0);
    }

    /**
     * Selecciona una lista de inventario por sucursal
     *
     * @param salesDepartment la tienda
     * @param useOffset       true si se desea usar offset en el SQL
     * @param useLimit        true si se desea usar LIMIT en el SQL
     * @param offset          el valor del offset en caso useOffset es true
     * @return el listado de productos encontrados en BD
     */
    public ArrayList<InventarioSucursal> select(Sucursal salesDepartment, Boolean useOffset, Boolean useLimit, int offset, int limit) {
        return this.select(salesDepartment, false, useLimit, useOffset, offset, limit);
    }

    /**
     * Este metodo busca en la base de datos toda la informacion relacionada a un producto
     * Este metodo puede buscar en todas las tiendas, o en una tienda en especifico
     *
     * @param salesDepartment   nulo si se quiere buscar en todas las tiendas, o la tienda si se desea buscar
     *                          una en especifico
     * @param bySalesDepartment true si se desea buscar la existencia de una tienda
     * @param useLimit          si se desea poner un limite en el numero de filas por consulta
     * @param useOffset         si se desea mover en la linea de inicio de la consulta
     * @param offset            el punto de inicio para la sentencia SQL
     * @param limit             el limite para la sentencia SQL
     * @return el listado de productos disponibles
     */
    public ArrayList<InventarioSucursal> select(Sucursal salesDepartment, Boolean bySalesDepartment, Boolean useLimit, Boolean useOffset, int offset, int limit) {
        ArrayList<InventarioSucursal> invAvailability = new ArrayList<>();
        // modifica el SQL para elegir entre todas las sucursales o una en especifico
        String SQL_TMP = SQL_SELECT.INVENTARIO_SUCURSAL.getSentence();
        // configuramos las consultas extra para usar un mismo metodo para todo
        SQL_TMP += bySalesDepartment ? SQL_SELECT.WHERE + SQL_SELECT.INVENTARIO_SUCURSAL_ADD_SUC_ID.getSentence() : "";
        SQL_TMP += useLimit ? SQL_SENTENCE.LIMIT : "";
        SQL_TMP += useOffset ? SQL_SENTENCE.OFFSET : "";
        int tmpSQLCounter = 1; // CONTADOR para agregar n extras a la sentencia SQL
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_TMP)) {
            // configuramos todos los posibles datos opcionales
            if (bySalesDepartment) ps.setInt(tmpSQLCounter++, salesDepartment.getId());
            if (useLimit) ps.setInt(tmpSQLCounter++, limit); // usamos como limite 100 filas para esta consulta
            if (useOffset) ps.setInt(tmpSQLCounter++, offset);
            // ejecuta sentencia SQL y obtiene los datos
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                invAvailability.add(getInventarioSucursalFromRS(rs));
            }
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
        return invAvailability;
    }

    /**
     * Obtiene el objeto a partir de un Result Set
     *
     * @param rs ResultSet
     * @return el objeto obtenido del rs si existe
     */
    private InventarioSucursal getInventarioSucursalFromRS(ResultSet rs) {
        // creamos los objetos pertinentes con los datos obtenidos
        try {
            InventarioSucursal tmpInventorySuc = new InventarioSucursal(rs.getInt("stock")); // basic inventory sucursal
            // obtenemos la sucursal y el inventario de cada elemento
            tmpInventorySuc.setSucursal(new SucursalDAO().select(rs.getInt("Sucursal_id")));
            tmpInventorySuc.setInventory(new InventarioDAO().select(rs.getInt("Inventario_id")));
            return tmpInventorySuc;
        } catch (Exception e) {
            System.out.println(CustomException.formatError(e.getMessage(), this.getClass()));
        }
        return null;
    }
}
