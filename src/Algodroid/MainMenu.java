package Algodroid;

import animatefx.animation.Bounce;
import animatefx.animation.Pulse;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class MainMenu 
{
    private Stage window = new Stage();//making a new stage for main menu
    static Media intro_source = new Media(new File("src/css/intro.mp3").toURI().toString());
    static MediaPlayer intro = new MediaPlayer(intro_source);

    public MainMenu()
    {
        intro.setOnEndOfMedia(new Runnable() {
            public void run() {
                intro.seek(Duration.ZERO);
            }
        });

        intro.play();

        //gets displayed after successful login
        //setting height and width for the new scene

        window.setMinWidth((Screen.getPrimary().getVisualBounds().getWidth()) - 100);
        window.setMinHeight((Screen.getPrimary().getVisualBounds().getHeight()) - 50);

        //setting icon image for the
        Image icon = new Image("images/icon.png");
        window.getIcons().add(icon);

        Image image = new Image("images/algodroid2.png");

        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        imageView.setFitWidth((Screen.getPrimary().getVisualBounds().getWidth())/2 );
        imageView.setFitHeight((Screen.getPrimary().getVisualBounds().getHeight())/2 );
        imageView.setPreserveRatio(true);

        VBox imageholder = new VBox();
        imageholder.getChildren().addAll(imageView);
        imageholder.setAlignment(Pos.CENTER);
        imageholder.setPadding(new Insets(200,10,50,10));


        //setting the tile of the window as main menu
        window.setTitle("Main Menu");
        //setting on close function that executes when the stage closes or close button is pressed
        window.setOnCloseRequest(e ->
        {
                closeProgram();
                e.consume();
        });

        //Making a horizontal box for the center of the borderpane
        VBox selection_menu = new VBox();

        //Selection buttons
        Button exit = new Button("EXIT");
        Button proceed = new Button("PLAY");
        Button credits = new Button("CREDITS");

        //Exit button closes window
        exit.setOnAction(e ->
        {   intro.stop();
            new MainGame.Main();
                closeProgram();
        });
        exit.setOnMouseEntered(e->new Pulse(exit).play());

        //adding all children elements to Hbox for center in borderpane
        selection_menu.getChildren().addAll(proceed, credits,exit);
        selection_menu.setPadding(new Insets(50, 30, 0, 30));
        selection_menu.setAlignment(Pos.CENTER);
        selection_menu.setSpacing(20);

        //setting elements of the borderpane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(selection_menu);
        borderPane.setTop(imageholder);

        //setting the 1st scene of the stage
        Scene scene1 = new Scene(borderPane);

        scene1.getStylesheets().add(MainMenu.class.getResource("/css/sample.css").toExternalForm());//adding stylesheet to the scene
        window.setScene(scene1);
        window.show();
        window.setFullScreenExitHint("");
        window.setFullScreen(true);


        imageView.setOnMouseEntered(e->new Bounce(imageView).play());

        new Bounce(imageView).play();
        new Bounce(exit).play();
        new Bounce(proceed).play();
        new Bounce(credits).play();

        //Credits button will display credits
        credits.setOnAction(e ->
        {
            Credits displayCredits = new Credits(window, scene1);
        });
        credits.setOnMouseEntered(e->new Pulse(credits).play());
        //If continue button on scene 1 is clicked, the scene will change to scene 2 containing the level selection scenes
        proceed.setOnAction(e ->
        {
            LevelSelector select_level = new LevelSelector(window,scene1);
        });
        proceed.setOnMouseEntered(e->new Pulse(proceed).play());

    }
    
    //a method that is invoked when exit button or close button is pressed and a dialogue box appears asking user to exit or not
    public void closeProgram() 
    {
        boolean result;
        //ConfirmBox confirmbox = new ConfirmBox();
        //result = confirmbox.getconfirmation();
        //System.out.println("Checkpoint Main menu");
        //if (result)
        //{
            window.close();
        //}

    }
    public static void stopIntro()
    {
        intro.stop();
    }
    public static void startIntro(){intro.play();}
}
