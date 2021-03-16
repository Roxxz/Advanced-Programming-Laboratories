
public class HighSchool implements Comparable<HighSchool>{
    public Integer id;
    private String name;
    private int capacity;

    HighSchool(int id){
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int compareTo(HighSchool o) {
        if(o.getClass() == HighSchool.class){
            HighSchool x = (HighSchool) o;
            return this.id.compareTo(x.id);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "HighSchool{" + id + '}';
    }
}
