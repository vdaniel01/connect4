import java.sql.*;

public class Adatbazis {
    private static final String DATABASE_URL = "jdbc:sqlite:connect4.db";

    public Adatbazis(){
        tablaLetrehozasa();
    }
    private void tablaLetrehozasa() {

        String tablaLetrehozasa = """
                CREATE TABLE IF NOT EXISTS jatekosok (nev TEXT PRIMARY KEY, gyozelem INTEGER DEFAULT 0);
                """;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()){
                statement.execute(tablaLetrehozasa);
        }
         catch (SQLException e) {
            System.out.println("Nem sikerült létrehozni a táblát: " + e.getMessage());
        }
    }

    public void ranglistaKiirasa() {
        String ranglista = "SELECT nev, gyozelem FROM jatekosok ORDER BY gyozelem DESC";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(ranglista)) {
            while (result.next()) {
                System.out.println(result.getString("nev") + " | győzelem: " + result.getInt("gyozelem"));
            }
        } catch (SQLException e) {
            System.out.println("Nem sikerült lekérni a ranglistát: " + e.getMessage());
        }
    }

    public void gyoztestHozzaad(String jatekosNev) {
        String gyoztestHozzaad = """
                INSERT INTO jatekosok (nev, gyozelem) VALUES (?, 1) ON CONFLICT(nev) DO UPDATE SET gyozelem = gyozelem + 1;
                """;

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(gyoztestHozzaad)) {
            preparedStatement.setString(1, jatekosNev);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nem sikerült frissíteni: " + e.getMessage());
        }
    }

}