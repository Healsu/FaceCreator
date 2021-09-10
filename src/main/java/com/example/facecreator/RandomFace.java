package com.example.facecreator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class RandomFace extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RandomFace.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Random Faces");
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
        gc.setFill(Color.BLACK);
        Random rand3 = new Random();
        int randShape = rand3.nextInt(2);
                if(randShape == 0) {
                    gc.strokeOval(150, 150, 300, 300);
                }
                else if(randShape == 1) {
                    gc.strokeRect(150, 150, 300, 300);
                }
                }

    public static void drawMouth(int mouthSize) {
        //Random funktion for mund
        Random rand = new Random();
        int randMouth = rand.nextInt(4);


        if (randMouth == 0) {
            gc.setFill(Color.BLACK);
            gc.fillOval(280, 370, mouthSize, mouthSize);
        }
        else if (randMouth == 1){
            gc.setLineWidth(2);
            gc.strokeArc(270,380,90,100,50,100, ArcType.OPEN);

        }
        else if (randMouth == 2){
            gc.setLineWidth(2);
            gc.strokeLine(220,360,400,360);

        }
        else if (randMouth == 3){
            gc.strokeArc(250,300,90,70,-40,-100, ArcType.OPEN);

        }
        System.out.println("Mouth number was "+randMouth);
    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        Random rand2 = new Random();
        int randEyes = rand2.nextInt(4);

        if(randEyes == 0) {
            gc.fillOval(220, 220, 20, 20);
            gc.fillOval(360, 220, 20, 20);

            gc.setLineWidth(5);
            gc.strokeLine(220,200,400,220);
        }
        else if (randEyes == 1) {
            gc.strokeArc(210,190,50,70,-60,300, ArcType.CHORD);
            gc.strokeArc(340,190,50,70,-60,300, ArcType.CHORD);
        }
        else if (randEyes == 2){
            gc.fillOval(200,220,40,40);
            gc.fillOval(360,220,40,40);

            gc.strokeOval(190,210,60,60);
            gc.strokeOval(350,210,60,60);



        }
        else if (randEyes == 3){
            gc.strokeArc(200,150,90,90,-40,-100, ArcType.CHORD);
            gc.fillOval(240,230,10,5);
            gc.strokeArc(320,150,90,90,-40,-100, ArcType.CHORD);
            gc.fillOval(360,230,10,5);

        }
        System.out.println("Eyes number was "+randEyes);
        }

    public static void etc() {
        //Bonus figurer til ansigtet
        Random rand4 = new Random();
        int randBonus = rand4.nextInt(4);

        if (randBonus == 0){
            gc.strokeLine(270,250,290,330);
            gc.strokeLine(290,330,330,250);
        }
        else if (randBonus == 1){
            gc.fillRect(180,100,250,70);
            gc.fillRect(250,0,100,150);

        }
        else if (randBonus == 2){
            gc.strokeArc(260,250,90,70,-40,-100, ArcType.ROUND);
        }

        else if (randBonus == 3){
            gc.strokeArc(300,250,50,100,200,200, ArcType.OPEN);

        }
        System.out.println("Bonus number was "+randBonus);
    }
    public static void main(String[] args) {
        launch();
    }
}