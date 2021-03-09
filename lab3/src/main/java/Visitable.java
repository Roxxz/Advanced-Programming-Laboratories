import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {

    default LocalTime defaultOpeningHour() {
        return LocalTime.of(9, 30);
    }

    default LocalTime defaultClosingHour() {
        return LocalTime.of(20, 0);
    }

    static Duration getVisitingDuration(Visitable location){
        LocalTime openingHour = location.getOpeningHour();
        LocalTime closingHour = location.getClosingHour();
        Duration duration = Duration.between(openingHour, closingHour);
        return  duration;
    }

    LocalTime getOpeningHour();
    LocalTime getClosingHour();

    void setOpeningHour(LocalTime hour);
    void setClosingHour(LocalTime hour);
}
