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
public class EndTile extends Tile {

    private final String path = System.getProperty("user.dir") + "\\src\\Images\\";
    private ImageIcon icon;

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Constructor for an EndTile
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public EndTile(int x, int y) {
        super(x, y);
        this.icon = new ImageIcon(path + "end.png");
        Transparent = true;
        Symbol = "E";
    }

    public void setHighScore() {
    }

    public void showHighScore() {
        System.out.println("Ya highscore = amazing BOI");
    }

    public void endLvl() {

    }

}
