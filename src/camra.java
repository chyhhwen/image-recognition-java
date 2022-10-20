import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.plaf.FontUIResource;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class camra
{
    static
    {
        System.loadLibrary("opencv_java310");
    }
    private JFrame frame;
    static JLabel label;
    static int flag=0;
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    camra window = new camra();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        VideoCapture camer = new VideoCapture();
        camer.open(0);
        if(!camer.isOpened())
        {
            System.out.println("Camera ERROR");
        }
        else
        {
            Mat frame = new Mat();
            while(flag==0)
            {
                camer.read(frame);
                Mat gray = new Mat(frame.rows(),frame.cols(),frame.type());
                Imgproc.cvtColor(frame,gray,Imgproc.COLOR_RGB2GRAY);
                label.setIcon(new ImageIcon(matImage.matToBufferedImage(gray)));
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public camra()
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
}
