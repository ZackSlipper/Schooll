package com.kitm.hybernate_test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kitm.hybernate_test.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDAO {
	private EntityManager entityManager;

	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		return entityManager.createQuery("FROM Student", Student.class).getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :lastName", Student.class);
		query.setParameter("lastName", lastName);

		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityManager.remove(student);
		}
	}

	@Override
	@Transactional
	public int deleteAll() {
		return entityManager.createQuery("DELETE FROM Student").executeUpdate();
	}
}
