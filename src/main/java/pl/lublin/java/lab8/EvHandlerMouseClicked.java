package pl.lublin.java.lab8;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EvHandlerMouseClicked implements EventHandler<MouseEvent> {

    HelloController controller;

    public EvHandlerMouseClicked(HelloController controller){
        super();
        this.controller = controller;
    }

    public void handle(MouseEvent ev){

        controller.lbX.setText("#" + ev.getX());
        controller.lbY.setText("#" + ev.getY());

    }

}
