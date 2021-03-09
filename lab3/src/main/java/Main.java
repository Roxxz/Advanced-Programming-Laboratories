import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Hotel location1 = new Hotel();
        Museum location2 = new Museum();
        Museum location3 = new Museum();
        Church location4 = new Church();
        Church location5 = new Church();
        Restaurant location6 = new Restaurant();
        Church location7 = new Church();

        location1.setName("Hotel");
        location1.setRank(5);

        location2.setName("Museum A");
        location2.setPrice(20.5);

        location3.setName("Museum B");
        location3.setPrice(15);

        location4.setName("Church A");
        location4.setOpeningHour(LocalTime.of(7, 0));
        location4.setClosingHour(LocalTime.of(21, 0));

        location5.setName("Church B");
        location5.setOpeningHour(LocalTime.of(8, 0));
        location5.setClosingHour(LocalTime.of(22, 0));

        location6.setName("Restaurant");
        location6.setRank(2);

        location7.setName("Church C");
        location7.setOpeningHour(LocalTime.of(6, 30));
        location7.setClosingHour(LocalTime.of(13, 0));

        location1.setCost(location2, 10);
        location1.setCost(location3, 50);
        location2.setCost(location3, 20);
        location2.setCost(location4, 20);
        location2.setCost(location5, 10);
        location3.setCost(location4, 20);
        location4.setCost(location5, 30);
        location4.setCost(location6, 10);
        location5.setCost(location6, 20);

        City c = new City();
        c.setCityName("Tokyo");
        c.addLocation(location1);
        c.addLocation(location2);
        c.addLocation(location3);
        c.addLocation(location4);
        c.addLocation(location5);
        c.addLocation(location6);
        c.addLocation(location7);

        TravelPlan plan = new TravelPlan(c);

        System.out.println(Visitable.getVisitingDuration(location4));
        System.out.println(location2.getClosingHour());
        System.out.println(location2.getPrice());
        System.out.println(location6.getRank());
        c.displayVisitableLocations();
        plan.displayPreferences();
    }
}
