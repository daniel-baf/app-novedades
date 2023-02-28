package Model;

import Model.DB.Domain.Sucursal.Sucursal;
import Model.DB.Domain.Usuario.Usuario;

/**
 * Puesto que el Usuario puede rotar de tienda, al logueqrse marca su ifnromacion
 * y esta es guardada en RAM para futuras consultas
 * @author jefe mayoneso
 */
public class CurrentUser {

    private static Usuario USER;
    private static Sucursal SALES_DEPARTMENT;

    public static Usuario getUSER() {
        return USER;
    }

    public static void setUSER(Usuario USER) {
        CurrentUser.USER = USER;
    }

    public static Sucursal getSalesDepartment() {
        return SALES_DEPARTMENT;
    }

    public static void setSalesDepartment(Sucursal salesDepartment) {
        SALES_DEPARTMENT = salesDepartment;
    }

    public static String print() {
        return "USUARIO ACTUAL\n" + USER.toString() + "\n" + SALES_DEPARTMENT.toString();
    }


}
