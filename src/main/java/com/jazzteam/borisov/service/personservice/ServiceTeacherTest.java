package com.jazzteam.borisov.service.personservice;

import com.jazzteam.borisov.AppConfig;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import com.jazzteam.borisov.models.person.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ServiceTeacherTest {

    private HeadOfDepartment headOfDepartment;
    private Teacher teacher;
    @Autowired
    private ServiceTeacher serviceTeacher;
    @Autowired
    private ServiceHeadOdDepartment serviceHeadOdDepartment;

    @Before
    public void setUp() {
        teacher = new Teacher("Sara", "teacher", "coca-cola", "12345678qwerty");
        headOfDepartment = new HeadOfDepartment("Stepan", "head of department",
                "pepsi", "123");
    }

    @Test
    public void createTeacherServiceObjectTest() {
        assertNotNull(serviceTeacher);
    }

    @Test
    public void addTeacherTest() {
        serviceTeacher.save(teacher);
        int id = teacher.getTeacherId();
        assertEquals(teacher, serviceTeacher.find(id));
    }

    @Test
    public void addHeadOfDepartmentTest() {
        serviceHeadOdDepartment.save(headOfDepartment);
        int id = headOfDepartment.getTeacherId();
        assertEquals(headOfDepartment, serviceHeadOdDepartment.find(id));
    }


    @Test
    public void getTeacherAndHeadOfDepartmentTest() {
        serviceTeacher.save(teacher);
        int idTeacher = teacher.getTeacherId();
        serviceHeadOdDepartment.save(headOfDepartment);
        int idHeader = headOfDepartment.getTeacherId();
        List<Teacher> teacherList = Arrays.asList(teacher, headOfDepartment);
        List<Teacher> teachersFromBD = new ArrayList<>();
        teachersFromBD.add(serviceTeacher.find(idTeacher));
        teachersFromBD.add(serviceTeacher.find(idHeader));
        assertEquals(teacherList, teachersFromBD);
    }
}