import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.lang.reflect.Method;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.lang.reflect.Method;


public class Menu {
    JMenuBar menuBar;
    JMenuItem menuItem;
    JMenu application;
    JMenu view;
    JMenu help;
    JMenu options;
    JMenu exit;
    JMenuItem hideOnTray;
    JMenuItem toggleFullScreen;
    JMenuItem toggleSidebar;
    JMenuItem helpHelp;
    JMenuItem about;
    JLabel labelHelp;
    JLabel labelAbout;
    JButton test;
    boolean hasBeenClicked = false;
    boolean isClicked = false;


    /**
     * for menu
     * add application menu and its submenus
     * add view menu and its submenus
     * add help menu and its submenus
     * added actionListener to menuItems
     * @param frame
     */
    public Menu(JFrame frame, JPanel panel){

        //Create the menu bar.
        menuBar = new JMenuBar();
        test = new JButton("testtt");

        //Build the application menu.
        application = new JMenu("Application");
        application.setMnemonic(KeyEvent.VK_A);
        application.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(application);

        //Build view menu
        view = new JMenu("View");
        view.setMnemonic(KeyEvent.VK_A);
        view.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(view);

        //Build Help menu
        help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_A);
        help.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(help);

        //toggleFullScreen menu item

        view.addSeparator();
        toggleFullScreen = new JMenuItem("Toggle Full Screen");
        toggleFullScreen.setMnemonic(KeyEvent.VK_S);
        view.add(toggleFullScreen);
        //toggleFullScreen.add(test);
        toggleFullScreen.setMnemonic( 'F' );
        toggleFullScreen.setAccelerator(KeyStroke.getKeyStroke('F'));
        toggleFullScreen.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!isClicked)
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        else
                            frame.setSize(frame.getPreferredSize());
                        isClicked = !isClicked;
                    }
                }
        );
        view.add(toggleFullScreen);

        //toggleSideBar submenu
        view.addSeparator();
        toggleSidebar = new JMenuItem("Toggle Sidebar");
        toggleFullScreen.setMnemonic(KeyEvent.VK_S);
        view.add(toggleSidebar);
        //toggleSidebar.setAccelerator(KeyStroke.getKeyStroke('S'));
        toggleSidebar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(!hasBeenClicked) {
                            panel.setVisible(false);
                        }
                        else {
                            panel.setVisible(true);
                        }
                        hasBeenClicked = !hasBeenClicked;
                    }
                }
        );


        //About menuItem
        labelAbout = new JLabel("<html>Email: k.kasiri@aut.ac.ir<br/>Student number: 9831006<br/>Name: kiana</html> ", SwingConstants.CENTER);
        help.addSeparator();
        about = new JMenuItem("About");
        about.setMnemonic(KeyEvent.VK_A);
        help.add(about);
        about.setMnemonic( 'A' );
        about.setAccelerator(KeyStroke.getKeyStroke('A'));
        about.addActionListener(
                new ActionListener() {
                    public void actionPerformed( ActionEvent e )
                    {
                        JOptionPane.showMessageDialog(frame, labelAbout);
                    }
                }
        );


        //Help menu item
        labelHelp = new JLabel("something to help you , it's in the next phase:))");
        help.addSeparator();
        helpHelp = new JMenuItem("Help");
        helpHelp.setMnemonic(KeyEvent.VK_H);
        help.add(helpHelp);
        helpHelp.setMnemonic( 'H' );
        helpHelp.setAccelerator(KeyStroke.getKeyStroke('H'));
        helpHelp.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        JOptionPane.showMessageDialog(frame, labelHelp);
                    }
                }

        );

        //options submenu
        application.addSeparator();
        options = new JMenu("Options");
        options.setMnemonic(KeyEvent.VK_S);

        application.add(options);

        //a group of check box menu items for option submenu
        options.addSeparator();
        JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("exit/system tray");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        options.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("follow redirect");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        options.add(cbMenuItem);


        final JPopupMenu popup = new JPopupMenu();
        // New project menu item
        JMenuItem menuItem = new JMenuItem("New Project...",
                new ImageIcon("images/newproject.png"));
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Project");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "New Project clicked!");
            }
        });
        popup.add(menuItem);
        menuBar.add(popup);
        // New File menu item
        menuItem = new JMenuItem("New File...",
                new ImageIcon("images/newfile.png"));
        menuItem.setMnemonic(KeyEvent.VK_F);
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "New File clicked!");
            }
        });
        popup.add(menuItem);
        menuBar.add(popup);


        //exit submenu
        application.addSeparator();
        exit = new JMenu("Exit");
        exit.setMnemonic(KeyEvent.VK_S);
        application.add(exit);
        JMenuItem exitExit = new JMenuItem("Exit");
        exit.add(exitExit);
        //actionListener for exit
        class exitApp implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        exitExit.addActionListener(new exitApp());
        exitExit.setAccelerator(KeyStroke.getKeyStroke('E'));
        frame.setJMenuBar(menuBar);

        //system hide tray
        hideOnTray = new JMenuItem("Hide on system tray");
        exit.add(hideOnTray);
        hideOnTray.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                frame.setExtendedState(JFrame.ICONIFIED);
                                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                            }
                        });
                    }
                }
        );

    }
}
