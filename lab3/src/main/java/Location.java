import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    private String name;
    protected Map<Location, Integer> costMap = new HashMap<>();

    public void setCost(Location location, int cost) {
        costMap.put(location, cost);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
