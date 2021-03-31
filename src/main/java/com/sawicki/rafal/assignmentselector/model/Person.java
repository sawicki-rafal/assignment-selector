package com.sawicki.rafal.assignmentselector.model;

import java.util.Objects;

public class Person {

    private static int idCounter = 0;

    private final int id = idCounter++;

    private final String name;

    public Person(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
