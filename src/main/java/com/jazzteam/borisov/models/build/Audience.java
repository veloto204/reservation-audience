package com.jazzteam.borisov.models.build;

import com.jazzteam.borisov.exception.NonAffiliationException;
import com.jazzteam.borisov.models.booking.Booking;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "audience")
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int audienceId;
    @Column(name = "audience_number")
    private String number;
    @Column(name = "number_of_places")
    private int numberOfPlaces;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId")
    private Department department;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "audienceHasParameters",
            joinColumns = {@JoinColumn(name = "audienceId")},
            inverseJoinColumns = {@JoinColumn(name = "parameterId")}
    )
    private Set<ParameterAudience> parameterAudienceList;

    @OneToMany(mappedBy = "audiences", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Booking> bookings;

    public Audience() {
    }

    public Audience(String number, int numberOfPlaces) {
        this.number = number;
        this.numberOfPlaces = numberOfPlaces;
        parameterAudienceList = new HashSet<>();
        bookings = new HashSet<>();
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(int audienceId) {
        this.audienceId = audienceId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (department.getFaculty().equals(this.faculty)) {
            this.department = department;
        } else {
            throw new NonAffiliationException();
        }
    }

    public Set<ParameterAudience> getParameterAudienceList() {
        return parameterAudienceList;
    }

    public void setParameterAudienceList(Set<ParameterAudience> parameterAudienceList) {
        this.parameterAudienceList = parameterAudienceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audience audience = (Audience) o;
        return audienceId == audience.audienceId &&
                numberOfPlaces == audience.numberOfPlaces &&
                Objects.equals(number, audience.number) &&
                Objects.equals(faculty, audience.faculty) &&
                Objects.equals(department, audience.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(audienceId, number, numberOfPlaces, faculty, department);
    }
}
