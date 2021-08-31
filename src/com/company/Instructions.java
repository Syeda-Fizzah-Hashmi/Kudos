package com.company;

import CipherIt.GUI;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import javafx.geometry.Insets;


public class Instructions {

    public static void instructionStage(Stage openingStage) throws MalformedURLException {
        URL path = Key.class.getResource("inst.mp4");
        playVideo(openingStage, "src/videos/inst.mp4");
    }

    public static void levelInstruction(Stage openingStage) {
        Button button1 = new Button("SHAPES");
                button1.setOnAction(e -> {
            try {
                        URL path = Key.class.getResource("shapes.mp4");
        playVideo(openingStage, "src/videos/shapes.mp4");
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        Button button2 = new Button("NUMBERS");
                button2.setOnAction(e -> {
            try {
                       URL path = Key.class.getResource("numbers.mp4");
        playVideo(openingStage, "src/videos/numbers.mp4");
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        Button button3 = new Button("ALPHABETS");
        button3.setOnAction(e -> {
            try {
                        URL path = Key.class.getResource("alphabet.mp4");
        playVideo(openingStage, "src/videos/alphabet.mp4");
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        Button button4 = new Button("ASCII CODE");
                button4.setOnAction(e -> {
            try {
                        URL path = Key.class.getResource("ascii.mp4");
        playVideo(openingStage, "src/videos/ascii.mp4");
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        Button button5 = new Button("EBCDIC CODE");
         button5.setOnAction(e -> {
            try {
         URL path = Key.class.getResource("ebcdic.mp4");
        playVideo(openingStage, "src/videos/ebcdic.mp4");
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        Button button6 = new Button("BACK");
        button6.setOnAction((ActionEvent e) -> GUI.showWelcomeScene(openingStage));
        VBox insButtonBox = new VBox(button1, button2, button3, button4, button5);
        insButtonBox.setSpacing(10);
        insButtonBox.setAlignment(Pos.CENTER);
        BorderPane insRootNode = new BorderPane();
        insRootNode.setPadding(new Insets(15));
        BorderPane.setMargin(insRootNode, new Insets(100, 12, 50, 12));
        insRootNode.setCenter(insButtonBox);
        insRootNode.setBottom(button6);

        //setting the background for the pane
        //creating a background image using background image class and passing an image to it
        //setting up the properties of the background imaged
        BackgroundImage myBI = new BackgroundImage(new Image("file:src/images/instructions.jpg", 32, 32, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(400.0, 400.0, false, false, false, false));
        insRootNode.setBackground(new Background(myBI));
        Scene scene = new Scene(insRootNode, 1280, 720);

        openingStage.setTitle("Embedded Media Player");
        openingStage.setScene(scene);
        openingStage.sizeToScene();
        openingStage.setMaximized(true);
                openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();

    }

    public static void playVideo(Stage openingStage, String fileLocation) throws MalformedURLException {
        Group root = new Group();
        Scene scene = new Scene(root, 1280, 720);
        // create media player
        File mediaFile = new File(fileLocation);
        Media media = new Media(mediaFile.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mv = new MediaView();
        mv.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);

        MediaControl mediaControl = new MediaControl(openingStage, mediaPlayer);
        scene.setRoot(mediaControl);
        openingStage.setTitle("Embedded Media Player");
        openingStage.setScene(scene);
        openingStage.sizeToScene();
        openingStage.setMaximized(true);
                openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();
    }
}
