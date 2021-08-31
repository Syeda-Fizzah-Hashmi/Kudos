package logicRace;

import animatefx.animation.GlowBackground;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class SelectLevel {
    private Stage stage;
    private Scene scene;
    private AnchorPane pane;
    private Label heading;
    private Button Level1;
    private Button Level2;
    private Button Level3;
    private Slider volumeSlider;
    private Button back;
    private Button Settings;
    private File musicFile;
    private Media music;
    private MediaPlayer musicPlayer;
    private File ImageFile;
    private Image backImage;
    private ImageView backImageView;
    public SelectLevel(){
        ImageFile = new File("src/images/background.jpg");
        backImage = new Image(ImageFile.toURI().toString());
        backImageView = new ImageView(backImage);
        backImageView.setFitHeight(768);
        backImageView.setFitWidth(1366);
        stage = new Stage();
        pane = new AnchorPane();
        scene = new Scene(pane, 1300, 720);
        heading = new Label("SELECT LEVEL");
        //File heading1fontfile = new File("src/Font/heading.ttf");
        Font heading1font = Font.loadFont("file:src/Font/heading.ttf", 100);
        Font TimerFont = Font.loadFont("file:src/Font/heading.ttf", 50);
        Font questionfont = Font.loadFont("file:src/Font/heading.ttf", 20);
        Stop[] stops1 = {new Stop(0, Color.YELLOW), new Stop(1, Color.RED)};
        LinearGradient color = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stops1);
        heading.setFont(heading1font);
        heading.setTextFill(color);
        heading.setEffect(new Bloom());
        Level1 = new Button("LEVEL 1");
        Level1.setFont(TimerFont);
        Level1.setTextFill(color);
        Level1.setEffect(new Bloom());
        Level1.setBorder(new Border(new BorderStroke(Color.ORANGERED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        Level1.setOnMouseEntered(e -> new GlowBackground(Level1, Color.TRANSPARENT, Color.GOLD, 500).play());
        Level2 = new Button("LEVEL 2");
        Level2.setFont(TimerFont);
        Level2.setTextFill(color);
        Level2.setEffect(new Bloom());
        Level2.setBorder(new Border(new BorderStroke(Color.ORANGERED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        Level2.setOnMouseEntered(e -> new GlowBackground(Level2, Color.TRANSPARENT, Color.GOLD, 500).play());
        Level3 = new Button("LEVEL 3");
        Level3.setFont(TimerFont);
        Level3.setTextFill(color);
        stage.setTitle("Select Level");
        File icon = new File("src/images/speed.png");
        Image iconImage = new Image(icon.toURI().toString());
        stage.getIcons().add(iconImage);
        Level3.setEffect(new Bloom());
        Level3.setBorder(new Border(new BorderStroke(Color.ORANGERED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        Level3.setOnMouseEntered(e -> new GlowBackground(Level3, Color.TRANSPARENT, Color.GOLD, 500).play());
        Button main = new Button("MAIN MENU");
        main.setFont(TimerFont);
        main.setStyle("-fx-background-color: #FFFFFF00");
        main.setEffect(new Bloom());
        main.setTextFill(color);
        main.setLayoutX(493);
        main.setLayoutY(600);
        main.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths((3)))));
        main.setOnMouseEntered(e -> new GlowBackground(main, Color.TRANSPARENT, Color.YELLOW, 500).play());
        main.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenu mainmenu = new MainMenu();
                musicPlayer.stop();
                stage.close();
            }
        });
        musicFile = new File("src/Audio/back on track.mp3");
        music = new Media(musicFile.toURI().toString());
        musicPlayer = new MediaPlayer(music);
        musicPlayer.play();
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        volumeSlider = new Slider(0, 100, 100);
        volumeSlider.setPrefHeight(50);
        volumeSlider.setPrefWidth(100);
        Settings = new Button();
        Settings.setGraphic(new ImageView("images/settings.png"));
        Settings.setStyle("-fx-background-color: #FFFFFF00");
        Settings.setLayoutX(1320);
        Settings.setLayoutY(0.1);
        Settings.setPadding(new Insets(6,4,6,4));
        Settings.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        Settings.setEffect(new Bloom());
        volumeSlider.setLayoutY(0);
        volumeSlider.setLayoutX(1220);
        volumeSlider.setEffect(new Bloom());
        volumeSlider.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        back = new Button();
        back.setGraphic(new ImageView("images/right-arrow.png"));
        back.setLayoutX(1182);
        back.setLayoutY(6.5);
        back.setStyle("-fx-background-color: #FFFFFF00");
        back.setEffect(new Bloom());
        back.setPadding(new Insets(2,2,2,2));
        volumeSlider.valueProperty().addListener(new InvalidationListener(){
            public void invalidated(Observable ov){
                if (volumeSlider.isValueChanging()){
                    musicPlayer.setVolume(volumeSlider.getValue() / 100);
                }
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(volumeSlider);
                pane.getChildren().remove(back);
            }
        });
        Settings.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                pane.getChildren().add(volumeSlider);
                pane.getChildren().add(back);
            }
        });
        Level1.setLayoutX(530);
        Level1.setLayoutY(300);
        Level2.setLayoutX(530);
        Level2.setLayoutY(400);
        Level3.setLayoutX(530);
        Level3.setLayoutY(500);
        heading.setLayoutX(260);
        heading.setLayoutY(100);
        Level1.setPadding(new Insets(17,39,17,39));
        Level1.setStyle("-fx-background-color: #FFFFFF00");
        Level2.setStyle("-fx-background-color: #FFFFFF00");
        Level3.setStyle("-fx-background-color: #FFFFFF00");

        Level1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Level1 l1 = new Level1();
                musicPlayer.stop();
                stage.close();
            }
        });
        Level2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Level2 l2 = new Level2();
                musicPlayer.stop();
                stage.close();
            }
        });
        Level3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Level3 l3 = new Level3();
                musicPlayer.stop();
                stage.close();
            }
        });
        pane.getChildren().addAll(backImageView, Settings, heading, Level1, Level2, Level3, main);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
