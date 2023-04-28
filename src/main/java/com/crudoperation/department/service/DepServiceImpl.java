package com.crudoperation.department.service;

import com.crudoperation.department.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperation.department.entity.Department;
import com.crudoperation.department.repository.DepRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class  DepServiceImpl implements DepService {
	@Autowired
	private DepRepository depRepository;

	@Override
	public Department saveDep(Department department) {
		return depRepository.save(department);
	}

	@Override
	public List<Department> getDep() { return depRepository.findAll();}

	@Override
	public Department getDepById(Long depId) throws DepartmentNotFoundException
	{
		Optional<Department> department = depRepository.findById(depId);
		if(!department.isPresent()){
			throw new DepartmentNotFoundException("Department not available");
		}
		return department.get();

	}

	@Override
	public void deleteDepById(Long depId) {  depRepository.deleteById(depId);}

	@Override
	public Department updateDepById(Long depId, Department department) {
		Department department1 = depRepository.findById(depId).get();
		if(Objects.nonNull(department.getDepName()) && !"".equalsIgnoreCase(department.getDepName())){
			department1.setDepName(department.getDepName());
		}

		if(Objects.nonNull(department.getDepAdd()) && !"".equalsIgnoreCase(department.getDepAdd())){
			department1.setDepAdd(department.getDepAdd());
		}

		if(Objects.nonNull(department.getDepCode()) && !"".equalsIgnoreCase(department.getDepCode())){
			department1.setDepCode(department.getDepCode());
		}
		return depRepository.save(department1);
	}

	@Override
	public Department fetchByDepName(String depName) {
		return depRepository.findByDepName(depName);
	}


}
