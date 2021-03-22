package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.dao.StudentDao;
import in.ashokit.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDao sdao;

	public StudentServiceImpl(StudentDao sdao) {
		super();
		this.sdao = sdao;
	}

	@Override
	public List<Student> loadStudents() {
		List<Student> showstudent = sdao.loadStudents();
		return showstudent;
	}

	@Override
	public void saveStudent(Student student) {
		
		if(student.getCountry().equals("UK")) {
			System.out.println("mail sent to "+student.getName());
		}
		sdao.saveStudent(student);
	}

	@Override
	public Student getStudentDetails(int id) {
		Student studentDetails = sdao.getStudentDetails(id);
		return studentDetails;
	}

	@Override
	public void updateStudent(Student student) {
		sdao.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		sdao.deleteStudent(id);
		
	}
	
}
