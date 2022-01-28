package co.micol.prj.emp.web;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.prj.emp.web.service.Dept;
import co.micol.prj.emp.web.service.Emp;
import co.micol.prj.emp.web.service.EmpMapper;

@Controller
public class EmpController {
	
	@Autowired EmpMapper mapper;

	@PostMapping("/test1")
	@ResponseBody
	public Map test1() {
		return Collections.singletonMap("result", "success");
	}
	
	@PostMapping("/emp")
	@ResponseBody
//	public Emp emp() {
//		Emp emp = Emp.builder()
//						.employee_id("100")
//						.hire_date(new Date())
//						.build();
//		return emp;
//	}
	public List<Emp> emp() {
		
		return mapper.findEmp();
	}
	
	//전체조회
	@GetMapping("/dept")
	@ResponseBody
//	public Dept dept() {
//		Dept dept = Dept.builder()
//						.department_id("10")
//						.department_name("개발")
//						.build();
//		return dept;
//	}
	public List<Dept> dept() {
		
		return mapper.findDept();
	}
	
	//등록 post
	@PostMapping("/dept")
	@ResponseBody
	public Dept insertDept(Dept dept) {
		mapper.insertDept(dept);
		return dept;
	}
	
	//삭제 json
	@DeleteMapping("/dept/{id}")
	@ResponseBody
	public Map deleteDept(@PathVariable String id) {
		mapper.deleteDept(id);
		return Collections.singletonMap("result", "success");
	}
	
	//단건조회 GET
	@GetMapping("/dept/{id}")
	@ResponseBody
	public Dept findDeptById(@PathVariable String id) {
		return mapper.findDeptById(id);
	}

	//수정 put
	@PutMapping("/dept")
	@ResponseBody
	public Dept updateDept(@RequestBody Dept dept) {
		mapper.updateDept(dept);
		return dept;
	}
}
