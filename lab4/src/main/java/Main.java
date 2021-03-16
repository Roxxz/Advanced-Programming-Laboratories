import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Student[] students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student(i)).toArray(Student[]::new);
        HighSchool[] highSchool = IntStream.rangeClosed(0, 2).mapToObj(i -> new HighSchool(i)).toArray(HighSchool[]::new);

        List<Student> studentsList = new LinkedList<>();
        studentsList.addAll(Arrays.asList(students));

        Set<HighSchool> highSchoolsSet = new TreeSet<>();
        highSchoolsSet.addAll(Arrays.asList(highSchool));

        List<Student> newSortedStudentsList = studentsList.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());

        Map<Student, List<HighSchool>> studentsInformation = new HashMap<>();
        studentsInformation.put(students[0], Arrays.asList(highSchool[0], highSchool[1], highSchool[2]));
        studentsInformation.put(students[1], Arrays.asList(highSchool[0], highSchool[1], highSchool[2]));
        studentsInformation.put(students[2], Arrays.asList(highSchool[0], highSchool[1]));
        studentsInformation.put(students[3], Arrays.asList(highSchool[0], highSchool[2]));

        studentsInformation.forEach((key, value) -> System.out.println(key + ":" + value));

        Map<HighSchool, List<Student>> highSchoolInformation = new HashMap<>();
        highSchoolInformation.put(highSchool[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        highSchoolInformation.put(highSchool[1], Arrays.asList(students[0], students[1], students[2]));
        highSchoolInformation.put(highSchool[2], Arrays.asList(students[0], students[1], students[3]));

        highSchoolInformation.forEach((key, value) -> System.out.println(key + ":" + value));

        System.out.println("The students who accept highSchools 0, 1 and 2 are: ");
        System.out.println(Arrays.toString(studentsList.stream().filter(e -> studentsInformation.get(e).contains(highSchool[0])
                && studentsInformation.get(e).contains(highSchool[1])
                && studentsInformation.get(e).contains(highSchool[2])).toArray()));

        System.out.println("The highSchools who have student 0 as their top preference are:");
        System.out.println(Arrays.toString(highSchoolsSet.stream().filter(std -> highSchoolInformation.get(std).contains(students[0])).toArray()));

        Faker faker = new Faker();
        for(Student s : students){ s.setName(faker.name().fullName()); }
        for(HighSchool h : highSchool){ h.setName(faker.university().name()); }

        Problem problem = new Problem();
        Solution solution = new Solution(problem);
        List<HighSchool> highSchoolsList = new ArrayList<>(highSchoolsSet);
        solution.getMatching(studentsList, highSchoolsList);
    }
}
