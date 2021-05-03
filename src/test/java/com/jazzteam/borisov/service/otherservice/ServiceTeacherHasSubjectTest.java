package com.jazzteam.borisov.service.otherservice;

import com.jazzteam.borisov.AppConfig;
import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import com.jazzteam.borisov.models.person.Dean;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import com.jazzteam.borisov.service.actionservice.ServiceSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ServiceTeacherHasSubjectTest {

    @Autowired
    private ServiceTeacherHasSubject serviceTeacherHasSubject;
    @Autowired
    private ServiceSubject serviceSubject;
    private HeadOfDepartment headOfDepartment;
    private TeacherHasSubject teacherHasSubject;
    private Dean dean;
    private Subject subject;

    @Before
    public void setUp() {
        dean = new Dean("Vasili");
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
        teacherHasSubject = new TeacherHasSubject(headOfDepartment, serviceSubject.find(16));
        subject.getTeachers().add(teacherHasSubject);
        headOfDepartment.getSubjects().add(teacherHasSubject);
    }

    @Test
    public void createTeacherHasSubjectServiceObjectTest() {
        assertNotNull(serviceTeacherHasSubject);
    }

    @Test
    public void addTeacherHasSubjectTest() {
        serviceSubject.save(subject);
        int id = teacherHasSubject.getTeaSubId();
        assertEquals(teacherHasSubject, serviceTeacherHasSubject.find(id));
    }

    @Test
    public void deleteTeacherHasSubjectTest() {
        serviceSubject.save(subject);
        int id = teacherHasSubject.getTeaSubId();
        serviceTeacherHasSubject.delete(id);
        assertNull(serviceTeacherHasSubject.find(id));
    }

    @Test
    public void updateTeacherHasSubjectTest() {
        serviceSubject.save(subject);
        int id = teacherHasSubject.getTeaSubId();
        teacherHasSubject.setTeacher(dean);
        subject.getTeachers().add(teacherHasSubject);
        dean.getSubjects().add(teacherHasSubject);
        headOfDepartment.getSubjects().clear();
        serviceTeacherHasSubject.update(teacherHasSubject);
        assertEquals(teacherHasSubject, serviceTeacherHasSubject.find(id));
    }

}