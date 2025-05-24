package com.kitm.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitm.Models.Model;
import com.kitm.Views.MenuItems;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController implements Initializable {

	@FXML
	public Button btn_logout;

	@FXML
	public Button btn_authors;

	@FXML
	public Text txt_currentUser;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		txt_currentUser.setText(Model.getInstance().getCurrentUserName());

		addListeners();
	}
	
	private void addListeners() {
		//Add listener to logout button
		btn_logout.setOnAction(e -> logout());
		//Add listener to authors button
		btn_authors.setOnAction(e -> onAuthors());
	}

	/*
	 * Handle authors window
	 */
	public void onAuthors() {
		Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(MenuItems.AUTHORS);
	}

	/*
	 * Handle logout event 
	 */
	public void logout() {
		//Create stage
		Stage stage = (Stage) btn_logout.getScene().getWindow();
		//Close stage
		Model.getInstance().getViewFactory().closeStage(stage);
		//Show login window
		Model.getInstance().getViewFactory().showLoginWindow();
		//Set login success flag to false
		Model.getInstance().setLoginSuccessFlag(false);
	}

}
