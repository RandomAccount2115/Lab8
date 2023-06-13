package pl.lublin.java.lab8;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HelloController {
    public Label lbX;
    public Label lbY;
    public Pane pnArea;

    private boolean dragged = false;

    private Rectangle rect;

    public EventHandler<MouseEvent> myClickHandler;


    public void handleMouse(MouseEvent mouseEvent, boolean aClick) {

        System.out.println("dragged:" + dragged);

        String prefix = dragged ? (aClick  ? "" : "@") : (aClick ? "!" : "*");

        lbX.setText(prefix + mouseEvent.getX());
        lbY.setText(prefix + mouseEvent.getY());

    }

    public void handleDrag(MouseEvent mouseEvent){
        lbX.setText("@" + mouseEvent.getX());
        lbY.setText("@" + mouseEvent.getY());

        rect.setX(mouseEvent.getX());
        rect.setY(mouseEvent.getY());

    }

    public void handleKeyPressed(KeyEvent keyEvent){

        if (keyEvent.getCode() == KeyCode.UP){
            rect.setY(rect.getY()-5);
        }
        else if (keyEvent.getCode() == KeyCode.DOWN){
            rect.setY(rect.getY()+5);
        }
        else if (keyEvent.getCode() == KeyCode.LEFT){
            rect.setX(rect.getX()-5);
        }
        else if (keyEvent.getCode() == KeyCode.RIGHT){
            rect.setX(rect.getX()+5);
        }

    }

    public void initialize(){

        pnArea.setOnMouseClicked((MouseEvent ev) -> handleMouse(ev, true));
        pnArea.setOnMouseMoved((MouseEvent ev) -> handleMouse(ev, false));

        double w = pnArea.getWidth();
        double h = pnArea.getHeight();

        rect = new Rectangle(10.0, 10.0, Color.AQUAMARINE);

        pnArea.getChildren().add(rect);

        rect.setRotate(45);
        rect.setWidth(50);
        rect.setHeight(50);

        pnArea.setOnDragDetected((MouseEvent ev) -> dragged = true);
        pnArea.setOnMouseDragged((MouseEvent ev) -> handleDrag(ev));
        pnArea.setOnMouseReleased((MouseEvent ev) -> dragged = false);

    }

    public void stageResized(){

        pnArea.setClip(new Rectangle(pnArea.getWidth(), pnArea.getHeight()));

    }
}