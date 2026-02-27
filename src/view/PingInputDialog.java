package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PingInputDialog extends JDialog {
    private JTextField textField;
    private boolean okPressed = false;

    public PingInputDialog(Frame owner) {
        super(owner, "Packages", true); // true = модальный режим
        setLayout(new FlowLayout());
        JPanel labels = new JPanel();
        labels.setLayout(new BorderLayout());
        JLabel label1 = new JLabel("Введите необходимое");
        JLabel label2 = new JLabel("колличество пакетов");
        labels.add(label1, BorderLayout.NORTH);
        labels.add(label2, BorderLayout.SOUTH);
        setLayout(new FlowLayout());
        add(labels);
        textField = new JTextField(5);
        add(textField);

        JButton okButton = new JButton("OK");
        okButton.addActionListener((ActionEvent e) -> {
            okPressed = true;
            dispose(); // закрываем диалог
        });
        add(okButton);

        pack(); // подгоняем размер под содержимое
        setLocationRelativeTo(owner); // центрируем относительно родителя
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // чтобы при закрытии крестиком не оставался в памяти
    }

    /**
     * Возвращает введённое число, если была нажата OK.
     * При ошибке парсинга или если диалог закрыт без OK возвращает -1.
     * Можно изменить логику под свои нужды (например, выбрасывать исключение).
     */
    public String getCount() {
        return textField.getText();
    }
}