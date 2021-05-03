package com.jazzteam.borisov.service.buildservice;

import com.jazzteam.borisov.AppConfig;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.models.person.Dean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ServiceFacultyTest {

    @Autowired
    private ServiceFaculty serviceFaculty;
    private Dean dean;
    private Faculty faculty;

    @Before
    public void setUp() {
        dean = new Dean("Vasili");
        dean.setPosition("Dean");
        faculty = new Faculty("Nanomechanics and Nanobiology Faculty");
    }

    @Test
    public void createFacultyServiceObjectTest() {
        assertNotNull(serviceFaculty);
    }

    @Test
    public void addFacultyTest() {
        serviceFaculty.save(faculty);
        int id = faculty.getFacultyId();
        assertEquals(faculty, serviceFaculty.find(id));
    }

    @Test
    public void deleteFacultyTest() {
        serviceFaculty.save(faculty);
        int id = faculty.getFacultyId();
        serviceFaculty.delete(id);
        assertNull(serviceFaculty.find(id));
    }

    @Test
    public void updateFacultyTest() {
        serviceFaculty.save(faculty);
        int id = faculty.getFacultyId();
        faculty.setDean(dean);
        serviceFaculty.update(faculty);
        assertEquals(faculty, serviceFaculty.find(id));
    }
}