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

public class Credits {
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
    private Label credits;
    public Credits(){
        credits = new Label("MADE BY: Ali Ammar");
        credits.setLayoutX(800);
        ImageFile = new File("src/images/level3.jpg");
        backImage = new Image(ImageFile.toURI().toString());
        backImageView = new ImageView(backImage);
        backImageView.setFitHeight(768);
        backImageView.setFitWidth(1366);
        stage = new Stage();
        stage.setTitle("Credits");
        File icon = new File("src/images/speed.png");
        Image iconImage = new Image(icon.toURI().toString());
        stage.getIcons().add(iconImage);
        pane = new AnchorPane();
        scene = new Scene(pane, 1300, 720);
        heading = new Label("CREDITS");
        heading.setLayoutX(700);
        //File heading1fontfile = new File("src/Font/heading.ttf");
        Font heading1font = Font.loadFont("file:src/Font/heading.ttf", 100);
        Font TimerFont = Font.loadFont("file:src/Font/heading.ttf", 50);
        Font questionfont = Font.loadFont("file:src/Font/heading.ttf", 20);
        Stop[] stops1 = {new Stop(0, Color.BLACK), new Stop(1, Color.BLACK)};
        LinearGradient color = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stops1);
        musicFile = new File("src/Audio/theory of everything.mp3");
        music = new Media(musicFile.toURI().toString());
        musicPlayer = new MediaPlayer(music);
        musicPlayer.play();
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        volumeSlider = new Slider(0, 100, 100);
        volumeSlider.setPrefHeight(50);
        volumeSlider.setPrefWidth(100);
        Settings = new Button();
        //Settings.setGraphic(new ImageView("src/images/settings.png"));
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
        Button main = new Button("MAIN MENU");
        main.setFont(TimerFont);
        main.setStyle("-fx-background-color: #FFFFFF00");
        main.setEffect(new Bloom());
        main.setTextFill(color);
        main.setLayoutX(510);
        main.setLayoutY(530);
        main.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths((3)))));
        main.setOnMouseEntered(e -> new GlowBackground(main, Color.TRANSPARENT, Color.YELLOW, 500).play());
        main.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenu mainmenu = new MainMenu();
                musicPlayer.stop();
                stage.close();
            }
        });
        heading.setFont(heading1font);
        heading.setTextFill(color);
        heading.setEffect(new Bloom());
        heading.setLayoutX(460);
        heading.setLayoutY(100);
        credits.setFont(TimerFont);
        credits.setTextFill(color);
        credits.setLayoutX(410);
        credits.setLayoutY(300);
        pane.getChildren().addAll(backImageView, heading, main, credits);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
