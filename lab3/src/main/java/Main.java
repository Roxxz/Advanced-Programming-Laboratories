public class Main {
    public static void main(String[] args) {

        Hotel v1 = new Hotel();
        Museum v2 = new Museum();
        Museum v3 = new Museum();
        Church v4 = new Church();
        Church v5 = new Church();
        Restaurant v6 = new Restaurant();

        v1.setName("Hotel");
        v2.setName("Museum A");
        v3.setName("Museum B");
        v4.setName("Church A");
        v5.setName("Church B");
        v6.setName("Restaurant");

        City city = new City();
        city.setName("Madrid");
        city.addLocation(v1.getName());
        city.addLocation(v2.getName());
        city.addLocation(v3.getName());
        city.addLocation(v4.getName());
        city.addLocation(v5.getName());
        city.addLocation(v6.getName());

        v1.addMap(v2.getName(), 10);
        v1.addMap(v3.getName(), 50);
        v2.addMap(v3.getName(), 20);
        v3.addMap(v2.getName(), 20);
        v2.addMap(v4.getName(), 20);
        v2.addMap(v5.getName(), 10);
        v3.addMap(v4.getName(), 20);
        v4.addMap(v5.getName(), 30);
        v5.addMap(v4.getName(), 30);
        v4.addMap(v6.getName(), 10);
        v5.addMap(v6.getName(), 20);

        v1.printMapHotel();
        v2.printMapMuseum();
        v3.printMapMuseum();
        v4.printMapChurch();
        v5.printMapChurch();
        v6.printMapRestaurant();
    }
}
