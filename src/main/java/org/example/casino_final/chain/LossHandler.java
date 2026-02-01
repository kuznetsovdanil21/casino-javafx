package org.example.casino_final.chain;

import javafx.scene.control.Alert;

public class LossHandler extends Handler {

    public LossHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean handle(int result) {
        if (result == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Проигрыш");
            alert.setHeaderText("Монетка потеряна 😢");
            alert.showAndWait();
            return false;
        }
        return next != null && next.handle(result);
    }
}
