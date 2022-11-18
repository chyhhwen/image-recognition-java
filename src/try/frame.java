import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.FontUIResource;
public class frame
{
    JButton button1 = new JButton("START");
    JButton button2 = new JButton("STOP");
    JLabel  label1 = new JLabel("資料庫未連接");
    JLabel  label2 = new JLabel("輸出值:");
    JLabel  label3 = new JLabel("空");
    int check = 0;
    public static void setUIFont(FontUIResource fui)
    {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements())
        {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof FontUIResource)
            {
                UIManager.put(key, fui);
            }
        }
    }
    private ActionListener actions = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == button1)
            {
                label1.setText("資料庫已連接");
                check = 1;
            }
            if (ae.getSource() == button2)
            {
                label1.setText("資料庫已關閉");
                System.exit(0);
            }
        }
    };

    public frame()
    {
        JFrame jFrame= new JFrame();
        jFrame.setSize(800,600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.setBounds(100,20,200,80);
        button1.addActionListener(actions);
        button2.setBounds(100,150,200,80);
        button2.addActionListener(actions);
        label1.setBounds(400,70,200,100);
        label2.setBounds(100,320,200,100);
        label3.setBounds(300,320,200,100);
        jFrame.add(button1);
        jFrame.add(button2);
        jFrame.add(label1);
        jFrame.add(label2);
        jFrame.add(label3);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        while(true)
        {
            button1.addActionListener(actions);
            if(check==1)
            {
                try
                {
                    Thread.sleep(1000);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                query query = new query();
                query .query(2,"SELECT * FROM `air`");
                label3.setText(query.output());
            }
        }
    }
    public static void main(String args[ ])
    {
        setUIFont(new FontUIResource("新細明體",Font.ITALIC,30));
        new frame();
    }

}