package Packman_Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map extends Pane {
    Scanner sc =new Scanner(System.in);
    private static Position start;
    private int unit = 50;
    private int size ;
    private int [][]map ;
    private int a;
    public Map(File file) {
        a = sc.nextInt();
            try{Scanner in = new Scanner(file);
             size = in.nextInt();
             if( a == size){
                 map= new int[size][size];
             }
            while (in.hasNextInt()) {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        map[i][j] = in.nextInt(); } } }
            GridPane gr = new GridPane();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] == 2) start = new Position(i, j);

                    if (map[j][i] == 1) {
//                        Rectangle rectangle = new Rectangle(unit, unit);
//                        rectangle.setStroke(Color.BLACK);
//                        rectangle.setFill(Color.AQUA);
//                        gr.add(rectangle, i, j);
                        Image image = new Image(new FileInputStream("src/Packman_Game/img/торт.gif")) ;
                        ImageView iv = new ImageView(image);
                        iv.setFitHeight(50);
                        iv.setFitWidth(50);
                        gr.add(iv , i ,j);
                    } else {
//                        Rectangle rectangle1 = new Rectangle(unit, unit);
//                        rectangle1.setStroke(Color.PINK);
//                        rectangle1.setFill(Color.WHITE);
//                        gr.add(rectangle1, i, j);
                        Image image = new Image(new FileInputStream("src/Packman_Game/img/куб.gif")) ;
                        ImageView iv = new ImageView(image);
                        iv.setFitHeight(50);
                        iv.setFitWidth(50);
                        gr.add(iv , i ,j);
                    }
                }
            }
            getChildren().add(gr); }

            catch (IOException e){}}


    public int getSize() {
        return size;
    }

    public int getUnit() {
        return unit;
    }
    public static Position getStartPosition(){
        return start;
    }
    public int getValueAt(int row , int column)  {
        return map[row][column];
    }
}
