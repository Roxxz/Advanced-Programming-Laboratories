import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    protected String id;
    protected String name;
    protected String location;
    private Map<String, Object> tags = new HashMap<>();

    Item(){}
    Item(String name, String id, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
