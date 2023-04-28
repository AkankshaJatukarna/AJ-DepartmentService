package com.crudoperation.department.controller;

import com.crudoperation.department.entity.Department;
import com.crudoperation.department.error.DepartmentNotFoundException;
import com.crudoperation.department.service.DepService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HelloController {

	@Autowired
	private DepService depService;
	
	private final Logger LOGGER= LoggerFactory.getLogger(HelloController.class);
	
	@PostMapping("/department")
	public Department saveDep(@RequestBody @Valid Department department)
	{
		LOGGER.info("inside save department of controller");
		return depService.saveDep(department);
	}

	@GetMapping("/department")
	public List<Department> getDep(){
		LOGGER.info("inside get department of controller");
		return depService.getDep();}

	@GetMapping("/department/{id}")
	public Department getDepById(@PathVariable("id") Long depId) throws DepartmentNotFoundException
	{
		LOGGER.info("inside get department by id of controller");
		return depService.getDepById(depId);
	}

	@DeleteMapping("/department/{id}")
	public String deleteDepById(@PathVariable("id") Long depId){
		 depService.deleteDepById(depId);
		 return "department deleted sucessfully";
	}
	@PutMapping("/department/{id}")
	public Department updateDepById(@PathVariable("id") Long depId, @RequestBody Department department){
		return depService.updateDepById(depId,department);
	}
	@GetMapping("/department/name/{name}")
	public Department fetchByDepName(@PathVariable("name") String depName){
		return depService.fetchByDepName(depName);
	}
}
