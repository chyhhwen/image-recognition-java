import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class ImageGui extends JPanel implements KeyListener
{
    public ImageGui(Mat m,String window)
    {
        super();
        init(m,window);
    }
    private  Mat mat;
    private boolean firstPaint = true;
    private  BufferedImage out;
    int type;
    private String WINDOW = "";
    private JFrame jframe = new JFrame();
    byte[] data;
    private void Mat2BufIm()
    {
        mat.get(0,0,data);
        out.getRaster().setDataElements(0,0,mat.cols(),mat.rows(),data);
    }
    private void init(Mat m,String window)
    {
        this.mat = m;
        data = new byte[mat.cols()*mat.rows()*(int)mat.elemSize()];
        WINDOW = window;
        if(mat.channels() == 1)
        {
            type = BufferedImage.TYPE_BYTE_GRAY;
        }
        else
        {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        out = new BufferedImage(mat.cols(),mat.rows(),type);
        Mat2BufIm();
        jframe.add(this);
        jframe.setSize(mat.cols(),mat.rows());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle(WINDOW);
        jframe.addKeyListener(this);
    }
    @Override
    public  void paintComponent(Graphics g)
    {
        g.drawImage(out,0,0,null);
    }
    public void  imshow()
    {
        if(firstPaint)
        {
            jframe.setVisible(true);
            firstPaint=false;
        }
        Mat2BufIm();
        this.repaint();
    }
    private static Object mt = new Object();
    private static int lastKey = 0;
    private static int key = 0;
    public static int waitKey(int millisecond)
    {
        try
        {
            if(millisecond == 0)
            {
                synchronized (mt)
                {
                    mt.wait();
                }
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        int ret = -1;
        if(key != lastKey)
        {
            ret = key;
            lastKey = key;
        }
        return ret;
    }
    @Override
    public void keyTyped(KeyEvent e)
    {

    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        synchronized (mt)
        {
            mt.notifyAll();
        }
        this.key = e.getKeyCode();
    }
    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}