/*
 * Game GUI, mainly consisting of JSwing components
 * 
 */
package gameproject;

import static gameproject.PlayingField.dimX;
import static gameproject.PlayingField.dimY;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

/**
 *
 * @author Wessel
 * @author Bas
 */
class gameComponents {

    StopWatch time = new StopWatch();
    String nr, gameTitle;
    JPanel buttonPanel, TPanel, LvlCells[][];
    JLayeredPane gamePanel;
    JPanel layeredTile;
    JLabel gamefield, tile;
    JButton showMenu, pauseButton, Retry, Reload, Finish;
    JFrame GameFrame;
    Font Default;
//    Menu menu;
    int lvlINT = 0;
    PlayingField PlayingField;
    Character P;

    String path = System.getProperty("user.dir") + "\\src\\Images\\";
    ImageIcon chosenTile = null;
    ImageIcon tileImage = new ImageIcon(path + "tile.png");
    ImageIcon barricade = new ImageIcon(path + "barricade.png");
    ImageIcon wall = new ImageIcon(path + "wall.png");
    ImageIcon start = new ImageIcon(path + "start.png");
    ImageIcon end = new ImageIcon(path + "end.png");
    ImageIcon key = new ImageIcon(path + "key.png");
    ImageIcon player = new ImageIcon(path + "player.png");
    Color tileColor = Color.decode("#c5c5c5");
    private JLabel playerTile;

    public gameComponents() {
        Menu menu = new Menu();

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
            quitGame();
            //character resetten
            //timer resetten
            //keys en barricades resetten

        });
        Reload = new JButton("↺");
        Reload.setFont(Default);
        Reload.setPreferredSize(new Dimension(60, 60));
        Reload.addActionListener((ActionEvent rl) -> {

            createGameWindow(gameTitle, lvlINT);
        });
        //debug end button
        Finish = new JButton("debug");
        Finish.setFont(Default);

        Finish.setPreferredSize(new Dimension(90, 50));
        Finish.addActionListener((ActionEvent f) -> {
            time.stop();
            System.out.println("Your Time is: " + time.getElapsedTimeSecs() + " seconds");
            menu.endLvl();

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
        CreateLvlCells();
        GameFrame.pack();
        time.start();
    }
//
//    public JPanel createTile(Tile t) {
//        layeredTile = new JPanel();
//
//        layeredTile.setLayout(new GridLayout());
//
//        if (t.Symbol.equals("O")) {
//            chosenTile = tileImage;
//            tile = new JLabel(chosenTile);
//        }
//        if (t.Symbol.equals("B")) {
//            chosenTile = barricade;
//            tile = new JLabel(chosenTile);
//        }
//        if (t.Symbol.equals("W")) {
//            chosenTile = wall;
//            tile = new JLabel(chosenTile);
//        }
//        if (t.Symbol.equals("S")) {
//            tile = playerTile;
//            tile.setBackground(GREEN);
//        }
//        if (t.Symbol.equals("E")) {
//            chosenTile = end;
//            tile = new JLabel(chosenTile);
//        }
//        if (t.Symbol.equals("K")) {
//            chosenTile = key;
//            tile = new JLabel(chosenTile);
//            tile.setBackground(tileColor);
//            JTextArea code = new JTextArea("poep");
//
//            gamePanel.add(code);
//            //layeredTile.add(code);
//        }
//        if (t.Symbol.equals("C")) {
//            chosenTile = player;
//            tile = new JLabel(chosenTile);
//            tile.setBackground(tileColor);
//
//        }
//        tile.setOpaque(true);
//        layeredTile.add(tile);
//        TPanel.add(layeredTile);
////        layeredTile.remove(tile);
//        return TPanel;
//    }

    private void CreateLvlCells() {
        LvlCells = new JPanel[dimX][dimY];
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                LvlCells[x][y] = new JPanel();
                LvlCells[x][y].setLayout(new OverlayLayout(LvlCells[x][y]));
                if (x == 0 && y == 0) {
                    //TPanel.add(playerP, new Integer(0));
                    P = PlayingField.getStartTile().spawnPlayer(PlayingField.getPf());
                    playerTile = new JLabel(P.getIcon());
                    LvlCells[x][y].add(playerTile);
                    System.out.println("PlayerSpawned!");
                }
                Tile tilee = PlayingField.getPf()[x][y].getTile();
                LvlCells[x][y].add(new JLabel(tilee.getIcon()));
                TPanel.add(LvlCells[x][y]);

            }
        }
    }

    class GameKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {

            int KeyCode = e.getKeyCode();
            handleCommand(KeyCode);

        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    /**
     * Handler for movement
     *
     * @param command what command has been given
     */
    public void handleCommand(int command) {
        ActionEnum code = ActionEnum.getEnumName(command);
        if (code != null) {
            switch (code) {
                case UP:
                    if (P.getyCoordinate() > 0) {
                        if (checkTile(0, -1)) {
                            P.up();
                            updatePlayer();
                            System.out.println("UP WE GO");
                        }
                    }
                    break;
                case LEFT:
                    if (P.getxCoordinate() > 0) {
                        if (checkTile(-1, 0)) {
                            P.left();
                            updatePlayer();
                            System.out.println("LEFT WE GO");
                        }
                    }
                    break;
                case DOWN:
                    if (P.getPrevyCoordinate() < PlayingField.dimY - 1) {
                        if (checkTile(0, 1)) {
                            P.down();
                            updatePlayer();
                            System.out.println("DOWN WE GO");
                        }
                    }
                    break;
                case RIGHT:
                    if (P.getPrevxCoordinate() < PlayingField.dimX - 1) {
                        if (checkTile(1, 0)) {
                            P.right();
                            updatePlayer();
                            System.out.println("RIGHT WE GO");
                        }
                    }
                    break;
                case ESCAPE:
                    PauseMenu menu = new PauseMenu();
                    menu.pauseGame();
                    System.out.println("Pause da game?!!!!");
//                    System.exit(0);
                    break;
            }
        }
    }

    public void updatePlayer() {
        int x = P.getPrevxCoordinate();
        int y = P.getPrevyCoordinate();
        LvlCells[x][y].remove(playerTile);
        System.out.println("RemovedPTile: x=" + P.getPrevxCoordinate() + " y=" + P.getPrevyCoordinate());
        LvlCells[x][y].repaint();
        x = P.getxCoordinate();
        y = P.getyCoordinate();
        LvlCells[x][y].add(playerTile);
        System.out.println("AddedPTile: x=" + P.getxCoordinate() + " y=" + P.getyCoordinate());
        LvlCells[x][y].repaint();
    }

    /**
     * Checking if the next move is possible
     *
     * @param pf Field to check
     * @param dx how far there should be checked relative to the player x
     * @param dy how far there should be checked relative to the player y
     * @return boolean if it is a valid space or not
     */
    private boolean checkTile(int dx, int dy) {
        int nextX = P.getxCoordinate() + dx;
        int nextY = P.getyCoordinate() + dy;
        Field[][] pf = PlayingField.getPf();

        Field field = pf[nextY][nextX];
        Rectangle r = new Rectangle(60 * nextX, 60 * nextY);
        if (field.getTile().Symbol.equalsIgnoreCase("O")) {
//            playerTile.setBounds(r);
            playerTile.setLocation(60 * nextX, 60 * nextY);
            return true;
        } else if (field.getTile().Symbol.equalsIgnoreCase("K")) {
            return true;
        } else if (field.getTile().Symbol.equalsIgnoreCase("S")) {
            return true;
        } else if (field.getTile().Symbol.equalsIgnoreCase("E")) {
            return true;
        } else if (field.getTile().Symbol.equalsIgnoreCase("B")) {
            if (P.getKeyInPocket() != null) {
//                field.getTile() instanceof Barricade
//                return P.useKey(b); //how to find the right Barricade?
            } else {
                return false; //temp until right way found
            }
        } else {
            return field.getTile().Symbol.equalsIgnoreCase("E");
        }
        return false;
    }

    public void quitGame() {

        GameFrame.dispose();

    }
}
