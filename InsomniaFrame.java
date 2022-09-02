import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;


public class InsomniaFrame {
    JFrame frame;
    JPanel panel;
    ConsoleColors consoleColors;
    JLabel label;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JTabbedPane tab1;
    JTabbedPane tab2;

    //JSplitPane splitPane;


    public InsomniaFrame(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        tab1 = new JTabbedPane();
        tab2 = new JTabbedPane();
        consoleColors = new ConsoleColors();
        frame = new JFrame("Insomnia");
        panel = new JPanel();
        label = new JLabel();
        frame.setBackground(Color.BLACK);
        frame.setSize(1500,800);// 2000, 1000
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setResizable(true);
        frame.setLocation(50,50);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
//        splitPane = new JSplitPane();


        frame.setBackground(Color.BLUE);
        label.setText("");

        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel3, tab1);
        JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp, panel1);
        frame.add(sp2, BorderLayout.CENTER);
        //frame.add(panel);

    }

    public void showGui(){
        frame.setVisible(true);
    }
}
