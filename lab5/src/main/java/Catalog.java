import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    Catalog() {}
    Catalog(String path){
        this.name=null;
        this.path=path;
    }
    Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item... item) {
        Collections.addAll( getItems (), item);
    }

    public void list() {
        System.out.println("All multimedia items are:");
        System.out.println( Arrays.toString( this.getItems ().toArray()));}

    public Item findById(String id) {
        for (Item it : getItems ()) {
            if (it.getId().equals(id)) {
                return it;
            }
        }
        return null;
    }
}