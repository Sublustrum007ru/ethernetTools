package view;

import controller.MainController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainGUI extends JFrame {
    private final int WIDTH = 700;
    private final int HEIGHT = 500;
    private static Font font = new Font("Times New Roman", Font.BOLD, 14);
    private JPanel headerPanel, addresPanel, btnHeadPanel, centerPanel, footerPanel;
    private JTextField sourceAddres;
    private JTextArea log;
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public MainGUI() {
        settings();
        createPanels();


        setVisible(true);
    }

    public String getAddres() {
        return sourceAddres.getText();
    }

    private void settings() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createPanels() {
        setLayout(new BorderLayout());
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        add(createFooterPanel(), BorderLayout.SOUTH);
    }

    private Component createHeaderPanel() {
        String name = "Hedaer Panel";
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setFont(font);
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        headerPanel.setBorder(setTitleBorder(name));
        headerPanel.add(CreateAddresHeaderPanel(), BorderLayout.NORTH);
        headerPanel.add(CreateButtonHeaderPanel(), BorderLayout.SOUTH);
        return headerPanel;
    }

    private Component CreateAddresHeaderPanel() {
        String name = "Source addres:";
        addresPanel = new JPanel();
        addresPanel.setFont(font);
        addresPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        addresPanel.setBorder(setTitleBorder(name));
        int lenght = (HEIGHT / 7) - 6;
        sourceAddres = new JTextField(lenght);
        addresPanel.add(sourceAddres);
        return addresPanel;
    }

    private Component CreateButtonHeaderPanel() {
        String name = "Buttons";
        btnHeadPanel = new JPanel();
        btnHeadPanel.setFont(font);
        btnHeadPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        btnHeadPanel.setBorder(setTitleBorder(name));
        JButton btnPing = new JButton("Ping");
        btnPing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainController.clickBTNPing();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton btnLookUp = new JButton("NS Look Up");
        btnLookUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainController.clickBTNNsLookUp();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton btnDeviceList = new JButton("Ethernet Device");
        btnDeviceList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    mainController.clickBTNDeviceList();
                }catch(IOException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
        btnHeadPanel.add(btnPing);
        btnHeadPanel.add(btnLookUp);
        btnHeadPanel.add(btnDeviceList);
        return btnHeadPanel;
    }

    private Component createCenterPanel() {
        String name = "Center panel";
        centerPanel = new JPanel();
        log = new JTextArea();
        log.setFont(font);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(log);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        centerPanel.setBorder(setTitleBorder(name));
        centerPanel.add(sp);
        return sp;
    }

    private Component createFooterPanel() {
        String name = "Footer";
        footerPanel = new JPanel();
        footerPanel.setFont(font);
        footerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        footerPanel.setBorder(setTitleBorder(name));
        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        footerPanel.add(btnClose);
        return footerPanel;
    }

    public <T> void showMessage(T msg) {
        String newMsg = msg + "";
        log.append(newMsg + "\n");
    }

    private TitledBorder setTitleBorder(String name) {
        Border baseBorder = BorderFactory.createEtchedBorder();

        /***
         * name - Имя панели.
         * TitleBorder.CENTER - Выравнивание по горизонтале
         * TitleBorder.TOP - Выравнивание по вертикали
         * font- Шрифт. В данном примере задан в самом начале.
         */
        TitledBorder titledBorder = BorderFactory.createTitledBorder(baseBorder, name, TitledBorder.CENTER, TitledBorder.TOP, font);
        return titledBorder;
    }

    public void closeMainGUI() {
        System.exit(0);
    }

    public void clearArea(){
        log.setText("");
    }
}

