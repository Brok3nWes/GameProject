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
public class Barricade {

    private final int xCoordinate;
    private final int yCoordinate;
    private final boolean Transparent;
    private final int code;

    public Barricade(int xCoordinate, int yCoordinate, boolean Transparent, int code) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.Transparent = Transparent;
        this.code = code;
    }
    
}
