package gameproject;

import javax.swing.JButton;



/**
 *
 * @author Wessel Bakker - 17094801
 * @author Bas Woltjer - 17067057
 */
public class GameProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Game game = new Game();

        String gameField = null;
        createComponents component = new createComponents(gameField);
       
        Lvl lvl1 = new Lvl(component);
        //component.setGamefield(gameField);

    }

   

    

}
