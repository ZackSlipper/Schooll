package com.kitm.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Author {
	private IntegerProperty id;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty city;

	/*
	 * Author constructor
	 * 
	 * @param id the author id
	 * @param firstName the author first name
	 * @param lastName the author last name
	 * @param email the author email
	 * @param city the author city
	 */
	public Author(int id, String firstName, String lastName, String email, String city) {
		this.id = new SimpleIntegerProperty(id);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
		this.city = new SimpleStringProperty(city);
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public StringProperty emailProperty() {
		return email;
	}

	public StringProperty cityProperty() {
		return city;
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public void setCity(String city) {
		this.city.set(city);
	}
	
	@Override
	public String toString() {
		return String.format("Author [FirstName=%s, LastName=%s, Email=%s, City=%s]", firstName.get(), lastName.get(), email.get(), city.get());
	}
}
