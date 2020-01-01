package com.git.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.git.model.Employee;

public interface employeeResponsitory extends JpaRepository<Employee, Integer>{

}
