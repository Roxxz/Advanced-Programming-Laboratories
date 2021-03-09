import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class City {

    private String cityName;
    public List<Location> locationList = new ArrayList<>();

    City(){}

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void addLocation(Location location){
        locationList.add(location);
    }

    /**
     * Adaug orele de deschidere de la locatiile visitable dar nu si payable la lista visitableHours
     * Sortez lista
     * Pentru fiecare ora din lista, parcurg lista de locatii si verific carei locatii, care indeplineste
     * conditiile de visitable but not payable, ii este corespunzatoare si afisez numele si ora respectivei locatii.
      */
    public void displayVisitableLocations(){
        List<LocalTime> visitableHours = new ArrayList<>();
        for(Location item : locationList){
            if(item instanceof Visitable && !(item instanceof Payable)){
                visitableHours.add(((Visitable) item).getOpeningHour());
            }
        }
        Collections.sort(visitableHours);
        System.out.println("The Visitable-but-not-Payable locations sorted by their opening hours are: ");
        for(LocalTime item1 : visitableHours){
            for(Location item2 : locationList){
                if(item2 instanceof Visitable && !(item2 instanceof Payable)) {
                    if(item1 == ((Visitable) item2).getOpeningHour()){
                        System.out.println(item2.getName() + " - " + item1);
                    }
                }
            }
        }
    }

}
