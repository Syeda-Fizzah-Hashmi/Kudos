package logicRace;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import animatefx.animation.*;
import java.io.File;

public class MainMenu {
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double height = screenBounds.getHeight();
    double width = screenBounds.getWidth();

    private Stage stage;
    private Scene scene;
    private AnchorPane menu;
    private File introFile;
    private Media intro;
    private MediaPlayer introPlayer;
    private MediaView introView;
    private Label heading;
    private File backFile;
    private Media background;
    private MediaPlayer backPlayer;
    private MediaView backView;
    private Image backImage;
    private Label subhead;
    private ImageView imageView;
    private Slider volumeSlider;
    private Button Settings;
    private Button back;
    private File musicFile;
    private Media music;
    private final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";
    private MediaPlayer musicPlayer;
    private Button NewGame;
    private Button SelectLevel;
    private Button Credits;
    private Button HighScore;
    private Button Exit;
    public MainMenu() {
        String headingstyle = "-fx-font-size: 200px;" +
                "-fx-text-fill: linear-gradient(#c81d41, #5952bf, #ebd6b1, #c4ae94, #c3c9b1);" + "-fx-text-fill: linear-gradient(DARKBLUE, DARKVIOLET, YELLOW, BLACK);";
        stage = new Stage();
        File icon = new File("src/images/speed.png");
        Image iconImage = new Image(icon.toURI().toString());
        stage.getIcons().add(iconImage);
        stage.setTitle("MainMenu");
        musicFile = new File("src/Audio/y2mate.com - Gaming Background Music Electronic No Copyright Free Energetic.mp3");
        music = new Media(musicFile.toURI().toString());
        musicPlayer = new MediaPlayer(music);
        heading = new Label("LOGIC RUN");
        //File headingFontFile = new File("src/Font/heading.ttf");
        heading.setLayoutX(170);
        heading.setLayoutY(25);
        Font subFont = Font.loadFont("file:src/Font/heading.ttf", 60);
        Font headingFont = Font.loadFont("file:src/Font/heading.ttf", 180);
        Font ButtonFont = Font.loadFont("file:src/Font/heading.ttf", 25);
        heading.setFont(headingFont);
        heading.setEffect(new Bloom());
        Stop[] stops = new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.ROYALBLUE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        Stop[] stops2 = new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.RED)};
        LinearGradient lg2 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops2);
        heading.setTextFill(lg2);
        menu = new AnchorPane();
        scene = new Scene(menu, 1300, 720);
        menu.setStyle("-fx-background-color: #383838");

        backFile = new File("src/videos/background4.mp4");
        background = new Media(backFile.toURI().toString());
        backPlayer = new MediaPlayer(background);
        backPlayer.isMute();
        backView = new MediaView(backPlayer);
        subhead = new Label("Being Logical is being Fast");
        subhead.setFont(subFont);
        subhead.setTextFill(lg2);
        subhead.setLayoutX(200);
        subhead.setLayoutY(215);
        subhead.setEffect(new Bloom());
        NewGame = new Button("NEW GAME");
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
                menu.getChildren().remove(volumeSlider);
                menu.getChildren().remove(back);
            }
        });
        Settings.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                menu.getChildren().add(volumeSlider);
                menu.getChildren().add(back);
            }
        });
        String buttonStyle = "-fx-background-color: BLACK";
        NewGame = new Button("NEW GAME");
        NewGame.setFont(ButtonFont);
        NewGame.setStyle(buttonStyle);
        NewGame.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        NewGame.setOnMouseEntered(e -> new GlowBackground(NewGame, Color.TRANSPARENT, Color.CYAN, 500).play());
        NewGame.setEffect(new Bloom());
        NewGame.setLayoutX(573);
        NewGame.setLayoutY(400);
        NewGame.setOnMouseClicked(e -> {
            NewGame.setStyle("-fx-background-color: BLACK");
        });
        NewGame.setTextFill(lg2);
        NewGame.setPadding(new Insets(8, 44, 8, 44));
        NewGame.setOnMouseEntered(e -> new Pulse(NewGame).play());
        NewGame.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                NewGame newgame = new NewGame();
                backPlayer.stop();
                musicPlayer.stop();
                stage.close();
            }
        });
        SelectLevel = new Button("SELECT LEVEL");
        SelectLevel.setEffect(new Bloom());
        SelectLevel.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        SelectLevel.setFont(ButtonFont);
        SelectLevel.setLayoutX(573);
        SelectLevel.setLayoutY(450);
        SelectLevel.setStyle("-fx-background-color: BLACK");
        SelectLevel.setTextFill(lg2);
        SelectLevel.setOnMouseEntered(e -> new GlowBackground(SelectLevel, Color.TRANSPARENT, Color.CYAN, 500).play());
        SelectLevel.setPadding(new Insets(8, 17, 8, 17));
        SelectLevel.setOnMouseEntered(e -> new Pulse(SelectLevel).play());
        SelectLevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SelectLevel selectlevel = new SelectLevel();
                musicPlayer.stop();
                stage.close();
            }
        });
        HighScore = new Button("HIGHSCORE");
        HighScore.setEffect(new Bloom());
        HighScore.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        HighScore.setFont(ButtonFont);
        HighScore.setLayoutX(573);
        HighScore.setLayoutY(501);
        HighScore.setStyle("-fx-background-color: BLACK");
        HighScore.setTextFill(lg2);
        HighScore.setPadding(new Insets(8, 45,8, 44));
        HighScore.setOnMouseEntered(e -> new Pulse(HighScore).play());
        HighScore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HighScore highscore = new HighScore();
                musicPlayer.stop();
                stage.close();
            }
        });
        Credits = new Button("CREDITS");
        Credits.setEffect(new Bloom());
        Credits.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        Credits.setFont(ButtonFont);
        Credits.setLayoutX(573);
        Credits.setLayoutY(553);
        Credits.setStyle("-fx-background-color: BLACK");
        Credits.setTextFill(lg2);
        Credits.setPadding(new Insets(8, 63, 8,64));
        Credits.setOnMouseEntered(e -> new Pulse(Credits).play());
        Credits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Credits cre = new Credits();
                musicPlayer.stop();
                stage.close();
            }
        });
        Exit = new Button("EXIT");
        Exit.setEffect(new Bloom());
        Exit.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        Exit.setFont(ButtonFont);
        Exit.setLayoutX(573);
        Exit.setLayoutY(605);
        Exit.setStyle("-fx-background-color: BLACK");
        Exit.setTextFill(lg2);
        Exit.setPadding(new Insets(7, 91, 7,90));
        Exit.setOnMouseEntered(e -> new Pulse(Exit).play());
        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                musicStop();
                new MainGame.Main();
                stage.close();
                //new MainGame.Main().MainGamestage(new Stage());
            }
        });
        menu.getChildren().add(backView);
        menu.getChildren().add(heading);
        menu.getChildren().add(subhead);
        menu.getChildren().add(Settings);
        menu.getChildren().add(NewGame);
        menu.getChildren().add(SelectLevel);
        menu.getChildren().add(HighScore);
        menu.getChildren().add(Credits);
        menu.getChildren().add(Exit);
        musicPlayer.play();
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backPlayer.play();
        backPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backView.setFitHeight(height);
        backView.setFitWidth(width);
        NewGame.setOnMouseEntered(e -> new GlowBackground(NewGame, Color.TRANSPARENT, Color.YELLOW, 500).play());
        SelectLevel.setOnMouseEntered(e -> new GlowBackground(SelectLevel, Color.TRANSPARENT, Color.YELLOW, 500).play());
        HighScore.setOnMouseEntered(e -> new GlowBackground(HighScore, Color.TRANSPARENT, Color.YELLOW, 500).play());
        Credits.setOnMouseEntered(e -> new GlowBackground(Credits, Color.TRANSPARENT, Color.YELLOW, 500).play());
        Exit.setOnMouseEntered(e -> new GlowBackground(Exit, Color.TRANSPARENT, Color.YELLOW, 500).play());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    public void StageShow(){
        stage.show();
    }
    public void musicStop(){
        musicPlayer.stop();
    }
}
