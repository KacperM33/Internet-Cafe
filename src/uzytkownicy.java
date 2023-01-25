import java.sql.*;
public class uzytkownicy {
    private static String URL = "jdbc:mysql://localhost:3307/uzytkownicy";
    private static String USER = "root";
    private static String PASS = "root";
    public static void dodaj(String _imie, String _nazwisko, String _czas_rozp, String _czas_zak, String _cena)
    {
        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO uzytkownicy.uzytkownicy (imie, nazwisko, czas_rozp, czas_zak, cena) VALUES " +
                    "('" +_imie+ "', '" +_nazwisko+ "','" +_czas_rozp+ "', '" +_czas_zak+ "', '" +_cena+ "')");

//            ResultSet select = statement.executeQuery("select * from `uzytkownicy`");
//
//            while (select.next()) {
//                System.out.println(select.getString("imie")+" | "+select.getString("nazwisko")+" | "+
//                        select.getString("czas_rozp")+" | "+select.getString("czas_zak")+" | "+select.getString("cena"));
//            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String [] args)
    {
//        uzytkownicy.dodaj("maciej", "paciej", "20:06", "23:15", 55);
    }

}