package sample;


import MainGame.MainUser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class BSTGUI extends Application  {

    User currentUser = new User();
    MainUser user = MainUser.getInstance();

   // static Stage openingStage=new Stage();
   // @Override
    public void start(Stage openingStage) {
        showOpeningStage(openingStage     );
    }

    public void showOpeningStage(Stage openingStage) {

        StackPane imagePane = new StackPane();

        Image whatIsBST = new Image("/images/what_is_BST.png");
        ImageView imageView1 = new ImageView(whatIsBST);
        imageView1.setFitHeight(800);
        imageView1.setFitWidth(1440);

        ImageView nextButtonImageView = new ImageView(new Image("/images/next_button.jpg"));
        nextButtonImageView.setFitWidth(100);
        nextButtonImageView.setFitHeight(35);

        Button nextButton = new Button("", nextButtonImageView);
        nextButton.setStyle("-fx-background-color: transparent");
        nextButton.setTranslateY(-310);
        nextButton.setTranslateX(500);

        imagePane.getChildren().addAll(imageView1, nextButton);

        Scene image1Scene = new Scene(imagePane/*, 1435, 700*/);

        openingStage.setScene(image1Scene);

        Image MainIcon = new Image("/images/MainIcon.png");
        openingStage.getIcons().add(MainIcon);
        openingStage.setTitle("Binary Search Tree");
        openingStage.setMaximized(true);
        openingStage.setFullScreen(true);
        openingStage.setFullScreenExitHint("");
        openingStage.show();

        nextButton.setOnAction((ActionEvent e) -> showBSTRulesScene(openingStage));
    }

    //@Override
    public void showBSTRulesScene(Stage openingStage) {

        StackPane imagePane = new StackPane();

        ImageView imageView3 = new ImageView(new Image("/images/bst_rules.png"));
        imageView3.setFitHeight(800);
        imageView3.setFitWidth(1440);

        ImageView nextButtonImageView = new ImageView(new Image("/images/next_button.jpg"));
        nextButtonImageView.setFitWidth(100);
        nextButtonImageView.setFitHeight(35);

        Button nextButton = new Button("", nextButtonImageView);
        nextButton.setStyle("-fx-background-color: transparent");
        nextButton.setTranslateY(-310);///-280;
        nextButton.setTranslateX(500);

        ImageView backButtonImageView = new ImageView(new Image("/images/backimage.png"));
        backButtonImageView.setFitWidth(100);
        backButtonImageView.setFitHeight(35);

        Button backButton = new Button("", backButtonImageView);
        backButton.setStyle("-fx-background-color: transparent");
        backButton.setTranslateY(-310);///-280;
        backButton.setTranslateX(380);

        imagePane.getChildren().addAll(imageView3,backButton,nextButton);

        Scene image3Scene = new Scene(imagePane/*, 1435, 700*/);

        openingStage.setScene(image3Scene);
        openingStage.setFullScreen(true);
        openingStage.setFullScreenExitHint("");

        nextButton.setOnAction((ActionEvent e) -> showNowImageScene(openingStage));

        backButton.setOnAction((ActionEvent e) -> {
            showOpeningStage(openingStage);
        });

    }

    //@Override
    public void showNowImageScene(Stage openingStage) {
        StackPane imagePane = new StackPane();

        ImageView imageView2 = new ImageView(new Image("/images/now.png"));
        imageView2.setFitHeight(800);
        imageView2.setFitWidth(1440);

        ImageView nextButtonImageView = new ImageView(new Image("/images/next_button.jpg"));
        nextButtonImageView.setFitWidth(100);
        nextButtonImageView.setFitHeight(35);

        Button nextButton = new Button("", nextButtonImageView);
        nextButton.setStyle("-fx-background-color: transparent");
        nextButton.setTranslateY(-310);
        nextButton.setTranslateX(500);

        ImageView backButtonImageView = new ImageView(new Image("/images/backimage.png"));
        backButtonImageView.setFitWidth(100);
        backButtonImageView.setFitHeight(35);

        Button backButton = new Button("", backButtonImageView);
        backButton.setStyle("-fx-background-color: transparent");
        backButton.setTranslateY(-310);///-280;
        backButton.setTranslateX(380);

        imagePane.getChildren().addAll(imageView2, nextButton,backButton);

        Scene image2Scene = new Scene(imagePane/*, 1435, 700*/);

        openingStage.setScene(image2Scene);
        openingStage.setFullScreen(true);
        openingStage.setFullScreenExitHint("");

        nextButton.setOnAction((ActionEvent e) -> {
            //NameStage(openingStage);
            try {
                loadUserData(user.getUserName());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            showMainMenuStage(openingStage);
        });

        backButton.setOnAction((ActionEvent e) -> {
            showBSTRulesScene(openingStage);
        });
    }

    //@Override
    public void showUserNameStage(Stage openingStage) {


        StackPane pane = new StackPane();

        Image MainIcon = new Image("/images/MainIcon.png");
        openingStage.getIcons().add(MainIcon);
        //userNameStage.getIcons().add(new Image("/sample/images/stage_logo.png"));

        AudioClip audio=new AudioClip(this.getClass().getResource("/Audio/Revolution.mp3").toExternalForm());
        audio.play();

        ImageView lockImageView = new ImageView(new Image("/images/Login.jpg"));
        lockImageView.setFitHeight(800);
        lockImageView.setFitWidth(1435);

        TextField userNameTextField = new TextField();
        userNameTextField.setAlignment(Pos.BASELINE_LEFT);
        userNameTextField.setMaxWidth(200);

        Label userNameLabel = new Label("Enter Name");
        userNameLabel.setTranslateY(-30);
        userNameLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        userNameLabel.setTextFill(Color.web("#FFFFFF"));

        pane.getChildren().addAll(lockImageView, userNameLabel, userNameTextField);

        Scene scene = new Scene(pane/*, 1435, 700*/);

        openingStage.setTitle("User Login/Signup");
        openingStage.setScene(scene);
        openingStage.setFullScreen(true);
        openingStage.setFullScreenExitHint("");
        openingStage.show();

        userNameTextField.setOnAction((ActionEvent e) -> {
            String name = userNameTextField.getText();
            try {
                loadUserData(name);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            showMainMenuStage(openingStage);

        });
    }

    //@Override
    public void loadUserData(String name) throws IOException, ClassNotFoundException {
        currentUser.setUserName(user.getUserName());
        if ((new File("userData.ser")).length() == 0) {
            currentUser.setUserName(name);
            currentUser.setScore(0);
            user.setBST_score(0);
        }
        else {
            ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("userData.ser")));

            ArrayList<User> userList = new ArrayList<>();

            userList = (ArrayList<User>) readFile.readObject();

            for (int i = 0; i < userList.size(); i++) {

                if (userList.get(i).getUserName() != null) {
                    if (userList.get(i).getUserName().equals(name)) {
                        currentUser.setScore(userList.get(i).getScore());
                        break;
                    }
                    currentUser.setUserName(name);
                    currentUser.setScore(0);

                }
            }
            readFile.close();
        }
    }

    //@Override
    public void showMainMenuStage(Stage openingStage) {

        openingStage.getIcons().add(new Image("/images/MainIcon.png"));

        StackPane pane1 = new StackPane();

        ImageView imageView = new ImageView(new Image("/images/Levels.jpg"));
        imageView.setFitHeight(800);
        imageView.setFitWidth(1440);

        pane1.getChildren().add(imageView);

        ImageView btNewGameImageView = new ImageView(new Image("/images/play_button.png"));
        btNewGameImageView.setFitWidth(120);
        btNewGameImageView.setFitHeight(40);

        ImageView btExitImageView = new ImageView(new Image("/images/exit_button.png"));
        btExitImageView.setFitWidth(120);
        btExitImageView.setFitHeight(40);

        Button btNewGame = new Button("", btNewGameImageView);
        btNewGame.setStyle("-fx-background-color: transparent");
        btNewGame.setTranslateY(-30);

        Button btExit = new Button("", btExitImageView);
        btExit.setStyle("-fx-background-color: transparent");
        btExit.setTranslateY(30);

        pane1.getChildren().addAll(btNewGame, btExit);

        Scene scene1 = new Scene(pane1, 1435, 700);

        openingStage.setTitle("Binary Search Tree");
        openingStage.setScene(scene1);
        openingStage.setFullScreen(true);
        openingStage.setFullScreenExitHint("");
        openingStage.show();

        btNewGame.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showNewGameStage(openingStage);
        });

        btExit.setOnAction((ActionEvent e) -> {
            try {
                exitGameHandles(openingStage, new WindowEvent(openingStage,WindowEvent.WINDOW_CLOSE_REQUEST) );
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        openingStage.setOnCloseRequest((WindowEvent e) -> {
            try {
                exitGameHandles(openingStage , e);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
    }

    //@Override
    public void showNewGameStage(Stage openingStage) {

        openingStage.getIcons().add(new Image("/images/MainIcon.png"));

        StackPane stPane = new StackPane();

        ImageView imageView = new ImageView(new Image("/images/Levels.jpg"));
        imageView.setFitHeight(800);
        imageView.setFitWidth(1440);

        stPane.getChildren().add(imageView);

        ImageView btLevel1Iv = new ImageView(new Image("/images/level_1.jpg"));
        btLevel1Iv.setFitWidth(120);
        btLevel1Iv.setFitHeight(30);
        Button btLevel1 = new Button("", btLevel1Iv);
        btLevel1.setStyle("-fx-background-color: transparent");

        ImageView btLevel2Iv = new ImageView(new Image("/images/level_2.jpg"));
        btLevel2Iv.setFitWidth(120);
        btLevel2Iv.setFitHeight(30);
        Button btLevel2 = new Button("", btLevel2Iv);
        btLevel2.setStyle("-fx-background-color: transparent");

        ImageView btLevel3Iv = new ImageView(new Image("/images/level_3.jpg"));
        btLevel3Iv.setFitWidth(120);
        btLevel3Iv.setFitHeight(30);
        Button btLevel3 = new Button("", btLevel3Iv);
        btLevel3.setStyle("-fx-background-color: transparent");

        ImageView btlevel4iv = new ImageView(new Image("/images/level_4.jpg"));
        btlevel4iv.setFitWidth(120);
        btlevel4iv.setFitHeight(30);
        Button btLevel4 = new Button("", btlevel4iv);
        btLevel4.setStyle("-fx-background-color: transparent");

        ImageView btlevel5iv = new ImageView(new Image("/images/level_5.jpg"));
        btlevel5iv.setFitWidth(120);
        btlevel5iv.setFitHeight(30);
        Button btLevel5 = new Button("", btlevel5iv);
        btLevel5.setStyle("-fx-background-color: transparent");

        ImageView btlevel6iv = new ImageView(new Image("/images/level_6.jpg"));
        btlevel6iv.setFitWidth(120);
        btlevel6iv.setFitHeight(30);
        Button btLevel6 = new Button("", btlevel6iv);
        btLevel6.setStyle("-fx-background-color: transparent");

        ImageView btlevel7iv = new ImageView(new Image("/images/level_7.jpg"));
        btlevel7iv.setFitWidth(120);
        btlevel7iv.setFitHeight(30);
        Button btLevel7 = new Button("", btlevel7iv);
        btLevel7.setStyle("-fx-background-color: transparent");

        ImageView btlevel8iv = new ImageView(new Image("/images/level_8.jpg"));
        btlevel8iv.setFitWidth(120);
        btlevel8iv.setFitHeight(30);
        Button btLevel8 = new Button("", btlevel8iv);
        btLevel8.setStyle("-fx-background-color: transparent");

        ImageView backButtonImageView = new ImageView(new Image("/images/backimage.png"));
        backButtonImageView.setFitWidth(100);
        backButtonImageView.setFitHeight(35);

        Button backButton = new Button("", backButtonImageView);
        backButton.setStyle("-fx-background-color: transparent");
        backButton.setTranslateY(250);///-280;
        backButtonImageView.setFitWidth(120);
        backButtonImageView.setFitHeight(30);
        //backButton.setTranslateX(400);

        btLevel1.setTranslateY(-150);
        btLevel2.setTranslateY(-100);
        btLevel3.setTranslateY(-50);
        btLevel4.setTranslateY(0);
        btLevel5.setTranslateY(50);
        btLevel6.setTranslateY(100);
        btLevel7.setTranslateY(150);
        btLevel8.setTranslateY(200);

        stPane.getChildren().addAll(btLevel1, btLevel2, btLevel3, btLevel4,btLevel5, btLevel6, btLevel7, btLevel8,backButton);

        if (currentUser.getScore() < 140)
            btLevel8.setDisable(true);
        if (currentUser.getScore() < 120)
            btLevel7.setDisable(true);
        if (currentUser.getScore() < 100)
            btLevel6.setDisable(true);
        if (currentUser.getScore() < 80)
            btLevel5.setDisable(true);
        if (currentUser.getScore() < 60)
            btLevel4.setDisable(true);
        if (currentUser.getScore() < 40)
            btLevel3.setDisable(true);
        if (currentUser.getScore() < 20)
            btLevel2.setDisable(true);

        openingStage.setOnCloseRequest((WindowEvent e) -> {
                    e.consume();
                    showMainMenuStage(openingStage);
                });
        Scene newGameScene = new Scene(stPane,1435,700);

        openingStage.setTitle("Levels");
        openingStage.setScene(newGameScene);
        openingStage.setFullScreen(true);
        openingStage.setFullScreenExitHint("");
        openingStage.show();

        btLevel1.setOnAction((ActionEvent e) -> {
           // openingStage.close();
            showLevelStage(1,openingStage);
        });

        btLevel2.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showLevelStage(2,openingStage);
        });

        btLevel3.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showLevelStage(3,openingStage);
        });

        btLevel4.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showLevelStage(4,openingStage);
        });

        btLevel5.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showLevelStage(5,openingStage);
        });

        btLevel6.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showLevelStage(6,openingStage);
        });

        btLevel7.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showLevelStage(7,openingStage);
        });

        btLevel8.setOnAction((ActionEvent e) -> {
           // openingStage.close();
            showLevelStage(8,openingStage);
        });
        backButton.setOnAction((ActionEvent e) -> {
            showMainMenuStage(openingStage);
        });
    }

    //@Override
    public void showLevelStage(int levelNumber, Stage openingStage) {

//        Stage levelStage = new Stage();
//        levelStage.setResizable(false);
        openingStage.getIcons().add(new Image("/images/stage_logo.png"));

        NumberGenerator numberGenerator = new NumberGenerator(levelNumber);

        BST tree = new BST();

        BorderPane pane = new BorderPane();

        ImageView imageView = new ImageView(new Image("/images/gradientTree.jpg"));
        imageView.setFitHeight(800);
        imageView.setFitWidth(1440);

        pane.getChildren().add(imageView);

        BTView view = new BTView(tree);

        pane.setCenter(view);

        /*Text options = new Text("Options: " + (numberGenerator.numberArray[3] + 20) + " " + (numberGenerator.numberArray[3] + 11) +
                " " + numberGenerator.numberArray[3] + " " + (numberGenerator.numberArray[3] + 27));
        options.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));*/

        TextField textField = new TextField();
        textField.setPrefColumnCount(5);
        textField.setAlignment(Pos.BASELINE_RIGHT);
        ImageView backButtonImageView = new ImageView(new Image("/images/backimage.png"));
        backButtonImageView.setFitWidth(80);
        backButtonImageView.setFitHeight(25);


        Button backButton = new Button("", backButtonImageView);
        backButton.setStyle("-fx-background-color: transparent");
        //backButton.setTranslateY(-510);///-280;
        //backButton.setTranslateX(300);



        HBox hBox = new HBox(5);

        Label textFieldLabel = new Label("Enter The Missing Number: ");
        textFieldLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        textFieldLabel.setTextFill(Color.web("#FFFFFF"));

        hBox.getChildren().addAll(textFieldLabel, textField,backButton);
        hBox.setAlignment(Pos.CENTER);



        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox);
        vBox.setAlignment(Pos.CENTER);

        pane.setBottom(vBox);

        //levelStage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(pane, 1435, 690);

        openingStage.setTitle("Game");
        openingStage.setScene(scene);
        openingStage.setFullScreen(true);
        openingStage.setFullScreenExitHint("");
        openingStage.show();

        for (int i = 0; i < numberGenerator.numberArray.length; i++) {
            int key = numberGenerator.numberArray[i];
            if (tree.search(key)) {
                view.displayTree();
            }
            else {
                tree.insert(key, i);
                view.displayTree();
            }

            try {
               Thread.sleep(500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            //delay 10ms
        }

        textField.setOnAction(e -> {
            int num = Integer.parseInt(textField.getText());

            TreeNode root = tree.getRoot();
            TreeNode missingNode= tree.missingNode;
            TreeNode parent= tree.missingNode.parent;
            TreeNode left= tree.missingNode.left;
            TreeNode right= tree.missingNode.right;

            boolean alreadyExist=false;

            for (int n: numberGenerator.numberArray){
                if (n == num)
                    alreadyExist=true;
            }

            boolean correctPosition=false;

            if (((parent.element< root.element) && (num< root.element))||((parent.element> root.element) && (num> root.element)))
                correctPosition=true;

            if (parent.left!=null?missingNode.element== parent.left.element:false){
                boolean isLessThanParent = parent!=null?num<parent.element:true;
                boolean isGreaterThanLeft= left!=null?num>left.element:true;
                boolean isLessThanRight= right!=null?num<right.element:true;

                if (correctPosition && (isLessThanRight && isGreaterThanLeft && isLessThanParent) || (num== tree.missingNode.element) && !alreadyExist){
                    showCongoMessageStage(levelNumber,openingStage);
                    //openingStage.close();
                }else
                    showTryAgainStage(openingStage,levelNumber);
            }else if (parent.right != null && missingNode.element == parent.right.element){
                boolean isGreaterThanParent = parent == null || num > parent.element;
                boolean isGreaterThanLeft= left!=null?num>left.element:true;
                boolean isLessThanRight= right!=null?num<right.element:true;

                if (correctPosition && (isLessThanRight && isGreaterThanLeft && isGreaterThanParent)||(num==tree.missingNode.element)&& !alreadyExist){
                    showCongoMessageStage(levelNumber,openingStage);
                   // openingStage.close();
                }else
                    showTryAgainStage(openingStage,levelNumber);
            }
        });
        openingStage.setOnCloseRequest((WindowEvent e) -> {
            e.consume();
            showNewGameStage(openingStage);

        });
    }

    //@Override
    public void showCongoMessageStage(int levelNumber, Stage openingStage) {

        if (levelNumber == 1 && currentUser.getScore() == 0)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 2 && currentUser.getScore() == 20)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 3 && currentUser.getScore() == 40)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 4 && currentUser.getScore() == 60)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 5 && currentUser.getScore() == 80)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 6 && currentUser.getScore() == 100)
            currentUser.setScore(currentUser.getScore() + 20);
        if (levelNumber == 7 && currentUser.getScore() == 120)
            currentUser.setScore(currentUser.getScore() + 20);

//        Stage congoStage = new Stage();
//        congoStage.setResizable(false);

        openingStage.getIcons().add(new Image("/images/stage_logo.png"));
        StackPane congoPane = new StackPane();

        //congoStage.initModality(Modality.APPLICATION_MODAL);

        ImageView congoImageView = new ImageView(new Image("/images/congo_image.jpg"));
        congoImageView.setFitHeight(720);
        congoImageView.setFitWidth(1440);

        Button btOk = new Button("OK");
        //btOk.setTranslateX(180);
        //btOk.setTranslateY(63);
        btOk.setMinWidth(80);
        btOk.setMinHeight(25);

        VBox vbox=new VBox();
        vbox.getChildren().addAll(btOk);
        vbox.setTranslateX(1200);
        vbox.setTranslateY(700);

        congoPane.getChildren().addAll(congoImageView, vbox);

        Scene congoScene = new Scene(congoPane, 1440, 720);
        openingStage.setTitle("Level Completed :-)");
        openingStage.setScene(congoScene);
        openingStage.setFullScreen(true);
        openingStage.setMaximized(true);
        openingStage.show();

        btOk.setOnAction((ActionEvent e) -> {
            //openingStage.close();
            showNewGameStage(openingStage);
        });
    }

    //@Override
    public void showTryAgainStage(Stage openingStage, int levelNumber) {
        StackPane tryAgainPane = new StackPane();

        ImageView tryAgainImageView = new ImageView(new Image("/images/try_again_image.jpg"));
        tryAgainImageView.setFitHeight(720);
        tryAgainImageView.setFitWidth(1440);

        Button btOk = new Button("OK");
        btOk.setMinWidth(80);
        btOk.setMinHeight(25);

        VBox vbox=new VBox();
        vbox.getChildren().addAll(btOk);
        vbox.setTranslateX(1200);
        vbox.setTranslateY(700);

        tryAgainPane.getChildren().addAll(tryAgainImageView, vbox);
        Scene tryAgainScene = new Scene(tryAgainPane);
        openingStage.setTitle("Level Failed :-(");
        openingStage.setScene(tryAgainScene);
        openingStage.setFullScreen(true);
        openingStage.setMaximized(true);
        openingStage.show();

        btOk.setOnAction((ActionEvent e) -> showLevelStage(levelNumber,openingStage));
    }

    //@Override
    public void exitGameHandles(Stage mainMenuStage, WindowEvent e ) throws IOException, ClassNotFoundException {
        // Create a Yes Button for the Alert
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        // Create a No Button for the Alert
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        // Create the Alert
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION, "", yes, no);
        // Set the Alert Title
        confirmationAlert.setTitle("Confirmation");
        // Set the Text to display to Alert Header
        confirmationAlert.setHeaderText("Are you sure you want to quit?");
        // Get the Yes or No Action Result in this Object
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        // If the result is yes
        if (result.get() == yes) {
            // Create an ArrayList of Users
            ArrayList<User> userList = new ArrayList<>();
            // If file is Empty
            if ((new File("userData.ser")).length() == 0) {
                // Add the User to the List

                userList.add(currentUser);
                ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("userData.ser")));
                // Write the List to the File
                writeFile.writeObject(userList);
                // Close the File
                writeFile.close();
            }
            // If file is not Empty
            else {
                // Create a Object Input Stream to read objects stored in the file
                ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("userData.ser")));
                // Cast the read object to Array list of Users and assign to userList
                userList = (ArrayList<User>) readFile.readObject();
                // Declared a variable to use as a flag
                int flag = 0;
                // Loop to Iterates through the list of Objects
                for (int i = 0; i < userList.size(); i++) {
                    // If the current User name is same as the name of read Objects
                    if (currentUser.getUserName().equals(userList.get(i).getUserName())) {
                        // Update Score of User
                        userList.get(i).setScore(currentUser.getScore());
                        // Write the object to the file
                        ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("userData.ser")));
                        writeFile.writeObject(userList);
                        // Close the file
                        writeFile.close();
                        // Set Flag to 1
                        flag = 1;
                        break;
                    }
                }
                // If Flag is not 1
                if (flag != 1) {
                    // Add the user to Array List of Users
                    ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("userData.ser")));
                    userList.add(currentUser);
                    // Write the userList to the File
                    writeFile.writeObject(userList);
                    // Close the File
                    writeFile.close();
                }
                // Close the file
                readFile.close();
            }
            // Close the Main Menu Stage
            new MainGame.Main().MainGamestage(mainMenuStage);
            //mainMenuStage.close();
        }else {
            e.consume();
            confirmationAlert.close();
            showMainMenuStage(mainMenuStage);
        }
    }
}
