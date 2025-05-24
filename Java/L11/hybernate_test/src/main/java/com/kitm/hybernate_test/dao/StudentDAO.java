package com.kitm.hybernate_test.dao;

import java.util.List;

import com.kitm.hybernate_test.entity.Student;

public interface StudentDAO {
	void save(Student student);
	
	Student findById(int id);
	
	List<Student> findAll();

	List<Student> findByLastName(String lastName);

	void update(Student student);

	void delete(Integer id);

	int deleteAll();
}
