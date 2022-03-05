package Packman_Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyPlayer implements Player {
    Map map;
    Position position;
    private Image image;
    private ImageView iv;
    MyPlayer(Map map) throws FileNotFoundException {
        position = Map.getStartPosition();
        image = new Image(new FileInputStream("src/Packman_Game/img/Cat.gif"));
        iv = new ImageView((image));
        iv.setLayoutX(position.getX()*map.getUnit() );
        iv.setLayoutY(position.getY()*map.getUnit() );
        iv.setFitHeight(50);
        iv.setFitWidth(50);
        map.getChildren().add(iv);
        this.map = map;
    }

    public void moveUp() {
        if (getPosition().getY() > 0 && map.getValueAt(getPosition().getY() - 1, getPosition().getX()) != 1){
            iv.setY(iv.getY() - map.getUnit() - 1);
            position.setX(position.getX());
            position.setY(position.getY() - 1); }
        else{
            System.out.println("Invalid position!");
        }
    }
    @Override
    public void moveDown() {
        if(getPosition().getY() < map.getSize() - 1 && map.getValueAt(getPosition().getY()+1,getPosition().getX()) != 1) {
            iv.setY(iv.getY() + map.getUnit() + 1);
            position.setX(position.getX());
            position.setY(position.getY() + 1); }
        else{
            System.out.println("Invalid position!");
        }
    }
    @Override
    public void moveRight() {
        if(getPosition().getX() < map.getSize() - 1 && map.getValueAt(getPosition().getY(),getPosition().getX()+1) != 1) {
            iv.setX(iv.getX() + map.getUnit() +1);
            position.setY(position.getY());
            position.setX(position.getX() + 1);
            iv.setTranslateZ(iv.getBoundsInLocal().getWidth() / 2.0);
            iv.setRotate(0);
            iv.setRotationAxis(Rotate.Y_AXIS);}
        else{
            System.out.println("Invalid position!");
        }
    }
    @Override
    public void moveLeft() {
        if(getPosition().getX() > 0 && map.getValueAt(getPosition().getY(), getPosition().getX()-1) != 1) {
            iv.setX(iv.getX() - map.getUnit()-1);
            position.setY(position.getY());
            position.setX(position.getX() - 1);
            iv.setTranslateZ(iv.getBoundsInLocal().getWidth() / 2.0);
            iv.setRotate(180);
            iv.setRotationAxis(Rotate.Y_AXIS);
        }
        else{
            System.out.println("Invalid position!");
        }
    }
    public Position getPosition() {
        return position;
    }

}
