package com.jazzteam.borisov.models.booking;


import com.jazzteam.borisov.models.build.Audience;
import com.jazzteam.borisov.models.other.TeacherHasSubject;
import com.jazzteam.borisov.models.person.Group;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "audienceId")
    private Audience audiences;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "teaSubId")
    private TeacherHasSubject teacherHasSubject;

    @Column(name = "date")
    private Calendar dateTime;

    @ManyToMany(mappedBy = "bookingSet", cascade = CascadeType.ALL)
    private Set<Group> groups;

    @Column(name = "log")
    private String log;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "lessonId")
    private Lesson lesson;

    public Booking() {
        groups = new HashSet<>();
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public TeacherHasSubject getTeacherHasSubject() {
        return teacherHasSubject;
    }

    public void setTeacherHasSubject(TeacherHasSubject teacherHasSubject) {
        this.teacherHasSubject = teacherHasSubject;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Audience getAudiences() {
        return audiences;
    }

    public void setAudiences(Audience audiences) {
        this.audiences = audiences;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
