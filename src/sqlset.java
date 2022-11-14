import java.sql.DriverManager;
import java.sql.*;
public abstract class sqlset /*資料庫設定*/
{
    public sqlset()
    {

    }
    public static Connection getConnection() throws SQLException
    {
        String serverName = "localhost";
        String database = "recognition";
        String url = "jdbc:mysql://" + serverName + "/" + database;
        // 帳號和密碼
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}