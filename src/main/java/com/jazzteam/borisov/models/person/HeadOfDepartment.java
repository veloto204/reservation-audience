package com.jazzteam.borisov.models.person;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "head_of_department")
public class HeadOfDepartment extends Teacher {
    public HeadOfDepartment() {
    }

    public HeadOfDepartment(String name, String position, String login, String password) {
        super(name, position, login, password);
    }

    public HeadOfDepartment(String name) {
        super(name);
    }
}
