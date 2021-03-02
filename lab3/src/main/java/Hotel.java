import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String name;
    private Map<String, Integer> map = new HashMap<>();

    Hotel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMap(String location, int cost){
        map.put(location, cost);
    }

    public void printMapHotel() {
        Museum.printAll(map, name);
    }
}
