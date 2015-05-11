package social;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Helpers {

    /** A Clock that never changes - useful for testing */
    public static Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    /** An Instant that never changes - useful for testing */
    public static Instant now = Instant.now(clock);
}
