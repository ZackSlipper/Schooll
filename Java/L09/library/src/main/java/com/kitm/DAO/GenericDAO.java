package com.kitm.DAO;

import java.util.List;

public interface GenericDAO<T> {
	/*
	 * FindEntityById method
	 */
	T findById(int id);

	/*
	 * Create new entity
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param city
	 */
	void create(String firstName, String lastName, String email, String city);

	/*
	 * Update entity
	 * 
	 * @param entity
	 */
	void update(T entity);

	/*
	 * Delete entity
	 * 
	 * @param id
	 */
	void delete(int id);

	/*
	 * Find all entities by type
	 */
	List<T> findAll();
}
