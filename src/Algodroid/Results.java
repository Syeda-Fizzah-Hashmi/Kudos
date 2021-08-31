package Algodroid;

import MainGame.MainUser;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.User;

import java.io.*;
import java.util.ArrayList;

public class Results
{   MainGame.MainUser user = MainGame.MainUser.getInstance();
    public Results(int score)
    {
        AudioClip gameover = new AudioClip(new File("src\\css\\gameover.mp3").toURI().toString());
        gameover.play();
        //making a new stage to display score
        Stage window = new Stage();
        //setting the modality so that user cannot interact with the background window until this one closes
        window.initModality(Modality.APPLICATION_MODAL);

        //adding an icon for the title bar to the stage
        Image image = new Image("images/icon.png");
        window.getIcons().add(image);

        //setting title of the window as results
        window.setTitle("Results");

        //setting height and width of the window
        window.setMinWidth(300);
        window.setMinHeight(175);

        //passing the parameter to a local variable
        int holder = score;

        //making a label to display the score on the scene
        String score_string = (" " + holder);
        Label label1 = new Label("You have successfully completed the Level!");
        Label label2 = new Label("With a score of" + score_string);

        //BUTTON
        Button ok = new Button("OK");

        //Closing window on click of button
        ok.setOnAction(e ->
        {   System.out.println(score);
            try {
            ArrayList<MainGame.MainUser> userList = new ArrayList<>();
            // If file is Empty
            if ((new File("AlgodroidData.ser")).length() == 0) {
                // Add the User to the List
                user.setAlgo_score(score);
                userList.add(user);
                    ObjectOutputStream writeFile;
                    writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("AlgodroidData.ser")));
                    // Write the List to the File
                    writeFile.writeObject(userList);
                    // Close the File
                    writeFile.close();
            }
            // If file is not Empty
            else {
                // Create a Object Input Stream to read objects stored in the file
                ObjectInputStream readFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("AlgodroidData.ser")));
                // Cast the read object to Array list of Users and assign to userList
                userList = (ArrayList<MainUser>) readFile.readObject();
                // Declared a variable to use as a flag
                int flag = 0;
                // Loop to Iterates through the list of Objects
                for (int i = 0; i < userList.size(); i++) {
                    // If the current User name is same as the name of read Objects
                    if (user.getUserName().equals(userList.get(i).getUserName())) {
                        // Update Score of User
                        userList.get(i).setAlgo_score(score);
                        // Write the object to the file
                        ObjectOutputStream writeFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("AlgodroidData.ser")));
                        writeFile.writeObject(userList);
                        writeFile.close();

                        // Set Flag to 1
                        flag = 1;
                        break;
                    }
                }
                // Close the file
                readFile.close();
            }

            window.close();
            }
            catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        });
        //setting spacing in the layout of vertical box
        VBox layout = new VBox(5);
        layout.getChildren().addAll(label1,label2,ok);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(ConfirmBox.class.getResource("/css/smallbox.css").toExternalForm());//adding style sheet to the scene
        window.setScene(scene);
        window.showAndWait();
        window.setFullScreenExitHint("");
        window.setFullScreen(true);

    }

}
