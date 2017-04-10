package gui;

import gui.listeners.OpenFileListener;
import gui.listeners.Subscribable;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by user on 23.02.17.
 */
public class Window extends JFrame implements Subscribable {
    private MainForm mainForm = new MainForm();
    private OpenFileListener openFileListener = new OpenFileListener(mainForm);

    public Window(int width, int height, boolean resizeable) {
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(800,600);
        setResizable(false);
        FileFilter fileFilter = new FileNameExtensionFilter("Flat ODG","fodg");
        openFileListener.setExtensionFilter(fileFilter);
        openFileListener.register(this);
        mainForm.addActionOpenFileButton(openFileListener);
        setContentPane(mainForm);
        setVisible(true);

    }


    @Override
    public void update() {
        //System.out.println(openFileListener.getChosenFile().getName());
    }
}
