package Algodroid;

import animatefx.animation.RubberBand;
import animatefx.animation.Wobble;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

abstract public class sortblueprint
{
    //new window and counter for checking and score to store score of user
    private final Stage window = new Stage();
    private int counter = 0;
    private int score = 0;
    private final String[] algo_steps;
    static Media background_source = new Media(new File("src/css/background.mp3").toURI().toString());
    MediaPlayer background =new MediaPlayer(background_source);

    AudioClip wrong = new AudioClip(new File("src/css/wrong.mp3").toURI().toString());
    AudioClip correct = new AudioClip(new File("src/css/correct.mp3").toURI().toString());

    public sortblueprint(String[] algo_steps,String title)
    {
        background.setOnEndOfMedia(new Runnable()
        {
            public void run() {
                background.seek(Duration.ZERO);
            }
        });
        background.play();

        this.algo_steps = algo_steps;
        Button[] button_array = new Button[this.algo_steps.length];
        Label[] label_array = new Label[this.algo_steps.length];
        int[] step_no = new int[algo_steps.length];
        HBox[] hbox_array = new HBox[this.algo_steps.length];

        //adding an icon for the title bar to the stage
        Image image = new Image("images/icon.png");
        window.getIcons().add(image);

        //setting on close function that executes when the stage closes or close button is pressed
        window.setOnCloseRequest(event ->
        {
            closeProgram();
            event.consume();
        });

        //setting title and dimensions of the window
        window.setTitle(title);
        window.setMinWidth((Screen.getPrimary().getVisualBounds().getWidth()));
        window.setMinHeight((Screen.getPrimary().getVisualBounds().getHeight()));

        for (int i = 0; i < algo_steps.length; i++)
        {
            step_no[i] = i;
        }
        shuffleArray(step_no);
        for (int i = 0; i < step_no.length; i++)
        {
            int shuffled = step_no[i];
            button_array[i] = new Button(algo_steps[shuffled]);
            label_array[i] = new Label();
            label_array[i].setDisable(true);
        }

        //making label as title and buttons as selectable options for user interaction
        Label tag = new Label(title);
        Label score_show = new Label();
        score_show.setText("Score: 0");

        //if the buttons are selected in the right sequence, the button gets disabled and score is incremented by 10
        //if the wrong button is selected , the score gets decremented by 5

        button_array[0].setOnAction(event ->
        {
            if (counter == step_no[0]) {
                RightChoice(button_array[0],label_array[0],step_no[0]);
            } else {
                DecrementScore(button_array[0]);
            }
            showScore(score_show, getScore());
        });

        button_array[1].setOnAction(event ->
        {
            if (counter == step_no[1]) //if the counter is equal to the value stored in the holder which is the step no, the score and counter will increment
            {
                RightChoice(button_array[1],label_array[1],step_no[1]); // a method which takes a button as a parameter and then if the order is correct
                // score, counter are incremented and then button is disabled
            }
            else {
                DecrementScore(button_array[1]);// decrements score by 5
            }
            showScore(score_show, getScore());//displays the score on screen
        });

        button_array[2].setOnAction(event ->
        {
            if (counter == step_no[2]) {
                RightChoice(button_array[2],label_array[2],step_no[2]);
            } else {
                DecrementScore(button_array[2]);
            }
            showScore(score_show, getScore());
        });

        button_array[3].setOnAction(event ->
        {
            if (counter == step_no[3]) {
                RightChoice(button_array[3],label_array[3],step_no[3]);
            } else {
                DecrementScore(button_array[3]);
            }
            showScore(score_show, getScore());
        });

        button_array[4].setOnAction(event ->
        {
            if (counter == step_no[4]) {
                RightChoice(button_array[4],label_array[4],step_no[4]);
            } else {
                DecrementScore(button_array[4]);
            }
            showScore(score_show, getScore());
        });

        button_array[5].setOnAction(event ->
        {
            if (counter == step_no[5]) {
                RightChoice(button_array[5],label_array[5],step_no[5]);
            } else {
                DecrementScore(button_array[5]);
            }
            showScore(score_show, getScore());
        });

        button_array[6].setOnAction(event ->
        {
            if (counter == step_no[6]) {
                RightChoice(button_array[6],label_array[6],step_no[6]);
            } else {
                DecrementScore(button_array[6]);
            }
            showScore(score_show, getScore());

            //if all the buttons are clicked in the right sequence, the counter will increase unto 5
            //when it becomes five, the level ends and the window closes , results window appears and then you are redirected to main menu
        });

        //using vertical box to vertically align all the children elements
        VBox layout = new VBox(20);
        layout.getChildren().addAll(tag, score_show);
        for(int i=0;i<this.algo_steps.length;i++)
        {
            hbox_array[i] = new HBox();
            hbox_array[i].getChildren().addAll(button_array[i],label_array[i]);
            hbox_array[i].setAlignment(Pos.CENTER);
            hbox_array[i].setSpacing(15);
            label_array[i].getStyleClass().add("step");
            layout.getChildren().add(hbox_array[i]);
        }

        layout.setAlignment(Pos.CENTER);
        tag.setAlignment(Pos.CENTER);
        tag.getStyleClass().add("tag");
        layout.setPadding(new Insets(20, 15, 20, 15));
        tag.setPadding(new Insets(0, 15, 20, 15));

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(quicksort.class.getResource("/css/sort.css").toExternalForm());//adding style sheet to the scene
        window.setScene(scene);
        window.setFullScreenExitHint("");
        window.setFullScreen(true);
        window.show();

    }

    //displays the confirmation box to close the program
    public void closeProgram() {
        boolean result;
        ConfirmBox confirmbox = new ConfirmBox();
        result = confirmbox.getconfirmation();
        System.out.println("Checkpoint QuickSort");
        if (result) {
            window.close();
        }


    }

    // returns the score
    public int getScore() {
        return score;
    }

    //decrements the score
    public void DecrementScore(Button any) {
        score = score - 5;
        wrong.play();
        new Wobble(any).play();
    }

    //shows the score on the scene
    public void showScore(Label score_show, int score) {
        score_show.setText("Score = " + score);
    }

    // a method which takes a button as a parameter and then if the order is correct
    // score, counter are incremented and then button is disabled
    public void RightChoice(Button any,Label someLabel,int stepno)
    {
        correct.play();
        new RubberBand(any).play();
        any.setDisable(true);
        counter++;
        score = score + 10;
        someLabel.setDisable(false);
        stepno = stepno+1;
        someLabel.setText("Step #" + stepno);

        if (counter == algo_steps.length)
        {
            background.stop();
            Results displayResults = new Results(getScore());
            window.close();
            MainMenu display_menu = new MainMenu();
        }
    }

    public static void shuffleArray(int[] arr) //shuffling an array
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
}
