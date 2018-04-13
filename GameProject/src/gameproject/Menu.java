package gameproject;

/**
 *
 * @author baswo
 */
class Menu {

    public void pauseGame() {
        PauseMenu pause = new PauseMenu();
        pause.showPauseMenu();

    }

    public void endLvl() {
        EndOfLvlMenu endMenu = new EndOfLvlMenu();
        endMenu.showEndMenu();
    }

    public void exitToMainMenu() {
       MainMenu menu = new MainMenu();
       
       menu.MainMenu();
    }
}
