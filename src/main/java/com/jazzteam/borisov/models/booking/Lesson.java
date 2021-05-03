package com.jazzteam.borisov.models.booking;


import com.jazzteam.borisov.models.build.Faculty;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonId;
    @Column(name = "numberLesson")
    private int numberLesson;
    @Column(name = "startTime")
    private LocalTime startTime;
    @Column(name = "finishTime")
    private LocalTime finishTime;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Booking> booking;

    public Lesson() {
        booking = new HashSet<>();
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int dateId) {
        this.lessonId = dateId;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(int numberLesson) {
        this.numberLesson = numberLesson;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }
}
