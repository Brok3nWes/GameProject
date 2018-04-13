/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import javax.swing.ImageIcon;

/**
 *
 * @author baswo
 */
public class EmptyTile extends Tile {
    private final String path = System.getProperty("user.dir") + "\\src\\Images\\";
    private ImageIcon icon;

    /**
     * Constructor for an EmtyTile
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public EmptyTile(int x, int y) {
        super(x, y);
        this.icon = new ImageIcon(path + "tile.png");
        Transparent = true;
        Symbol = "O";
    }

}
