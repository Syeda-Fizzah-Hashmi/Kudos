package Algodroid;

import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LevelSelector
{
    public LevelSelector(Stage window,Scene scene1)
    {

        //setting height and width of the window
        window.setMinWidth((Screen.getPrimary().getVisualBounds().getWidth()));
        window.setMinHeight((Screen.getPrimary().getVisualBounds().getHeight()));
        //setting the tile of the window as main menu
        window.setTitle("Select Level");

        //setting on close function that executes when the stage closes or close button is pressed
        window.setOnCloseRequest(e ->
        {
            closeProgram(window);
            e.consume();
        });

        //MAKING A NEW SCENE BY ADDING VERTICAL BOX AND 2 BUTTONS
        VBox choice = new VBox(20);
        Label welcome = new Label("SELECT LEVEL");
        Button level1 = new Button("Quick Sort");
        Button level2 = new Button("Selection Sort");
        Button level3 = new Button("Bubble Sort");
        Button level4 = new Button("Insertion Sort");
        Button level5 = new Button("Radix Sort");
        Button level6 = new Button("Merge Sort");
        Button level7 = new Button("Heap Sort");
        Button level8 = new Button("Bucket Sort");
        Button exit = new Button("Exit to Main Menu");
        exit.setPadding(new Insets(10));

        choice.getChildren().addAll(welcome,level1, level2,level3,level4,level5,level6,level7,level8,exit);
        choice.setAlignment(Pos.CENTER);

        welcome.setOnMouseEntered(e->new Flash(welcome).play());

        //level 1 window will display and current window will close
        level1.setOnAction(e ->
        {
            continueLevel(window);
            quicksort display_quicksort = new quicksort();
        });
        level1.setOnMouseEntered(e->new Pulse(level1).play());

        //IF Level 2 is selected, the window will close and the level window will appear
        level2.setOnAction(e ->
        {
            continueLevel(window);
            selectionsort display_selectionsort = new selectionsort();
        });
        level2.setOnMouseEntered(e->new Pulse(level2).play());

        level3.setOnAction(e ->
        {
            continueLevel(window);
            bubblesort display_bubblesort = new bubblesort();
        });
        level3.setOnMouseEntered(e->new Pulse(level3).play());

        //IF Level 2 is selected, the window will close and the level window will appear
        level4.setOnAction(e ->
        {
            continueLevel(window);
            insertionsort display_insertionsort = new insertionsort();
        });
        level4.setOnMouseEntered(e->new Pulse(level4).play());

        level5.setOnAction(e ->
        {
            continueLevel(window);
           radixsort display_radixsort = new radixsort();
        });
        level5.setOnMouseEntered(e->new Pulse(level5).play());

        level6.setOnAction(e ->
        {
            continueLevel(window);
            mergesort display_mergesort = new mergesort();
        });
        level6.setOnMouseEntered(e->new Pulse(level6).play());

        level7.setOnAction(e ->
        {
            continueLevel(window);
            heapsort display_heapsort = new heapsort();
        });
        level7.setOnMouseEntered(e->new Pulse(level7).play());

        level8.setOnAction(e ->
        {
            continueLevel(window);
            bucketsort display_bucketsort = new bucketsort();
        });
        level8.setOnMouseEntered(e->new Pulse(level8).play());

        exit.setOnAction(e ->
        {
            window.setScene(scene1);
            window.setFullScreenExitHint("");
            window.setFullScreen(true);
        });
        exit.setOnMouseEntered(e->new Pulse(exit).play());

            Scene scene2 = new Scene(choice);
            welcome.getStyleClass().add("tag");
            scene2.getStylesheets().add(quicksort.class.getResource("/css/mainmenu.css").toExternalForm());
            exit.getStyleClass().add("tag2");
            window.setScene(scene2);
            window.setFullScreenExitHint("");
            window.setFullScreen(true);

    }

    public void closeProgram(Stage window)
    {
        boolean result;
        ConfirmBox confirmbox = new ConfirmBox();
        result = confirmbox.getconfirmation();
        System.out.println("Checkpoint Level Selector");
        if (result)
        {
            window.close();
        }

    }
    public void continueLevel(Stage window)
    {
        MainMenu.stopIntro();
        window.close();
    }

}