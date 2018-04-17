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
class EndOfLvlMenu extends Menu {
    private final JButton showMenu2;
    private final JLabel EndTitle, Time;

    public EndOfLvlMenu(MainMenu mm, gameComponents gf, String time) {
        EndTitle = new JLabel("End Reached!");
        EndTitle.setFont(MediumTitle);
        Time = new JLabel("You did it in " + time + " seconds!");
        Time.setFont(Default);        
        //back to menu button from end menu
        showMenu2 = new JButton("Back to main menu");
        showMenu2.setFont(Default);
        showMenu2.setPreferredSize(new Dimension(200, 45));
        showMenu2.addActionListener((ActionEvent e) -> {
            gf.removeMenu();
            MainFrame.dispose();
            mm.showMenu();
        });

        //end of level menu
        JPanel endPanel = new JPanel();
        endPanel.add(EndTitle);
        endPanel.add(Time);
        endPanel.add(showMenu2);
        endPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),
                "Maze Game - End of Level"));
        MainFrame.add(endPanel);

        //End Menu settings
        MainFrame.setSize(300, 350);
        MainFrame.setTitle("Maze Game - End of Level");
        MainFrame.setResizable(false);
        MainFrame.setUndecorated(true);
        MainFrame.setLocationRelativeTo(MainFrame);
        MainFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }
}
