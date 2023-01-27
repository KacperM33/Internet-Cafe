import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class wypoz
{
    private static String URL = "jdbc:mysql://localhost:3307/wypoz";
    private static String USER = "root";
    private static String PASS = "root";

    public String _tytul;
    public String _wydawca;
    public String _cena;
    public static ArrayList<wypoz> listaGry = new ArrayList<wypoz>();

    public String get_tytul()
    {
        return _tytul;
    }
    public String get_wydawca()
    {
        return _wydawca;
    }
    public String get_cena() {
        return _cena;
    }

    public wypoz(String tytull, String wydawcaa, String cenaa)
    {
        _tytul=tytull;
        _wydawca=wydawcaa;
        _cena=cenaa;
    }
    public static void connect()
    {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();

            String select = "SELECT tytul, wydawca, cena FROM wypoz.gry";

            ResultSet rezultat = statement.executeQuery(select);

            while(rezultat.next())
            {
                String tytul = rezultat.getString("tytul");
                String wydawca = rezultat.getString("wydawca");
                String cena = rezultat.getString("cena");
                listaGry.add(new wypoz(tytul, wydawca, cena));
//                System.out.println(tytul+" | "+wydawca+" | "+cena);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void delete(int id)
    {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();

            String delete = "DELETE FROM wypoz.gry WHERE id = " + "'" +id+ "'";

            statement.executeUpdate(delete);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
//        wypoz.delete(3);
//        wypoz.connect();
    }
}
