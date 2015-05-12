package social.posts;

import org.junit.Test;
import social.posts.Post;
import social.posts.PostCommand;
import social.posts.Posts;

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
