package com.kitm.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitm.Models.Model;
import com.kitm.Views.MenuItems;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AuthorsController implements Initializable {

	@FXML
	public Button btn_AddAuthor;

	@FXML
	public TableView tbl_Authors;

	@FXML
	public TableColumn col_Id;

	@FXML
	public TableColumn col_FirstName;

	@FXML
	public TableColumn col_LastName;

	@FXML
	public TableColumn col_Email;

	@FXML
	public TableColumn col_City;

	
	@FXML
	public MenuItem mi_DeleteAuthor;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		btn_AddAuthor.setOnAction(e -> onCreateAuthor());
	}

	/*
	 * Open create author window
	 */
	public void onCreateAuthor() {
		Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(MenuItems.CREATE_AUTHOR);
	}
}
