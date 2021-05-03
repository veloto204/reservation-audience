package com.jazzteam.borisov.service;

import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.models.booking.Booking;
import com.jazzteam.borisov.models.booking.Lesson;
import com.jazzteam.borisov.models.build.Audience;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.build.Faculty;
import com.jazzteam.borisov.models.build.ParameterAudience;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import com.jazzteam.borisov.models.person.Dean;
import com.jazzteam.borisov.models.person.Group;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import com.jazzteam.borisov.models.person.Teacher;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

@SuppressWarnings("unchecked")
public class FacultyTest {
    Teacher teacher1 = new Teacher("Edward");
    Teacher teacher2 = new Teacher("Alex");
    Teacher teacher3 = new Teacher("Sonya");
    Subject subject1 = new Subject("Math");
    Subject subject2 = new Subject("Physics");
    Department department = new Department("First");
    Faculty faculty = new Faculty("Nanomechanics and Nanobiology Faculty");
    Dean dean = new Dean("Vasili");
    Service departmentService = new Service(Department.class);
    Service teacherService = new Service(Teacher.class);
    Service headService = new Service(HeadOfDepartment.class);
    Service deanService = new Service(Dean.class);
    Service facultyService = new Service(Faculty.class);
    Service groupService = new Service(Group.class);
    Service dateService = new Service(Lesson.class);
    HeadOfDepartment headOfDepartment = new HeadOfDepartment("Andre");
    Group group = new Group(1);
    Audience audience = new Audience("101", 20);
    ParameterAudience parameterAudience = new ParameterAudience("Standart");
    Lesson date = new Lesson();
    Service bookingS = new Service(Booking.class);

    @Test
    @Ignore
    public void addTest() {
        date.setNumberLesson(1);
        faculty.setDean(dean);
        //Calendar HMS = new GregorianCalendar();
        //HMS.set(Calendar.HOUR_OF_DAY, 8);
        //HMS.set(Calendar.MINUTE, 45);
        //HMS.set(Calendar.SECOND,0);
        date.setStartTime(LocalTime.of(8, 45, 0, 0));
        date.setFinishTime(LocalTime.of(9, 45, 0, 0));
        //date.setStartTime(new Time(8,15,0));
        //date.setFinishTime(new Time(9,50,0));
        //date.getStartTime().set(Calendar.SECOND, HMS.get(Calendar.SECOND));
        //System.out.println(date.getStartTime().getTime());
        date.setFaculty(faculty);
        dean.setPosition("Dean");
        faculty.getLessons().add(date);
        //System.out.println(date.getStartTime().getTime());
        faculty.getDepartments().add(department);
        faculty.getAudiences().add(audience);
        audience.getParameterAudienceList().add(parameterAudience);
        parameterAudience.getAudienceList().add(audience);
        audience.setFaculty(faculty);
        faculty.getDepartments().add(department);
        subject1.setDepartment(department);
        department.getSubjects().add(subject1);
        group.setStudentGroup(4);
        group.setSubjects(Collections.singletonList(subject1));
        subject1.setGroups(Collections.singletonList(group));
        department.setTeachers(Arrays.asList(headOfDepartment, teacher1, dean, teacher2));
        dean.setDepartment(department);
        headOfDepartment.setDepartment(department);
        teacher1.setDepartment(department);
        teacher2.setDepartment(department);
        department.setFaculty(faculty);
        department.setHeadOfDepartment(headOfDepartment);
        //deanService.save(dean);
        //headService.save(headOfDepartment);
        department.setFaculty(faculty);
        TeacherHasSubject teacherHasSubject = new TeacherHasSubject(teacher1, subject1);
        //TeacherHasSubject teacherHasSubject1 = new TeacherHasSubject(teacher1, subject2);
        //TeacherHasSubject teacherHasSubject2 = new TeacherHasSubject(teacher2, subject1);
        //TeacherHasSubject teacherHasSubject3 = new TeacherHasSubject(teacher2, subject2);
        subject1.getTeachers().add(teacherHasSubject);
        /*subject1.getTeachers().add( new TeacherHasSubject((Teacher) dean, subject1));
       subject1.getTeachers().add(new TeacherHasSubject((Teacher) headOfDepartment, subject1));
        subject1.getTeachers().add(new TeacherHasSubject(teacher2, subject1));*/

        teacher1.getSubjects().add(teacherHasSubject);
        Booking booking = new Booking();
        booking.setAudiences(audience);
        audience.getBookings().add(booking);
        booking.setDateTime(new GregorianCalendar(2020, Calendar.FEBRUARY, 10));
        booking.setLog("Hello World");
        booking.setTeacherHasSubject(teacherHasSubject);
        teacherHasSubject.getBookings().add(booking);
        booking.setLesson(date);
        date.getBooking().add(booking);
        //booking.getGroups().add()
        bookingS.save(booking);
        /*groupService.save(group);*/
      /*  dean.getSubjects().add(new TeacherHasSubject((Teacher) dean, subject1));
        headOfDepartment.getSubjects().add(new TeacherHasSubject((Teacher) headOfDepartment, subject1));
        teacher2.getSubjects().add(new TeacherHasSubject(teacher2, subject1));*/

        //subject1.setTeachers(Arrays.asList(teacherHasSubject, teacherHasSubject2));
        //subject2.setTeachers(Arrays.asList(teacherHasSubject1, teacherHasSubject3));
        //teacher1.setSubjects(Arrays.asList(teacherHasSubject, teacherHasSubject1));
        //teacher2.setSubjects(Arrays.asList(teacherHasSubject2, teacherHasSubject3));
        //subject2.setDepartment(department);

        //department.getSubjects().add(subject2);
        //facultyService.save(faculty);

        //departmentService.save(department);
        //deanService.save(dean);
        //faculty.setDean(dean);
        //faculty.setDepartments(Collections.singletonList(department));
        //facultyService.save(faculty);

        //departmentService.save(department);
        //headService.save(headOfDepartment);
        //assertEquals(3, faculty.getFacultyId());
        /*faculty.setDean(dean);
        department.setTeachers(Arrays.asList(headOfDepartment, teacher1, dean));
        dean.setDepartment((Department) departmentService.find(1));
        deanService.save(dean);
        headOfDepartment.setDepartment((Department) departmentService.find(1));*/
        //departmentService.save(department);
        //HeadOfDepartment headOfDepartment = new HeadOfDepartment("Andre");
        //department.setTeachers(Arrays.asList(headOfDepartment, teacher1));
        //headOfDepartment.setDepartment((Department) departmentService.find(1));
        //teacher1.setDepartment((Department) departmentService.find(1));
        //teacherService.save(teacher1);
        //headService.save(headOfDepartment);
    }
}