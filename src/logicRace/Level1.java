package logicRace;

import MainGame.MainUser;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import animatefx.animation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Level1{
    private Stage Level1;
    private Scene scene;
    private AnchorPane pane;
    private Label heading;
    private File backFile;
    private Media back;
    private MediaPlayer backPlayer;
    private Label heading1;
    private Label subhead1;
    private Label question;
    private String question1;
    private String one;
    private String ans1 = "hello world";
    private String question2;
    private String two;
    private String ans2 = "80";
    private String question3;
    private String three;
    private String ans3 = "76";
    private String question4;
    private String four;
    private String ans4 = "198";
    private String five;
    private String ans5 = "71";
    private String six;
    private String ans6 = "131";
    private File runnerFile;
    private Image runner;
    private ImageView runnerview;
    private Line ground;
    private Line finishline;
    private TextField answer;
    private HBox Timer;
    private Label text;
    private Timeline timeline;
    private Button submit;
    private int mins = 0, secs = 0, milsec = 0;
    private Label timer;
    private Label complete;
    private Button nextLevel;
    private Label Time;
    private Label highscore;
    private String temp1;
    private File musicFile;
    private Media music;
    private MediaPlayer musicPlayer;
    private Slider volumeSlider;
    private Button goback;
    private Button Settings;
    private File ImageFile;
    private Image backImage;
    private ImageView backImageView;
    public Level1(){
        Button main1 = new Button("MAIN MENU");
        File wrongFile = new File("src/Audio/y2mate.com - Wrong Answersound effect for youtube video.mp3");
        Media wrong = new Media(wrongFile.toURI().toString());
        MediaPlayer wrongPlayer = new MediaPlayer(wrong);
        Label no = new Label("WRONG ANSWER");
        ImageFile = new File("src/images/back1.jpg");
        backImage = new Image(ImageFile.toURI().toString());
        backImageView = new ImageView(backImage);
        backImageView.setFitHeight(768);
        backImageView.setFitWidth(1366);
        Level1 = new Stage();
        Level1.setTitle("Level 1");
        File icon = new File("src/images/speed.png");
        Image iconImage = new Image(icon.toURI().toString());
        Level1.getIcons().add(iconImage);
        pane = new AnchorPane();
        scene = new Scene(pane, 1300, 720);
        Level1.setScene(scene);
        musicFile = new File("src/Audio/Loyalty_Freak_Music_-_04_-_Cant_Stop_My_Feet_.mp3");
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
        goback = new Button();
        goback.setGraphic(new ImageView("images/right-arrow.png"));
        goback.setLayoutX(1182);
        goback.setLayoutY(6.5);
        goback.setStyle("-fx-background-color: #FFFFFF00");
        goback.setEffect(new Bloom());
        goback.setPadding(new Insets(2,2,2,2));
        volumeSlider.valueProperty().addListener(new InvalidationListener(){
            public void invalidated(Observable ov){
                if (volumeSlider.isValueChanging()){
                    musicPlayer.setVolume(volumeSlider.getValue() / 100);
                }
            }
        });
        goback.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(volumeSlider);
                pane.getChildren().remove(goback);
            }
        });
        Settings.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                pane.getChildren().add(volumeSlider);
                pane.getChildren().add(goback);
            }
        });
        one = "Question 01\n" +
                "main(){\n" +
                "        print(\"HELLO WORLD\");\t\t    \n" +
                "    }\n";
        two = "Question 02\n" +
                "main(){\n" +
                "        print(2 * 40);\n" +
                "   }\n";
        three = "Question 03\n" +
                "main(){\n" +
                "        int a = 4, b = 24;\n" +
                "        print(a + b * a - b);                \n" +
                "    }";
        four = "Question 04\n" +
                "main(){\n" +
                "        int a = 10, b = 20;\n" +
                "        print(a * b - b / a);                 \n" +
                "    }\n";
        five = "Question 05\n" +
                "main(){\n" +
                "          double x = 9.0;\n" +
                "          double y = 5.0;\n" +
                "          double z = 6.0;\n" +
                "          print(x * z / y - z + x / z);\n" +
                "    }";
        six = "Question 06\n" +
                "main(){\n" +
                "        String word = \"AB\";                    \n" +
                "        print((int)word.charAt(0) + \n(int)word.charAt(1)); \n//HINT: The words change into ASCII.\n" +
                "    }\n";
        //File heading1fontfile = new File("src/Font/heading.ttf");
        Font heading1font = Font.loadFont("file:src/Font/heading.ttf", 100);
        Font TimerFont = Font.loadFont("file:src/Font/heading.ttf", 50);
        Font questionfont = Font.loadFont("file:src/Font/heading.ttf", 20);
        Stop[] stops1 = {new Stop(0, Color.YELLOW), new Stop(1, Color.RED)};
        LinearGradient color = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stops1);
        Button main = new Button("MAIN MENU");
        no.setFont(questionfont);
        no.setTextFill(color);
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
                Level1.close();
            }
        });
        heading1 = new Label("LEVEL 1");
        heading1.setFont(heading1font);
        heading1.setTextFill(color);
        heading1.setEffect(new Bloom());
        heading1.setLayoutX(470);
        heading1.toFront();
        question = new Label();
        question.setText(one);
        question.setFont(Font.font("Verdana", 20));
        question.setTextFill(Color.YELLOW);
        question.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        question.setPadding(new Insets(10,10,10,10));
        question.setLayoutY(145);
        question.setLayoutX(10);
        runnerFile = new File("src/images/runner.gif");
        runner = new Image(runnerFile.toURI().toString());
        runnerview = new ImageView(runner);
        runnerview.setLayoutX(0);
        runnerview.setLayoutY(500);
        runnerview.setFitHeight(250);
        runnerview.setFitWidth(250);
        ground = new Line(0, 750, 1380,750);
        ground.setEffect(new Bloom());
        ground.setStroke(Color.YELLOW);
        Label finishlabel = new Label("FINISH LINE");
        finishlabel.setFont(questionfont);
        finishlabel.setTextFill(color);
        finishline = new Line(1300, 500, 1300, 750);
        finishline.setEffect(new Bloom());
        finishline.setStroke(Color.WHITE);
        finishlabel.setLayoutX(1235);
        finishlabel.setLayoutY(470);
        answer = new TextField();
        answer.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        Label prompt = new Label("ENTER YOU ANSWER HERE: ");
        prompt.setFont(questionfont);
        prompt.setTextFill(color);
        String style = "-fx-background-color: #FFFFFF00;" + "-fx-text-inner-color: YELLOW;";
        answer.setStyle(style);
        prompt.setLayoutX(544);
        prompt.setLayoutY(130);
        answer.setSkin(new TextFieldSkin(answer));
        answer.setFont(questionfont);
        answer.setLayoutX(544);
        answer.setLayoutY(155);
        answer.setPrefWidth(190);
        StopWatch stopwatch = new StopWatch(pane, TimerFont, color);
        timer = new Label("TIMER");
        timer.setFont(TimerFont);
        timer.setTextFill(color);
        timer.setLayoutX(1080);
        timer.setLayoutY(130);
        submit = new Button("Enter");
        submit.setEffect(new Bloom());
        submit.setFont(questionfont);
        submit.setTextFill(color);
        submit.setStyle("-fx-background-color: #FFFFFF00");
        submit.setLayoutX(735);
        submit.setLayoutY(155);
        submit.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        submit.setOnMouseEntered(e -> new GlowBackground(submit, Color.TRANSPARENT, Color.YELLOW, 500).play());
        complete = new Label("GOOD JOB YOUR TIME: ");
        complete.setFont(TimerFont);
        complete.setTextFill(color);
        complete.setLayoutX(400);
        complete.setLayoutY(180);
        complete.setEffect(new Bloom());
        nextLevel = new Button("Next Level");
        nextLevel.setFont(TimerFont);
        nextLevel.setTextFill(color);
        nextLevel.setLayoutX(490);
        nextLevel.setLayoutY(470);
        nextLevel.setStyle("-fx-background-color: #FFFFFF00");
        nextLevel.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
        nextLevel.setEffect(new Bloom());
        nextLevel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                Level2 level2 = new Level2();
                musicPlayer.stop();
                Level1.close();
            }
        });
        nextLevel.setOnMouseEntered(e -> new GlowBackground(nextLevel, Color.TRANSPARENT, Color.YELLOW, 500).play());
        Time = new Label();
        Time.setText(stopwatch.getTime().getText());
        Time.setFont(TimerFont);
        Time.setTextFill(color);
        Time.setLayoutX(350);
        Time.setLayoutY(180);
        Time.setEffect(new Bloom());
        highscore = new Label();
        wrongPlayer.setVolume(100);
        wrongPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                wrongPlayer.stop();
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (question.getText().equals(one)){
                    if (answer.getText().compareTo(ans1) != 0 && answer.getText().compareTo("") != 0){
                        answer.setText("");
                        wrongPlayer.play();
                    }
                    if (answer.getText().equals(ans1)){
                        runnerview.setLayoutX(200);
                        question.setText(two);
                        answer.setText("");
                    }
                }
                if (question.getText().equals(two)){
                    if (answer.getText().compareTo(ans2) != 0 && answer.getText().compareTo("") != 0){
                        answer.setText("");
                        wrongPlayer.play();
                    }
                    if (answer.getText().equals(ans2)){
                        runnerview.setLayoutX(400);
                        question.setText(three);
                        answer.setText("");
                    }
                }
                if (question.getText().equals(three)){
                    if (answer.getText().compareTo(ans3) != 0 && answer.getText().compareTo("") != 0){
                        answer.setText("");
                        wrongPlayer.play();
                    }
                    if (answer.getText().equals(ans3)){
                        runnerview.setLayoutX(600);
                        question.setText(four);
                        answer.setText("");
                    }
                }
                if (question.getText().equals(four)){
                    if (answer.getText().compareTo(ans4) != 0 && answer.getText().compareTo("") != 0){
                        answer.setText("");
                        wrongPlayer.play();
                    }
                    if (answer.getText().equals(ans4)){
                        runnerview.setLayoutX(800);
                        question.setText(five);
                        answer.setText("");
                    }
                }
                if (question.getText().equals(five)){
                    if (answer.getText().compareTo(ans5) != 0 && answer.getText().compareTo("") != 0){
                        answer.setText("");
                        wrongPlayer.play();
                    }
                    if (answer.getText().equals(ans5)){
                        runnerview.setLayoutX(1000);
                        question.setText(six);
                        answer.setText("");
                    }
                }
                if (question.getText().equals(six)){
                    if (answer.getText().compareTo(ans6) != 0 && answer.getText().compareTo("") != 0){
                        answer.setText("");
                        wrongPlayer.play();
                    }
                    if (answer.getText().equals(ans6)){
                        runnerview.setLayoutX(1200);
                        pane.getChildren().removeAll(question, question, main1, runnerview, ground, finishline, finishlabel, answer, prompt, timer, submit, stopwatch.getTime(), main);
                        stopwatch.setLayoutTime(550, 230);
                        stopwatch.pause();
                        String timeRecorded = stopwatch.getTime().getText();
                        Level1Score score = new Level1Score(timeRecorded);
                        MainUser user = MainGame.MainUser.getInstance();
                        user.setlogicRace_time(timeRecorded);
                        highscore.setFont(TimerFont);
                        highscore.setTextFill(color);
                        highscore.setEffect(new Bloom());
                        //==========================================
                        new HighScore().scoreWriter(user, timeRecorded);
                        //==========================================
                        File level1 = new File("level1.txt");
                        try {
                            Scanner input = new Scanner(level1);
                            while(input.hasNext()){
                                String temp = input.nextLine();
                                highscore.setText("HIGHSCORE: " + temp);
                                temp1 = temp;
                            }
                            input.close();
                        }
                        catch(FileNotFoundException e){

                        }
                        highscore.setText("HIGHSCORE: " + temp1);
                        highscore.setLayoutX(380);
                        highscore.setLayoutY(290);
                        pane.getChildren().addAll(complete, nextLevel, stopwatch.getTime(), highscore, main);
                        question.setText(two);
                    }
                }
            }
        });
        main1.setFont(TimerFont);
        main1.setStyle("-fx-background-color: #FFFFFF00");
        main1.setEffect(new Bloom());
        main1.setTextFill(color);
        main1.setLayoutX(980);
        main1.setLayoutY(250);
        main1.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths((3)))));
        main1.setOnMouseEntered(e -> new GlowBackground(main1, Color.TRANSPARENT, Color.YELLOW, 500).play());
        main1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenu mainmenu = new MainMenu();
                musicPlayer.stop();
                Level1.close();
            }
        });
        pane.getChildren().addAll(backImageView, heading1, question, runnerview, ground, finishline, finishlabel, answer, prompt, timer, submit, Settings, main1, stopwatch.getTime());
        Level1.setFullScreen(true);
        Level1.show();
    }
}

