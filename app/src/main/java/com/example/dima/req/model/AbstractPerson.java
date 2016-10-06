package com.example.dima.req.model;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Index;
import io.requery.Key;

@Entity
abstract public class AbstractPerson {
    @Key @Generated
    int id;

    @Index("name_index")
    String name;
    String firstName;
    String lastName;
    String email;

    public String FIO(){
        return firstName + " " + lastName;
    }
}
