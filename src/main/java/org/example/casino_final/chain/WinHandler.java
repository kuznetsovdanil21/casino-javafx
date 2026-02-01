package org.example.casino_final.chain;

import javafx.scene.control.Alert;

public class WinHandler extends Handler {

    public WinHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean handle(int result) {
        if (result == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Победа!");
            alert.setHeaderText("🎉 Вы выиграли 3 монеты!");
            alert.showAndWait();
            return true;
        }
        return next != null && next.handle(result);
    }
}
