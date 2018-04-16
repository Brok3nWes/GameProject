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
    JLabel gamefield, tile, info;
    JButton showMenu, pauseButton, Retry, Reload, Finish;
    JFrame GameFrame;
    Font Default, MediumText, BigText;
//    Menu menu;
    int lvlINT;
    PlayingField PlayingField;
    Character P;
    Menu menu;

//    String path = System.getProperty("user.dir") + "\\src\\Images\\";
//    ImageIcon chosenTile = null;
//    ImageIcon tileImage = new ImageIcon(path + "tile.png");
//    ImageIcon barricade = new ImageIcon(path + "barricade.png");
//    ImageIcon wall = new ImageIcon(path + "wall.png");
//    ImageIcon start = new ImageIcon(path + "start.png");
//    ImageIcon end = new ImageIcon(path + "end.png");
//    ImageIcon key = new ImageIcon(path + "key.png");
//    ImageIcon player = new ImageIcon(path + "player.png");
//    Color tileColor = Color.decode("#c5c5c5");
    private JLabel playerTile;

    public gameComponents() {
        menu = new Menu();
        //fonts
        Default = new Font("", Font.BOLD, 17);
        MediumText = new Font("", Font.PLAIN, 22);
        BigText = new Font("", Font.BOLD,30);
        GameFrame = new JFrame();
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
            time.restart();
            resetLvl();
            //character resetten
            //keys en barricades resetten

        });
        Reload = new JButton("↺");
        Reload.setFont(Default);
        Reload.setPreferredSize(new Dimension(60, 60));
        Reload.addActionListener((ActionEvent rl) -> {
            quitGame();
            createGameWindow(gameTitle, lvlINT);
        });
        //debug end button
        Finish = new JButton("debug");
        Finish.setFont(Default);

        Finish.setPreferredSize(new Dimension(90, 50));
        Finish.addActionListener((ActionEvent f) -> {
           // time.stop();
            System.out.println("Your Time is: " + time.getElapsedTimeSecs() + " seconds");
            menu.endLvl();

        });
    }

    /**
     * Method for creating the full game window
     *
     * @param GameTitle to set the title of the window
     * @param lvlINT to generate the level selected
     */
    public void createGameWindow(String GameTitle, int lvlINT) {
        System.out.println();
        gameTitle = GameTitle;
        //PlayingField
        PlayingField = new PlayingField();
        PlayingField.setLvl(lvlINT);
        buildPanels();
        LvlCells = new JPanel[dimX][dimY];
        createJPanelCells();
        createLvlCells();
        GameFrame.pack();
        time.start();
    }

    /**
     * Method to create the gamePanel and the buttonPanel
     */

    private void buildPanels() {
        TPanel = new JPanel();
        TPanel.setLayout(new GridLayout(10, 10, 0, 0));
        //buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.add(pauseButton);
        buttonPanel.add(Retry);
        buttonPanel.add(Reload);
        buttonPanel.add(Finish);
        buttonPanel.setBackground(GRAY);
        buttonPanel.setFocusable(true);
        buttonPanel.addKeyListener(new GameKeyListener());
        info = new JLabel();
        info.setFont(MediumText);
        info.setText("Start!");
        //gamePanel
        gamePanel = new JLayeredPane();
        gamePanel.setLayout(new BorderLayout(10, 5));
        gamePanel.setBackground(GRAY);
        gamePanel.addKeyListener(new GameKeyListener());
        gamePanel.setFocusable(true);
        gamePanel.add(info);
        gamePanel.add(TPanel, BorderLayout.PAGE_END);
        //GameFrame
        GameFrame = new JFrame(gameTitle);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameFrame.setSize(700, 650);
        GameFrame.setResizable(false);
        GameFrame.setLayout(new BorderLayout());
        GameFrame.add(buttonPanel);
        GameFrame.add(gamePanel, BorderLayout.PAGE_END);
        GameFrame.setLocationRelativeTo(GameFrame);
        GameFrame.setVisible(true);
        GameFrame.setEnabled(true);
    }

    /**
     * ResetLvl (not 100% working)
     */

    private void resetLvl() {
        removeAllCells();
        repaintAllCells();
        createLvlCells();
        repaintAllCells();
        info.setText("Start!");
    }

    /**
     * Loop to remove everything in the JPanels in the 2d array LvlCells
     */
    private void removeAllCells() {
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                LvlCells[x][y].removeAll();
            }
        }
    }

    /**
     * Loop to validate and repaint the JPanels in the 2d array LvlCells
     */
    private void repaintAllCells() {
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                LvlCells[x][y].validate();
                LvlCells[x][y].repaint();
            }
        }
    }

    /**
     * Loop to create the JPanels in the 2d array LvlCells
     */
    private void createJPanelCells() {
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                LvlCells[x][y] = new JPanel();
                LvlCells[x][y].setLayout(new OverlayLayout(LvlCells[x][y]));
            }
        }
    }

    /**
     * Create lvl cells from PlayingField input
     */
    private void createLvlCells() {
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (x == 0 && y == 0) {
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

        System.out.println("you... SHITE!");
    }

    /**
     * GameKeyListenerClass to listen to specific keycodes
     */
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
                    if (P.getyCoordinate() < PlayingField.dimY - 1) {
                        if (checkTile(0, 1)) {
                            P.down();
                            updatePlayer();
                            System.out.println("DOWN WE GO");
                        }
                    }
                    break;
                case RIGHT:
                    if (P.getxCoordinate() < PlayingField.dimX - 1) {
                        if (checkTile(1, 0)) {
                            P.right();
                            updatePlayer();
                            System.out.println("RIGHT WE GO");
                        }
                    }
                    break;
                case ESCAPE:
                    menu.pauseGame();
                    System.out.println("Pause da game?!!!!");
                    break;
            }
        }
    }

    /**
     * Repaint one specific cell
     */
    private void repaintCell(int x, int y) {
        LvlCells[x][y].revalidate();
        LvlCells[x][y].repaint();
    }

    /**
     * Update the player tile
     */
    public void updatePlayer() {
        int y = P.getPrevxCoordinate();
        int x = P.getPrevyCoordinate();
        LvlCells[x][y].remove(playerTile);
        System.out.println("RemovedPTile: x=" + P.getPrevxCoordinate() + " y=" + P.getPrevyCoordinate());
        repaintCell(x, y);
        y = P.getxCoordinate();
        x = P.getyCoordinate();
        LvlCells[x][y].add(playerTile);
        System.out.println("AddedPTile: x=" + P.getxCoordinate() + " y=" + P.getyCoordinate());
        repaintCell(x, y);
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
        if (field.getTile().Symbol.equalsIgnoreCase("O")) {
            playerTile.setLocation(60 * nextX, 60 * nextY);
            info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY));
            return true;
        } else if (field.getTile().Symbol.equalsIgnoreCase("K")) {
            Key k = (Key) field.getTile();
            LvlCells[nextY][nextX].removeAll();
            field.resetTile(nextX, nextY);
            repaintCell(nextY, nextX);
            info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY) + "     Picked up key | code: " + k.getCode());
            return P.pickupKey(k);
        } else if (field.getTile().Symbol.equalsIgnoreCase("S")) {
            return true;
        } else if (field.getTile().Symbol.equalsIgnoreCase("E")) {
            //time.stop();
            info.setFont(BigText);
            info.setText("End Reached!         Time: " + time.getElapsedTimeSecs() + " sec");
            System.out.println("Your Time is: " + time.getElapsedTimeSecs() + " seconds");
            //menu.endLvl();
            menu.endLvl();
            return true;
        } else if (field.getTile().Symbol.equalsIgnoreCase("B")) {
            if (P.getKeyInPocket() != null) {
                Barricade b = (Barricade) field.getTile();
                boolean checkKey = P.useKey(b);
                if (checkKey) {
                    LvlCells[nextY][nextX].removeAll();
                    field.resetTile(nextX, nextY);
                    repaintCell(nextY, nextX);
                    info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY) + "     Broke Barricade | code: " + b.getCode());
                }
                return checkKey;
            } else {
                info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY) + "      You dont have the right key!");
                return false;
            }
        } else {
            return field.getTile().Symbol.equalsIgnoreCase("E");
        }
    }

    public void quitGame() {
        GameFrame.dispose();

    }
}
