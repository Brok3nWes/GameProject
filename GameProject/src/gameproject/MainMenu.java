/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import static java.awt.Color.WHITE;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author baswo
 */
public class MainMenu extends Menu{
    String gameTitle;
    int lvlINT;
    JFrame MainMenu;
    JButton exitGame,playButton,Level1,Level2,Level3,Random;
    Font Default,BigButton,BigTitle,MediumTitle,MediumText;
    
    
    public JFrame MainMenu(){
        gameTitle = "Maze Game - In-Game";
        MainMenu = new JFrame();
        
        Default = new Font("", Font.BOLD, 17);
        BigButton = new Font("", Font.BOLD, 75);
        BigTitle = new Font("", Font.BOLD, 65);
        MediumTitle = new Font("", Font.BOLD, 40);
        MediumText = new Font("", Font.PLAIN, 25);
        
        JLabel selected = new JLabel("Selected:                                      Random");
        selected.setFont(Default);
        
        //main menu play button
        playButton = new JButton("Play!");
        playButton.setFont(BigButton);
        playButton.setPreferredSize(new Dimension(300, 100));
        //the button initializes the game level
        playButton.addActionListener((ActionEvent e) -> {
           // createGameWindow(gameTitle, lvlINT);
           // GameFrame.setLocationRelativeTo(MainMenu);
            MainMenu.setVisible(false);

        });

        //exit button
        exitGame = new JButton("Exit");
        exitGame.setFont(Default);
        exitGame.setPreferredSize(new Dimension(150, 60));
        exitGame.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        //level selector button1 
        Level1 = new JButton("Level 1");
        Level1.setFont(Default);
        Level1.setPreferredSize(new Dimension(150, 60));
        Level1.addActionListener((ActionEvent u) -> {
            lvlINT = 1;
            selected.setText("Selected:                                        Level 1");
            System.out.println("Level " + lvlINT + " selected");

        });
        //level selector button2 
        Level2 = new JButton("Level 2");
        Level2.setFont(Default);
        Level2.setPreferredSize(new Dimension(150, 60));
        Level2.addActionListener((ActionEvent t) -> {
            lvlINT = 2;
            selected.setText("Selected:                                        Level 2");
            System.out.println("Level " + lvlINT + " selected");
        });
        //level selector button3
        Level3 = new JButton("Level 3");
        Level3.setFont(Default);
        Level3.setPreferredSize(new Dimension(150, 60));
        Level3.addActionListener((ActionEvent l) -> {
            lvlINT = 3;
            selected.setText("Selected:                                        Level 3");
            System.out.println("Level " + lvlINT + " selected");
        });

        //level selector random
        Random = new JButton("Random");
        Random.setFont(Default);
        Random.setPreferredSize(new Dimension(150, 60));
        Random.addActionListener((ActionEvent l) -> {
            lvlINT = 0;
            selected.setText("Selected:                                      Random");
            System.out.println("Random level selected");
        });

        //title's
        //Main Menu Title
        JLabel MainTitle = new JLabel("Maze Game");
        MainTitle.setFont(BigTitle);
        MainTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
         //Main menu
        JPanel MainPanel = new JPanel();
        MainPanel.add(MainTitle);
        MainPanel.add(playButton);
        MainPanel.add(selected);
        MainPanel.add(Level1);
        MainPanel.add(Level2);
        MainPanel.add(Level3);
        MainPanel.add(Random);
        MainPanel.add(exitGame);
        MainMenu.add(MainPanel);
        MainPanel.setBackground(WHITE);
        
        
        MainMenu.setSize(450,500);
        MainMenu.setTitle("Maze Game - Main Menu");
        MainMenu.setResizable(false);
        MainMenu.setLocationRelativeTo(null);

        //close operation
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        MainMenu.setVisible(true);
    
        
        return MainMenu;
    }
    
    public void showMenu(){
        
    }
}
