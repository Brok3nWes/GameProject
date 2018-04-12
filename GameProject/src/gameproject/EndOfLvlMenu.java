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
class EndOfLvlMenu extends Menu {

    JFrame EndMenu;
    JButton showMenu2;
    Font MediumText, MediumTitle, Default;

    public JFrame EndOfLvlMenu() {
        Default = new Font("", Font.BOLD, 17);
        MediumText = new Font("", Font.PLAIN, 25);
        MediumTitle = new Font("", Font.BOLD, 40);
        EndMenu = new JFrame();

        JLabel EndTitle = new JLabel("End Reached!");
        EndTitle.setFont(MediumTitle);
        //Highscore label
        JLabel HS = new JLabel("Highscore: ");
        HS.setFont(MediumText);
        //score after round
        JLabel YS = new JLabel("Your Score: ");
        YS.setFont(MediumText);

        //back to menu button from end menu
        showMenu2 = new JButton("Back to main menu");
        showMenu2.setFont(Default);
        showMenu2.setPreferredSize(new Dimension(200, 45));
        showMenu2.addActionListener((ActionEvent e) -> {

        });

        //end of level menu
        JPanel endPanel = new JPanel();
        endPanel.add(EndTitle);
        endPanel.add(HS);
        endPanel.add(YS);
        endPanel.add(showMenu2);
        EndMenu.add(endPanel);
        endPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),
                "Maze Game - End of Level"));

        //End Menu settings
        EndMenu.setSize(300, 350);
        EndMenu.setTitle("Maze Game - End of Level");
        EndMenu.setResizable(false);
        EndMenu.setUndecorated(true);

        EndMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        return EndMenu;
    }

    public void showEndMenu() {
        EndMenu.setVisible(true);
    }

    public void hideEndMenu(JFrame EndMenu) {
        EndMenu.setVisible(false);
    }
}
