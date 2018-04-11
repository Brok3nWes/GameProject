package gameproject;

/**
 *
 * @author baswo
 */
class Menu {
    PauseMenu pause = new PauseMenu();
    MainMenu mainMenu = new MainMenu();
    EndOfLvlMenu endMenu = new EndOfLvlMenu();

    public void pauseGame() {
       pause.showPauseMenu();
       



// MainMenu.setVisible(false);
        //PauseMenu.setLocationRelativeTo(GameFrame);
        //PauseMenu.setVisible(true);
        //EndMenu.setVisible(false);
        //GameFrame.setEnabled(false);
    }
    public void exitToMenu(){
        pause.hidePauseMenu();
        mainMenu.showMenu();
        endMenu.hideEndMenu();


//MainMenu.setLocationRelativeTo(GameFrame);
          //  MainMenu.setVisible(true);
           // GameFrame.setVisible(false);
            //PauseMenu.setVisible(false);
            //EndMenu.setVisible(false);
    }
}

