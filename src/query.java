import java.sql.*;
public class query
{

    public void query(int number, String put)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("�䤣���X�ʵ{�����O");
            e.printStackTrace();
        }
        try
        {
            Connection connection = sqlset.getConnection();
            Statement statement = connection.createStatement();
            // �d��city��
            try (ResultSet resultSet = statement.executeQuery(put))
            {
                if(number == 1)//USE
                {
                    System.out.println("input yes");
                }
                else if(number == 2)// select all
                {
                    while (resultSet.next())
                    {
                        System.out.println(resultSet.getString("id") + "    " + resultSet.getString(
                                "aid") + "   ");
                    }
                }
                else
                {
                    System.out.println("ERROR SQLPUT");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}