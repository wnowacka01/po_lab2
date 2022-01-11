package wyszukiwarka.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnect {
    protected Connection connection;

    //metoda łączenia z bazą danych w technologi JDBC
    public Connection getConnection(){
        final String connectionString = "jdbc:mysql://localhost:3306/wyszukiwarka";
        try {
            connection = DriverManager.getConnection(connectionString, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex); //wywala błąd jeśli nie połączy sie z bazą
        }
        return connection;
    }
}
