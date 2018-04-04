package gameproject;


import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

class GameGrid extends Canvas {
   Image img = Toolkit.getDefaultToolkit().getImage("Tile.jpg");
  
int w = img.getWidth(null);
int h = img.getHeight(null);


  int width, height;

  int dimX;

  int dimY;

  GameGrid(int w, int h, int r, int c) {
    setSize(width = w, height = h);
    dimX = r;
    dimY = c;
  }

  public void paint(Graphics g) {
    int i;
    width = getSize().width;
    height = getSize().height;

    // draw the rows
    int rowHt = height / (dimX);
    for (i = 0; i < dimX; i++)
      g.drawLine(0, i * rowHt, width, i * rowHt);

    // draw the columns
    int rowWid = width / (dimY);
    for (i = 0; i < dimY; i++)
      g.drawLine(i * rowWid, 0, i * rowWid, height);
        }
}


public class FieldFrame extends Frame {
  
  FieldFrame(String title, int w, int h, int rows, int cols) {
    setTitle(title);

    // Now create a Canvas and add it to the Frame.
    GameGrid field = new GameGrid(w, h, rows, cols);
    add(field);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
      }
    });

    pack();
  }
}