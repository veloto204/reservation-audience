package com.jazzteam.borisov.models.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jazzteam.borisov.models.build.Department;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Inheritance(strategy = InheritanceType.JOINED)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int teacherId;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_departmentId")
    private Department department;
    @JsonBackReference
    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL)
    private Set<TeacherHasSubject> subjects;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
        subjects = new HashSet<>();
    }

    public Teacher(String name, String position, String login, String password) {
        this.name = name;
        this.position = position;
        this.login = login;
        this.password = password;
        subjects = new HashSet<>();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Set<TeacherHasSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<TeacherHasSubject> subjects) {
        this.subjects = subjects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, name);
    }
}
