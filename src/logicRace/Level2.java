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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Level2 {
    private Stage level2;
    private Scene scene;
    private AnchorPane pane;
    private Label heading;
    private File backFile;
    private Media back1;
    private MediaPlayer backPlayer1;
    private Label heading1;
    private Label subhead1;
    private Label question;
    private String question1;
    private String one;
    private String ans1 = "gnimmargorp";                  //gnimmargorp
    private String question2;
    private String two;
    private String ans2 = "12";
    private String question3;
    private String three;
    private String ans3 = "123456789";
    private String question4;
    private String four;
    private String ans4 = "58";
    private String five;
    private String ans5 = "6.3";
    private String six;
    private String ans6 = "5050";
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
    public Level2(){
        Button main2 = new Button("MAIN MENU");
        File wrongFile = new File("src/Audio/y2mate.com - Wrong Answersound effect for youtube video.mp3");
        Media wrong = new Media(wrongFile.toURI().toString());
        MediaPlayer wrongPlayer = new MediaPlayer(wrong);
        ImageFile = new File("src/images/back2.jpg");
        backImage = new Image(ImageFile.toURI().toString());
        backImageView = new ImageView(backImage);
        backImageView.setFitHeight(768);
        backImageView.setFitWidth(1366);
        level2 = new Stage();
        level2.setTitle("Level 2");
        File icon = new File("src/images/speed.png");
        Image iconImage = new Image(icon.toURI().toString());
        level2.getIcons().add(iconImage);
        pane = new AnchorPane();
        scene = new Scene(pane, 1300, 720);
        level2.setScene(scene);
        musicFile = new File("src/Audio/Inspire-ashutosh.mp3");
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
        //File heading1fontfile = new File("src/Font/heading.ttf");
        Font heading1font = Font.loadFont("file:src/Font/heading.ttf", 100);
        Font TimerFont = Font.loadFont("file:src/Font/heading.ttf", 50);
        Font questionfont = Font.loadFont("file:src/Font/heading.ttf", 20);
        Stop[] stops1 = {new Stop(0, Color.YELLOW), new Stop(1, Color.VIOLET)};
        LinearGradient color = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stops1);
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
                level2.close();
            }
        });
        heading1 = new Label("LEVEL 2");
        heading1.setFont(heading1font);
        heading1.setTextFill(color);
        heading1.setEffect(new Bloom());
        heading1.setLayoutX(470);
        heading1.toFront();
        question = new Label();
        one = "Question 01\n" +
                "main(){\n" +
                "        String str = \"programming\";\n" +
                "        String output = new String();\n" +
                "        int i, j = 0;\n" +
                "        for (i = str.length() - 1;i >= 0;i--)\n" +
                "        {\n" +
                "            output = output + str.charAt(i);\n" +
                "        }\n" +
                "        print(output);\n" +
                "}";
        two = "Question 02\n" +
                "main(){\n" +
                "        double[] i = {5.0, 7.0, 12.0, 14.0, 22.0};\n" +
                "        double sum = 0, average;\n" +
                "        int count;\n" +
                "        for (count = 0;count < i.length;count++)\n" +
                "        {\n" +
                "            sum = sum + i[count];\n" +
                "        }\n" +
                "        average = sum / i.length;\n" +
                "        print(average);\n" +
                "}";
        three = "Question 03\n" +
                "main(){\n" +
                "        int[] numbers = {5,6,2,3,1,9,4,8,7};\n" +
                "        int i, j, temp;\n" +
                "        for (i = 0;i < numbers.length;i++)\n" +
                "        {\n" +
                "            for (j = 0;j < numbers.length;j++)\n" +
                "            {\n" +
                "                if (numbers[i] < numbers[j]){\n" +
                "                    temp = numbers[i];\n" +
                "                    numbers[i] = numbers[j];\n" +
                "                    numbers[j] = temp;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        for (i = 0;i < numbers.length;i++)\n" +
                "        {\n" +
                "           \t    print(numbers[i]);\n" +
                "        }\n" +
                "}";
        four = "Question 04\n" +
                "main(){\n" +
                "          int x = 9;\n" +
                "          print(x * 6 + 5 / 4 * x - 5);\n" +
                "    }";
        five = "Question 05\n" +
                "main(){\n" +
                "          double x = 9.0;\n" +
                "          double y = 5.0;\n" +
                "          double z = 6.0;\n" +
                "          print(x * z / y - z + x / z);\n" +
                "    }";
        six = "main(String[] args){\n" +
                "        String number = \"50\";\n" +
                "        int num = Integer.valueOf(number);\n" +
                "        System.out.println(Integer.toString(num) + \"50\");\n" +
                "    }";
        question.setText(one);
        question.setFont(Font.font("Tahoma", 20));
        question.setTextFill(color);
        question.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
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
                musicPlayer.stop();
                level2.close();
                Level3 Level3 = new Level3();
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
                        pane.getChildren().removeAll(question, question, main2, runnerview, ground, finishline, finishlabel, answer, prompt, timer, submit, stopwatch.getTime(), main);
                        stopwatch.setLayoutTime(550, 230);
                        stopwatch.pause();
                        String timeRecorded = stopwatch.getTime().getText();
                        Level2Score score = new Level2Score(timeRecorded);
                        MainUser user = MainGame.MainUser.getInstance();
                        user.setlogicRace_time(timeRecorded);
                        highscore.setFont(TimerFont);
                        highscore.setTextFill(color);
                        highscore.setEffect(new Bloom());
                        //==========================================
                        new HighScore().scoreWriter(user, timeRecorded);
                        //==========================================
                        File level1 = new File("level2.txt");
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
        main2.setFont(TimerFont);
        main2.setStyle("-fx-background-color: #FFFFFF00");
        main2.setEffect(new Bloom());
        main2.setTextFill(color);
        main2.setLayoutX(980);
        main2.setLayoutY(250);
        main2.setBorder(new Border(new BorderStroke(Color.YELLOW, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths((3)))));
        main2.setOnMouseEntered(e -> new GlowBackground(main2, Color.TRANSPARENT, Color.YELLOW, 500).play());
        main2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenu mainmenu = new MainMenu();
                musicPlayer.stop();
                level2.close();
            }
        });
        pane.getChildren().addAll(backImageView, heading1, question, runnerview, ground, finishline, finishlabel, answer, prompt, timer, submit, Settings, main2, stopwatch.getTime());
        level2.setFullScreen(true);
        level2.show();
    }
}
