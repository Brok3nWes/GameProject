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

    /**
     * Constructor for an EndTile
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public EndTile(int x, int y) {
        super(x, y);
        Symbol = "E";
    }
}
