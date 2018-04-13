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

    public void exitToMainMenu() {
//        PauseMenu pause = new PauseMenu();
        MainMenu mainMenu = new MainMenu();
        EndOfLvlMenu EndMenu = new EndOfLvlMenu();
//        pause.hidePauseMenu();
        mainMenu.showMenu();
        EndMenu.hideEndMenu();
    }
}
