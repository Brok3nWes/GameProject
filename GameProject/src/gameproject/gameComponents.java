/*
 * Game GUI, mainly consisting of JSwing components
 * 
 */
package gameproject;

import static gameproject.PlayingField.dimX;
import static gameproject.PlayingField.dimY;
import java.awt.BorderLayout;
import static java.awt.Color.GRAY;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Wessel
 * @author Bas
 */
class gameComponents {

    String nr, gameTitle;
    JPanel buttonPanel, TPanel;
    JLayeredPane gamePanel, layeredTile;
    JLabel gamefield, tile;
    JButton showMenu, pauseButton, Retry, Reload, Finish;
    JFrame GameFrame;
    Font Default;
    int lvlINT = 0;
    PlayingField PlayingField;

    String path = System.getProperty("user.dir") + "\\src\\Images\\";
    ImageIcon chosenTile = null;
    ImageIcon tileImage = new ImageIcon(path + "tile.png");
    ImageIcon barricade = new ImageIcon(path + "barricade.png");
    ImageIcon wall = new ImageIcon(path + "wall.png");
    ImageIcon start = new ImageIcon(path + "start.png");
    ImageIcon end = new ImageIcon(path + "end.png");
    ImageIcon key = new ImageIcon(path + "key.png");
    ImageIcon player = new ImageIcon(path + "player.png");

    public gameComponents(String gameField) {
        Menu menu = new Menu();
        EndOfLvlMenu endMenu = new EndOfLvlMenu();
        
        GameFrame = new JFrame();

        //fonts
        Default = new Font("", Font.BOLD, 17);
        
        //pause menu
        pauseButton = new JButton("Pause");
        pauseButton.setFont(Default);
        pauseButton.setPreferredSize(new Dimension(100, 60));
        pauseButton.addActionListener((ActionEvent e) -> {
           menu.pauseGame();
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
            GameFrame.dispose();
            createGameWindow(gameTitle, lvlINT);
        });
        //debug end button
        Finish = new JButton("debug");
        Finish.setFont(Default);

        Finish.setPreferredSize(new Dimension(90, 50));
        Finish.addActionListener((ActionEvent f) -> {
            endMenu.showEndMenu();
        });
    }

    public void createGameWindow(String GameTitle, int lvlINT) {
        System.out.println();
        GameFrame = new JFrame(GameTitle);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonPanel = new JPanel();
        GameFrame.setSize(700, 650);
        GameFrame.setResizable(false);
        GameFrame.setLayout(new BorderLayout());
        gamePanel = new JLayeredPane();
        gamePanel.setLayout(new BorderLayout(10, 5));
        buttonPanel.add(pauseButton);
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
        PlayingField = new PlayingField();
        PlayingField.setLvl(lvlINT);
        gamePanel.setFocusable(true);
        buttonPanel.setFocusable(true);
        gamePanel.addKeyListener(new GameKeyListener());
        buttonPanel.addKeyListener(new GameKeyListener());
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (x == 0 && y == 0) {
                    JLabel playerP = new JLabel(player);
                    playerP.setLocation(20, 20);
                    //TPanel.add(playerP, new Integer(0));
                    PlayingField.getStartTile().spawnPlayer(PlayingField.getPf());
                    System.out.println("PlayerSpawned!");
                }
                Tile tilee = PlayingField.getPf()[y][x].getTile();
                createTile(tilee);

            }
        }
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

    class GameKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {

            int KeyCode = e.getKeyCode();
            PlayingField.getStartTile().getPlayer().handleMovement(KeyCode, PlayingField.getPf());
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }}

    
