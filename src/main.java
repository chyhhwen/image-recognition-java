import java.sql.*;

public class main
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("找不到驅動程式類別");
            e.printStackTrace();
        }

        try
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            // 查詢city表
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM air")) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("id") + "    " + resultSet.getString(
                            "aid") + "   ");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //設定檔
    private static Connection getConnection() throws SQLException {
        String serverName = "localhost";
        String database = "test";
        String url = "jdbc:mysql://" + serverName + "/" + database;
        // 帳號和密碼
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}