package lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Diana", Arrays.asList(new Course("CS"), new Course("Management"),
                new Course("Farming"))));
        students.add(new Student("Anatoly", Arrays.asList(new Course("CS"), new Course("Math"))));
        students.add(new Student("Pavel", Arrays.asList(new Course("Testing"), new Course("Squash"),
                new Course("Speaking"), new Course("Drawing"), new Course("CS"))));
        students.add(new Student("Masha", Collections.singletonList(new Course("Testing"))));

        System.out.println(students.stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        Course course = new Course("CS");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
