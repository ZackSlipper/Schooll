package com.kitm.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitm.Models.Model;
import com.kitm.Utilities.AlertUtility;
import com.kitm.Views.MenuItems;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateAuthorController implements Initializable {
	
	@FXML
	public TextField tf_FirstName;

	@FXML
	public TextField tf_LastName;

	@FXML
	public TextField tf_Email;

	@FXML
	public TextField tf_City;

	@FXML
	public Button btn_CreateAuthor;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		btn_CreateAuthor.setOnAction(e -> createAuthor());
	}
	
	private void createAuthor() {
		String firstName = tf_FirstName.getText();
		String lastName = tf_LastName.getText();
		String email = tf_Email.getText();
		String city = tf_City.getText();
		
		Model.getInstance().createAuthor(firstName, lastName, email, city);
		
		AlertUtility.displayInformation("Author created successfully!");
		clearFields();
	}

	private void clearFields() {
		tf_FirstName.clear();
		tf_LastName.clear();
		tf_Email.clear();
		tf_City.clear();
	}
}
