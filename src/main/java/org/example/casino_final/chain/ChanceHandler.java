package org.example.casino_final.chain;

import javafx.scene.control.Alert;

public class ChanceHandler extends Handler {

    public ChanceHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean handle(int result) {
        if (result == 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Шанс!");
            alert.setHeaderText("🍀 Судьба даёт ещё одну попытку!");
            alert.showAndWait();
            return true;
        }
        return next != null && next.handle(result);
    }
}
