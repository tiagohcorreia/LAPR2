package app.ui;

import app.ui.console.menu.MainMenuUI;

public class Main {

    public static void main(String[] args) {

        try {

            MainMenuUI menu = new MainMenuUI();
            menu.run();

        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }
}
    

