import javax.swing.*;
import java.awt.*;

public class RequestList {

    private JLabel savedRequests;
    private JButton request1;
    private JLabel requestType1;
    private JButton request2;
    private JLabel requestType2;
    private JButton request3;
    private JLabel requestType3;
    private JLabel label;

    /**
     * constructor
     *
     * @param frame
     * @param panel1
     */

    public RequestList(JFrame frame, JPanel panel1) {
        savedRequests = new JLabel("SAVED REQUESTS");
//        panel1 = new JPanel();
        //panel1.add(savedRequests);
        request1 = new JButton("request1");
        request1.setContentAreaFilled(false);
        request1.setOpaque(true);
        request1.setBackground(Color.orange);
        request2 = new JButton("request2");
        request2.setContentAreaFilled(false);
        request2.setOpaque(true);
        request2.setBackground(Color.blue);
        request3 = new JButton("request3");
        request3.setContentAreaFilled(false);
        request3.setOpaque(true);
        request3.setBackground(Color.yellow);
        String type;
        requestType1 = new JLabel("GET");
        requestType1.setOpaque(true);
        requestType1.setBackground(Color.orange);
        requestType2 = new JLabel("POST");
        requestType2.setOpaque(true);
        requestType2.setBackground(Color.blue);
        requestType3 = new JLabel("PUT");
        requestType3.setOpaque(true);
        requestType3.setBackground(Color.yellow);


        label = new JLabel("Insomnia");
        label.setLocation(40, 0);
        label.setSize(100, 50);
        Font labelFont = label.getFont();
        String labelText = label.getText();

        label.setForeground(Color.cyan);
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, 50));
        //label.setFont();
        //panel1.add(label);

//        panel1.add(requestType1);
//        panel1.add(request1);
//
//        panel1.add(requestType2);
//        panel1.add(request2);
//
//        panel1.add(requestType3);
//        panel1.add(request3);


        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();

        panel1.setLayout(layout);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 60;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(label, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 40;
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(request1, gbc);

        gbc.ipadx = 40;
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel1.add(requestType1, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 40;
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(request2, gbc);

        gbc.ipadx = 40;
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel1.add(requestType2, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 40;
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(request3, gbc);

        gbc.ipadx = 40;
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel1.add(requestType3, gbc);


        panel1.setBounds(0, 0, 405, 800);
        panel1.setBackground(Color.DARK_GRAY);
        frame.add(panel1);
    }
}
