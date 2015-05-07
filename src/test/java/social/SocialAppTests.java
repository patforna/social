package social;

import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SocialAppTests {

    private SocialApp app = new SocialApp();

    @Test
    @Ignore
    public void shouldBeAbleToPostAndRead() {
        run("Alice -> I love the weather today\n" +
                "Bob -> Damn! We lost!\n" +
                "Bob -> Good game though.\n");

        assertThat(run("Alice\n"), is("Good game though. (1 minute ago)\n"));
        assertThat(run("Bob\n"), is("Damn! We lost! (2 minutes ago)\n"));
    }

    private String run(String commands) {
        StringWriter out = new StringWriter();
        app.run(new StringReader(commands), new PrintWriter(out));
        return out.toString();
    }
}
