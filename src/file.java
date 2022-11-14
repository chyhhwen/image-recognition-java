import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class file
{
    private String file_name = "C:\\Users\\User\\Desktop\\java-database-recognition\\src\\picture\\check.txt";

    public file()
    {

    }
    public String use(int choose, String put)
    {
        String out = null;
        switch (choose)
        {
            case 0:
                clean();
                break;
            case 1:
                read();
                break;
            case 2:
                write(put);
                break;
            case 3:
                out = name();
                break;
            default:
                System.out.println("ERROR TXT");
        }
        return out;
    }
    public String name()
    {
        String now_hour = null;
        String now_minute = null;
        String now_second = null;
        String now_year = null;
        String now_month = null;
        String now_day = null;
        String data_name = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date = dtf.format(LocalDateTime.now());
        now_hour = date.substring(11,13);
        now_minute = date.substring(14,16);
        now_second = date.substring(17,19);
        now_year = date.substring(0,4);
        now_month = date.substring(5,7);
        now_day = date.substring(8,10);
        data_name = now_year + now_month + now_day + "-";
        data_name += now_hour + now_minute + now_second;
        return data_name;
    }
    public void clean()
    {
        try
        {
            FileWriter fileWriter = new FileWriter(file_name);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void write(String date)
    {
        BufferedWriter writer = null;
        File file = new File(file_name);
        try
        {
            writer = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream(file_name,true),"UTF-8"));
            writer.newLine();
            writer.append(date);
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    public String read()
    {
        BufferedReader reader = null;
        String out = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(file_name), "UTF-8"));
            String put = null;
            while((put = reader.readLine()) != null)
            {
               out = put;
            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return out;
    }
    public void check(String date)
    {
        String put = read();
        /*if(put != date)
        {

        }*/
        //System.out.println(put);
    }
}