import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class main
{
    //≥]©w¿…
    public main()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                System.out.print(dtf.format(LocalDateTime.now())+"  |   ");
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            query query = new query();
            query .query(2,"SELECT * FROM `air`");
        }
    }
    public static void main(String[] args)
    {
        new  main();
    }

}