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
    public void exitToMainMenu(){
        PauseMenu pause = new PauseMenu();
        MainMenu mainMenu = new MainMenu();
//        EndOfLvlMenu endMenu = new EndOfLvlMenu();
        pause.hidePauseMenu();
        mainMenu.showMenu();
//        endMenu.hideEndMenu();
    }
}

