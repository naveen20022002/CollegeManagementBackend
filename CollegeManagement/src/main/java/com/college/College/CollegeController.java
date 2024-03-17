package com.college.College;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.college.EmployeeManagement.Employee;
//import com.college.EmployeeManagement.EmployeeRepository;

@RestController
@CrossOrigin
@RequestMapping("/college")

public class CollegeController {
	@Autowired
	private CollegeRepository clgRepo;
	
	@PostMapping
	public College addCollege(@RequestBody College clg) {
		return clgRepo.save(clg);
	}
	@PutMapping("/{id}")
	public College updateCollege(@RequestBody College clg, @PathVariable Long id) {
		clg.setId(id);
		return clgRepo.save(clg);
	}
	@DeleteMapping("/{id}")
	public void deleteCollege(@PathVariable Long id) {
		clgRepo.deleteById(id);
	}
	@GetMapping
	public List<College> displayCollege() {
		return clgRepo.findAll();
	}
}


