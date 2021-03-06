package social.posts;

import org.junit.Test;
import social.posts.Post;
import social.posts.Posts;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static social.Helpers.now;

public class PostsTest {

    private Posts posts = new Posts();
    private String user = "alice", message = "likes candy", messageTwo = "likes kiwi";
    private Post p1 = new Post(now, user, message);
    private Post p2 = new Post(now, user, messageTwo);

    @Test
    public void shouldSaveAndReadPosts() {
        posts.save(p1);
        assertThat(posts.find(user), hasItems(p1));
    }

    @Test
    public void shouldSaveAndReadMultiplePosts() {
        posts.save(p1);
        posts.save(p2);
        assertThat(posts.find(user), hasItems(p1, p2));
    }

    @Test
    public void shouldReturnEmptyListIfNoPosts() {
        assertThat(posts.find(user).size(), is(0));
    }
}