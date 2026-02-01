package org.example.casino_final.ui;

import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationUtil {

    public static void spin(Node node) {
        RotateTransition rt = new RotateTransition(Duration.millis(600), node);
        rt.setByAngle(360);
        rt.play();
    }
}
