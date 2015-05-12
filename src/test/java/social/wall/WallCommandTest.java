package social.wall;

import org.junit.Test;
import social.Helpers;
import social.posts.Post;
import social.wall.Wall;
import social.wall.WallCommand;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WallCommandTest {

    private Wall wall = mock(Wall.class);

    private WallCommand cmd = new WallCommand(wall, "user");

    @Test
    public void shouldLoadPosts() {
        List<Post> posts = asList(new Post(Helpers.now, "user", "msg"));
        when(wall.find("user")).thenReturn(posts);
        assertThat(cmd.execute(), is(posts));
    }

    @Test
    public void shouldMakeSurePostsDisplayUserName() {
        List<Post> posts = asList(new Post(Helpers.now, "user", "msg"));
        when(wall.find("user")).thenReturn(posts);
        assertThat(cmd.execute().get(0).toString(), startsWith("user - msg"));
    }

}