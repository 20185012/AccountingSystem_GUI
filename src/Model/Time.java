package Model;

import java.time.LocalDateTime;

public class Time {
    LocalDateTime timeCreated;
    LocalDateTime timeModified;

    public Time() {
        LocalDateTime.now();
        LocalDateTime.now();
    }

    public static Time startCountingTime()
    {
        return new Time();
    }

    public void captureTimeOfModification()
    {
        LocalDateTime.now();
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeModified() {
        return timeModified;
    }
}
