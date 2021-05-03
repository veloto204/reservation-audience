package com.jazzteam.borisov.service.actionservice;

import com.jazzteam.borisov.AppConfig;
import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
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
public class ServiceSubjectTest {

    @Autowired
    private ServiceSubject serviceSubject;
    private HeadOfDepartment headOfDepartment;
    private Subject subject;

    @Before
    public void setUp() {
        Dean dean = new Dean("Vasili");
        dean.setPosition("Dean");
        headOfDepartment = new HeadOfDepartment("Andre");
        headOfDepartment.setPosition("Head Of Department");
        Faculty faculty = new Faculty("Nanomechanics and Nanobiology Faculty");
        Department department = new Department("Common Physics");
        faculty.getDepartments().add(department);
        faculty.setDean(dean);
        department.setFaculty(faculty);
        department.setHeadOfDepartment(headOfDepartment);
        headOfDepartment.setDepartment(department);
        subject = new Subject("Mechanics");
        department.getSubjects().add(subject);
        subject.setDepartment(department);
    }

    @Test
    public void createSubjectServiceObjectTest() {
        assertNotNull(serviceSubject);
    }

    @Test
    public void addSubjectTest() {
        serviceSubject.save(subject);
        int id = subject.getSubjectId();
        assertEquals(subject, serviceSubject.find(id));
    }

    @Test
    public void deleteSubjectTest() {
        serviceSubject.save(subject);
        int id = subject.getSubjectId();
        serviceSubject.delete(id);
        assertNull(serviceSubject.find(id));
    }

    @Test
    public void updateSubjectTest() {
        serviceSubject.save(subject);
        int id = subject.getSubjectId();
        TeacherHasSubject teacherHasSubject = new TeacherHasSubject(headOfDepartment, subject);
        subject.getTeachers().add(teacherHasSubject);
        headOfDepartment.getSubjects().add(teacherHasSubject);
        serviceSubject.update(subject);
        assertEquals(subject, serviceSubject.find(id));
    }
}