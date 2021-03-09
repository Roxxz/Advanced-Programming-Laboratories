import java.time.LocalTime;

public class Church extends Location implements Visitable{
    private LocalTime openingHour = defaultOpeningHour();
    private LocalTime closingHour = defaultClosingHour();

    Church(){}

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
}
