import org.opencv.core.Point;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;

public class project
{
    static
    {
        System.loadLibrary("opencv_java310");
    }
    public static JFrame frame;
    static JLabel label;
    static int flag=0;
    public  project()
    {
        initialize();
    }
    private void  initialize()
    {
        frame = new JFrame();
        frame.setBounds(100,100,798,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        label = new JLabel("");
        label.setBounds(50,50,640,480);
        frame.getContentPane().add(label);
    }
    /*private static void sql()
    {
        query query = new query();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String date = dtf.format(LocalDateTime.now());
        String input = "INSERT INTO `main` VALUES(NULL,\"";
        String put = input+date+"\");";
        query.query(1,put);
        System.out.print(date+" | ");
    }*/
    public static void main(String[] args)
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
                        for(Rect r : rects)
                        {
                            Imgproc.rectangle(frame,new Point(r.x,r.y),new Point(r.x+r.width,r.y+r.height),
                                    new Scalar(0,255,0),3);
                        }
                        label.setIcon(new ImageIcon(matImage.matToBufferedImage(frame)));
                        /*/try
                        {
                            Thread.sleep(800);
                            sql();
                        }
                        catch (InterruptedException e)
                        {
                            throw new RuntimeException(e);
                        }*/
                    }
                    /*try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }*/
                }
            }
        }
    }
}
