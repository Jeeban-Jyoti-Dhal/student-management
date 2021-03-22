package in.ashokit.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Student;
@Repository
public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate template;
	
	public StudentDaoImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Student> loadStudents() {
		//List<Student> studentsList=new ArrayList<Student>();
		String sql1="select * from oeja3.students";
		List<Student> studentsList = template.query(sql1, new BeanPropertyRowMapper<Student>(Student.class));
		return studentsList;
	}

	@Override
	public void saveStudent(Student student) {
			String qry2="insert into students(name,mobile,country) values(?,?,?)";
		   Object[] arr={student.getName(),student.getMobile(),student.getCountry()};
		   int update = template.update(qry2, arr);
		   System.out.println(update+ " record inserted");
	}

	@Override
	public Student getStudentDetails(int id) {
		String sql="select * from students where id=?";
		Student queryForObject = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
		return queryForObject;
	}

	@Override
	public void updateStudent(Student student) {
		String sql1="update students set name=?, mobile=?, country=? where id=?";
		template.update(sql1, student.getName(),student.getMobile(),student.getCountry(),student.getId());
		System.out.println("1 record updated");
	}

	@Override
	public void deleteStudent(int id) {
		String sql2="delete from students where id=?";
		template.update(sql2, id);
	}

}
