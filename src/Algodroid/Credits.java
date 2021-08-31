package Algodroid;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Credits {
    //gets invoked when credits button in the main menu is clicked
    public Credits(Stage window, Scene scene1)
    {
        MainMenu.stopIntro();

        Media resource = new Media(new File("src/css/credits.mp3").toURI().toString());
        MediaPlayer credits =new MediaPlayer(resource);
        credits.setOnEndOfMedia(new Runnable() {
            public void run() {
                credits.seek(Duration.ZERO);
            }
        });

        credits.play();

        //adding an icon for the title bar to the stage
        Image image = new Image("images/icon.png");
        window.getIcons().add(image);

        //setting title of the window by getting the input from the parameter passed
        window.setTitle("Credits");
        window.setMinWidth((Screen.getPrimary().getVisualBounds().getWidth()));
        window.setMinHeight((Screen.getPrimary().getVisualBounds().getHeight()));

        //close button to close the credits window
        Button closebutton = new Button();
        closebutton.setText("EXIT");
        closebutton.setOnAction(event ->
                {
                    credits.stop();
                    window.setScene(scene1);
                    MainMenu.startIntro();
                    window.setFullScreenExitHint("");
                    window.setFullScreen(true);
                }
        );
        // making a vertical box to vertically align all the child elements of the scene
        BorderPane layout = new BorderPane();
        HBox center = new HBox();
        center.getChildren().add(closebutton);
        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(15, 15, 15, 15));
        layout.setBottom(center);
        closebutton.setPadding(new Insets(10, 10, 10, 10));

        Scene display_credits = new Scene(layout);
        display_credits.getStylesheets().add(Credits.class.getResource("/css/credits.css").toExternalForm());//adding stylesheet to the scene
        window.setScene(display_credits);
        window.setFullScreenExitHint("");
        window.setFullScreen(true);
    }

}
