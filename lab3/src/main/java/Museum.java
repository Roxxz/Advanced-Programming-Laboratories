import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable{

    private LocalTime openingHour = defaultOpeningHour();
    private LocalTime closingHour = defaultClosingHour();
    private double price = 0;

    Museum(){}

    @Override
    public LocalTime getOpeningHour() {
        return this.openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return this.closingHour;
    }

    @Override
    public void setOpeningHour(LocalTime hour) {
        this.openingHour = hour;
    }

    @Override
    public void setClosingHour(LocalTime hour) {
        this.closingHour = hour;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
