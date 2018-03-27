package gameproject;

import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
            int Smallx = 300;
            int Smally = 350;
            int Gamex = 700;
            int Gamey = 650;
            
            //fonts
            Font Default = new Font("", Font.BOLD, 17);
            Font BigButton = new Font("", Font.BOLD, 35);
            
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
              //buttons
                 //main menu play button
                 JButton playButton = new JButton("Play!");
                 playButton.setFont(BigButton);
                 playButton.setPreferredSize(new Dimension(150,70));
                 //the button initializes the game level
                 playButton.addActionListener((ActionEvent e) -> {
                     GameFrame.setVisible(true);
                     MainMenu.setVisible(false);
        });
                 
                 //back to menu button
                 JButton showMenu = new JButton("Back to main menu");
                 showMenu.setFont(Default);
                 showMenu.setPreferredSize(new Dimension(200,45));
                 showMenu.addActionListener((ActionEvent e) -> {
                     MainMenu.setVisible(true);
                     GameFrame.setVisible(false);
                     PauseMenu.setVisible(false);
                     EndMenu.setVisible(false);
        });
                 //exit button
                 JButton exitGame = new JButton("Exit");
                 exitGame.setFont(Default);
                 exitGame.setPreferredSize(new Dimension(80,40));
                 exitGame.addActionListener((ActionEvent e) -> {
                     System.exit(1);
                 });
                 //show pause menu
                 JButton pauseMenu = new JButton("Pause");
                 pauseMenu.setFont(Default);
                 pauseMenu.addActionListener((ActionEvent e) -> {
                     MainMenu.setVisible(false);
                     PauseMenu.setVisible(true);
                     EndMenu.setVisible(false);
        });
                 //resume
                 JButton Resume = new JButton("Resume");
                 Resume.setFont(Default);
                 Resume.setFont(Default);
                 Resume.setPreferredSize(new Dimension(200,45));
                 Resume.addActionListener((ActionEvent e) -> {
                    
                     PauseMenu.setVisible(false);
                     
        });
                 
                 
              //Panels
                 //Main menu
                 JPanel MainPanel = new JPanel();
                 MainPanel.add(playButton);
                 MainMenu.add(MainPanel);
                 MainPanel.add(exitGame);
                 
                 //pause menu
                 JPanel pausePanel = new JPanel();
                 PauseMenu.add(pausePanel);
                 pausePanel.add(Resume);
                 pausePanel.add(showMenu);
                 pausePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),
                            GameTitle + Paused));
                                  
                 //in-game
                 JPanel gamePanel = new JPanel();
                 GameFrame.add(gamePanel);
                 gamePanel.add(pauseMenu);
                 gamePanel.setBackground(GREEN);
                 
                 
            //configuration of frames
                //Main Menu Settings
                MainMenu.setSize(Bigx,Bigy);
                MainMenu.setTitle(GameTitle + MainM);
                MainMenu.setResizable(false);
                MainMenu.setLocationRelativeTo(null);
            
                //Pause Menu settings
                PauseMenu.setSize(Smallx,Smally);
                PauseMenu.setTitle(GameTitle + Paused);
                PauseMenu.setResizable(false);
                PauseMenu.setUndecorated(true);
                PauseMenu.setLocationRelativeTo(null);
                
                //End Menu settings
                EndMenu.setSize(Smallx,Smally);
                EndMenu.setTitle(GameTitle + Ended);
                EndMenu.setResizable(false);
                EndMenu.setLocationRelativeTo(null);
                
                //Game Frame settings
                GameFrame.setSize(Gamex,Gamey);
                GameFrame.setTitle(GameTitle + Game);
                GameFrame.setResizable(false);
                GameFrame.setLocationRelativeTo(null);
            
            //these frames are visible on startup
            MainMenu.setVisible(true);
            
           
            
            
    }
    
}
