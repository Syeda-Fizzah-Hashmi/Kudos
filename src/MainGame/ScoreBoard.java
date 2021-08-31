package MainGame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.User;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ScoreBoard {
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double height = screenBounds.getHeight();
    double width = screenBounds.getWidth();
    MainUser user;
    AudioClip audio;

    ScoreBoard(MainUser user){
        this.user = user;
        audio = new AudioClip(this.getClass().getResource("/Audio/Inspire-ashutosh.mp3").toExternalForm());
        audio.play();
    }
    public void scoreBoardStage(Stage stage) throws IOException, ClassNotFoundException {
        Image image = new Image("style/images/title.png");
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        imageView.setFitWidth((Screen.getPrimary().getVisualBounds().getWidth())/3 );
        imageView.setFitHeight((Screen.getPrimary().getVisualBounds().getHeight())/5 );

        sample.BSTGUI bst = new sample.BSTGUI();
        loadUserData(user.getUserName());

        Label nameLabel = new Label(user.getUserName()+"'s Scores!");
        Label BSTlabel_heading = new Label("BS Tree");
        Label Algolabel_heading = new Label("Algodroid");
        Label logiclabel_heading = new Label("LogicRace");
        Label EncDeclabel_heading = new Label("Cipher it");
        Label MinSpanlabel_heading = new Label("SpaceRoute");

        Label BSTlabel = new Label(""+user.getBST_score());
        Label Algolabel = new Label(""+user.getAlgo_score());
        Label logiclabel = new Label(user.getlogicRace_time());
        Label MinSpanlabel = new Label(""+user.getSpaceRoute_score());
        Label EncDeclabel = new Label(""+user.getEncDec_score());
        Button back= new Button("⬅ Go Back");

        nameLabel.setMaxWidth(width);
        nameLabel.setAlignment(Pos.CENTER);

        BSTlabel_heading.setId("label");
        Algolabel_heading.setId("label");
        logiclabel_heading.setId("label");
        EncDeclabel_heading.setId("label");
        MinSpanlabel_heading.setId("label");

        BSTlabel_heading.setStyle("-fx-background-color: rgb(251, 3, 175 , 0.4)");
        BSTlabel.setStyle("-fx-background-color: rgb(251, 3, 175  , 0.3)");
        Algolabel_heading.setStyle("-fx-background-color: rgb(251, 3, 239  , 0.4)");
        Algolabel.setStyle("-fx-background-color: rgb(251, 3, 239 , 0.3)");
        logiclabel_heading.setStyle("-fx-background-color: rgb(197, 70, 245, 0.4)");
        logiclabel.setStyle("-fx-background-color: rgb(197, 70, 245, 0.3)");
        MinSpanlabel_heading.setStyle("-fx-background-color: rgb(3, 133, 251,0.4)");
        MinSpanlabel.setStyle("-fx-background-color: rgb(3, 133, 251, 0.3)");
        EncDeclabel_heading.setStyle("-fx-background-color: rgb(3, 47, 251 , 0.4)");
        EncDeclabel.setStyle("-fx-background-color: rgb(3, 47, 251 , 0.3)");

        VBox imageholder = new VBox();
        imageholder.getChildren().addAll(imageView, nameLabel);
        imageholder.setAlignment(Pos.CENTER);
        imageholder.setPadding(new Insets(30,10,0,10));

        GridPane gridPane = new GridPane();
        gridPane.add(BSTlabel_heading, 0, 0, 1, 1);
        gridPane.add(Algolabel_heading, 1, 0, 1, 1);
        gridPane.add(logiclabel_heading, 2, 0, 1, 1);
        gridPane.add(MinSpanlabel_heading, 3, 0, 1, 1);
        //gridPane.add(EncDeclabel_heading, 1, 3, 1, 1);


        gridPane.add(BSTlabel, 0, 1, 1, 1);
        gridPane.add(Algolabel, 1, 1, 1, 1);
        gridPane.add(logiclabel, 2, 1, 1, 1);
        gridPane.add(MinSpanlabel, 3, 1, 1, 1);
        //gridPane.add(EncDeclabel, 1, 4, 1, 1);
        gridPane.add(back, 1,3,2,4);


        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHalignment(BSTlabel_heading, HPos.CENTER);
        gridPane.setHalignment(Algolabel_heading, HPos.CENTER);
        gridPane.setHalignment(logiclabel_heading, HPos.CENTER);
        gridPane.setHalignment(EncDeclabel_heading, HPos.CENTER);
        gridPane.setHalignment(MinSpanlabel_heading, HPos.CENTER);

        gridPane.setHalignment(BSTlabel, HPos.CENTER);
        gridPane.setHalignment(Algolabel, HPos.CENTER);
        gridPane.setHalignment(logiclabel, HPos.CENTER);
        gridPane.setHalignment(EncDeclabel, HPos.CENTER);
        gridPane.setHalignment(MinSpanlabel, HPos.CENTER);

        gridPane.setHalignment(back, HPos.CENTER);

        gridPane.setId("grid");

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setTop(imageholder);
        borderPane.setId("scoreboard-background");
        Scene scoreScene= new Scene(borderPane, width, height);
        scoreScene.getStylesheets().add("style/style.css");
        stage.setScene(scoreScene);
        stage.setMaximized(true);
        stage.show();

        back.setOnAction(e -> {
            audio.stop();
            new Main().MainGamestage(stage);
        });
    }
    public void loadUserData(String name) throws IOException, ClassNotFoundException {
        //=======================================================================================
        // BST Scores
        //=======================================================================================
        if ((new File("userData.ser")).length() != 0) {
            ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("userData.ser")));
            ArrayList<User> userList = new ArrayList<>();
            userList = (ArrayList<User>) readFile.readObject();
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserName() != null) {
                    if (userList.get(i).getUserName().equals(name)) {
                        user.setBST_score(userList.get(i).getScore());
                        System.out.println("BST scores");
                        break;
                    }
                }
            }
            readFile.close();
        }
        //=======================================================================================
        // Algodroid Scores
        //=======================================================================================
        if ((new File("AlgodroidData.ser")).length() != 0) {
            ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("AlgodroidData.ser")));
            ArrayList<MainUser> userList = new ArrayList<>();
            userList = (ArrayList<MainUser>) readFile.readObject();
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserName() != null) {
                    if (userList.get(i).getUserName().equals(name)) {
                        user.setAlgo_score(userList.get(i).getAlgo_score());
                        System.out.println("Algo scores ");
                        break;
                    }
                }
            }
            readFile.close();
        }
        //=======================================================================================
        // Logic Race Scores
        //=======================================================================================
        if ((new File("LogicRaceData.ser")).length() != 0) {
            ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("LogicRaceData.ser")));
            ArrayList<MainUser> userList = new ArrayList<>();
            userList = (ArrayList<MainUser>) readFile.readObject();
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserName() != null) {
                    if (userList.get(i).getUserName().equals(name)) {
                        user.setlogicRace_time(userList.get(i).getlogicRace_time());
                        System.out.println("Logic Race scores ");
                        break;
                    }
                }
            }
            readFile.close();
        }
        //=======================================================================================
        // Space Router Scores
        //=======================================================================================
        if ((new File("SpaceRouterData.ser")).length() != 0) {
            ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("SpaceRouterData.ser")));
            ArrayList<MainUser> userList = new ArrayList<>();
            userList = (ArrayList<MainUser>) readFile.readObject();
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserName() != null) {
                    if (userList.get(i).getUserName().equals(name)) {
                        user.setSpaceRoute_score(userList.get(i).getSpaceRoute_score());
                        System.out.println("Space Router Score extracted");
                        break;
                    }
                }
            }
            readFile.close();
        }

        //=======================================================================================
        // Encrypt Decrypt Scores
        //=======================================================================================
        /* Copy paste above if block and update file name and getter function*/
    }

}
