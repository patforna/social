package social.app;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SocialAppTest {

    private CommandParser parser = mock(CommandParser.class);

    private Command command = mock(Command.class);

    private Serializer serializer = mock(Serializer.class);

    private SocialApp app = new SocialApp(parser, serializer, false);

    @Test
    public void shouldParseInputAndExecuteCommand() throws Exception {
        when(parser.parse("foo")).thenReturn(command);
        app.run("foo");
        verify(command).execute();
    }

    @Test
    public void shouldSerialiseOutput() throws Exception {
        when(command.execute()).thenReturn("bar");
        when(parser.parse(any())).thenReturn(command);
        when(serializer.serialize("bar")).thenReturn("baz");
        assertThat(app.run("foo"), is("baz"));
    }
}
