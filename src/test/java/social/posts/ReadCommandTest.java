package social.posts;

import org.junit.Test;
import social.posts.Post;
import social.posts.Posts;
import social.posts.ReadCommand;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static social.Helpers.now;

public class ReadCommandTest {

    private Posts posts = mock(Posts.class);

    private ReadCommand cmd = new ReadCommand(posts, "user");

    @Test
    public void shouldReadPosts() {
        Post p1 = new Post(now, "user", "m1");
        Post p2 = new Post(now, "user", "m2");

        when(posts.find("user")).thenReturn(asList(p1, p2));

        assertThat(cmd.execute(), hasItems(p1, p2));
    }

}