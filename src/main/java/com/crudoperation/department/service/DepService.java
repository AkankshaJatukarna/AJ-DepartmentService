package com.crudoperation.department.service;

import com.crudoperation.department.entity.Department;
import com.crudoperation.department.error.DepartmentNotFoundException;

import java.util.List;

public interface DepService {

	Department saveDep(Department department);

    List<Department> getDep();

    Department getDepById(Long depId) throws DepartmentNotFoundException;

    void deleteDepById(Long depId);

    Department updateDepById(Long depId, Department department);

    Department fetchByDepName(String depName);
}
