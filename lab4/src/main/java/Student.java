import java.util.ArrayList;
import java.util.List;

public class Student {
    private Integer id;
    private List<Highschool> highschoolPreferences;

    Student(int id){
        this.setHighschoolPreferences(new ArrayList<>());
        this.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Highschool> getHighschoolPreferences() {
        return highschoolPreferences;
    }

    public void setHighschoolPreferences(List<Highschool> highschoolPreferences) {
        this.highschoolPreferences = highschoolPreferences;
    }

    public void addHighschool(Highschool h){
        highschoolPreferences.add(h);
    }

    @Override
    public String toString() {
        String s = "[";
        for(Highschool h : highschoolPreferences){
            s = s + h.getId() + ',';
        }
        s = s + ']';
        return "Student{" +
                "id=" + id +
                ", highschoolPreferences=" + highschoolPreferences +
                '}';
    }
}
