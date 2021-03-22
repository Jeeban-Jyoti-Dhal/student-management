package in.ashokit.dao;

import java.util.List;

import in.ashokit.entity.Student;

public interface StudentDao {
    List<Student> loadStudents();
    void saveStudent(Student student);
    Student getStudentDetails(int id);
	void updateStudent(Student student);
	void deleteStudent(int id);
}
