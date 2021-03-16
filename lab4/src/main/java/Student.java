
public class Student {
    public int id;
    private String name;
    private double score;
    public boolean available = true;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    Student(int id){
        this.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + id + '}';
    }
}
