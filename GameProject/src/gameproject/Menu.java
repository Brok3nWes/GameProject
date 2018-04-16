package gameproject;

/**
 *
 * @author baswo
 */
class Menu {

    public void pauseGame() {
        StopWatch time = new StopWatch();
        PauseMenu pause = new PauseMenu();
        pause.showPauseMenu();
        time.stop();
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
