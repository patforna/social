package social;

import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static social.Helpers.clock;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AcceptanceTests {

    private SocialApp app = new SocialApp(new CommandParser(new Posts(), clock), new Serializer());

    @Test
    public void shouldBeAbleToPostAndRead() throws Exception {
        run("Alice -> I love the weather today");
        run("Bob -> Damn! We lost!");
        run("Bob -> Good game though.");

        assertThat(run("Alice"), is("I love the weather today (moments ago)"));
        assertThat(run("Bob"), is("Damn! We lost! (moments ago)\nGood game though. (moments ago)"));
    }
    
    private String run(String command) throws Exception {
        StringWriter out = new StringWriter();
        app.run(new StringReader(command + "\n"), new PrintWriter(out));
        return out.toString().trim();
    }
}
