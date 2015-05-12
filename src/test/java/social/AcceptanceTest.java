package social;

import org.junit.Test;
import social.app.CommandParser;
import social.app.Serializer;
import social.app.SocialApp;
import social.friends.Friends;
import social.posts.Posts;
import social.wall.Wall;

import java.io.*;
import java.time.Clock;

import static java.time.Clock.offset;
import static java.time.Duration.ofMinutes;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static social.Helpers.clock;

public class AcceptanceTest {

    private final Clock twoMinsAgo = offset(clock, ofMinutes(-2));
    private final Posts posts = new Posts();
    private final Friends friends = new Friends();
    private final Wall wall = new Wall(friends, posts);
    private final CommandParser parser = new CommandParser(posts, friends, wall, twoMinsAgo);
    private final Serializer serializer = new Serializer();
    private final SocialApp app = new SocialApp(parser, serializer, false);

    @Test
    public void shouldBeAbleToReadPosts() throws Exception {
        run("Alice -> I love the weather today");
        run("Bob -> Damn! We lost!");
        run("Bob -> Good game though.");

        assertThat(run("Alice"), is("I love the weather today (2 minutes ago)"));
        assertThat(run("Bob"), is("Damn! We lost! (2 minutes ago)\nGood game though. (2 minutes ago)"));
    }

    @Test
    public void shouldBeAbleToReadWall() throws Exception {
        run("Alice -> I love the weather today");
        run("Charlie -> I'm in New York today!");

        run("Charlie follows Alice");

        assertThat(run("Charlie wall"), is("Charlie - I'm in New York today! (2 minutes ago)\n"
                + "Alice - I love the weather today (2 minutes ago)"));
    }

    private String run(String command) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        app.run(new StringReader(command + "\n"), new PrintStream(out));
        return out.toString().trim();
    }
}
