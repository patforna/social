package social;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static social.Helpers.clock;

public class CommandParserTests {

    private Posts posts = new Posts();
    private CommandParser parser = new CommandParser(posts, clock);

    @Test
    public void shouldParsePostCommand() {
        assertThat(parser.parse("user -> a message"), is(new PostCommand(posts, clock, "user", "a message")));
    }

    @Test
    public void shouldParseReadCommand() {
        assertThat(parser.parse("user"), is(new ReadCommand(posts, "user")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUnknownCommand() {
        parser.parse("foo bar");
    }
}
