/*
 * Game GUI, mainly consisting of JSwing components
 * 
 */
package gameproject;

import static gameproject.PlayingField.dimX;
import static gameproject.PlayingField.dimY;
import java.awt.BorderLayout;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.GRAY;
import static java.awt.Color.LIGHT_GRAY;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

/**
 *
 * @author Wessel
 * @author Bas
 */
class gameComponents extends Menu {

    private StopWatch time = new StopWatch();
    private String gameTitle;
    private JPanel buttonPanel, TPanel, LvlCells[][];
    private JLayeredPane gamePanel;
    private JLabel info, playerTile;
    private final JButton pauseButton, Retry, Reload;
    private int lvlINT;
    private PlayingField PlayingField;
    private Character P;
    protected MainMenu mm;
    private final GameKeyListener GKL = new GameKeyListener();

    /**
     * constructor for gameComponents
     *
     * @param mainMenu for making the MainMenu accessible
     */
    public gameComponents(MainMenu mainMenu) {
        mm = mainMenu;
        //pause menu
        pauseButton = new JButton("Pause");
        pauseButton.setFont(Default);
        pauseButton.setPreferredSize(new Dimension(100, 60));
        pauseButton.addActionListener((ActionEvent e) -> {
            pauseGame();
        });

        Retry = new JButton("Retry");
        Retry.setFont(Default);
        Retry.setPreferredSize(new Dimension(100, 60));
        Retry.addActionListener((ActionEvent r) -> {
            time.restart();
            this.resetLvl();
            //character resetten
            //keys en barricades resetten

        });
        Reload = new JButton("RandomLvl");
        Reload.setFont(Default);
        Reload.setPreferredSize(new Dimension(130, 60));
        Reload.addActionListener((ActionEvent rl) -> {
            this.removeMenu();
            this.createGameWindow(gameTitle, lvlINT);
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
        LvlCells = new JPanel[dimX][dimY];
        this.buildPanels();
        this.createJPanelCells();
        this.createLvlCells();
        MainFrame.pack();
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
        buttonPanel.setBackground(GRAY);
        info = new JLabel();
        info.setFont(MediumText);
        info.setText("Start!");
        info.setOpaque(true);
        info.setBackground(LIGHT_GRAY);
        //gamePanel
        gamePanel = new JLayeredPane();
        gamePanel.setLayout(new BorderLayout(10, 0));
        gamePanel.setBackground(GRAY);
        gamePanel.add(info);
        gamePanel.add(TPanel, BorderLayout.PAGE_END);
        //GameFrame
        MainFrame = new JFrame(gameTitle);
        MainFrame.setAutoRequestFocus(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setSize(700, 650);
        MainFrame.setResizable(false);
        MainFrame.setLayout(new BorderLayout());
        MainFrame.add(buttonPanel);
        MainFrame.add(gamePanel, BorderLayout.PAGE_END);
        MainFrame.setLocationRelativeTo(MainFrame);
        MainFrame.addKeyListener(GKL);
        MainFrame.setVisible(true);
        MainFrame.setEnabled(true);
        this.setFocus();
    }

    /**
     * Method for resetting the current level even if it's a randomly generated
     * level
     */
    private void resetLvl() {
        this.removeAllCells();
        this.repaintAllCells();
        this.createLvlCells();
        this.repaintAllCells();
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
                if (x == 0 && y == 0) {//startTile
                    P = PlayingField.getStartTile().spawnPlayer(PlayingField.getPf());
                    playerTile = new JLabel(P.getIcon());
                    LvlCells[x][y].add(playerTile);
                    LvlCells[x][y].setBackground(GREEN);
                    System.out.println("PlayerSpawned!");
                }
                Tile tilee = PlayingField.getPf()[x][y].getTile();
                LvlCells[x][y].add(new JLabel(tilee.getIcon()));
                if (x == 9 && y == 9) {//endTile
                    LvlCells[x][y].setBackground(RED);
                }
                LvlCells[x][y].setName(tilee.Symbol);
                TPanel.add(LvlCells[x][y]);
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
                    pauseGame();
                    System.out.println("Pause da game?!!!!");
                    break;
                case RESET:
                    resetLvl();
                    break;
            }
        }
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
        String Symbol = LvlCells[nextY][nextX].getName();
        if (Symbol.equalsIgnoreCase("O")) {
            playerTile.setLocation(60 * nextX, 60 * nextY);
            info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY));
            return true;
        } else if (Symbol.equalsIgnoreCase("K")) {
            Key k = (Key) field.getTile();
            LvlCells[nextY][nextX].removeAll();
            LvlCells[nextY][nextX].setName("O");
            repaintCell(nextY, nextX);
            info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY) + "     Picked up key | code: " + k.getCode());
            return P.pickupKey(k);
        } else if (Symbol.equalsIgnoreCase("S")) {
            return true;
        } else if (Symbol.equalsIgnoreCase("E")) {
            endLvl();
            return true;
        } else if (Symbol.equalsIgnoreCase("B")) {
            if (P.getKeyInPocket() != null) {
                Barricade b = (Barricade) field.getTile();
                boolean checkKey = P.useKey(b);
                if (checkKey) {
                    LvlCells[nextY][nextX].removeAll();
                    LvlCells[nextY][nextX].setName("O");
                    repaintCell(nextY, nextX);
                    info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY) + "     Broke Barricade | code: " + b.getCode());
                }
                return checkKey;
            } else {
                info.setText("Moved Player to: x:" + nextX + " y:" + (9 - nextY) + "      You dont have the right key!");
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * When remove method is called, also reset time
     */
    @Override
    public void removeMenu() {
        this.MainFrame.dispose();
        time.reset();
    }

    /**
     * setFocusable to true
     */
    public void setFocus() {
        MainFrame.setFocusable(true);
    }

    /**
     * Pause the game
     */
    private void pauseGame() {
        time.stop();
        PauseMenu pause = new PauseMenu(mm, this, time);
        pause.showMenu();
    }

    /**
     * End the level
     */
    private void endLvl() {
        time.stop();
        info.setFont(BigText);
        info.setText("End Reached!         Time: " + time.getElapsedTimeSecs() + " sec");
        System.out.println("Your Time is: " + time.getElapsedTimeSecs() + " seconds");
        EndOfLvlMenu endMenu = new EndOfLvlMenu(mm, this, Long.toString(time.getElapsedTimeSecs()));
        endMenu.showMenu();
        time.reset();
    }
}
