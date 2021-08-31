package logicRace;

import MainGame.MainUser;
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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HighScore {
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
    private Label highscore1;
    private Label highscore2;
    private Label highscore3;
    public HighScore(){
        String temp1 = new String();
        String temp2 = new String();
        String temp3 = new String();
        highscore1 = new Label();
        highscore2 = new Label();
        highscore3 = new Label();
        File level1 = new File("level1.txt");
        try {
            Scanner input = new Scanner(level1);
            while(input.hasNext()){
                temp1 = input.next();
                highscore1.setText("HIGHSCORE1: " + temp1);
            }
            input.close();
        }
        catch(FileNotFoundException e){

        }
        File level2 = new File("level2.txt");
        try {
            Scanner input = new Scanner(level2);
            while(input.hasNext()){
                temp2 = input.next();
                highscore2.setText("HIGHSCORE2: " + temp2);
            }
            input.close();
        }
        catch(FileNotFoundException e){

        }
        File level3 = new File("level3.txt");
        try {
            Scanner input = new Scanner(level3);
            while(input.hasNext()){
                temp3 = input.next();
                highscore3.setText("HIGHSCORE3: " + temp3);
            }
            input.close();
        }
        catch(FileNotFoundException e){

        }
        highscore1.setLayoutX(380);
        highscore1.setLayoutY(300);
        highscore2.setLayoutX(380);
        highscore2.setLayoutY(400);
        highscore3.setLayoutX(380);
        highscore3.setLayoutY(500);
        highscore1.setEffect(new Bloom());
        highscore2.setEffect(new Bloom());
        highscore3.setEffect(new Bloom());
        ImageFile = new File("src/images/pexels-adrien-olichon-2387793.jpg");
        backImage = new Image(ImageFile.toURI().toString());
        backImageView = new ImageView(backImage);
        backImageView.setFitHeight(768);
        backImageView.setFitWidth(1366);
        stage = new Stage();
        stage.setTitle("HighScores");
        File icon = new File("src/images/speed.png");
        Image iconImage = new Image(icon.toURI().toString());
        stage.getIcons().add(iconImage);
        pane = new AnchorPane();
        scene = new Scene(pane, 1300, 720);
        heading = new Label("HIGHSCORES");
        //File heading1fontfile = new File("src/Font/heading.ttf");
        Font heading1font = Font.loadFont("file:src/Font/heading.ttf", 100);
        Font TimerFont = Font.loadFont("file:src/Font/heading.ttf", 50);
        Font questionfont = Font.loadFont("file:src/Font/heading.ttf", 20);
        Stop[] stops1 = {new Stop(0, Color.YELLOW), new Stop(1, Color.RED)};
        LinearGradient color = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stops1);
        musicFile = new File("src/Audio/Sweet.mp3");
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
        Button main = new Button("MAIN MENU");
        main.setFont(TimerFont);
        main.setStyle("-fx-background-color: #FFFFFF00");
        main.setEffect(new Bloom());
        main.setTextFill(color);
        main.setLayoutX(510);
        main.setLayoutY(580);
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
        highscore1.setFont(TimerFont);
        highscore1.setTextFill(color);
        highscore2.setFont(TimerFont);
        highscore2.setTextFill(color);
        highscore3.setFont(TimerFont);
        highscore3.setTextFill(color);
        heading.setFont(heading1font);
        heading.setTextFill(color);
        heading.setEffect(new Bloom());
        heading.setLayoutX(350);
        heading.setLayoutY(100);
        pane.getChildren().addAll(backImageView, heading, Settings, highscore1, highscore2, highscore3, main);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public void scoreWriter(MainUser user, String timeRecorded){
        try {
            ArrayList<MainUser> userList = new ArrayList<>();
            // If file is Empty
            if ((new File("LogicRaceData.ser")).length() == 0) {
                System.out.println("insideeeeeeee Empty");
                user.setlogicRace_time(timeRecorded);
                userList.add(user);
                ObjectOutputStream writeFile;
                writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("LogicRaceData.ser")));
                writeFile.writeObject(userList);
                writeFile.close();
            }
            // If file is not Empty
            else {
                System.out.println("insideeeeeeee");
                ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("LogicRaceData.ser")));
                userList = (ArrayList<MainUser>) readFile.readObject();
                int flag = 0;
                for (int i = 0; i < userList.size(); i++) {
                    if (user.getUserName().equals(userList.get(i).getUserName())) {
                        userList.get(i).setlogicRace_time(timeRecorded);
                        ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("LogicRaceData.ser")));
                        writeFile.writeObject(userList);
                        writeFile.close();
                        flag = 1;
                        break;
                    }
                }
                readFile.close();
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
