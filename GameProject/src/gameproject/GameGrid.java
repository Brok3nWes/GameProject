/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author baswo
 */
class GameGrid extends Canvas {

    int width, height;

    int dimX;

    int dimY;

    GameGrid(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        dimX = r;
        dimY = c;
    }

    @Override
    public void paint(Graphics g) {
        int i;
        width = getSize().width;
        height = getSize().height;

        // draw the rows
        int rowHt = height / (dimX);
        for (i = 0; i < dimX; i++) {
            g.drawLine(0, i * rowHt, width, i * rowHt);
        }

        // draw the columns
        int rowWid = width / (dimY);
        for (i = 0; i < dimY; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);
        }
    }
}
