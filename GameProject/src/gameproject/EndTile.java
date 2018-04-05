/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author baswo
 */
public class EndTile extends Tile {

    public EndTile(int x, int y) {
        super(x, y);
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
