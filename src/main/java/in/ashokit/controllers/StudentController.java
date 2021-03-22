package in.ashokit.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.dao.StudentDao;
import in.ashokit.entity.Student;
import in.ashokit.service.StudentService;

@Controller
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping("/showstudent")
	public String studentList(Model model) {
		System.out.println("inside studentList method");
		// call the service method to get the data
		List<Student> loadStudents = service.loadStudents();
		// loadStudents.forEach(s-> {System.out.println(s);});
		model.addAttribute("students", loadStudents);
		return "student-list";
		

	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "add-student";

	}

	@PostMapping("/studentSaved")
	public String savedStudent(Student student) {
		System.out.println(student);

		// do a condition check
		// if the user does not have an id do an insert
		// if the user does have a id -> do a update

		if (student.getId() == null) {
			// do a service method to save the students
			service.saveStudent(student);
		}else {
			//do an update 
			service.updateStudent(student);
		}

		return "redirect:/showstudent";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam int id, Model model) {

		/*Student student = new Student();
		model.addAttribute("student", student);*/

		System.out.println("Lookind for data having id equals to " + id);

		Student details = service.getStudentDetails(id);
		System.out.println(details);

		model.addAttribute("student", details);

		// setting the student info
		/*student.setId(details.getId());
		student.setName(details.getName());
		student.setMobile(details.getMobile());
		student.setCountry(details.getCountry());*/

		return "add-student";
	}
	
	@GetMapping("deleteStudent")
	public String deleteStudent(@RequestParam int id) {
		
		service.deleteStudent(id);
		
		return "redirect:/showstudent";
	}

}
