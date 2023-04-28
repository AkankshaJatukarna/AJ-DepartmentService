package com.crudoperation.department.repository;

import com.crudoperation.department.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class DepartmentRepositoryTest {
    @Autowired
    private DepRepository depRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .depName("ME")
                        .depCode("011")
                        .depAdd("Delhi")
                        .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = depRepository.findById(1L).get();
        assertEquals(department.getDepName(), "ME");
    }
}

