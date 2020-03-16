package daos;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/Credit_Card?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "Farmerc92";
    public static final String PASS = "ZipCode#92";

    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}
