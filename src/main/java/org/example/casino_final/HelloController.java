package org.example.casino_final;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.example.casino_final.game.ActionChain;
import org.example.casino_final.game.Player;
import org.example.casino_final.ui.AnimationUtil;

public class HelloController {

    @FXML private BorderPane root;
    @FXML private ImageView bag1;
    @FXML private ImageView bag2;
    @FXML private ImageView bag3;
    @FXML private Label infoLabel;

    private Player player;
    private ActionChain action;

    @FXML
    public void initialize() {

        // 🌤 Белый фон приложения
        root.setStyle(
                "-fx-background-color: white;" +
                        "-fx-border-color: #dddddd;"
        );

        infoLabel.setStyle(
                "-fx-text-fill: #333333;" +
                        "-fx-font-size: 14px;"
        );

        Image bag = new Image(
                getClass().getResource("/bag.png").toExternalForm()
        );

        bag1.setImage(bag);
        bag2.setImage(bag);
        bag3.setImage(bag);

        player = new Player(3);
        infoLabel.setText("Монет: " + player.getCoins());
    }

    @FXML
    public void onPay() {
        player.win(1);
        infoLabel.setText("Монета добавлена. Баланс: " + player.getCoins());
    }

    @FXML
    public void onStart() {

        if (!player.pay()) {
            infoLabel.setText("Нет монет 😢");
            return;
        }

        action = new ActionChain();

        // ✨ анимация
        AnimationUtil.spin(bag1);
        AnimationUtil.spin(bag2);
        AnimationUtil.spin(bag3);

        int result = action.play();
        boolean cont = action.process(result);

        if (result == 1) {
            player.win(3);
        }

        infoLabel.setText(
                "Монет: " + player.getCoins() +
                        (cont ? " | Можно продолжать" : " | Игра окончена")
        );
    }
}
