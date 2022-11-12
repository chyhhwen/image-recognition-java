import org.opencv.core.Point;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class project
{
    static
    {
        System.loadLibrary("opencv_java310");/*引入opencv*/
    }
    public static JFrame frame;
    static JLabel label;
    static int flag=0;
    public  project()
    {
        initialize();
    }
    private void  initialize()//*劃出GUI*/
    {
        frame = new JFrame();
        frame.setBounds(100,100,850,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        label = new JLabel("");
        label.setBounds(50,50,640,480);
        frame.getContentPane().add(label);
    }
    private static void sql(int put1)/*資料庫*/
    {
        query query = new query();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date = dtf.format(LocalDateTime.now());
        String input = "INSERT INTO `focus` VALUES(NULL,";
        String put = input + "\"" + put1 + "\",";
        put = put + "\"" + date +"\");";
        query.query(3,put);
        System.out.println(put);
    }
    public static void main(String[] args)/*主要*/
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    project window = new project();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        String xmlFile = "C:/Users/USER/Desktop/java-database-recognition/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml";
        CascadeClassifier cascadeClassifier = new CascadeClassifier(xmlFile);
        if(cascadeClassifier.empty())
        {
            System.out.println("road error");
        }
        else
        {
            VideoCapture camera = new VideoCapture(0);
            camera.open(0);
            if(!camera.isOpened())
            {
                System.out.println("carma open error");
            }
            else
            {
                Mat frame = new Mat();
                while(flag==0)
                {
                    camera.read(frame);
                    if(!camera.read(frame))
                    {
                        System.out.println("read error");
                        break;
                    }
                    Mat gray = new Mat(frame.rows(),frame.cols(),frame.type());
                    MatOfRect matOfRect = new MatOfRect();
                    Imgproc.cvtColor(frame,gray,Imgproc.COLOR_RGB2GRAY);
                    cascadeClassifier.detectMultiScale(gray,matOfRect);
                    if(!matOfRect.empty())
                    {
                        Rect[] rects = matOfRect.toArray();
                        int people = 0;
                        for(Rect r : rects)
                        {
                            Imgproc.rectangle(frame,new Point(r.x,r.y),new Point(r.x+r.width,r.y+r.height),
                                    new Scalar(0,255,0),3);
                            people += 1;
                        }
                        label.setIcon(new ImageIcon(matImage.matToBufferedImage(frame)));
                        sql(people);
                    }
                }
            }
        }
    }
}
