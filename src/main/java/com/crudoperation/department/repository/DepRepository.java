package com.crudoperation.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudoperation.department.entity.Department;

@Repository
public interface DepRepository extends JpaRepository<Department, Long> {
    @Query("select d from Department d where d.depName=?1")
    public Department findByDepName(String depName);
}



