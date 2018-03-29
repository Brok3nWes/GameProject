/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wessel
 */
      class createComponents {

        public createComponents() {
            
        HighScore HighScore = new HighScore();
        HighScore = null; //Tijdelijk! weer weghalen!

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
        Font BigButton = new Font("", Font.BOLD, 75);
        Font BigTitle = new Font("", Font.BOLD, 65);
        Font MediumTitle = new Font("", Font.BOLD, 40);
        Font MediumText = new Font("", Font.PLAIN, 25);

        //information
        String GameTitle = "Maze Game - ";
        String Paused = "Paused";
        String Game = "In-game";
        String MainM = "Main Menu";
        String Ended = "End of Level";

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
        playButton.setPreferredSize(new Dimension(300, 100));
        //the button initializes the game level
        playButton.addActionListener((ActionEvent e) -> {
            GameFrame.setLocationRelativeTo(MainMenu);
            GameFrame.setVisible(true);
            MainMenu.setVisible(false);
            GameFrame.setEnabled(true);
        });

        //back to menu button from pause menu
        JButton showMenu = new JButton("Back to main menu");
        showMenu.setFont(Default);
        showMenu.setPreferredSize(new Dimension(200, 45));
        showMenu.addActionListener((ActionEvent e) -> {
            MainMenu.setVisible(true);
            GameFrame.setVisible(false);
            PauseMenu.setVisible(false);
            EndMenu.setVisible(false);
        });
        //back to menu button from end menu
        JButton showMenu2 = new JButton("Back to main menu");
        showMenu2.setFont(Default);
        showMenu2.setPreferredSize(new Dimension(200, 45));
        showMenu2.addActionListener((ActionEvent e) -> {
            MainMenu.setVisible(true);
            GameFrame.setVisible(false);
            PauseMenu.setVisible(false);
            EndMenu.setVisible(false);
        });
        //exit button
        JButton exitGame = new JButton("Exit");
        exitGame.setFont(Default);
        exitGame.setPreferredSize(new Dimension(150, 60));
        exitGame.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        //show pause menu
        JButton pauseMenu = new JButton("Pause");
        pauseMenu.setFont(Default);
        pauseMenu.addActionListener((ActionEvent e) -> {
            MainMenu.setVisible(false);
            PauseMenu.setLocationRelativeTo(GameFrame);
            PauseMenu.setVisible(true);
            EndMenu.setVisible(false);
            GameFrame.setEnabled(false);
        });
        //resume
        JButton Resume = new JButton("Resume");
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
        JLabel gamefield = new JLabel();
        

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
        JPanel gamePanel = new JPanel();
        GameFrame.add(gamePanel);
        gamePanel.add(pauseMenu);
        gamePanel.setBackground(GREEN);
        gamePanel.add(gamefield);

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

        //Game Frame settings
        GameFrame.setSize(Gamex, Gamey);
        GameFrame.setTitle(GameTitle + Game);
        GameFrame.setResizable(false);
        GameFrame.setLocationRelativeTo(null);

        //these frames are visible on startup
        MainMenu.setVisible(true);
        //EndMenu.setVisible(true);
        }
    }