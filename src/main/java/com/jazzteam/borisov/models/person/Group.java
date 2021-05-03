package com.jazzteam.borisov.models.person;

import com.jazzteam.borisov.models.action.Subject;
import com.jazzteam.borisov.models.booking.Booking;

import javax.persistence.*;

@Entity
@Table(name = "groupCourse")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(name = "courseS")
    private int course;

    @Column(name = "studentGroup")
    private int studentGroup;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "groupHasSubject",
            joinColumns = {@JoinColumn(name = "groupId")},
            inverseJoinColumns = {@JoinColumn(name = "subjectId")}
    )
    private List<Subject> subjects;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "groupHasBooking",
            joinColumns = {@JoinColumn(name = "groupId")},
            inverseJoinColumns = {@JoinColumn(name = "bookingId")}
    )
    private Set<Booking> bookingSet;

    public Group() {
    }

    public Group(int course) {
        this.course = course;
        subjects = new ArrayList<>();
        bookingSet = new HashSet<>();
    }

    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set<Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(int studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupId == group.groupId &&
                course == group.course &&
                studentGroup == group.studentGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, course, studentGroup);
    }
}
