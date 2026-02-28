package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class NsLookUp{
    private MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }
    public void startNsLookUp(String targetAddres) throws IOException {
        Process nsLookUp = Runtime.getRuntime().exec("nslookup " + targetAddres);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        nsLookUp.getInputStream(),
                        Charset.forName("CP1251")  // CP1251 - English CP886 - Russian
                )
        );
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
