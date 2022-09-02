import javax.swing.*;
import java.awt.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Response {
    //JTabbedPane tab;
    JButton ok;
    JButton time;
    JButton quality;
    JPanel panel1;
    JPanel panel2;
    JComboBox box;
    JButton copyToClipBoard;
    JTextField keyHeader1;
    JTextField valueHeader1;
    JTextField keyHeader2;
    JTextField valueHeader2;
    JCheckBox status1;
    JButton trash1;
    JCheckBox status2;
    JButton trash2;
    JTextArea responseBody;
    JScrollPane scroll;
    JTextArea responseHeaders;

    /**
     * constructor
     * @param frame
     */

    public Response(JFrame frame){

        ok = new JButton("200 OK");
        ok.setForeground(Color.GREEN);
        time = new JButton("3.34s");
        time.setBackground(Color.LIGHT_GRAY);
        quality = new JButton("14.7KB");
        quality.setBackground(Color.LIGHT_GRAY);
        ok.setBounds(950, 50, 80,50);
        time.setBounds(1030, 50, 80, 50);
        quality.setBounds(1110, 50, 80, 50);

        frame.add(ok);
        frame.add(time);
        frame.add(quality);

        //tab = new JTabbedPane();

    }

    /**
     * adding Header Tab
     * adding double TextFields
     * adding clipToClipboard Button
     * @param frame
     * @param tab
     */
    public void header (JFrame frame, JTabbedPane tab){
        panel1 = new JPanel();
        copyToClipBoard = new JButton("Copy To Clipboard");
        tab.setBounds(900,150,500,650);
        panel1.setBackground(Color.LIGHT_GRAY);


        responseHeaders = new JTextArea();
        panel1.add(responseHeaders);

        keyHeader1 = new JTextField();
        valueHeader1 = new JTextField();
        keyHeader2 = new JTextField();
        valueHeader2 = new JTextField();
        status1 = new JCheckBox();
        trash1 = new JButton("X");
        status2 = new JCheckBox();
        trash2 = new JButton("X");
        panel1.setBackground(Color.LIGHT_GRAY);


        panel1.setSize(300,300);
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 100;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(keyHeader1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(valueHeader1, gbc);

        gbc.ipadx = 20;
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel1.add(status1, gbc);

        gbc.ipadx = 5;
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel1.add(trash1, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 100;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(keyHeader2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(valueHeader2, gbc);

        gbc.ipadx = 20;
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel1.add(status2, gbc);

        gbc.ipadx = 5;
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel1.add(trash2, gbc);

        gbc.fill = GridBagConstraints.BELOW_BASELINE_TRAILING;
        gbc.ipadx = 50;
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel1.add(copyToClipBoard, gbc);

        tab.add("HEADER", panel1);
        frame.add(tab);
    }

    /**
     * adding messageBody Tab
     * Adding combo box
     * @param frame
     * @param tab
     */
    public void messageBody(JFrame frame, JTabbedPane tab){
        panel2 = new JPanel();
        responseBody = new JTextArea(30,38);
        responseBody.setSize(30,30);
        responseBody.setLocation(100,100);
        responseBody.setBackground(Color.LIGHT_GRAY);

        panel2.setBackground(Color.LIGHT_GRAY);
        String[] messageString = {"RAW", "PREVIEW"};
        box = new JComboBox(messageString);
        panel2.add(box);

        panel2.setBorder(new TitledBorder(new EtchedBorder(), "Display Area"));
        responseBody.setLineWrap(true);

        responseBody.setEditable(false); // set textArea non-editable

        scroll = new JScrollPane(responseBody, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setForeground(Color.DARK_GRAY);
        panel2.add(scroll);

        //panel2.add(responseBody);

        tab.add("MESSAGE BODY", panel2);
        frame.add(tab);

    }


}
