package com.example.facecreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondHead extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SecondHead.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Mayor");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawPrimitiveFace();

        stage.show();
    }

    public static void drawPrimitiveFace() {
        drawShape();
        drawMouth(50);
        drawEyes();
        etc();
    }

    public static void drawShape() {
        gc.strokeOval(150, 150, 300, 300);
    }

    public static void drawMouth(int mouthSize) {
        gc.setFill(Color.BLACK);
        //gc.fillOval(280,370,mouthSize,mouthSize);


        gc.setLineWidth(2);
        gc.strokeLine(220,360,400,360);

    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        gc.fillOval(200,220,40,40);
        gc.fillOval(360,220,40,40);

        gc.strokeOval(190,210,60,60);
        gc.strokeOval(350,210,60,60);

        gc.strokeLine(270,250,290,330);
        gc.strokeLine(290,330,330,250);
    }

    public static void etc() {

        gc.fillRect(180,100,250,70);
        gc.fillRect(250,0,100,150);
    }
    public static void main(String[] args) {
        launch();
    }
}