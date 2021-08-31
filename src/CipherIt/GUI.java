package CipherIt;

import com.company.*;
import com.company.Instructions;
import com.company.Key;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Scene.*;

import java.net.MalformedURLException;

public class GUI {

    //public static void main(String[] args) {Application.launch(args); }
    AudioClip audio;
    //@Override
    //public void start(Stage openingStage) throws Exception { showWelcomeScene(openingStage);}
    public GUI(){
        showWelcomeScene(new Stage());
    }

    public static void showWelcomeScene(Stage openingStage) {
        Label l1 = new Label();
        Button play = new Button();
        Button exit = new Button();
        Button help = new Button();
        //Creating a graphic (image)
        Image l = new Image("file:label.png");
        ImageView label = new ImageView(l);
        label.setFitHeight(120);
        label.setPreserveRatio(true);
        l1.setPadding(new Insets(56, 24, 16, 24));
        l1.setGraphic(label);

        Image img = new Image("file:src/images/playbutton.png");
        ImageView playImg = new ImageView(img);
        playImg.setFitHeight(40);
        playImg.setPreserveRatio(true);
        play.setAlignment(Pos.CENTER);
        play.setMnemonicParsing(false);

        play.setPadding(new Insets(8, 12, 8, 12));

        //Setting a graphic to the button
        play.setGraphic(playImg);

        Image img1 = new Image("file:src/images/exit.png");
        ImageView exitImg = new ImageView(img1);
        exitImg.setFitHeight(40);
        exitImg.setPreserveRatio(true);

        //Setting the size of the button
        exit.setPrefSize(30, 30);
        //Setting a graphic to the button
        exit.setGraphic(exitImg);

        Image img2 = new Image("file:src/images/help.png");
        ImageView helpImg = new ImageView(img2);
        helpImg.setFitHeight(40);
        helpImg.setPreserveRatio(true);

        //Setting the size of the button
        help.setPrefSize(30, 30);
        //Setting a graphic to the button
        help.setGraphic(helpImg);

        //Setting font to the text
        l1.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 20));

        //  l1.setContentDisplay(ContentDisplay.TOP);
        VBox v1 = new VBox();

        //center aligning the pane
        l1.setAlignment(Pos.TOP_CENTER);
        v1.getChildren().add(l1);
        v1.setAlignment(Pos.CENTER);
        HBox v2 = new HBox();

        exit.setAlignment(Pos.BASELINE_LEFT);
        help.setAlignment(Pos.BASELINE_RIGHT);
        v2.getChildren().addAll(exit, help);

        BorderPane borderPane = new BorderPane();
//        BorderPane borderPane1 = new BorderPane();
//        BorderPane root = new BorderPane();
//        borderPane1.setRight(help);
//        borderPane.setBottom(borderPane1);
        borderPane.setTop(v1);
        borderPane.setCenter(play);
        borderPane.setBottom(v2);

        BackgroundImage myBI = new BackgroundImage(new Image("file:src/images/welcome.jpg", true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        Scene openingScene = new Scene(borderPane, 600, 600);
        v2.setSpacing(openingScene.getWidth());
//then you set to your node
        borderPane.setBackground(new Background(myBI));
        play.setOnAction(e -> showLevels(openingStage));
        exit.setOnAction(e -> {
            new MainGame.Main();
            openingStage.close();
        });//setting exit button on
        help.setOnAction(e -> {
            try {
                Instructions.instructionStage(openingStage);
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        openingStage.setScene(openingScene);
        openingStage.setMaximized(true);
        openingStage.setFullScreen(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.show();

        //setting the title of the stage
        openingStage.setTitle("Puzzle Game");
        //method to display the stage
        openingStage.show();
        //maximizing the screenSize
        openingStage.setMaximized(true);
        openingStage.setFullScreen(true);

    }

    public static void showLevels(Stage openingStage) {

        Label l1 = new Label();
        Button level1 = new Button();
        Button level2 = new Button();
        Button level3 = new Button();
        Button level4 = new Button();
        Button level5 = new Button();
        Button back = new Button();
        //Creating a graphic (image)
        Image l = new Image("file:src/images/levels.png");
        ImageView label = new ImageView(l);
        label.setFitHeight(150);
        label.setPreserveRatio(true);

        l1.setTranslateX(0);
        l1.setTranslateY(125);
        l1.setGraphic(label);

        Image img = new Image("file:src/images/level1.png");
        ImageView shapes = new ImageView(img);
        shapes.setFitHeight(40);
        shapes.setPreserveRatio(true);

        //Setting the size of the button
        level1.setPrefSize(30, 30);
        //Setting a graphic to the button
        level1.setGraphic(shapes);

        Image img1 = new Image("file:src/images/numbers.png");
        ImageView numbers = new ImageView(img1);
        numbers.setFitHeight(40);
        numbers.setPreserveRatio(true);

        //Setting the size of the button
        level2.setPrefSize(30, 30);
        //Setting a graphic to the button
        level2.setGraphic(numbers);

        Image img2 = new Image("file:src/images/shapes.png");
        ImageView alphabets = new ImageView(img2);
        alphabets.setFitHeight(40);
        alphabets.setPreserveRatio(true);

        //Setting the size of the button
        level3.setPrefSize(30, 30);
        //Setting a graphic to the button
        level3.setGraphic(alphabets);

        Image img4 = new Image("file:src/images/ascii.png");
        ImageView ascii = new ImageView(img4);
        ascii.setFitHeight(40);
        ascii.setPreserveRatio(true);
        //Creating a Button

        //Setting the size of the button
        level4.setPrefSize(30, 30);
        //Setting a graphic to the button
        level4.setGraphic(ascii);

        Image img5 = new Image("file:src/images/ebcdic.png");
        ImageView ebc = new ImageView(img5);
        ebc.setFitHeight(40);
        ebc.setPreserveRatio(true);

        //Setting the size of the button
        level5.setPrefSize(30, 30);
        //Setting a graphic to the button
        level5.setGraphic(ebc);

        Image img3 = new Image("file:src/images/back.png");
        ImageView back4 = new ImageView(img3);
        back4.setFitHeight(40);
        back4.setPreserveRatio(true);

        //Setting the size of the button
        back.setPrefSize(30, 30);
        //Setting a graphic to the button
        back.setGraphic(back4);

        //Setting font to the text
        l1.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 20));

        l1.setContentDisplay(ContentDisplay.TOP);
        Text space = new Text();
        space.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 120));
        Text space1 = new Text();
        space1.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 100));
        VBox p1 = new VBox(20);
        //center aligning the pane
        p1.setAlignment(Pos.CENTER);
        p1.getChildren().addAll(l1, space, level1, level2, level3,
                level4, level5, space1);
        FlowPane pane = new FlowPane();
        pane.setHgap(202);
        pane.setVgap(0);
        pane.getChildren().addAll(back);

        back.setOnAction((ActionEvent e) -> showWelcomeScene(openingStage));
        level1.setOnAction((ActionEvent e) -> level1(openingStage));
        level2.setOnAction((ActionEvent e) -> level2(openingStage));
        level3.setOnAction((ActionEvent e) -> level3(openingStage));
        level4.setOnAction((ActionEvent e) -> level4(openingStage));
        level5.setOnAction((ActionEvent e) -> level5(openingStage));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(p1);
        borderPane.setBottom(pane);

        BackgroundImage myBI = new BackgroundImage(new Image("file:src/images/levelsBI.png", true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
//then you set to your node
        borderPane.setBackground(new Background(myBI));
        Scene levelScene = new Scene(borderPane);
        openingStage.setScene(levelScene);
        openingStage.show();
        //maximizing the screenSize
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);

    }

    public static Boolean check(String ans, String input) {

        return input.equalsIgnoreCase(ans);
    }

    public static void level1(Stage openingStage) {

        TextField field = new TextField();
        Button check = new Button("Enter");
        Image img = new Image("file:src/images/enter.png");
        ImageView enter = new ImageView(img);
        enter.setFitHeight(40);
        enter.setPreserveRatio(true);

        //Setting the size of the button
        check.setPrefSize(30, 30);
        //Setting a graphic to the button
        check.setGraphic(enter);
        Key k1 = new Key();
        String word = k1.workPicked();
        HBox h1 = k1.pane(word);
        Shape[] arr = k1.code1(word);
        int codeInt = (int) (Math.random() * arr.length);
        Shape s1 = k1.randomShape(codeInt, arr);
        String ans = k1.getAns(codeInt, word);

        check.setOnAction(e -> {

            Boolean bool = check(ans, field.getText());

            if (bool) {

                correctScene(openingStage, 1);

            } else {
                wrong(openingStage, 1);

            }
        });
        Font font = new Font("Comic Sans MS", 33);

        Text text1 = new Text(" \n\n         If ");
        Text text = new Text(word);
        Text text2 = new Text(" is represented by  ");
        Text text3 = new Text("  then what letter does the shape  ");
        Text text4 = new Text("   represent?\n");

        TextFlow t1 = new TextFlow();
        Font lvl2font = new Font("Comic Sans MS", 35);
        text1.setFill(Color.RED);
        text1.setFont(font);
        text.setFill(Color.RED);
        text.setFont(font);
        text2.setFill(Color.DARKBLUE);
        text2.setFont(lvl2font);
        text3.setFill(Color.RED);
        text3.setFont(font);
        text4.setFill(Color.RED);
        text4.setFont(font);

        t1.getChildren().addAll(text1, text, text2, h1, text3, s1, text4);

        field.setMaxWidth(80);
        field.setAlignment(Pos.CENTER);

        BorderPane rootNode = new BorderPane();
        rootNode.setPadding(new Insets(15));

        rootNode.setTop(t1);
        rootNode.setCenter(field);
        rootNode.setBottom(check);
        //setting the background of the node
        Image image1 = new Image("file:src/images/" + word + ".png");
        BackgroundImage myBI = new BackgroundImage(image1,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        rootNode.setBackground(new Background(myBI));
        Scene scene1 = new Scene(rootNode);
        openingStage.setScene(scene1);
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);

        openingStage.setFullScreen(true);
        openingStage.show();

    }

    public static void level2(Stage openingStage) {
//String word, String num, String character, TextField field1, Button button
        Key k2 = new Key();
        Button button = new Button("Enter");
        Image img = new Image("file:src/images/enter.png");
        ImageView enter = new ImageView(img);
        enter.setFitHeight(40);
        enter.setPreserveRatio(true);

        //Setting the size of the button
        button.setPrefSize(30, 30);
        //Setting a graphic to the button
        button.setGraphic(enter);
        TextField field2 = new TextField();
        String word = k2.workPicked();
        String character = k2.randomChar(word);
        String num = k2.code2(word);
        String ans2 = k2.code2ans(character);

        button.setOnAction(e -> {
            Boolean bool2 = check(ans2, field2.getText());

            if (bool2) {

                correctScene(openingStage, 2);

            } else {
                wrong(openingStage, 2);

            }
        });
        Text t1 = new Text(" \n\n     If ");
        Text t2 = new Text(word);
        Text t3 = new Text("  is represented by ");
        Text t4 = new Text(num);
        Text t5 = new Text(" then which number represents ");
        Text t6 = new Text(character);
        Text t7 = new Text(" ?");

        Font font = new Font("Comic Sans MS", 26);
        TextFlow textflow = new TextFlow();
        Font lvl2font = new Font("Comic Sans MS", 28);

        t1.setFill(Color.RED);
        t1.setFont(font);
        t2.setFill(Color.DARKBLUE);
        t2.setFont(lvl2font);
        t3.setFill(Color.RED);
        t3.setFont(font);
        t4.setFill(Color.RED);
        t4.setFont(font);
        t5.setFill(Color.DARKBLUE);
        t5.setFont(lvl2font);
        t6.setFill(Color.RED);
        t6.setFont(font);
        t7.setFill(Color.RED);
        t7.setFont(font);

        textflow.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7);
        field2.setMaxWidth(80);
        field2.setAlignment(Pos.CENTER);

        BorderPane rootNode = new BorderPane();
        rootNode.setPadding(new Insets(15));

        rootNode.setTop(textflow);
        rootNode.setCenter(field2);
        rootNode.setBottom(button);
        //setting the background of the node
        Image image1 = new Image("file:src/images/" + word + ".png");
        BackgroundImage myBI = new BackgroundImage(image1,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        rootNode.setBackground(new Background(myBI));
        Scene scene1 = new Scene(rootNode, 600, 600);
        openingStage.setScene(scene1);
        //maximizing the screenSize
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();
    }

    public static void level3(Stage openingStage) {
        Button check3 = new Button("Enter");
        Image img = new Image("file:src/images/enter.png");
        ImageView enter = new ImageView(img);
        enter.setFitHeight(40);
        enter.setPreserveRatio(true);

        //Setting the size of the button
        check3.setPrefSize(30, 30);
        //Setting a graphic to the button
        check3.setGraphic(enter);
        TextField lvl3q1ans = new TextField();
        Key k3 = new Key();
        String lvl3word = k3.workPicked();
        String lvl3char = k3.randomChar(lvl3word);
        String lvl3num = k3.reverseCode(lvl3word);
        String lvl3ans = k3.reverseCode(lvl3char);

        check3.setOnAction(e -> {
            Boolean bool3 = check(lvl3ans, lvl3q1ans.getText());

            if (bool3) {

                correctScene(openingStage, 3);

            } else {
                wrong(openingStage, 3);

            }
        });
        Text t1 = new Text("\n\n      If ");
        Text t2 = new Text(lvl3word);
        Text t3 = new Text("  stand for the word ");
        Text t4 = new Text(lvl3num);
        Text t5 = new Text(" then what letter represents ");
        Text t6 = new Text(lvl3char);
        Text t7 = new Text(" ?");

        Font font = new Font("Comic Sans MS", 26);
        TextFlow textflow = new TextFlow();
        Font lvl2font = new Font("Comic Sans MS", 28);

        t1.setFill(Color.RED);
        t1.setFont(font);
        t2.setFill(Color.DARKBLUE);
        t2.setFont(lvl2font);
        t3.setFill(Color.RED);
        t3.setFont(font);
        t4.setFill(Color.RED);
        t4.setFont(font);
        t5.setFill(Color.DARKBLUE);
        t5.setFont(lvl2font);
        t6.setFill(Color.RED);
        t6.setFont(font);
        t7.setFill(Color.RED);
        t7.setFont(font);

        textflow.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7);
        lvl3q1ans.setMaxWidth(80);
        lvl3q1ans.setAlignment(Pos.CENTER);

        BorderPane rootNode = new BorderPane();
        rootNode.setPadding(new Insets(15));

        rootNode.setTop(textflow);
        rootNode.setCenter(lvl3q1ans);
        rootNode.setBottom(check3);
        //setting the background of the node

        Image image1 = new Image("file:src/images/" + lvl3word + ".png");
        BackgroundImage myBI = new BackgroundImage(image1,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        rootNode.setBackground(new Background(myBI));
        Scene scene1 = new Scene(rootNode);
        openingStage.setScene(scene1);
        //maximizing the screenSize
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();

    }

    public static void level4(Stage openingStage) {
        //String word, TextField field1, Button button
        Key k4 = new Key();
        String lvl4word = k4.randomCharecter();
        Button lvl4check = new Button("Enter");
        Image img = new Image("file:src/images/enter.png");
        ImageView enter = new ImageView(img);
        enter.setFitHeight(40);
        enter.setPreserveRatio(true);

        //Setting the size of the button
        lvl4check.setPrefSize(30, 30);
        //Setting a graphic to the button
        lvl4check.setGraphic(enter);
        TextField lvl4ans = new TextField();
        Text t1 = new Text(" \n\n   How is the character ");
        Text t2 = new Text(lvl4word);
        Text t3 = new Text("  represented in ASCII CODE? ");
        String ans = k4.asciiAnswer(lvl4word);

        lvl4check.setOnAction(e -> {
            Boolean bool4 = check(ans, lvl4ans.getText());

            if (bool4) {

                correctScene(openingStage, 4);

            } else {
                wrong(openingStage, 4);

            }
        });
        Font font = new Font("Comic Sans MS", 26);
        TextFlow textflow = new TextFlow();
        Font lvl2font = new Font("Comic Sans MS", 28);

        t1.setFill(Color.RED);
        t1.setFont(font);
        t2.setFill(Color.DARKBLUE);
        t2.setFont(lvl2font);
        t3.setFill(Color.RED);
        t3.setFont(font);

        textflow.getChildren().addAll(t1, t2, t3);
        lvl4ans.setMaxWidth(40);

        BorderPane rootNode = new BorderPane();
        rootNode.setPadding(new Insets(15));

        rootNode.setTop(textflow);
        rootNode.setCenter(lvl4ans);
        rootNode.setBottom(lvl4check);
        //setting the background of the node

        Image image = new Image("file:src/images/asciibg.png");
        BackgroundImage myBI = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        rootNode.setBackground(new Background(myBI));
        Scene scene1 = new Scene(rootNode);
        openingStage.setScene(scene1);
        //maximizing the screenSize
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();
    }

    public static void level5(Stage openingStage) {
//String word, TextField field1, Button button
        Key k5 = new Key();
        Button lvl5check = new Button("Enter");
        Image img = new Image("file:src/images/enter.png");
        ImageView enter = new ImageView(img);
        enter.setFitHeight(40);
        enter.setPreserveRatio(true);

        //Setting the size of the button
        lvl5check.setPrefSize(30, 30);
        //Setting a graphic to the button
        lvl5check.setGraphic(enter);
        TextField lvl5ans = new TextField();
        String[] p1 = k5.ebcCode();
        Text t1 = new Text("\n\n      How is the character ");
        Text t2 = new Text(p1[0]);
        Text t3 = new Text("  represented in EBCDIC CODE? ");

        lvl5check.setOnAction(e -> {
            Boolean bool5 = check(p1[1], lvl5ans.getText());

            if (bool5) {

                correctScene(openingStage, 5);

            } else {
                wrong(openingStage, 5);

            }
        });
        Font font = new Font("Comic Sans MS", 26);
        TextFlow textflow = new TextFlow();
        Font lvl2font = new Font("Comic Sans MS", 28);

        t1.setFill(Color.RED);
        t1.setFont(font);
        t2.setFill(Color.DARKBLUE);
        t2.setFont(lvl2font);
        t3.setFill(Color.RED);
        t3.setFont(font);

        textflow.getChildren().addAll(t1, t2, t3);
        lvl5ans.setMaxWidth(80);
        lvl5ans.setAlignment(Pos.CENTER);

        BorderPane rootNode = new BorderPane();
        rootNode.setPadding(new Insets(15));

        rootNode.setTop(textflow);
        rootNode.setCenter(lvl5ans);
        rootNode.setBottom(lvl5check);
        //setting the background of the node
        Image image = new Image("file:src/images/ebc.png");
        BackgroundImage myBI = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        rootNode.setBackground(new Background(myBI));
        Scene scene1 = new Scene(rootNode);
        openingStage.setScene(scene1);
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();
    }

    public static void correctScene(Stage openingStage, int level) {
        Button button1 = new Button();//back button
        Button button2 = new Button();//button for next question
        switch (level) {
            case 1:
                button2.setOnAction(i -> level1(openingStage));
                break;
            case 2:
                button2.setOnAction(i -> level2(openingStage));
                break;
            case 3:
                button2.setOnAction(i -> level3(openingStage));
                break;
            case 4:
                button2.setOnAction(i -> level4(openingStage));
                break;
            case 5:
                button2.setOnAction(i -> level5(openingStage));
                break;
        }
        button1.setOnAction(g -> showWelcomeScene(openingStage));
        Image l = new Image("file:src/images/correcttxt.png");
        ImageView label = new ImageView(l);
        label.setFitHeight(120);
        label.setPreserveRatio(true);
        HBox label1 = new HBox(label);
        label1.setAlignment(Pos.CENTER);
        label1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        label1.setMaxWidth(40);

        label1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: darkorange;");
        Text t = new Text("\n\n\n\n\n\n\n\n");
        Text t1 = new Text(" You gave the right answer. \nNice Work!");
        t1.setStyle("-fx-background-color: stable; -fx-text-fill: white;");

        Image img1 = new Image("file:src/images/back.png");
        ImageView back = new ImageView(img1);
        back.setFitHeight(40);
        back.setPreserveRatio(true);
        //Creating a Button

        button1.setTranslateX(0);
        button1.setTranslateY(0);
        //Setting the size of the button
        button1.setPrefSize(30, 30);
        //Setting a graphic to the button
        button1.setGraphic(back);
        Image img = new Image("file:src/images/nextQuestion.png");
        ImageView nextQuestion = new ImageView(img);
        nextQuestion.setFitHeight(40);
        nextQuestion.setPreserveRatio(true);

        button2.setTranslateX(0);
        button2.setTranslateY(0);
        //Setting the size of the button
        button2.setPrefSize(30, 30);
        //Setting a graphic to the button
        button2.setGraphic(nextQuestion);

        //Setting font to the text
        t1.setFont(Font.font("Gruppo", FontWeight.BOLD,
                FontPosture.REGULAR, 20));
        t1.setFill(Color.DARKORANGE);
        t1.setTextAlignment(TextAlignment.CENTER);
        BorderPane borderPane = new BorderPane();
        HBox txt = new HBox(t1);
        txt.setAlignment(Pos.CENTER);
        txt.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        txt.setMaxWidth(40);
        VBox sp = new VBox();
        sp.setAlignment(Pos.CENTER);
        txt.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: darkorange;");
        FlowPane pane = new FlowPane();
        pane.setHgap(63);
        pane.setVgap(0);
        pane.getChildren().addAll(button1, button2);
        sp.getChildren().addAll(label1, t, txt);
        BorderPane.setMargin(sp, new Insets(100, 12, 50, 12));

        borderPane.setTop(sp);
        borderPane.setBottom(pane);

//setting the background for the pane
        //creating a background image using background image class and
        //setting up the properties of the background imaged
        BackgroundImage myBI = new BackgroundImage(new Image("file:src/images/right.png", true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        borderPane.setBackground(new Background(myBI));
        Scene correctScene = new Scene(borderPane);
        openingStage.setScene(correctScene);
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();
    }

    public static void wrong(Stage openingStage, int level) {
        Button button1 = new Button();
        Button button2 = new Button();
        switch (level) {
            case 1:
                button2.setOnAction(i -> level1(openingStage));
                break;
            case 2:
                button2.setOnAction(i -> level2(openingStage));
                break;
            case 3:
                button2.setOnAction(i -> level3(openingStage));
                break;
            case 4:
                button2.setOnAction(i -> level4(openingStage));
                break;
            case 5:
                button2.setOnAction(i -> level5(openingStage));
                break;
        }
        button1.setOnAction(g -> showWelcomeScene(openingStage));
        Image l = new Image("file:src/images/wrongtxt.png");
        ImageView label = new ImageView(l);
        label.setFitHeight(120);
        label.setPreserveRatio(true);
        HBox label1 = new HBox(label);
        label1.setAlignment(Pos.CENTER);
        label1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        label1.setMaxWidth(40);

        label1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: darkorange;");
        Text t = new Text("\n\n\n\n\n\n\n\n");
        Text t2 = new Text("Your answer was wrong :(\nDo you want to try again?");
        Image img = new Image("file:src/images/no.png");
        ImageView no = new ImageView(img);
        no.setFitHeight(50);
        no.setPreserveRatio(true);
        //Creating a Button

        button1.setTranslateX(0);
        button1.setTranslateY(5);
        //Setting the size of the button
        button1.setPrefSize(60, 60);
        //Setting a graphic to the button
        button1.setGraphic(no);

        Image img1 = new Image("file:src/images/yes.png");
        ImageView yes = new ImageView(img1);
        yes.setFitHeight(50);
        yes.setPreserveRatio(true);
        //Creating a Button

        button2.setTranslateX(120);
        button2.setTranslateY(5);
        //Setting the size of the button
        button2.setPrefSize(60, 60);
        //Setting a graphic to the button
        button2.setGraphic(yes);

        //Setting font to the text
        t2.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 20));
        t2.setFill(Color.DARKORANGE);
        t2.setTextAlignment(TextAlignment.CENTER);
        BorderPane borderPane = new BorderPane();
        HBox txt = new HBox(t2);
        txt.setAlignment(Pos.CENTER);
        txt.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        txt.setMaxWidth(40);
        VBox sp = new VBox();
        sp.setAlignment(Pos.CENTER);
        txt.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: darkorange;");
        FlowPane pane = new FlowPane();
        pane.setHgap(63);
        pane.setVgap(0);
        pane.getChildren().addAll(button1, button2);
        sp.getChildren().addAll(label1, t, txt);
        BorderPane.setMargin(sp, new Insets(100, 12, 50, 12));

        borderPane.setTop(sp);
        borderPane.setBottom(pane);

        //setting the background for the pane
        //creating a background image using background image class and
        //setting up the properties of the background image
        BackgroundImage myBI = new BackgroundImage(new Image("file:src/images/wrongbackground.png", true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        borderPane.setBackground(new Background(myBI));
        Scene wrongScene = new Scene(borderPane);
        openingStage.setScene(wrongScene);
        openingStage.setMaximized(true);
        openingStage.setMinWidth(700);
        openingStage.setMinHeight(700);
        openingStage.setFullScreen(true);
        openingStage.show();
    }
}
