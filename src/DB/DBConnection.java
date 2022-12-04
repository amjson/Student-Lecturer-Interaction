package DB;

/**
 *
 * @author JoeAlpha
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {    
    // setting connection to the database
    public static Connection setConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/my_project_dit", "root", "");
        
        return conn;
    }
}
