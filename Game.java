package Packman_Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Game extends Application {
    Map map;
    MyPlayer player;
    Food food;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        String file1 = "src/Packman_Game/img/Музыка.mp3";
        Media media = new Media(new File(file1).toURI().toString());
        MediaPlayer thunder = new MediaPlayer(media);
        thunder.play();

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        File file = new File(s);
        map = new Map(file);
        player = new MyPlayer(map);
        food = new Food(map, player);
        Scene scene = new Scene(map, 400, 400);
        scene.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.RIGHT)) {
                player.moveRight();
            }
            if (event.getCode().equals(KeyCode.LEFT)) {
                player.moveLeft();
            }
            if (event.getCode().equals(KeyCode.UP)) {
                player.moveUp();
            }
            if (event.getCode().equals(KeyCode.DOWN)) {
                player.moveDown();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("Eater");
        primaryStage.show();
    }
}