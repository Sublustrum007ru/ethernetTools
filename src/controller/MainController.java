package controller;

import view.MainGUI;

import java.io.IOException;

public class MainController implements MainView {

    private MainGUI mainGUI;
    private MyPing myPing;
    private NsLookUp nsLookUp;

    public void setMainGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    public void setMyPing(MyPing myPing) {
        this.myPing = myPing;
    }

    public void setNsLookUp(NsLookUp nsLookUp) {
        this.nsLookUp = nsLookUp;
    }

    public void clickBTNPing() throws IOException {
        if (checkInputAddres()) {
            showMessage("Поле ввода адреса не может быть пустым!!!\nВведите адрес");
            return;
        }
        mainGUI.clearArea();
        myPing.stratPing(mainGUI.getAddres());

    }

    public void clickBTNNsLookUp() throws IOException {
        if (checkInputAddres()) {
            showMessage("Поле ввода адреса не может быть пустым!!!\nВведите адрес");
            return;
        }
        mainGUI.clearArea();
        nsLookUp.startNsLookUp(mainGUI.getAddres());
    }

    private boolean checkInputAddres() {
        if (mainGUI.getAddres().isEmpty()) {
            return true;
        }
        return false;
    }


    @Override
    public <T> void showMessage(T message) {
        mainGUI.showMessage(message);
    }
}
