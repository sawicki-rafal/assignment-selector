package com.sawicki.rafal.assignmentselector;

import com.sawicki.rafal.assignmentselector.model.Person;

import java.util.*;
import java.util.stream.Stream;

public class Assigner {
    private List<Person> peopleList;
    private int peopleCounter;
    private int peopleAmount;

    public Map<Integer, Person> assign(final Collection<Person> people, final Stream<Integer> assignments) {
        initialize(people);
        Collections.shuffle(peopleList);
        final Map<Integer, Person> result = new HashMap<>();

        assignments.forEach(assignmentNumber -> {
            result.put(assignmentNumber, getNextPerson());
        });

        return result;
    }

    private void initialize(final Collection<Person> people) {
        peopleList = new ArrayList<>(people);
        peopleCounter = 0;
        peopleAmount = peopleList.size();
    }

    private Person getNextPerson() {
        int nextPersonIndex = (peopleCounter++) % peopleAmount;
        return peopleList.get(nextPersonIndex);
    }
}
