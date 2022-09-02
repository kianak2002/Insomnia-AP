import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewRequest {

    JTextArea textAreaBody;

    JButton URL;
    TextArea textAreaSend;
    JButton save;
    JComboBox request;
    JTextField keyHeader1;
    JTextField valueHeader1;
    JTextField keyHeader2;
    JTextField valueHeader2;
    JCheckBox statusHeader1;
    JButton trashHeader1;
    JCheckBox statusHeader2;
    JButton trashHeader2;
    JCheckBox statusQuery1;
    JButton trashQuery1;
    JCheckBox statusQuery2;
    JButton trashQuery2;
    JButton addHeader;
    JButton addQuery;
    JTextField keyQuery1;
    JTextField valueQuery1;
    JTextField keyQuery2;
    JTextField valueQuery2;


    /**
     * constructor
     * @param frame
     * @param p1
     * @param tab
     */
    public NewRequest(JFrame frame, JPanel p1,JTabbedPane tab){
        URL = new JButton("Send");
        URL.setLocation(800,50);
        URL.setSize(100,50);
        frame.add(URL);
        textAreaSend = new TextArea();
        textAreaSend.setBounds(500,50,300,50);
        frame.add(textAreaSend);

        String[] requestString ={"GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "CUSTOM METHOD"};
        request = new JComboBox(requestString);
        request.setBounds(400,50,100,50);
        frame.add(request);

        //save button
        save = new JButton("Save");
        save.setLocation(800,120);
        save.setSize(100,40);
        frame.add(save);


        //body tab
        textAreaBody = new JTextArea(35,30);
        textAreaBody.setBackground(Color.LIGHT_GRAY);

        p1.add(textAreaBody);

        tab.setBounds(400,150,500,650);
        tab.setBackground(Color.PINK);

        frame.add(tab);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * adding Body Tab to the frame
     * adding a check box and textArea for body tab
     * @param textAreaBody
     * @param p1
     * @param frame
     * @param tab
     */
    public void body(JTextArea textAreaBody, JPanel p1, JFrame frame, JTabbedPane tab){
        p1.setBackground(Color.LIGHT_GRAY);
        String[] bodyStrings = { "JSN", "XML", "YAML", "EDN", "Other" };

        JComboBox bodyList = new JComboBox(bodyStrings);
        p1.add(bodyList);
        bodyList.setBounds(100,100,200,100);
        p1.add(textAreaBody);
        tab.add("Body" ,p1);
        Label bodyLabel = new Label("Select a body type from above");
        p1.add(bodyLabel);
        bodyLabel.setBounds(50,50,100,50);
        frame.add(tab);
    }

    /**
     * adding Header Tab
     * adding double textFields and trash Icon
     * adding an "add" icon
     * @param frame
     * @param p4
     * @param tab
     */
    public void header(JFrame frame, JPanel p4, JTabbedPane tab){
        JPanel head = new JPanel();
        keyHeader1 = new JTextField();
        valueHeader1 = new JTextField();
        keyHeader2 = new JTextField();
        valueHeader2 = new JTextField();
        statusHeader1 = new JCheckBox();
        trashHeader1 = new JButton("X");
        statusHeader2 = new JCheckBox();
        trashHeader2 = new JButton("X");
        addHeader = new JButton("Add");
        p4.setBackground(Color.LIGHT_GRAY);


        //p4.setSize(300,300);
        p4.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p4.add(addHeader, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 150;
        gbc.gridx = 0;
        gbc.gridy = 1;
        p4.add(keyHeader1, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        p4.add(valueHeader1, gbc);

        gbc.ipadx = 20;
        gbc.gridx = 2;
        gbc.gridy = 1;
        p4.add(statusHeader1, gbc);
        //head.add(statusHeader1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        p4.add(trashHeader1, gbc);
        //head.add(trashHeader1, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 150;
        gbc.gridx = 0;
        gbc.gridy = 2;
        p4.add(keyHeader2, gbc);
        //head.add(keyHeader2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        p4.add(valueHeader2, gbc);
        //head.add(valueHeader2, gbc);


        gbc.ipadx = 20;
        gbc.gridx = 2;
        gbc.gridy = 2;
        p4.add(statusHeader2, gbc);
        //head.add(statusHeader2);

        gbc.gridx = 3;
        gbc.gridy = 2;
        p4.add(trashHeader2, gbc);
        //head.add(trashHeader2);

//        addHeader.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        p4.add(head);
//                    }
//                }
//        );
        tab.add("Header",p4);
        frame.add(tab);
    }

    /**
     * Adding Query Tab
     * adding double textFields and trash Icon
     * adding an "add" icon
     * @param frame
     * @param p3
     * @param tab
     */
    public void query(JFrame frame, JPanel p3, JTabbedPane tab){
        keyQuery1 = new JTextField();
        valueQuery1 = new JTextField();
        keyQuery2 = new JTextField();
        valueQuery2 = new JTextField();
        statusQuery1 = new JCheckBox();
        statusQuery2 = new JCheckBox();
        trashQuery1 = new JButton("X");
        trashQuery2 = new JButton("X");
        addQuery = new JButton("Add");

        p3.setBackground(Color.LIGHT_GRAY);
        p3.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p3.add(addQuery, gbc);


        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 150;
        gbc.gridx = 0;
        gbc.gridy = 1;
        p3.add(keyQuery1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        p3.add(valueQuery1, gbc);

        gbc.ipadx = 20;
        gbc.gridx = 2;
        gbc.gridy = 1;
        p3.add(statusQuery1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        p3.add(trashQuery1, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 150;
        gbc.gridx = 0;
        gbc.gridy = 2;
        p3.add(keyQuery2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        p3.add(valueQuery2, gbc);

        gbc.ipadx = 20;
        gbc.gridx = 2;
        gbc.gridy = 2;
        p3.add(statusQuery2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        p3.add(trashQuery2, gbc);

        tab.add("Query",p3);
        frame.add(tab);

    }

    /**
     * adding Auth Tab
     * @param frame
     * @param p2
     * @param tab
     */
    public void auth(JFrame frame, JPanel p2, JTabbedPane tab){
        p2.setBackground(Color.LIGHT_GRAY);
        tab.add("Auth",p2);
    }

    /**
     * adding Docs Tab
     * @param frame
     * @param p5
     * @param tab
     */
    public void docs(JFrame frame, JPanel p5, JTabbedPane tab){
        p5.setBackground(Color.LIGHT_GRAY);
        tab.add("Auth",p5);
    }
}
