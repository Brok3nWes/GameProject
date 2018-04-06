/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import static gameproject.PlayingField.dimX;
import static gameproject.PlayingField.dimY;
import java.awt.BorderLayout;
import static java.awt.Color.BLUE;
import static java.awt.Color.GRAY;
import static java.awt.Color.WHITE;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wessel
 */
class createComponents {
    
    ArrayList<String> testtiles = new ArrayList<>(100);
    String nr, gameTitle;
    
    JPanel buttonPanel, TPanel,levelPanel;
    JLayeredPane  gamePanel, layeredTile;
    JLabel gamefield, tile;
    JButton playButton, showMenu, showMenu2, Resume, exitGame, pauseMenu, Retry, Reload,Finish,Level1,Level2,Level3;
    JFrame GameFrame, MainMenu, PauseMenu, EndMenu;
    Font Default, BigButton, BigTitle, MediumTitle, MediumText;

        String path = System.getProperty("user.dir") + "\\src\\Images\\";
        ImageIcon chosenTile = null;
        ImageIcon tileImage = new ImageIcon(path + "tile.png");
        ImageIcon barricade = new ImageIcon(path + "barricade.png");
        ImageIcon wall = new ImageIcon(path + "wall.png");
        ImageIcon start = new ImageIcon(path + "start.png");
        ImageIcon end = new ImageIcon(path + "end.png");
        ImageIcon key = new ImageIcon(path + "key.png");
        ImageIcon player = new ImageIcon(path + "player.png");
        
    public createComponents(String gameField) {
        PlayingField level = new PlayingField();
        
        gameTitle = "Maze Game - In-Game";
        HighScore HighScore = new HighScore();
        
        MainMenu = new JFrame();
        PauseMenu = new JFrame();
        EndMenu = new JFrame();
        GameFrame = new JFrame();

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
            
            testtiles.clear();
            createGameWindow(gameTitle);
            GameFrame.setLocationRelativeTo(MainMenu);
            MainMenu.setVisible(false);

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
        pauseMenu.setPreferredSize(new Dimension(100, 60));
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
        Resume.setPreferredSize(new Dimension(200, 45));
        Resume.addActionListener((ActionEvent e) -> {
            GameFrame.setEnabled(true);
            PauseMenu.setVisible(false);
        });
        Retry = new JButton("Retry");
        Retry.setFont(Default);
        Retry.setPreferredSize(new Dimension(100, 60));
        Retry.addActionListener((ActionEvent r) -> {
            //character resetten
            //timer resetten
            //keys en barricades resetten

        });
        Reload = new JButton("↺");
        Reload.setFont(Default);
        Reload.setPreferredSize(new Dimension(60, 60));
        Reload.addActionListener((ActionEvent rl) -> {
            testtiles.clear();
            GameFrame.dispose();
            createGameWindow(gameTitle);
         });   
        //debug end button
        Finish = new JButton("debug");
        Finish.setFont(Default);
        
        Finish.setPreferredSize(new Dimension(90, 50));
        Finish.addActionListener((ActionEvent f) -> {
            EndMenu.setLocationRelativeTo(GameFrame);
            EndMenu.setVisible(true);
       });
        //level1 selector button1 
        Level1 = new JButton("Level 1");
        Level1.setFont(Default);
        Level1.setPreferredSize(new Dimension(150, 60));
        Level1.addActionListener((ActionEvent u) -> {
            level.changeLevel(1);
            
        });
        //level1 selector button2 
        Level2 = new JButton("Level 2");
        Level2.setFont(Default);
        Level2.setPreferredSize(new Dimension(150, 60));
        Level2.addActionListener((ActionEvent t) -> {
            level.changeLevel(2);
           
            
        });
        //level1 selector button3
        Level3 = new JButton("Level 3");
        Level3.setFont(Default);
        Level3.setPreferredSize(new Dimension(150, 60));
        Level3.addActionListener((ActionEvent l) -> {
            level.changeLevel(3);
            
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

        //Panels
        
        //Main menu
        JPanel MainPanel = new JPanel();
        MainPanel.add(MainTitle);
        MainPanel.add(playButton);
        
        MainMenu.add(MainPanel);
        
        MainPanel.add(Level1);
        MainPanel.add(Level2);
        MainPanel.add(Level3);
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
        
        //End Menu settings
        EndMenu.setSize(Smallx, Smally);
        EndMenu.setTitle(GameTitle + Ended);
        EndMenu.setResizable(false);
        EndMenu.setUndecorated(true);

        //close operations
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PauseMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        EndMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //these frames are visible on startup
        MainMenu.setVisible(true);
    }

    public void createGameWindow(String GameTitle) {
        System.out.println();
        GameFrame = new JFrame(GameTitle);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonPanel = new JPanel();
        GameFrame.setSize(700, 650);
        GameFrame.setResizable(false);
        GameFrame.setLayout(new BorderLayout());
        gamePanel = new JLayeredPane();
        gamePanel.setLayout(new BorderLayout(10, 5));
        buttonPanel.add(pauseMenu);
        buttonPanel.add(Retry);
        buttonPanel.add(Reload);
        buttonPanel.add(Finish);
        buttonPanel.setBackground(GRAY);
        gamePanel.setBackground(GRAY);
        GameFrame.add(buttonPanel);
        GameFrame.add(gamePanel, BorderLayout.PAGE_END);
        TPanel = new JPanel();
        TPanel.setLayout(new GridLayout(10, 10, 0, 0));
       
        gamePanel.add(TPanel, BorderLayout.PAGE_END);
        GameFrame.setLocationRelativeTo(GameFrame);
        GameFrame.setVisible(true);
        GameFrame.setEnabled(true);
        PlayingField field = new PlayingField();
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
               
                Tile tilee = field.getPf()[x][y].getTile();
                createTile(tilee);

            }
        }
         
//            randomizeTiles();
        GameFrame.pack();
    }

    public JPanel createTile(Tile t) {

        if (t.Symbol.equals("O")) {
            chosenTile = tileImage;
        }
        if (t.Symbol.equals("B")) {
            chosenTile = barricade;
        }
        if (t.Symbol.equals("W")) {
            chosenTile = wall;
        }
        if (t.Symbol.equals("S")) {
            chosenTile = start;
        }
        if (t.Symbol.equals("E")) {
            chosenTile = end;
        }
        if (t.Symbol.equals("K")) {
            chosenTile = key;
        }
        if (t.Symbol.equals("C")) {
            chosenTile = player;
        }
        
        layeredTile = new JLayeredPane();
        layeredTile.setLayout(new BorderLayout(10, 5));
        tile = new JLabel(chosenTile);
        layeredTile.add(tile);
        
        TPanel.add(layeredTile);
        
        return TPanel;
    }
}
