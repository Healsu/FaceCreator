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

public class ThirdHead extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ThirdHead.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
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

        gc.strokeRect(150, 150, 300, 300);
    }

    public static void drawMouth(int mouthSize) {
        gc.setFill(Color.BLACK);
        gc.fillOval(280,370,mouthSize,mouthSize);
    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        gc.strokeArc(200,150,90,90,-40,-100, ArcType.CHORD);
        gc.fillOval(240,230,10,5);
        gc.strokeArc(320,150,90,90,-40,-100, ArcType.CHORD);
        gc.fillOval(360,230,10,5);

    }
    public static void etc() {

    }

    public static void main(String[] args) {
        launch();
    }
}