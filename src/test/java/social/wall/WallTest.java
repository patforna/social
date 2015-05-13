package social.wall;

import org.junit.Test;
import social.friends.Friends;
import social.posts.Post;
import social.posts.Posts;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
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
    private Post a1 = new Post(now, ali, "a-m1");
    private Post b1 = new Post(now.minusSeconds(60), bob, "b-m1");
    private Post b2 = new Post(now.plusSeconds(60), bob, "b-m2");

    @Test
    public void shouldSaveAndListPostsInChronologicalOrder() {
        when(friends.find(ali)).thenReturn(asList(bob));
        when(posts.find(ali)).thenReturn(asList(a1));
        when(posts.find(bob)).thenReturn(asList(b1, b2));

        assertThat(wall.find(ali), is(asList(b1, a1, b2)));
    }
}