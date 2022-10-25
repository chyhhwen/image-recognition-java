import java.sql.DriverManager;
import java.sql.*;
public abstract class sqlset
{
    public sqlset()
    {

    }
    public static Connection getConnection() throws SQLException {
        String serverName = "localhost";
        String database = "project";
        String url = "jdbc:mysql://" + serverName + "/" + database;
        // ±b¸¹©M±K½X
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}