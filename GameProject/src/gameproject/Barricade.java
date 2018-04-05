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

    private final int xCoordinate, yCoordinate, code;
    private final boolean Transparent;
    private final String Symbol;

    public Barricade(int xCoordinate, int yCoordinate, int code) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.Transparent = false;
        this.code = code;
        Symbol = "B";
    }

    public int getCode() {
        return code;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public String getSymbol() {
        return Symbol;
    }

}
