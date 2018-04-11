package gameproject;

/**
 *
 * @author baswo
 */
class Menu {
    
    
    

    public void pauseGame() {
        PauseMenu pause = new PauseMenu();
       pause.showPauseMenu();
       



// MainMenu.setVisible(false);
        //PauseMenu.setLocationRelativeTo(GameFrame);
        //PauseMenu.setVisible(true);
        //EndMenu.setVisible(false);
        //GameFrame.setEnabled(false);
    }
    public void exitToMenu(){
        PauseMenu pause = new PauseMenu();
        MainMenu mainMenu = new MainMenu();
        EndOfLvlMenu endMenu = new EndOfLvlMenu();
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

