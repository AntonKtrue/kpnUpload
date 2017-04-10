package gui.listeners;



import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;


/**
 * Created by user on 12.03.17.
 */
public class OpenFileListener implements ActionListener {

    private final JFileChooser fc = new JFileChooser();
    private final Component owner;
    private File chosenFile;
    private ArrayList<Subscribable> subscribables = new ArrayList<Subscribable>();

    public OpenFileListener(Component owner) {
        this.owner = owner;
    }

    public void setExtensionFilter(FileFilter fileFilter ) {
        fc.setFileFilter(fileFilter);
    }

    public void register(Subscribable subscribable) {
        subscribables.add(subscribable);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fc.showOpenDialog(owner);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            chosenFile = fc.getSelectedFile();
            update();
        }
    }

    public File getChosenFile() {
        return chosenFile;
    }


    public void update() {
        for(Subscribable subscribable : subscribables) {
            subscribable.update();
        }
    }
}
