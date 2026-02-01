module org.example.casino_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.casino_final to javafx.fxml;
    exports org.example.casino_final;
}