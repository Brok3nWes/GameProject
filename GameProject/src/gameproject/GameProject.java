package gameproject;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;



/**
 *
 * @author Wessel Bakker - 17094801
 * @author Bas Woltjer - 17067057
 */
public class GameProject {

  
    public static void main(String[] args) {
//        Game game = new Game();

        String gameField = null;
        createComponents component = new createComponents(gameField);
       
        Lvl lvl1 = new Lvl(component);
        //component.setGamefield(gameField);
        
    }

   

    

}
