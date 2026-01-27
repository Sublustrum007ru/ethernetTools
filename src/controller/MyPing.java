package controller;

import view.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MyPing{
    private MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public void stratPing() throws IOException {
        message("Start ping to addres!!");
//        ping();
    }

    public void ping() throws IOException {
        String addres = "yandex.ru";
        Process ping = Runtime.getRuntime().exec("ping " + addres + " -t");
        BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream(), Charset.forName("CP866")));
        String line;
        while ((line = br.readLine()) != null) {
            message(line);
        }
        br.close();
    }

    public <T>void message (T message){
        mainController.showMessage(message);
    }
}
