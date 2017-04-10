package gui;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by user on 08.03.17.
 */
public class MainForm extends JPanel {
    private JPanel rootPanel;
    private JButton openFileButton;
    private JTable table1;
    private JButton button2;
    private JTextArea textArea1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = this;
    }

    public void addActionOpenFileButton(ActionListener listener) {
        openFileButton.addActionListener(listener);
    }
}
