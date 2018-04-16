/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

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
 * @author baswo
 */
public class PauseMenu extends Menu {

    JFrame PauseMenu;
    JButton Resume, showMenu,Stop;
    Font MediumText, MediumTitle, Default;

    public PauseMenu() {
        Menu menu = new Menu();
        StopWatch time = new StopWatch();
        
        Default = new Font("", Font.BOLD, 17);
        MediumText = new Font("", Font.PLAIN, 25);
        MediumTitle = new Font("", Font.BOLD, 40);
        PauseMenu = new JFrame();
        //pause menu title
        JLabel PauseTitle = new JLabel("Paused");
        PauseTitle.setFont(MediumTitle);
        //back to menu button from pause menu
        showMenu = new JButton("Back to main menu");
        showMenu.setFont(Default);
        showMenu.setPreferredSize(new Dimension(200, 45));
        showMenu.addActionListener((ActionEvent e) -> {
            menu.exitToMainMenu();
        });

        //resume
        Resume = new JButton("Resume");
        Resume.setFont(Default);
        Resume.setPreferredSize(new Dimension(200, 45));
        Resume.addActionListener((ActionEvent e) -> {
            hidePauseMenu();
            time.start();
        });

        Stop = new JButton("Stop");
        Stop.setFont(Default);
        Stop.setPreferredSize(new Dimension(200, 45));
        Stop.addActionListener((ActionEvent e) -> {
            time.stop();
            time.getElapsedTimeSecs();
        });
        //pause menu
        JPanel pausePanel = new JPanel();
        PauseMenu.add(pausePanel);
        pausePanel.add(PauseTitle);
        pausePanel.add(Resume);
        pausePanel.add(showMenu);
        pausePanel.add(Stop);
        pausePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),
                "Maze Game - Paused"));

        //Pause Menu settings
        PauseMenu.setSize(300, 350);
        PauseMenu.setTitle("Maze Game - Paused");
        PauseMenu.setResizable(false);
        PauseMenu.setUndecorated(true);
        PauseMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void showPauseMenu() {
        PauseMenu.setLocationRelativeTo(PauseMenu);
        PauseMenu.setVisible(true);
    }

    public void hidePauseMenu() {
        PauseMenu.setVisible(false);
    }
}
