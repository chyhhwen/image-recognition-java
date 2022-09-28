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
            System.out.println("�䤣���X�ʵ{�����O");
            e.printStackTrace();
        }

        try
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            // �d��city��
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

    //�]�w��
    private static Connection getConnection() throws SQLException {
        String serverName = "localhost";
        String database = "test";
        String url = "jdbc:mysql://" + serverName + "/" + database;
        // �b���M�K�X
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}