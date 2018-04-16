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
public class Barricade extends Tile {

    private int code;
    private final String path = System.getProperty("user.dir") + "\\src\\Images\\";
    private ImageIcon icon;

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Constructor for the Barricade
     *
     * @param x set coordinate
     * @param y set coordinate
     * @param code Set the code to an Integer
     */
    public Barricade(int x, int y, int code) {
        super(x, y);
        this.code = code;
        if (code == 200) {
            this.icon = new ImageIcon(path + "barricade200.png");
        } else {
            this.icon = new ImageIcon(path + "barricade100.png");
        }
        
        Symbol = "B";
    }

    /**
     * Getter for the code
     *
     * @return the code that has been set for the barricade
     */
    public int getCode() {
        return code;
    }

}
