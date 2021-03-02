import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Museum {
    private String name;
    private Map<String, Integer> map = new HashMap<>();

    Museum(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMap(String location, int cost){
        map.put(location, cost);
    }

    public void printMapMuseum() {
        printAll(map, name);
    }

    static void printAll(Map<String, Integer> map, String name) {
        Set set = map.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(name + " to " + entry.getKey() + "-> " + entry.getValue());
            System.lineSeparator();
        }
    }
}
