package GPlot;

import GUI.GUI;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.ui.ApplicationFrame;

public class GPlotURL extends ApplicationFrame {

    public static final String URLSTRING = "http://www.owncloud.arnaudcouchet.fr/out.csv";

    public GPlotURL(String title, GUI g) {
        super(title);
        try {
            String fileName = g.getJTextField1().getText();
            GPlot.fileList = new ArrayList<>();
            URL url = new URL(fileName);
            Scanner s = new Scanner(url.openStream());
            add(GPlot.getPlotWithScanner(s, g));
        } catch (FileNotFoundException | MalformedURLException ex) {
            Logger.getLogger(GPlotURL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GPlotURL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
    }
}
