package gameproject;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FieldFrame extends Frame {

    FieldFrame(String title, int w, int h, int rows, int cols) {
        setTitle(title);

        // Now create a Canvas and add it to the Frame.
        GameGrid field = new GameGrid(w, h, rows, cols);
        add(field);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        pack();
    }
}
