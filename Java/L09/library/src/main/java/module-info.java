module com.kitm {
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	requires transitive java.sql;
	requires java.logging;

	requires transitive javafx.controls;

    opens com.kitm to javafx.fxml;
    exports com.kitm;
	exports com.kitm.Controllers;
	exports com.kitm.Models;
	exports com.kitm.Views;
}
