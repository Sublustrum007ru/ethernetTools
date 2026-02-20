package view;


import controller.MainController;
import controller.MyPing;
import controller.NsLookUp;

import java.io.IOException;

public class Application {
    public Application() throws IOException {
        MainGUI mainGUI = new MainGUI();
        MainController mainController = new MainController();
        mainGUI.setMainController(mainController);
        mainController.setMainGUI(mainGUI);

        MyPing myPing = new MyPing();
        myPing.setMainController(mainController);
        mainController.setMyPing(myPing);
        NsLookUp nsLookUp = new NsLookUp();
        nsLookUp.setMainController(mainController);
        mainController.setNsLookUp(nsLookUp);

        String helloMSG = "Hello World!!!\nMy name is Sublustrum007\n";
        mainController.showMessage(helloMSG);
    }
} 
