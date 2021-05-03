package com.jazzteam.borisov.service.buildservice;

import com.jazzteam.borisov.AppConfig;
import com.jazzteam.borisov.exception.NonAffiliationException;
import com.jazzteam.borisov.models.build.Audience;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.models.build.ParameterAudience;
import com.jazzteam.borisov.models.person.Dean;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ServiceAudienceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Autowired
    private ServiceAudience serviceAudience;
    @Autowired
    private ServiceParameterAudience serviceParameterAudience;
    private Audience audience;
    private ParameterAudience parameterAudience;

    @Before
    public void setUp() {
        Dean dean = new Dean("Vasili");
        dean.setPosition("Dean");
        Faculty faculty = new Faculty("Nanomechanics and Nanobiology Faculty");
        audience = new Audience("100a", 25);
        audience.setFaculty(faculty);
        faculty.getAudiences().add(audience);
        parameterAudience = new ParameterAudience("Standart");
    }

    @Test
    public void createAudienceServiceObjectTest() {
        assertNotNull(serviceAudience);
    }

    @Test
    public void addAudienceTest() {
        audience.getParameterAudienceList().add(parameterAudience);
        parameterAudience.getAudienceList().add(audience);
        serviceAudience.save(audience);
        int id = audience.getAudienceId();
        assertEquals(audience, serviceAudience.find(id));
    }

    @Test
    public void addAudienceWithoutParameterTest() {
        serviceAudience.save(audience);
        int id = audience.getAudienceId();
        assertEquals(audience, serviceAudience.find(id));
    }

    @Test
    public void addParameterTest() {

        serviceParameterAudience.save(parameterAudience);
        int id = parameterAudience.getParameterId();
        assertEquals(parameterAudience, serviceParameterAudience.find(id));
    }

    @Test
    public void deleteAudienceTest() {
        serviceAudience.save(audience);
        int id = audience.getAudienceId();
        serviceAudience.delete(id);
        assertNull(serviceAudience.find(id));
    }

    @Test
    public void updateFacultyTest() {
        serviceAudience.save(audience);
        int id = audience.getAudienceId();
        audience.getParameterAudienceList().add(parameterAudience);
        parameterAudience.getAudienceList().add(audience);
        serviceAudience.update(audience);
        assertEquals(audience, serviceAudience.find(id));
    }

    @Test
    public void addAudienceDepartmentAnotherFacultyTest() {
        thrown.expect(NonAffiliationException.class);
        Department departmentAnother = new Department("Mathematical Department");
        Faculty facultyMath = new Faculty("Math");
        facultyMath.getDepartments().add(departmentAnother);
        departmentAnother.setFaculty(facultyMath);
        audience.setDepartment(departmentAnother);
    }
}