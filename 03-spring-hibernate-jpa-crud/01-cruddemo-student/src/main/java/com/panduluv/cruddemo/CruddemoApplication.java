package com.panduluv.cruddemo;

import com.panduluv.cruddemo.dao.StudentDAO;
import com.panduluv.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted Row Count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting the student with id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with Id: "+ studentId);
		Student student = studentDAO.findById(studentId);
		System.out.println("Found student: "+ student);

		// change firstName to "Harshitha"
		System.out.println("Updating student.....");
		student.setFirstName("Harshitha");

		// update the student
		studentDAO.update(student);

		//display the updated student
		System.out.println("Updated student: "+student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Anthan");

		// display the list of students
		theStudents.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {

//		get a list of students
		List<Student> theStudents = studentDAO.findAll();

//		display the list of students
		theStudents.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {

//		create a student object
		System.out.println("creating a new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffyduck@gmail.com" );

//		save the student
		System.out.println("saving the new student...");
		studentDAO.save(tempStudent);

//		display id of the saved student
		System.out.println("saved student. Generated id: "+ tempStudent.getId());

//		retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: "+ tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

//		display student
		System.out.println("Found the student: "+ myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

//		Create multiple students
		System.out.println("Creating 3 new student objects... ");
		Student tempStudent1 = new Student("Harshitha", "Reddy", "harshithareddy@gmail.com");
		Student tempStudent2 = new Student("Unnu", "Anthan", "unnuanthan@gmail.com");
		Student tempStudent3 = new Student("Pandu", "nagari", "pandunagari@gmail.com");

//		Save multiple students
		System.out.println("saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

//		Create the student object
		System.out.println("Creating a new student object... ");
		Student tempStudent = new Student("Uday", "Reddy", "udayreddy@gmail.com");

//		Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		display id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());
	}

}
