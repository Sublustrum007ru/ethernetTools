package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MyTracert{
    private final MainController mainController = new MainController();
    public MyTracert(String addres) throws IOException {
        Process ping = Runtime.getRuntime().exec("tracert " + addres); //  + " -t");
        BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream(), Charset.forName("CP866")));
        String line;
        while ((line = br.readLine()) != null) {
            showMessage(line);
        }
        br.close();
    }

    private <T>void showMessage(T msg){
        mainController.showMessage(msg);
    }
}
