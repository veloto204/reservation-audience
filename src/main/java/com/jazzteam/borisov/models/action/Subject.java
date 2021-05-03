package com.jazzteam.borisov.models.action;

import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import com.jazzteam.borisov.models.person.Group;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    @Column(name = "name")
    private String name;
    @OneToMany(
            mappedBy = "subject",
            cascade = CascadeType.ALL
    )
    private Set<TeacherHasSubject> teachers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_departmentId")
    private Department department;

    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
    private List<Group> groups;

    public Subject(String name) {
        this.name = name;
        teachers = new HashSet<>();
        groups = new ArrayList<>();
    }

    public Subject() {
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TeacherHasSubject> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherHasSubject> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId &&
                Objects.equals(name, subject.name) &&
                Objects.equals(department, subject.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, name, department);
    }
}
