package gameproject;

/**
 *
 * @author baswo
 */
class Menu {

    public MainMenu Mmenu;
    PauseMenu pause;
    EndOfLvlMenu endMenu;

    public Menu() {
    }
    public Menu(int i) {
        Mmenu = new MainMenu();
    }

    public void pauseGame() {
        pause = new PauseMenu();
        pause.showPauseMenu();
    }

    public void endLvl() {
        endMenu = new EndOfLvlMenu();
        endMenu.showEndMenu();
    }

    public void showMM() {
        System.out.println(this.Mmenu.toString());
        this.Mmenu.showMenu();
    }

    public void exit2MM() {
        pause.removePauseMenu();
        Mmenu.showMenu();

    }
}
