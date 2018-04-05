/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.BorderLayout;
import java.awt.Canvas;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
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
   ArrayList<String> testtiles = new ArrayList<String>(100); 
    
    String nr,gameTitle;
    JPanel gamePanel,TPanel;
    JLabel gamefield, tile;
    JButton playButton, showMenu, showMenu2, Resume, exitGame, pauseMenu,Retry,Reload;
    JFrame GameFrame,MainMenu,PauseMenu,EndMenu;
    Font Default,BigButton,BigTitle,MediumTitle,MediumText;
    int i = 0;
    public createComponents(String gameField, String nr) {
        gameTitle = "Maze Game - In-Game";
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
            
           // new FieldFrame(GameTitle + Game, 300, 300, 10, 10).setVisible(true);
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
        Resume.setPreferredSize(new Dimension(200, 45));
        Resume.addActionListener((ActionEvent e) -> {
            GameFrame.setEnabled(true);
            PauseMenu.setVisible(false);
});
        Retry = new JButton("Retry");
        Retry.setFont(Default);
        Retry.setPreferredSize(new Dimension(100, 45));
        Retry.addActionListener((ActionEvent r) -> {
            //character resetten
            //timer resetten
            //keys en barricades resetten
            
    });
        Reload = new JButton("↺");
        Reload.setFont(Default);
        Reload.setPreferredSize(new Dimension(50, 50));
        Reload.addActionListener((ActionEvent rl) -> {
            testtiles.clear();
            GameFrame.dispose();
            createGameWindow(gameTitle);
            
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
               
        GameFrame.setSize(700,650);
        GameFrame.setResizable(false);
        GameFrame.setLocationRelativeTo(null);
        gamePanel = new JPanel();
        Canvas gameCanvas = new Canvas();
        //   gameCanvas.paint(Graphics);
        gamePanel.add(Retry);
        gamePanel.add(Reload);
        gamePanel.add(pauseMenu);
        gamePanel.add(gameCanvas);
        gamePanel.setBackground(GREEN);
        //GameFrame.add(gamescrl);
        GameFrame.add(gamePanel);
        TPanel = new JPanel();
        for (i = 0; i<100; i++){    
        randomizeTiles();
            
        }
        TPanel.setLayout(new GridLayout(10,10));
        TPanel.setBackground(BLUE);
        
        
        gamePanel.add(TPanel);
        GameFrame.pack();
        GameFrame.setLocationRelativeTo(GameFrame);
        GameFrame.setVisible(true);
        GameFrame.setEnabled(true);
    }
    public void randomizeTiles(){
        if (i<1){
        testtiles.add("start");
        } else{
            Random rnd = new Random();
            int  n = rnd.nextInt(3);
            
            if(n==0){
                testtiles.add("tile");
            }
            if(n==1){
                testtiles.add("barricade");
            }
            if(n==2){
                testtiles.add("wall");
            }
            /*if(n==3){
            testtiles.add("key");
            }*/
            if(n==6){
                testtiles.add("character");
            }
            if(i==98){
                testtiles.add("end");
            }
}   
        createTile(i);
    }
    
    public JPanel createTile(int i){
        String tilenr = Integer.toString(i);
        ImageIcon chosenTile = null;
        ImageIcon tileImage = new ImageIcon("E:\\Documents\\GitHub\\GameProject\\tile.png");
        ImageIcon barricade = new ImageIcon("E:\\Documents\\GitHub\\GameProject\\barricade.png");
        ImageIcon wall = new ImageIcon("E:\\Documents\\GitHub\\GameProject\\wall.png");
        ImageIcon start = new ImageIcon("E:\\Documents\\GitHub\\GameProject\\start.png");
        ImageIcon end = new ImageIcon("E:\\Documents\\GitHub\\GameProject\\end.png");
        ImageIcon key = new ImageIcon("E:\\Documents\\GitHub\\GameProject\\key.png");
        ImageIcon player = new ImageIcon("E:\\Documents\\GitHub\\GameProject\\player.png");
        
        if(testtiles.get(i).equals("tile")){
            chosenTile = tileImage;
        }
        if(testtiles.get(i).equals("barricade")){
            chosenTile = barricade;
        }
        if(testtiles.get(i).equals("wall")){
            chosenTile = wall;
        }
        if(testtiles.get(i).equals("start")){
            chosenTile = start;
        }
        if(testtiles.get(i).equals("end")){
            chosenTile = end;
        }
        if(testtiles.get(i).equals("key")){
            chosenTile = key;
        }
        if(testtiles.get(i).equals("character")){
            chosenTile = player;
        }
        
        tile = new JLabel(chosenTile);
        tile.setSize(10,10);
        tile.setSize(200,200);
        TPanel.add(tile);
        
        return TPanel;
}
}
