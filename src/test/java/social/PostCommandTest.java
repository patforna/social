package social;

import org.junit.Test;

import java.time.Instant;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static social.Helpers.clock;
import static social.Helpers.now;

public class PostCommandTest {

    private Posts posts = mock(Posts.class);

    private PostCommand cmd = new PostCommand(posts, clock, "user", "message");

    @Test
    public void shouldSavePost() {
        cmd.execute();
        verify(posts).save(new Post(now, "user", "message"));
    }
}
