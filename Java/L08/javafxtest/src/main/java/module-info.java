module com.kitm {
    requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;

    opens com.kitm to javafx.fxml;
    exports com.kitm;
}
