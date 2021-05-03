package com.jazzteam.borisov.models.person;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dean")
public class Dean extends Teacher {
    public Dean(String name, String position, String login, String password) {
        super(name, position, login, password);
    }

    public Dean() {
    }

    public Dean(String name) {
        super(name);
    }
}
