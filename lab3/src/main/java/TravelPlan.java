import java.util.*;

public class TravelPlan {
    private City city;
    private List<Integer> preferencesList = new ArrayList<>();

    TravelPlan(City city){
        this.setCity(city);
        for (int preferenceIndex = 0; preferenceIndex < city.locationList.size(); preferenceIndex++){
            preferencesList.add(preferenceIndex + 1);
        }
        Collections.shuffle(preferencesList);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void displayPreferences(){
        System.out.println("The preferences regarding the visiting order are: ");
        for (int preferenceIndex = 0; preferenceIndex < city.locationList.size(); preferenceIndex++){
            System.out.println(city.locationList.get(preferenceIndex).getName() + " - " + preferencesList.get(preferenceIndex));
        }
    }
}
