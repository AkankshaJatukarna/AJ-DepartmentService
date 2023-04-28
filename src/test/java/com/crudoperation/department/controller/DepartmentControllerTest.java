package com.crudoperation.department.controller;

import com.crudoperation.department.entity.Department;
import com.crudoperation.department.service.DepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DepService departmentService;
    private Department department;
    @BeforeEach
    void setUp(){
        department=Department.builder()
                .depAdd("Muzaffarnagar")
                .depCode("T-06")
                .depName("IT")
                .depId(1L)
                .build();
    }
    @Test
    void savedepartment() throws Exception{
        Department inputDepartment = Department.builder()
                .depAdd("Muzaffarnagar")
                .depCode("T-06")
                .depName("IT")
                .depId(1L)
                .build();
        Mockito.when(departmentService.saveDep(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"departmentName\":\"IT\",\n" +
                                "\t\"departmentAddress\":\"Muzaffarnagar\",\n" +
                                "\t\"departmentCode\":\"T-06\"\n" +
                                "}"))
                .andExpect(status().isOk());

    }
    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/department/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").
                        value(department.getDepName()));
    }

}

