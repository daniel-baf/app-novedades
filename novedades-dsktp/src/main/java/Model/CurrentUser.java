package Model;

import Model.DB.Domain.Sucursal.Sucursal;
import Model.DB.Domain.Usuario.Usuario;

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
        return "USUARIO ACTUAL\n" +
            USER.toString() + "\n" +
            SALES_DEPARTMENT.toString();
    }


}
