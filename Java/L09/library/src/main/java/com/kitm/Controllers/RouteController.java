package com.kitm.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitm.Models.Model;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class RouteController implements Initializable{

	public BorderPane parent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Model.getInstance().getViewFactory().getUserSelectedMenuItem().addListener((observable, oldValue, newValue) -> {
			switch (newValue) {
				case AUTHORS:
					parent.setCenter(Model.getInstance().getViewFactory().getAuthorsView());
					break;
				case CREATE_AUTHOR:
					parent.setCenter(Model.getInstance().getViewFactory().getCreateAuthorView());
					break;
				default:
					parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
					break;
			}
		});
	}
}
