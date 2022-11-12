import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            System.out.println("找不到驅動程式類別");
            e.printStackTrace();
        }
        try
        {
            Connection connection = sqlset.getConnection();
                if(number == 1)//輸入
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
                else if(number == 2)//查詢
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
                else if(number == 3)//應用
                {
                    Statement statement = connection.createStatement();
                    String put1 = "SELECT * FROM `focus`";
                    ResultSet resultSet = statement.executeQuery(put1);
                    String time = null;
                    String hour = null;
                    String minute = null;
                    String second = null;
                    String now_hour = null;
                    String now_minute = null;
                    String now_second = null;
                    while (resultSet.next()) {
                        out = resultSet.getString("id");
                        time = resultSet.getString(3);
                    }
                    /*資料庫時間*/
                    hour = time.substring(11,13);
                    minute = time.substring(14,16);
                    second = time.substring(17,19);
                    System.out.println(time);
                    System.out.println(hour);
                    System.out.println(minute);
                    System.out.println(second);
                    /*現在時間*/
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    String date = dtf.format(LocalDateTime.now());
                    now_hour = date.substring(11,13);
                    now_minute = date.substring(14,16);
                    now_second = date.substring(17,19);
                    System.out.println(date);
                    System.out.println(now_hour);
                    System.out.println(now_minute);
                    System.out.println(now_second);
                    /*判斷不一樣*/
                    int yes = 0;
                    if(Integer.parseInt(now_hour) != Integer.parseInt(hour))
                    {
                        yes = 1;
                    }
                    if(Integer.parseInt(now_minute) != Integer.parseInt(minute))
                    {
                        yes = 1;
                    }
                    if(Integer.parseInt(now_second) != Integer.parseInt(second))
                    {
                        yes = 1;
                    }
                    System.out.println(yes);
                    if(yes == 1)
                    {
                        try
                        {
                            statement.executeUpdate(String.format(put));
                        }
                        catch (SQLException e)
                        {
                            e.printStackTrace();
                        }
                        System.out.println("input yes");
                    }
                    yes = 0;
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
    public String output()/*輸出輸入值*/
    {

        return out;
    }

}