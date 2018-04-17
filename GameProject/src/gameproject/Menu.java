package gameproject;

import java.awt.Font;
import javax.swing.JFrame;

/**
 *
 * @author baswo
 */
class Menu {

    protected Font Default = new Font("", Font.BOLD, 17);
    protected Font MediumText = new Font("", Font.PLAIN, 25);
    protected Font MediumTitle = new Font("", Font.BOLD, 40);
    protected Font BigText = new Font("", Font.BOLD, 30);
    protected Font BigButton = new Font("", Font.BOLD, 75);
    protected Font BigTitle = new Font("", Font.BOLD, 65);
    JFrame MainFrame = new JFrame();

    /**
     * Method to show the main frame of the class
     */
    public void showMenu() {
        this.MainFrame.setVisible(true);
    }

    /**
     * Method to hide the main frame of the class
     */
    public void hideMenu() {
        this.MainFrame.setVisible(false);
    }

    /**
     * Method to dispose of the main frame of the class
     */
    public void removeMenu() {
        this.MainFrame.dispose();
    }
}
