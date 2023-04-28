package com.crudoperation.department.service;
import com.crudoperation.department.entity.Department;
import com.crudoperation.department.repository.DepRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    private DepService departmentService;

    @MockBean
    private DepRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .depName("IT")
                        .depAdd("Mzn")
                        .depCode("06")
                        .depId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepName("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found =
                departmentService.fetchByDepName(departmentName);

        assertEquals(departmentName, found.getDepName());
    }
}

