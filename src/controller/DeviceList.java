package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

public class DeviceList {

    private MainController mainController;

    public void setMainContorller(MainController mainController){
        this.mainController = mainController;
    }

    public void searchDevice() throws IOException {
//        String addres = "yandex.ru";
        Process device = Runtime.getRuntime().exec("netsh interface show interface");
        BufferedReader br = new BufferedReader(new InputStreamReader(device.getInputStream(), Charset.forName("CP866")));
        String line;
        int count = 0;
        int countDevice = 1;
        message("Device list:");
        while ((line = br.readLine()) != null) {
            if(count >= 3){
                if(!line.isEmpty()){
                    message(countDevice + ": " + line);
                    countDevice++;
                }
            }
            count++;
        }
        br.close();
    }

    private static String getConsoleEncoding() {
        try {
            Process process = Runtime.getRuntime().exec("chcp");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), "CP866")); // chcp всегда выдаёт в OEM
            String line = reader.readLine();
            if (line != null && line.contains(":")) {
                String codePage = line.substring(line.indexOf(":") + 1).trim();
                return "CP" + codePage;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "CP866"; // запасной вариант
    }

    public <T> void message(T message) {
        mainController.showMessage(message);
    }
}
