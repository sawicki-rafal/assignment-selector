package com.sawicki.rafal.assignmentselector;

import com.sawicki.rafal.assignmentselector.model.Person;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.ArgGroup;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Command(name = "Assignment selector", mixinStandardHelpOptions = true, version = "1.0")
public class App implements Callable<Integer> {

    @Option(names = {"-p", "--people"}, arity = "1..*", required = true,
            description = "Names of peoples separated by space.")
    private String[] peopleNames;

    @ArgGroup(multiplicity = "1")
    private ExercisesNumbers exercisesNumbers;

    static class ExercisesNumbers {
        @Option(names = {"-r", "--range"}, required = true, split = "-", arity = "1",
                description = "Range of the exercises, boundaries inclusive. From and to value separated by dash (-).")
        Integer[] exercisesRange;

        @Option(names = {"-s", "--set"}, required = true, arity = "1..*",
                description = "Set of exercises. Values separated by space.")
        Integer[] exercises;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {

        final Stream<Integer> exercisesStream = getExercisesStream();

        final List<Person> peopleList = Arrays.stream(peopleNames)
                .map(Person::new)
                .collect(Collectors.toList());

        final Map<Integer, Person> assignMap = new Assigner().assign(peopleList, exercisesStream);

        final Map<Person, List<Integer>> collect = assignMap.keySet().stream()
                .collect(Collectors.groupingBy(assignMap::get));

        System.out.println(collect);

        return 0;
    }

    private Stream<Integer> getExercisesStream() {
        if (exercisesNumbers.exercisesRange != null) {
            return IntStream.rangeClosed(exercisesNumbers.exercisesRange[0], exercisesNumbers.exercisesRange[1]).boxed();
        } else {
            return Arrays.stream(exercisesNumbers.exercisesRange);
        }
    }


}
