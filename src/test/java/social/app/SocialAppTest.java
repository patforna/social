package social.app;

import org.junit.Test;
import social.app.Command;
import social.app.CommandParser;
import social.app.Serializer;
import social.app.SocialApp;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SocialAppTest {

    private CommandParser parser = mock(CommandParser.class);

    private Command command = mock(Command.class);

    private Serializer serializer = mock(Serializer.class);

    private SocialApp app = new SocialApp(parser, serializer);

    @Test
    public void shouldParseInputAndExecuteCommand() throws Exception {
        when(parser.parse("foo")).thenReturn(command);
        run("foo");
        verify(command).execute();
    }

    @Test
    public void shouldSerialiseOutput() throws Exception {
        when(command.execute()).thenReturn("bar");
        when(parser.parse(any())).thenReturn(command);
        when(serializer.serialize("bar")).thenReturn("baz");
        assertThat(run("foo"), is("baz"));
    }

    // FIXME DRY
    private String run(String command) throws Exception {
        StringWriter out = new StringWriter();
        app.run(new StringReader(command + "\n"), new PrintWriter(out));
        return out.toString().trim();
    }
}
