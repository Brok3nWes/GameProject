package gameproject;

import javax.swing.JFrame;

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
        Game game = new Game();
        HighScore HighScore = new HighScore();
        
        //initialize frames
        JFrame MainMenu = new JFrame();
        JFrame PauseMenu = new JFrame();
        JFrame EndMenu = new JFrame();
        JFrame GameFrame = new JFrame();
        
        //main settings of frames
            //frame sizes
            int Bigx = 450;
            int Bigy = 500;
            int Smallx = 350;
            int Smally = 400;
            int Gamex = 700;
            int Gamey = 650;
            
            //information
            String GameTitle =   "Maze Game - ";
            String Paused =      "Paused";
            String Game =        "In-game";
            String MainM =       "Main Menu";
            String Ended =       "End of Level";
        
            //close operations
            MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PauseMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            EndMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //configuration of components
            
            //configuration of frames
                //Main Menu Settings
                MainMenu.setSize(Bigx,Bigy);
                MainMenu.setTitle(GameTitle + MainM);
                MainMenu.setResizable(false);
            
                //Pause Menu settings
                PauseMenu.setSize(Smallx,Smally);
                PauseMenu.setTitle(GameTitle + Paused);
                PauseMenu.setResizable(false);
                
                //End Menu settings
                EndMenu.setSize(Smallx,Smally);
                EndMenu.setTitle(GameTitle + Ended);
                EndMenu.setResizable(false);
                
                //Game Frame settings
                GameFrame.setSize(Gamex,Gamey);
                GameFrame.setTitle(GameTitle + Game);
                GameFrame.setResizable(false);
            
            //these frames are visible on startup
            MainMenu.setVisible(true);
    }
    
}
