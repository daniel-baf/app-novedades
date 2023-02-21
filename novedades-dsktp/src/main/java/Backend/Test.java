package Backend;

import Backend.Login.LoginChecker;

public class Test {
    public static void main(String[] args) {

//        bd

        try {
//             crear
//            AreaDAO areaDAO = new AreaDAO();
//            areaDAO.insert(new Area("temporal"));
//            areaDAO.insert(new Area("remodelacion"));
//            areaDAO.insert(new Area("comida"));
//             borrar
//            areaDAO.delete("temporal");
//            ArrayList<String> areas = areaDAO.select();
//            areas.forEach(area -> {
//                System.out.println(area.toString());
//            });

            // creamos usuario
//            UsuarioDAO uDao = new UsuarioDAO();
//            Usuario user;
//            user = new Usuario("123", "daniel bautista", "gdfsgds", "comida", true);
//            uDao.insert(user); // password = EQtYltzHuvfPpkuiMyf87A==
//            System.out.printf("----\nUsuario: %1$s%n", user.toString());
//            user.setPassword(AES256Encrypter.encrypt("pato loco132"));
//            uDao.update(user);
//            user = uDao.select("123");
//            System.out.printf("----\nUsuario: %1$s%n", user.toString());
//            uDao.delete(user.getUsuario());

            String user = "slr1";
            String pswrd = "ventas123";
            new LoginChecker().checkLogin(user,pswrd);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
