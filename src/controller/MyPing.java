package controller;

import view.Application;
import view.MainGUI;
import view.PingInputDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MyPing {
    private MainGUI mainGUI;
    private MainController mainController;
    private int COUNT;
    private int DEFAULT_COUNT = 10;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void stratPing(String targetAddres) throws IOException {
        message("Start ping to " + targetAddres + "!!");
        PingInputDialog dialog = new PingInputDialog(mainGUI);
        dialog.setVisible(true);
        try{
            COUNT = Integer.parseInt(dialog.getCount());
        }catch(NumberFormatException e){
            message("Необходимо ввести число больше 0");
            return;
        }
        ping(targetAddres, COUNT);
    }

    public void ping(String addres, int targetCount) throws IOException {
//        String addres = "yandex.ru";
        Process ping = Runtime.getRuntime().exec("ping -n " + targetCount + " " + addres);
        BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream(), Charset.forName("CP866")));
        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            message(line);
            count++;
        }
        br.close();
    }

    public <T> void message(T message) {
        mainController.showMessage(message);
    }
}