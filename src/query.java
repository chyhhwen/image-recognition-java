import java.sql.*;
public class query
{
    String out="";
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
                if(number == 1)//��J
                {
                    Statement statement = connection.createStatement();
                    try
                    {
                        statement.executeUpdate(String.format(put));
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println("input yes");
                    connection.close();
                }
                else if(number == 2)//�d��
                {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(put);
                    while (resultSet.next())
                    {
                        out = resultSet.getString("id");
                        /*System.out.printf("%d ",resultSet.getInt(1));
                        System.out.printf("%s ",resultSet.getString(2));*/
                        System.out.printf("%s",resultSet.getString(3));
                    }
                    connection.close();
                }
                else if(number == 3)//����
                {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(put);
                    while (resultSet.next())
                    {
                        out = resultSet.getString("id");
                        /*System.out.printf("%d ",resultSet.getInt(1));
                        System.out.printf("%s ",resultSet.getString(2));*/
                        System.out.printf("%s",resultSet.getString(3));
                    }
                    connection.close();
                }
                else
                {
                    System.out.println("ERROR SQLPUT");
                }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public String output()
    {

        return out;
    }

}