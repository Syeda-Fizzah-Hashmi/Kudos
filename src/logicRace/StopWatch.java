package logicRace;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class StopWatch {
    private HBox Timer;
    private Label text;
    private Timeline timeline;
    private int mins = 0, secs = 0, milsec = 0;
    public void change(Label text){
        if (milsec == 1000){
            secs++;
            milsec = 0;
        }
        if (secs == 60){
            mins++;
            secs = 0;
        }
        text.setText((((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs + ":"
                + (((milsec/10) == 0) ? "00" : (((milsec/100) == 0) ? "0" : "")) + milsec++);
    }
    public StopWatch(AnchorPane pane, Font font, LinearGradient color){
        text = new Label("00:00:000");
        text.setTextFill(color);
        text.setFont(font);
        timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                change(text);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        text.toFront();
        text.setLayoutX(1030);
        text.setLayoutY(180);
        timeline.play();
    }
    public Label getTime(){
        return text;
    }
    public void pause(){
        timeline.pause();
    }
    public void setLayoutTime(double x, double y){
        text.setLayoutX(x);
        text.setLayoutY(y);
    }
}
