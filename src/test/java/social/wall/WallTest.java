package social.wall;

import org.junit.Test;
import social.friends.Friends;
import social.posts.Post;
import social.posts.Posts;
import social.wall.Wall;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static social.Helpers.now;

public class WallTest {

    private Friends friends = mock(Friends.class);
    private Posts posts = mock(Posts.class);
    private Wall wall = new Wall(friends, posts);

    private String ali = "ali";
    private String bob = "bob";
    private Post p1 = new Post(now, ali, "a-m1");
    private Post p2 = new Post(now, bob, "b-m1");
    private Post p3 = new Post(now, bob, "b-m2");

    @Test
    public void shouldSaveAndReadPosts() {
        when(friends.find(ali)).thenReturn(asList(bob));
        when(posts.find(ali)).thenReturn(asList(p1));
        when(posts.find(bob)).thenReturn(asList(p2, p3));

        assertThat(wall.find(ali), hasItems(p1, p2, p3));
    }
}