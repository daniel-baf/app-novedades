package Backend;

import Backend.DB.DAO.Usuario.AreaDAO;
import Backend.DB.Domain.Usuario.Area;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        bd

        try {
            // crear
            AreaDAO areaDAO = new AreaDAO();
//            areaDAO.insert(new Area("temporal"));
//            areaDAO.insert(new Area("remodelacion"));
//            areaDAO.insert(new Area("comida"));
            // borrar
            areaDAO.delete("temporal");
            ArrayList<Area> areas = areaDAO.select();
            areas.forEach(area -> {
                System.out.println(area.toString());
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        String data = "my_contra 1234";
//        try {
//            System.out.println(String.format("Texto: %t") AES256Encrypter.encrypt(data) + );
//        } catch (Exception e) {
//            System.out.println("error: " + e.getMessage());
//        }
    }
}
