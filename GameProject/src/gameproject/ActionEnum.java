/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.event.KeyEvent;

/**
 *
 * @author baswo
 */
public enum ActionEnum {

    UP(KeyEvent.VK_UP),
    DOWN(KeyEvent.VK_DOWN),
    LEFT(KeyEvent.VK_LEFT),
    RIGHT(KeyEvent.VK_RIGHT),
    ESCAPE(KeyEvent.VK_ESCAPE),
    RESET(KeyEvent.VK_R);

    private final int EnumCode;

    ActionEnum(int EnumCode) {
        this.EnumCode = EnumCode;
    }

    public int getEnumCode() {
        return EnumCode;
    }

    public static ActionEnum getEnumName(int EnumCode) {
        for (ActionEnum c : values()) { //enhanced forloop for checking if the code is in the values
            if (c.getEnumCode() == EnumCode) {
                return c;
            }
        }
        return null;
    }
}
