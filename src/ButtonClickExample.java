import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonClickExample
{
    private JTextField tfield;
    private JButton button;
    private JLabel label;

    private ActionListener actions = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == button)
            {
                label.setText(tfield.getText());
            }
            else if (ae.getSource() == tfield)
            {
                button.doClick();
            }
        }
    };

    private void displayGUI()
    {
        JFrame frame = new JFrame("Button Click Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));

        JPanel centerPanel = new JPanel();
        tfield = new JTextField("", 10);
        button = new JButton("Click Me or not, YOUR WISH");
        tfield.addActionListener(actions);
        button.addActionListener(actions);
        centerPanel.add(tfield);
        centerPanel.add(button);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        label = new JLabel("Nothing to show yet", JLabel.CENTER);
        contentPane.add(label, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ButtonClickExample().displayGUI();
            }
        });
    }
}