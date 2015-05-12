package social.app;

import org.junit.Test;
import social.app.CommandParser;
import social.friends.FollowCommand;
import social.friends.Friends;
import social.posts.PostCommand;
import social.posts.Posts;
import social.posts.ReadCommand;
import social.wall.Wall;
import social.wall.WallCommand;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static social.Helpers.clock;

public class CommandParserTest {

    private Posts posts = mock(Posts.class);
    private Friends friends = mock(Friends.class);
    private Wall wall = mock(Wall.class);
    private CommandParser parser = new CommandParser(posts, friends, wall, clock);

    @Test
    public void shouldParsePostCommand() {
        assertThat(parser.parse("user -> a message"), instanceOf(PostCommand.class));
    }

    @Test
    public void shouldParseReadCommand() {
        assertThat(parser.parse("user"), instanceOf(ReadCommand.class));
    }

    @Test
    public void shouldParseFollowCommand() {
        assertThat(parser.parse("a follows b"), instanceOf(FollowCommand.class));
    }

    @Test
    public void shouldParseWallCommand() {
        assertThat(parser.parse("a wall"), instanceOf(WallCommand.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUnknownCommand() {
        parser.parse("foo bar");
    }
}
