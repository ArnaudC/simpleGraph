package GPlot;

import GUI.GUI;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.ui.ApplicationFrame;

public class GPlotFile extends ApplicationFrame {

    public static final String FILE = "./res/out.csv";

    public GPlotFile(String title, GUI g) {
        super(title);
        try {
            String fileName = g.getJTextField2().getText();
            Scanner s = new Scanner(new File(fileName));
            add(GPlot.getPlotWithScanner(s, g));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GPlotFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }
}
