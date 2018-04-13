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
//        PauseMenu pause = new PauseMenu();
//        pause.hidePauseMenu();
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.showMenu();
//        EndOfLvlMenu EndMenu = new EndOfLvlMenu();
//        EndMenu.hideEndMenu();
    }
}
