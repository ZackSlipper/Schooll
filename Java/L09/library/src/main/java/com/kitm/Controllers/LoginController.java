package com.kitm.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitm.Models.Model;
import com.kitm.Utilities.AlertUtility;

public class LoginController implements Initializable {
	
	@FXML
	public TextField txt_username_field;

	@FXML
	public PasswordField passwd;

	@FXML
	public Hyperlink hyp_register_link;

	@FXML
	public Button btn_login;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		hyp_register_link.setOnAction(actionEvent -> onRegister());
		btn_login.setOnAction(actionEvent -> onLogin());
	}

	/*
	 * Handle login action
	 */
	public void onLogin() {
		Stage stage = (Stage) hyp_register_link.getScene().getWindow();

		//Model.getInstance().getViewFactory().showMainWindow();

		//Check credentials
		Model.getInstance().checkCredentials(txt_username_field.getText(), passwd.getText());

		//If login is successful, open dashboard
		if (Model.getInstance().getLoginSuccessFlag()) {
			Model.getInstance().getViewFactory().showMainWindow();
			Model.getInstance().getViewFactory().closeStage(stage);
		} else {
			txt_username_field.setText(null);
			passwd.setText(null);
			AlertUtility.displayError("Invalid credentials");
		}
	}

	/*
	 * Handle register action
	 */
	public void onRegister() {
		Stage stage = (Stage) hyp_register_link.getScene().getWindow();

		Model.getInstance().getViewFactory().showRegisterWindow();
		Model.getInstance().getViewFactory().closeStage(stage);
	}	
}
