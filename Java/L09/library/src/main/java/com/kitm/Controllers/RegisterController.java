package com.kitm.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitm.Models.Model;
import com.kitm.Utilities.AlertUtility;
import com.kitm.Utilities.UserUtility;

public class RegisterController implements Initializable {
	
	@FXML
	public TextField txt_username_field;

	@FXML
	public PasswordField passwd;

	@FXML
	public PasswordField repeat_passwd;

	@FXML
	public Button btn_register;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		btn_register.setOnAction(actionEvent -> onRegister());
	}

	public void onRegister() {
		Stage stage = (Stage) btn_register.getScene().getWindow();

		//Check if passwords match
		if (Model.getInstance().userExists(txt_username_field.getText())) {
			AlertUtility.displayError("User already exists!");
			clearFields();
			return;
		}

		if (!UserUtility.doPasswordsMatch(passwd.getText(), repeat_passwd.getText())) {
			AlertUtility.displayError("Passwords do not match!");
			return;
		}

		Model.getInstance().createUser(txt_username_field.getText(), passwd.getText());

		AlertUtility.displayInformation("User created successfully!");

		Model.getInstance().getViewFactory().showLoginWindow();
		Model.getInstance().getViewFactory().closeStage(stage);
	}

	/*
	 * Clear form fields
	 */
	public void clearFields() {
		txt_username_field.clear();
		passwd.clear();
		repeat_passwd.clear();
	}
}
