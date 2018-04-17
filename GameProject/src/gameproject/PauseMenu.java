/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.Dimension;
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
class PauseMenu extends Menu {

    private final JButton Resume, showMenu, Stop;

    public PauseMenu(MainMenu mm, gameComponents gf, StopWatch time) {
        //pause menu title
        JLabel PauseTitle = new JLabel("Paused");
        PauseTitle.setFont(MediumTitle);

        //back to menu button
        showMenu = new JButton("Back to main menu");
        showMenu.setFont(Default);
        showMenu.setPreferredSize(new Dimension(200, 45));
        showMenu.addActionListener((ActionEvent e) -> {
            this.removeMenu();
            gf.removeMenu();
            mm.showMenu();
        });

        //resume button
        Resume = new JButton("Resume");
        Resume.setFont(Default);
        Resume.setPreferredSize(new Dimension(200, 45));
        Resume.addActionListener((ActionEvent e) -> {
            this.removeMenu();
//            MainFrame.setAlwaysOnTop(false);
            time.start();
//            gf.setFocus();
        });

        //stop button
        Stop = new JButton("Stop");
        Stop.setFont(Default);
        Stop.setPreferredSize(new Dimension(200, 45));
        Stop.addActionListener((ActionEvent e) -> {
            this.removeMenu();
            gf.removeMenu();
            System.exit(0);
        });

        //pause menu
        JPanel pausePanel = new JPanel();
        pausePanel.add(PauseTitle);
        pausePanel.add(Resume);
        pausePanel.add(showMenu);
        pausePanel.add(Stop);
        pausePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),
                "Maze Game - Paused"));
        MainFrame.add(pausePanel);
        //Pause Menu settings
        MainFrame.setSize(300, 350);
        MainFrame.setTitle("Maze Game - Paused");
        MainFrame.setResizable(false);
        MainFrame.setUndecorated(true);
        MainFrame.setLocationRelativeTo(gf.MainFrame);
        MainFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void showMenu() {
        this.MainFrame.setVisible(true);
        this.MainFrame.setAlwaysOnTop(true);
    }
}
