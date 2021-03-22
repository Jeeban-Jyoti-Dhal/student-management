package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Student;

public interface StudentService {
	
List<Student>	loadStudents();

void saveStudent(Student student);

Student getStudentDetails(int id);

void updateStudent(Student student);

void deleteStudent(int id);

}
