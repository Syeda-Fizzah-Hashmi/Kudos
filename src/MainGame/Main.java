package MainGame;
/*
Integration steps
====================
=> execute the new game separately (debug)
=> create new package
=> place code source files
=> place images to the src/images folder 
=> similarly audio and videos to their respective folders 
 ++ do it by drag drop inside intellij so refactoring is performed automatically
=> update gui (MainGame.Main) and call new game in callback of button
=> update MainUser class update properties
=> implement function to write scores to .ser file
=> update ScoreBoard.java to read and display scores

====================
Run Configuration:
=> Add new game package under the section "Packages and classes coverage"
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


public class Main extends Application {
    MainUser user = MainUser.getInstance();
    AudioClip audio;
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double height = screenBounds.getHeight();
    double width = screenBounds.getWidth();

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    Scene scene1, scene2;

    public Main() {
        audio = new AudioClip(this.getClass().getResource("/Audio/Vicetone.mp3").toExternalForm());
        audio.setCycleCount(AudioClip.INDEFINITE);
        audio.play();
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        showTitleStage();
    }

    public void showTitleStage() {
        Stage titleStage = new Stage();
        Image image = new Image("style/images/title.png");

        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        imageView.setFitWidth((Screen.getPrimary().getVisualBounds().getWidth()) / 3);
        imageView.setFitHeight((Screen.getPrimary().getVisualBounds().getHeight()) / 4);

        VBox imageholder = new VBox();
        imageholder.getChildren().addAll(imageView);
        imageholder.setAlignment(Pos.CENTER);
        imageholder.setId("bg");
        imageholder.setPadding(new Insets(50, 10, 10, 10));

        AtomicInteger counter = new AtomicInteger();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3.7), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showUserNameStage(titleStage);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
        Scene imgScene = new Scene(imageholder, width, height);
        imgScene.getStylesheets().add("style/style.css");
        titleStage.setScene(imgScene);
        titleStage.setMaximized(true);
        titleStage.show();

    }

    public void showUserNameStage(Stage userNameStage) {
        StackPane pane = new StackPane();

        Image MainIcon = new Image("/images/MainIcon.png");
        userNameStage.getIcons().add(MainIcon);

        ImageView lockImageView = new ImageView(new Image("style/images/name.gif"));
        lockImageView.setFitHeight(height + 300);
        lockImageView.setFitWidth(width);

        TextField userNameTextField = new TextField();
        userNameTextField.setPromptText("Name...");
        userNameTextField.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        userNameTextField.setAlignment(Pos.BASELINE_LEFT);
        userNameTextField.setMaxWidth(300);
        userNameTextField.setMaxHeight(70);
        userNameTextField.setTranslateY(150);
        userNameTextField.setTranslateX(-41);

        pane.getChildren().addAll(lockImageView, userNameTextField);
        pane.setId("linear-grad-to-bottom");

        Scene scene = new Scene(pane, width, height);
        scene.getStylesheets().add("style/style.css");
        userNameStage.setTitle("Gamer's Name ...");
        userNameStage.setScene(scene);
        userNameStage.setMaximized(true);
        userNameStage.show();

        userNameTextField.setOnAction((ActionEvent e) -> {
            String name = userNameTextField.getText();
            try {
                Boolean outcome;
                // if file is not empty check if name already taken?
                if ((new File("UserList.ser")).length() == 0)
                {
                    // 1) set user name
                    user.setUserName(name);
                    // 2) add user to userList.txt
                    ArrayList<MainUser> userList = new ArrayList<>();
                    userList.add(user);
                    ObjectOutputStream writeFile;
                    writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("UserList.ser")));
                    writeFile.writeObject(userList);
                    writeFile.close();
                    // 3) show next screen to user
                    MainGamestage(userNameStage);
                }else{
                    outcome = checkUser(userNameStage, user, name);
                    if (outcome == true) {
                        user.setUserName(name);
                        MainGamestage(userNameStage);
                    }
                    if (outcome == false){
                        showUserNameStage(userNameStage);
                    }
                }


            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
    }

    public void MainGamestage(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX GUI");

        Image image = new Image("style/images/title.png");
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        imageView.setFitWidth((Screen.getPrimary().getVisualBounds().getWidth()) / 3);
        imageView.setFitHeight((Screen.getPrimary().getVisualBounds().getHeight()) / 5);

        // creating user name label
        Label nameLabel = new Label("Welcome " + user.getUserName());
        nameLabel.setId("label");
        nameLabel.setFont(Font.font("monospace", FontWeight.findByWeight(2), 70));

        VBox imageholder = new VBox();
        imageholder.getChildren().addAll(imageView, nameLabel);
        imageholder.setAlignment(Pos.CENTER);
        imageholder.setPadding(new Insets(30, 10, 0, 10));
        imageholder.setStyle("-fx-background-color:rgb(94, 50, 101, 0.4);");

        ImageView owlImage = new ImageView(new Image("style/images/owl2.gif"));
        owlImage.setFitWidth(width / 5);
        owlImage.setFitHeight(height / 3);
        //Game Tabs
        Button btn1 = new Button("Binary Search Trees");
        Button btn2 = new Button("Algodroid");
        Button btn3 = new Button("Cipher it!");
        Button btn4 = new Button("Logic Race");
        Button btn5 = new Button("Space Router");
        Button btn6 = new Button("Score Board");
        Button btn7 = new Button("Exit");

        //Handlers
        //---------------------------------------------------
        btn1.setOnAction(e -> {
            audio.stop();
            sample.BSTGUI BSTGUI = new sample.BSTGUI();
            BSTGUI.showOpeningStage(primaryStage);
        });
        btn2.setOnAction(e -> {
            audio.stop();
            new Algodroid.MainMenu();
        });
        btn3.setOnAction(e -> {
            audio.stop();
            new CipherIt.GUI();
        });
        btn4.setOnAction(e -> {
            audio.stop();
            new logicRace.MainMenu();
        });
        btn5.setOnAction(e -> {
            audio.stop();
            try {
                SpaceRouter.Menu spaceRouter = new SpaceRouter.Menu();
                spaceRouter.MainMenu();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn6.setOnAction(e -> {
            audio.stop();
            ScoreBoard sb = new ScoreBoard(user);
            try {
                sb.scoreBoardStage(primaryStage);
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        });
        btn7.setOnAction(e -> {
            audio.stop();
            primaryStage.close();
        });

        //Display Controls
        btn6.setId("green-button-style");
        //Games Buttons
        VBox btnHolders = new VBox();
        btnHolders.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        btnHolders.setAlignment(Pos.CENTER);
        btnHolders.setSpacing(2.0);
        btnHolders.setPadding(new Insets(0, 100, 10, 150));

        //Extra Buttons
        VBox RightBtnHolder = new VBox();
        RightBtnHolder.getChildren().addAll(owlImage, btn6, btn7);
        RightBtnHolder.setAlignment(Pos.CENTER);
        RightBtnHolder.setPadding(new Insets(0, 100, 0, 150));

        GridPane grid = new GridPane();
        grid.add(btnHolders, 0, 0);
        grid.add(RightBtnHolder, 1, 0);
        grid.setStyle("-fx-background-color:linear-gradient(to bottom, rgb(94, 50, 101, 0.4), rgb(12, 184, 217, 0.4));");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);
        borderPane.setTop(imageholder);
        borderPane.setId("pane");

        scene1 = new Scene(borderPane, width, height);
        scene1.getStylesheets().add("style/style.css");

        primaryStage.setScene(scene1);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    // Existing User check?
    public Boolean checkUser(Stage stage, MainUser user, String name) throws IOException, ClassNotFoundException {
        Boolean outcome = false;
        Boolean isExists = false;
        // 1) read the file
        ArrayList<MainUser> userList = new ArrayList<>();
        ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("UserList.ser")));
        userList = (ArrayList<MainUser>) readFile.readObject();
        for (int i = 0; i < userList.size(); i++) {
            // 2) if user name exists
            System.out.println(userList.get(i).getUserName());
            if (name.equals(userList.get(i).getUserName())) {
                isExists = true;
                // 3) show alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Name!!");
                alert.setHeaderText("Already Existing Name!! ");
                alert.setContentText("Continue with already existing name?");
                Optional<ButtonType> result = alert.showAndWait();
                // 4) if yes
                if (result.get() == ButtonType.OK) {
                    outcome = true;
                    return outcome;
                }
                if(result.get() == ButtonType.CANCEL){
                    outcome = false;
                    return outcome;
                }
            }
        }
        // 5) if name is not existing
        if (isExists == false) {
            System.out.println("Nameeeeeeeeeeeeee not existsssssssssssssss ");
            // 5.1) set name
            user.setUserName(name);
            // 5.2) write this name to a file
            userList.add(user);
            ObjectOutputStream writeFile;
            writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("UserList.ser")));
            writeFile.writeObject(userList);
            writeFile.close();
            // 5.3) return true
            MainGamestage(stage);
            return true;
        }
        return true;
    }
}