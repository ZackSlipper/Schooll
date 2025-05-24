package com.kitm;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import com.kitm.Models.Model;
import com.kitm.Utilities.AlertUtility;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
	public void start(Stage stage) throws IOException {
		if (Model.getInstance().hasRegisteredUsers()) {
			Model.getInstance().getViewFactory().showLoginWindow();
		}
		else
		{
			AlertUtility.displayError("No registered users found! Create a new user.");
			Model.getInstance().getViewFactory().showRegisterWindow();
		}
    }

    public static void main(String[] args) {
        launch();
    }
}