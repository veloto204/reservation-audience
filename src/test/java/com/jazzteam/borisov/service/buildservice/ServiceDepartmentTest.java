package com.jazzteam.borisov.service.buildservice;

import com.jazzteam.borisov.AppConfig;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.models.person.Dean;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ServiceDepartmentTest {

    @Autowired
    private ServiceDepartment serviceDepartment;
    private Department department;

    @Before
    public void setUp() {
        Dean dean = new Dean("Vasili");
        dean.setPosition("Dean");
        HeadOfDepartment headOfDepartment = new HeadOfDepartment("Andre");
        headOfDepartment.setPosition("Head Of Department");
        Faculty faculty = new Faculty("Nanomechanics and Nanobiology Faculty");
        department = new Department("Common Physics");
        faculty.getDepartments().add(department);
        faculty.setDean(dean);
        department.setFaculty(faculty);
        department.setHeadOfDepartment(headOfDepartment);
        headOfDepartment.setDepartment(department);
    }

    @Test
    public void createDepartmentServiceObjectTest() {
        assertNotNull(serviceDepartment);
    }

    @Test
    public void addDepartmentTest() {
        serviceDepartment.save(department);
        int id = department.getDepartmentId();
        assertEquals(department, serviceDepartment.find(id));
    }

    @Test
    public void deleteDepartmentTest() {
        serviceDepartment.save(department);
        int id = department.getDepartmentId();
        serviceDepartment.delete(id);
        assertNull(serviceDepartment.find(id));
    }

    @Test
    public void updateDepartmentTest() {
        serviceDepartment.save(department);
        int id = department.getDepartmentId();
        department.setHeadOfDepartment(new HeadOfDepartment("Polo"));
        department.getHeadOfDepartment().setPosition("Head Of Department");
        serviceDepartment.update(department);
        assertEquals(department, serviceDepartment.find(id));
    }
}