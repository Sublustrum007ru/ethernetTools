package controller;

import view.MainGUI;

import java.io.IOException;

public class MainController implements MainView {

    private MainGUI mainGUI;
    private MyPing myPing;

    public void setMainGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    public void setMyPing(MyPing myPing) {
        this.myPing = myPing;
    }

    public void clickBTNPing() throws IOException {
        myPing.stratPing();
    }

    public void clickBTNNsLookUp() throws IOException {
        showMessage("Click button NsLookUp");
    }


    @Override
    public <T> void showMessage(T message) {
        mainGUI.showMessage(message);
    }
}
