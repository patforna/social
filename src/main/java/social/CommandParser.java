package social;

import java.time.Clock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class CommandParser {

    private static final Pattern POST_PATTERN = compile("^(\\w+)\\s->\\s(.+)$");

    private static final Pattern READ_PATTERN = compile("^(\\w+)$");

    private final Posts posts;
    private final Clock clock;

    public CommandParser(Posts posts, Clock clock) {
        this.posts = posts;
        this.clock = clock;
    }

    public Command parse(String input) {
        Matcher matcher = POST_PATTERN.matcher(input);
        if (matcher.matches())
            return new PostCommand(posts, clock, matcher.group(1), matcher.group(2));

        matcher = READ_PATTERN.matcher(input);
        if (matcher.matches())
            return new ReadCommand(posts, matcher.group(1));

        throw new IllegalArgumentException("Unknown command: " + input);
    }
}
