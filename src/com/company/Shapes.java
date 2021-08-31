package com.company;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Shapes {
    public Polygon polygon(Color fillColor, Color strokeColor) {
        Polygon polygon = new Polygon();
        polygon.setFill(fillColor);
        polygon.setStroke(strokeColor);
        polygon.getPoints().addAll(0.0, 20.0,
                25.0, 20.0,
                20.0, 0.0);
        polygon.setStrokeWidth(3.0);
        return polygon;
    }

    public Rectangle rectangle(Color fillColor, Color strokeColor) {
        Rectangle rectangle = new Rectangle(20, 20, 20, 20);
        rectangle.setFill(fillColor);
        rectangle.setStroke(strokeColor);
        return rectangle;

    }

    public Circle circle(Color fillColor, Color strokeColor) {
        Circle circle = new Circle();
        //Setting the properties of the circle
        circle.setFill(fillColor);
        circle.setStroke(strokeColor);
        circle.setCenterX(20);
        circle.setCenterY(13);
        circle.setRadius(10);

        //Setting other properties
        circle.setStrokeWidth(3.0);
        return circle;
    }
}
