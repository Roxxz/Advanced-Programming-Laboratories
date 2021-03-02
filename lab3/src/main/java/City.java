import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<String> locationList = new ArrayList<>();

    City(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLocation(String location){
        locationList.add(location);
    }
}
