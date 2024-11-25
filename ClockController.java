import java.time.LocalTime;

public class ClockController {
    private ClockPanel clockPanel;
    private LocalTime currentTime;

    public ClockController(ClockPanel clockPanel) {
        this.clockPanel = clockPanel;
        this.currentTime = LocalTime.now();
        updateClock();
    }

    public void increaseHour() {
        currentTime = currentTime.plusHours(1);
        updateClock();
    }

    public void decreaseHour() {
        currentTime = currentTime.minusHours(1);
        updateClock();
    }

    public void increaseMinute() {
        currentTime = currentTime.plusMinutes(1);
        updateClock();
    }

    public void decreaseMinute() {
        currentTime = currentTime.minusMinutes(1);
        updateClock();
    }

    private void updateClock() {
        clockPanel.setTime(currentTime);
    }
}