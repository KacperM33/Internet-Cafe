import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class uzytkownicy {
    private static String URL = "jdbc:mysql://localhost:3307/uzytkownicy";
    private static String USER = "root";
    private static String PASS = "root";
    public String imie;
    public String nazwisko;
    public String czas_rozp;
    public String czas_zak;
    public String cena;
    public static ArrayList<uzytkownicy> lista = new ArrayList<uzytkownicy>();
    public uzytkownicy(String imie, String nazwisko, String czas_rozp, String czas_zak, String cena)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.czas_rozp = czas_rozp;
        this.czas_zak = czas_zak;
        this.cena = cena;
    }

    public String getImie()
    {
        return this.imie;
    }
    public String getNazwisko()
    {
        return this.nazwisko;
    }
    public String getCzas_rozp()
    {
        return this.czas_rozp;
    }
    public String getCzas_zak()
    {
        return this.czas_zak;
    }
    public String getCena()
    {
        return this.cena;
    }

    public static void dodaj(String _imie, String _nazwisko, String _czas_rozp, String _czas_zak, String _cena)
    {
        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO uzytkownicy.uzytkownicy (imie, nazwisko, czas_rozp, czas_zak, cena) VALUES " +
                    "('" +_imie+ "', '" +_nazwisko+ "','" +_czas_rozp+ "', '" +_czas_zak+ "', '" +_cena+ "')");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void pokaz()
    {

        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            Statement statement = connection.createStatement();

            String select = "SELECT imie, nazwisko, czas_rozp, czas_zak, cena FROM uzytkownicy.uzytkownicy";

            ResultSet rezultat = statement.executeQuery(select);

            while(rezultat.next())
            {
                String imie = rezultat.getString("imie");
                String nazwisko = rezultat.getString("nazwisko");
                String czas_rozp = rezultat.getString("czas_rozp");
                String czas_zak = rezultat.getString("czas_zak");
                String cena = rezultat.getString("cena");
                lista.add(new uzytkownicy(imie, nazwisko, czas_rozp, czas_zak, cena));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void pobierz()
    {

        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            Statement statement = connection.createStatement();

            String select = "SELECT imie, nazwisko, czas_rozp, czas_zak, cena FROM uzytkownicy.uzytkownicy";

            ResultSet rezultat = statement.executeQuery(select);

            PrintWriter pw = new PrintWriter(new File("C:\\Users\\Kacper\\Documents\\uzytkownicy_tabela.csv"));
            StringBuilder sb = new StringBuilder();

            sb.append("Imie");
            sb.append(";");
            sb.append("Nazwisko");
            sb.append(";");
            sb.append("Czas rozpoczecia");
            sb.append(";");
            sb.append("Czas zakończenia");
            sb.append(";");
            sb.append("Cena");
            sb.append("\r\n");

            while(rezultat.next())
            {
                sb.append(rezultat.getString("imie"));
                sb.append(";");
                sb.append(rezultat.getString("nazwisko"));
                sb.append(";");
                sb.append(rezultat.getString("czas_rozp"));
                sb.append(";");
                sb.append(rezultat.getString("czas_zak"));
                sb.append(";");
                sb.append(rezultat.getString("cena"));
                sb.append("\r\n");
            }

            pw.write(sb.toString());
            pw.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String [] args)
    {
//        uzytkownicy.dodaj("maciej", "paciej", "20:06", "23:15", "55 zł");
//        uzytkownicy.pokaz();
//        uzytkownicy.pobierz();
    }

}