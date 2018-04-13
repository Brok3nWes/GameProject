package gameproject;

import javax.swing.ImageIcon;

/**
 *
 * @author baswo
 */
class StartTile extends Tile {

    private Character player1;
    private final String path = System.getProperty("user.dir") + "\\src\\Images\\";
    private ImageIcon icon;

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Constructor for a StartTile
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public StartTile(int x, int y) {
        super(x, y);
        this.icon = new ImageIcon(path + "start.png");
        Transparent = true;
        Symbol = "S";
    }

    /**
     * Create Player at StartTilePosition
     *
     * @param field for getting the
     */
    public Character spawnPlayer(Field[][] field) {
        player1 = new Character(this.xCoordinate, this.yCoordinate);
        return player1;
    }

    public void startTimer() {

    }
}
