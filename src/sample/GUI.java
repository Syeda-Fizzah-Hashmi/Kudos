package sample;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public interface GUI {
    void showBSTRulesScene(Stage openingStage);
    void showNowImageScene(Stage openingStage);
   // void showUserNameStage();

    void showUserNameStage(Stage openingStage);

    void loadUserData(String name) throws IOException, ClassNotFoundException;
    void showMainMenuStage();
//    void showNewGameStage();
//    void showLevelStage(int levelNumber);
//    void showCongoMessageStage(int levelNumber);
//    void showTryAgainStage();

    void showMainMenuStage(Stage openingStage);

    void showNewGameStage(Stage openingStage);

    void showLevelStage(int levelNumber, Stage openingStage);

    void showCongoMessageStage(int levelNumber, Stage openingStage);

    void showTryAgainStage(Stage openingStage, int levelNumber);

    void exitGameHandles(Stage mainMenuStage, WindowEvent e) throws IOException, ClassNotFoundException;
}
