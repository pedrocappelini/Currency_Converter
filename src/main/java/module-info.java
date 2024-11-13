module pedrao {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens pedrao to javafx.fxml;
    exports pedrao;
}
