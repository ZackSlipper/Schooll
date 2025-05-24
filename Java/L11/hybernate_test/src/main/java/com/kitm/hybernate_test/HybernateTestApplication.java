package com.kitm.hybernate_test;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kitm.hybernate_test.dao.StudentDAO;
import com.kitm.hybernate_test.entity.Student;

@SpringBootApplication
public class HybernateTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HybernateTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//findStudentById(studentDAO);
			getStudentList(studentDAO);
			//deleteAllStudents(studentDAO);
			//deleteStudent(studentDAO, 1);
			//getStudentList(studentDAO);
			//getStudentsByLastName(studentDAO, "Smith");
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int deletedCount = studentDAO.deleteAll();
		System.out.println("Deleted " + deletedCount + " students.");
	}

	private void updateStudent(StudentDAO studentDAO, Student student) {
		if (student == null) {
			System.out.println("Student not found!");
			return;
		}

		student.setFirstName("JOHN");
		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void deleteStudent(StudentDAO studentDAO, int id) {
		System.out.println("Deleting student with ID: " + id);
		studentDAO.delete(id);
		System.out.println("Deleted student with ID: " + id);
	}

	private void getStudentsByLastName(StudentDAO studentDAO, String lastName) {
		System.out.println("Finding students with last name: " + lastName);
		List<Student> students = studentDAO.findByLastName(lastName);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void getStudentList(StudentDAO studentDAO) {
		System.out.println("Finding all students...");
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void findStudentById(StudentDAO studentDAO) {
		System.out.println("Finding student with ID 1...");
		Student student = studentDAO.findById(1);
		System.out.println("Found student: " + student);
	}

	private void createStudent(StudentDAO studentDAO) {
		/*System.out.println("Creating new student object...");
		Student student = new Student("John", "Johny", "john.johny@example.com");
		System.out.println("Saving the student...");
		studentDAO.save(student);
		System.out.println("Saved student: " + student);
		System.out.println("Generated ID: " + student.getId());
		System.out.println("Student saved successfully!");*/

		Student student2 = new Student("Alice", "Smith", "alice.smith@example.com");
		studentDAO.save(student2);
		System.out.println("Saved student: " + student2);
		System.out.println("Generated ID: " + student2.getId());
		System.out.println("Student saved successfully!");

		Student student3 = new Student("Bob", "Brown", "bob.brown@example.com");
		studentDAO.save(student3);
		System.out.println("Saved student: " + student3);
		System.out.println("Generated ID: " + student3.getId());
		System.out.println("Student saved successfully!");

		Student student4 = new Student("Clara", "Davis", "clara.davis@example.com");
		studentDAO.save(student4);
		System.out.println("Saved student: " + student4);
		System.out.println("Generated ID: " + student4.getId());
		System.out.println("Student saved successfully!");

		Student student5 = new Student("Eve", "Evans", "eve.evans@example.com");
		studentDAO.save(student5);
		System.out.println("Saved student: " + student5);
		System.out.println("Generated ID: " + student5.getId());
		System.out.println("Student saved successfully!");
	}
}
