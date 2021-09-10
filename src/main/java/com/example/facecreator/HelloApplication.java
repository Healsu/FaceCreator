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

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloOpgave.class.getResource("hello-view.fxml"));


        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Kirby with face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);
        gc.setFill(Color.PINK);
        gc.fillOval(190, 150, 300, 300);
        gc.setFill(Color.RED);
        gc.fillOval(390, 400, 200, 100);
        gc.setFill(Color.RED);
        gc.fillOval(130, 400, 200, 100);
        drawPrimitiveFace();

        stage.show();
    }

    public static void drawPrimitiveFace() {
        drawShape();
        drawMouth(100);
        drawEyes();
    }

    public static void drawShape() {
        gc.strokeOval(190, 150, 300, 300);
    }

    public static void drawMouth(int mouthSize) {
        gc.setFill(Color.BLACK);
        gc.strokeArc(280,250,90,70,-40,-100, ArcType.OPEN);


        //Arm
        gc.strokeArc(410,210,50,180,200,180, ArcType.OPEN);
        gc.strokeArc(210,210,50,180,-200,180, ArcType.OPEN);
    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        gc.strokeArc(260,210,50,70,-60,300, ArcType.CHORD);
        gc.strokeArc(370,210,50,70,-60,300, ArcType.CHORD);

        gc.setFill(Color.BLACK);
        gc.fillArc(260,210,50,70,-60,300, ArcType.CHORD);
        //gc.fillOval(220,210,20,30);
        //gc.fillOval(360,220,20,30);

    }

    public static void main(String[] args) {
        launch();
    }
}