package com.git.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.git.model.Employee;
import com.git.reponsitory.employeeResponsitory;

@Service
public class service {

	@Autowired
	employeeResponsitory responsitory;
	
	public List<Employee> getAll(){
		return responsitory.findAll();
	}
	
	public Employee save(Employee employee) {
		return responsitory.save(employee);
	}
	
	public Optional<Employee> edit(Integer id) {
		return responsitory.findById(id);
	}
	public void del(Integer id) {
		responsitory.deleteById(id);
	}
	
	public List<Employee> search(String name , String email) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("name").withIgnorePaths("email");
        return responsitory.findAll(Example.of(employee, exampleMatcher));

    }
}
