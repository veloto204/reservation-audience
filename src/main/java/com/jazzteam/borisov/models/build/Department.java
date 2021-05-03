package com.jazzteam.borisov.models.build;

import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.models.person.HeadOfDepartment;
import com.jazzteam.borisov.models.person.Teacher;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Teacher> teachers;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "head_Of_Department_Teacher_HeaderId")
    private HeadOfDepartment headOfDepartment;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_FacultyId")
    private Faculty faculty;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Audience> audiences;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
        teachers = new ArrayList<>();
        subjects = new HashSet<>();
        audiences = new HashSet<>();
    }

    public Set<Audience> getAudiences() {
        return audiences;
    }

    public void setAudiences(Set<Audience> audiences) {
        this.audiences = audiences;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public HeadOfDepartment getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(HeadOfDepartment headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public int getId() {
        return departmentId;
    }

    public void setId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        teacher.setDepartment(this);
        teachers.add(teacher);
    }

    public void removeAuto(Teacher teacher) {
        teachers.remove(teacher);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId &&
                Objects.equals(name, that.name) &&
                Objects.equals(headOfDepartment, that.headOfDepartment) &&
                Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, name, headOfDepartment, faculty);
    }
}
