package social.app;

import social.friends.FollowCommand;
import social.friends.Friends;
import social.posts.PostCommand;
import social.posts.Posts;
import social.posts.ReadCommand;
import social.wall.Wall;
import social.wall.WallCommand;

import java.time.Clock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class CommandParser {

    private static final Pattern POST_PATTERN = compile("^(\\w+)\\s->\\s(.+)$");
    private static final Pattern READ_PATTERN = compile("^(\\w+)$");
    private static final Pattern FOLLOW_PATTERN = compile("^(\\w+)\\sfollows\\s(\\w+)$");
    private static final Pattern WALL_PATTERN = compile("^(\\w+)\\swall$");

    private final Posts posts;
    private final Friends friends;
    private final Wall wall;
    private final Clock clock;

    public CommandParser(Posts posts, Friends friends, Wall wall, Clock clock) {
        this.posts = posts;
        this.friends = friends;
        this.wall = wall;
        this.clock = clock;
    }

    public Command parse(String input) {
        Matcher matcher = POST_PATTERN.matcher(input);
        if (matcher.matches())
            return new PostCommand(posts, clock, matcher.group(1), matcher.group(2));

        matcher = READ_PATTERN.matcher(input);
        if (matcher.matches())
            return new ReadCommand(posts, matcher.group(1));

        matcher = FOLLOW_PATTERN.matcher(input);
        if (matcher.matches())
            return new FollowCommand(friends, matcher.group(1), matcher.group(2));

        matcher = WALL_PATTERN.matcher(input);
        if (matcher.matches())
            return new WallCommand(wall, matcher.group(1));

        throw new IllegalArgumentException("Unknown command: " + input);
    }
}
