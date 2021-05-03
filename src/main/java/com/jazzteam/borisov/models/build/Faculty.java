package com.jazzteam.borisov.models.build;

import com.jazzteam.borisov.models.booking.Lesson;
import com.jazzteam.borisov.models.person.Dean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facultyId;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dean_Teacher_DeanId")
    private Dean dean;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Department> departments;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Audience> audiences;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Lesson> lessons;

    public Faculty(String name) {
        this.name = name;
        departments = new HashSet<>();
        audiences = new HashSet<>();
        lessons = new HashSet<>();
    }

    public Faculty() {
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Audience> getAudiences() {
        return audiences;
    }

    public void setAudiences(Set<Audience> audiences) {
        this.audiences = audiences;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dean getDean() {
        return dean;
    }

    public void setDean(Dean dean) {
        this.dean = dean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyId == faculty.facultyId &&
                Objects.equals(name, faculty.name) &&
                Objects.equals(dean, faculty.dean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, name, dean);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", name='" + name + '\'' +
                ", dean=" + dean +
                '}';
    }
}
