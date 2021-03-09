public class Main {
    public static void main(String[] args) {
        Student s0 = new Student(0);
        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(3);

        Highschool h0 = new Highschool(0);
        Highschool h1 = new Highschool(1);
        Highschool h2 = new Highschool(2);

        s0.addHighschool(h0);
        s0.addHighschool(h1);
        s0.addHighschool(h2);

        s1.addHighschool(h0);
        s1.addHighschool(h1);
        s1.addHighschool(h2);

        s2.addHighschool(h0);
        s2.addHighschool(h1);

        s3.addHighschool(h0);
        s3.addHighschool(h2);

        h0.addStudent(s3);
        h0.addStudent(s0);
        h0.addStudent(s1);
        h0.addStudent(s2);

        h1.addStudent(s0);
        h1.addStudent(s1);
        h1.addStudent(s2);

        h2.addStudent(s0);
        h2.addStudent(s1);
        h2.addStudent(s3);


    }
}
