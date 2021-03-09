import java.util.ArrayList;
import java.util.List;

public class Highschool implements Comparable{
    private Integer id;
    private List<Student> students = new ArrayList<>();

    Highschool(int id){
        this.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s){
        students.add(s);
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass() == Highschool.class){
            Highschool x = (Highschool) o;
            return this.id.compareTo(x.id);
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "[";
        for(Student r : students){
            s = s + r.getId() + ',';
        }
        s = s + ']';
        return "Highschool{" +
                "id=" + id +
                ", students=" + students +
                '}';
    }
}
