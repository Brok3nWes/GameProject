/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.Canvas;
import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wessel
 */
class createComponents {
    String nr;
    JPanel gamePanel;
    JLabel gamefield, tile;
    JButton playButton, showMenu, showMenu2, Resume, exitGame, pauseMenu;
    JFrame GameFrame,MainMenu,PauseMenu,EndMenu;
    Font Default,BigButton,BigTitle,MediumTitle,MediumText;
    int i;
    public createComponents(String gameField, String nr) {

        HighScore HighScore = new HighScore();
        HighScore = null; //Tijdelijk! weer weghalen!
        MainMenu = new JFrame();
        PauseMenu = new JFrame();
        EndMenu = new JFrame();
        GameFrame = new JFrame();
        //main settings of frames
        //frame sizes
        int Bigx = 450;
        int Bigy = 500;
        int Smallx = 300;
        int Smally = 350;
        int Gamex = 700;
        int Gamey = 650;

        //fonts
        Default = new Font("", Font.BOLD, 17);
        BigButton = new Font("", Font.BOLD, 75);
        BigTitle = new Font("", Font.BOLD, 65);
        MediumTitle = new Font("", Font.BOLD, 40);
        MediumText = new Font("", Font.PLAIN, 25);

        //information
        String GameTitle = "Maze Game - ";
        String Paused = "Paused";
        String Game = "In-game";
        String MainM = "Main Menu";
        String Ended = "End of Level";
        

        //configuration of components
        //buttons
        //main menu play button
        playButton = new JButton("Play!");
        playButton.setFont(BigButton);
        playButton.setPreferredSize(new Dimension(300, 100));
        //the button initializes the game level
        playButton.addActionListener((ActionEvent e) -> {
            GameFrame.setLocationRelativeTo(MainMenu);
            new FieldFrame(GameTitle + Game, 300, 300, 10, 10).setVisible(true);
            createGameWindow("");
            MainMenu.setVisible(false);
            GameFrame.setVisible(true);
            GameFrame.setEnabled(true);
        });

        //back to menu button from pause menu
        showMenu = new JButton("Back to main menu");
        showMenu.setFont(Default);
        showMenu.setPreferredSize(new Dimension(200, 45));
        showMenu.addActionListener((ActionEvent e) -> {
            MainMenu.setLocationRelativeTo(GameFrame);
            MainMenu.setVisible(true);
            GameFrame.setVisible(false);
            PauseMenu.setVisible(false);
            EndMenu.setVisible(false);
        });
        //back to menu button from end menu
        showMenu2 = new JButton("Back to main menu");
        showMenu2.setFont(Default);
        showMenu2.setPreferredSize(new Dimension(200, 45));
        showMenu2.addActionListener((ActionEvent e) -> {
            MainMenu.setLocationRelativeTo(GameFrame);
            MainMenu.setVisible(true);
            GameFrame.setVisible(false);
            PauseMenu.setVisible(false);
            EndMenu.setVisible(false);
        });
        //exit button
        exitGame = new JButton("Exit");
        exitGame.setFont(Default);
        exitGame.setPreferredSize(new Dimension(150, 60));
        exitGame.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        //pause menu
        pauseMenu = new JButton("Pause");
        pauseMenu.setFont(Default);
        pauseMenu.setPreferredSize(new Dimension(100, 50));
        pauseMenu.addActionListener((ActionEvent e) -> {
            MainMenu.setVisible(false);
            PauseMenu.setLocationRelativeTo(GameFrame);
            PauseMenu.setVisible(true);
            EndMenu.setVisible(false);
            GameFrame.setEnabled(false);

        });
        //resume
        Resume = new JButton("Resume");
        Resume.setFont(Default);
        Resume.setFont(Default);
        Resume.setPreferredSize(new Dimension(200, 45));
        Resume.addActionListener((ActionEvent e) -> {
            GameFrame.setEnabled(true);
            PauseMenu.setVisible(false);

        });
        //title's
        //Main Menu Title
        JLabel MainTitle = new JLabel("Maze Game");
        MainTitle.setFont(BigTitle);
        MainTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        //pause menu title
        JLabel PauseTitle = new JLabel("Paused");
        PauseTitle.setFont(MediumTitle);
        //end title
        JLabel EndTitle = new JLabel("End Reached!");
        EndTitle.setFont(MediumTitle);

        //Highscore label
        JLabel HS = new JLabel("Highscore: " + HighScore);
        HS.setFont(MediumText);
        //score after round
        JLabel YS = new JLabel("Your Score: ");
        YS.setFont(MediumText);

        //game as text
        /*gamefield = new JLabel();
        JScrollPane gamescrl = new JScrollPane(gamefield);
        gamescrl.setBounds(200, 200, 200, 200);*/

        //Panels
        //Main menu
        JPanel MainPanel = new JPanel();
        // MainPanel.setLayout(new SpringLayout());
        MainPanel.add(MainTitle);
        MainPanel.add(playButton);
        MainMenu.add(MainPanel);
        MainPanel.add(exitGame);
        MainPanel.setBackground(WHITE);
        //components of main menu

        //pause menu
        JPanel pausePanel = new JPanel();
        PauseMenu.add(pausePanel);
        pausePanel.add(PauseTitle);
        pausePanel.add(Resume);
        pausePanel.add(showMenu);
        pausePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),
                GameTitle + Paused));

        //in-game
        

        //end of level menu
        JPanel endPanel = new JPanel();
        endPanel.add(EndTitle);
        endPanel.add(HS);
        endPanel.add(YS);
        endPanel.add(showMenu2);
        EndMenu.add(endPanel);
        endPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),
                GameTitle + Ended));

        //configuration of frames
        //Main Menu Settings
        MainMenu.setSize(Bigx, Bigy);
        MainMenu.setTitle(GameTitle + MainM);
        MainMenu.setResizable(false);
        MainMenu.setLocationRelativeTo(null);

        //Pause Menu settings
        PauseMenu.setSize(Smallx, Smally);
        PauseMenu.setTitle(GameTitle + Paused);
        PauseMenu.setResizable(false);
        PauseMenu.setUndecorated(true);
        PauseMenu.setLocationRelativeTo(null);

        //End Menu settings
        EndMenu.setSize(Smallx, Smally);
        EndMenu.setTitle(GameTitle + Ended);
        EndMenu.setResizable(false);
        EndMenu.setLocationRelativeTo(null);
        EndMenu.setUndecorated(true);

        

        //these frames are visible on startup
        MainMenu.setVisible(true);
        //EndMenu.setVisible(true);

        //close operations
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PauseMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        EndMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void createGameWindow(String GameTitle) {
        GameFrame = new JFrame(GameTitle);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Game Frame settings
        GameFrame.setSize(700,650);
        GameFrame.setResizable(false);
        GameFrame.setLocationRelativeTo(null);
        gamePanel = new JPanel();
        Canvas gameCanvas = new Canvas();
        //   gameCanvas.paint(Graphics);
        gamePanel.add(pauseMenu);
        gamePanel.add(gameCanvas);
        gamePanel.setBackground(GREEN);
        //GameFrame.add(gamescrl);
        GameFrame.add(gamePanel);
        JLabel till = createTile(i);
        
        for (i = 0; i<10; i++){
        GameFrame.add(till);
        }
        GameFrame.pack();
    }
    
    
    public JLabel createTile(int i){
        String tilenr = Integer.toString(i);
        
        tile = new JLabel(tilenr);
        tile.setSize(200,200);
        
        System.out.print("derp");
        return tile;
}
}
