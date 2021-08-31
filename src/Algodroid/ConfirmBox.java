package Algodroid;


import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox //gets displayed when the user clicks on exit button or close button
{
    private static boolean answer;

    public ConfirmBox()
    {
        //making a new window for the dialogue box
        Stage window = new Stage();

        //setting the modality so that user cannot interact with the background window until this one closes
        window.initModality(Modality.APPLICATION_MODAL);

        //adding an icon for the title bar to the stage
        Image image = new Image("images/icon.png");
        window.getIcons().add(image);

        //setting the title of the window from the parameter passed
        window.setTitle("EXIT");

        //setting the height and width of the window
        window.setMinWidth(300);
        window.setMinHeight(200);

        //making labels and buttons for user interaction
        Label label1 = new Label("Are you sure you want to Exit?");

        //selection buttons
        Button yes = new Button("Yes");
        Button no = new Button("No");

        //Button returns true on yes which then closes all the windows
        yes.setOnAction(e ->
        {
            answer = true;
            window.close();
        });
        //Button returns false which closes this dialogue box but keeps all other windows open
        no.setOnAction(e ->
        {
            answer = false;
            window.close();
        });

        //making a vbox to vertically align all the children elements on the scene
        VBox layout = new VBox(5);
        layout.getChildren().addAll(label1, yes, no);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(ConfirmBox.class.getResource("/css/smallbox.css").toExternalForm());//adding stylesheet to the scene
        window.setScene(scene);
        window.showAndWait();

    }

    public boolean getconfirmation()
    {
        return answer;
    }

}
