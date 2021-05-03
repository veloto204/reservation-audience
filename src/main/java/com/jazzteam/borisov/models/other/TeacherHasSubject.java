package com.jazzteam.borisov.models.other;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.models.booking.Booking;
import com.jazzteam.borisov.models.person.Teacher;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teacherHasSubject")
public class TeacherHasSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "teaSubId")
    private int teaSubId;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "subjectId")
    private Subject subject;

    @OneToMany(mappedBy = "teacherHasSubject", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Booking> bookings;

    public TeacherHasSubject() {
    }

    public TeacherHasSubject(Teacher teacher, Subject subject) {
        this.teacher = teacher;
        this.subject = subject;
        bookings = new HashSet<>();
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getTeaSubId() {
        return teaSubId;
    }

    public void setTeaSubId(int teaSubId) {
        this.teaSubId = teaSubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherHasSubject that = (TeacherHasSubject) o;
        return teaSubId == that.teaSubId &&
                Objects.equals(teacher, that.teacher) &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher, subject, teaSubId);
    }
}
