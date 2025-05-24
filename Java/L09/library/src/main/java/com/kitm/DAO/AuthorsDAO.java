package com.kitm.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import com.kitm.Models.Author;
import com.kitm.Models.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AuthorsDAO implements GenericDAO<Author> {

	private Connection connection;
	private static final Logger logger = Logger.getLogger(AuthorsDAO.class.getName());

	public AuthorsDAO(Connection connection) {		
		this.connection = connection;
	}

	@Override
	public Author findById(int id) {
		return null;
	}

	@Override
	public void create(String firstName, String lastName, String email, String city) {
		String sql = "INSERT INTO authors (first_name, last_name, email, city, date, user_id) VALUES (?, ?, ?, ?, ?, ?)";
		int userId = Model.getInstance().getCurrentUserId();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);
			statement.setString(4, city);
			statement.setDate(5, Date.valueOf(LocalDate.now()));
			statement.setInt(6, userId);

			statement.executeUpdate();

			logger.info("Author created successfully");
		} catch (Exception e) {
			logger.severe("Error creating user: " + e.getMessage());
		}
	}

	@Override
	public void update(Author entity) {
		
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public ObservableList<Author> findAll() {
		ObservableList<Author> authors = FXCollections.observableArrayList();
		String sql = "SELECT id, first_name, last_name, email, city, date FROM authors";
		try (PreparedStatement statement = this.connection.prepareStatement(sql)){
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				String city = resultSet.getString("city");

				Author author = new Author(id, firstName, lastName, email, city);
				authors.add(author);
			}
		} catch (Exception e) {
			logger.severe("Error fetching authors: " + e.getMessage());
		}
		
		return authors;
	}
}
