package social;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static social.Helpers.now;

public class PostTest {

    @Test
    public void shouldShowMessageAndPrettyTime() {
        assertThat(postAgo(5).toString(), is("msg (moments ago)"));
        assertThat(postAgo(1 * 60).toString(), is("msg (1 minute ago)"));
        assertThat(postAgo(2 * 60).toString(), is("msg (2 minutes ago)"));
    }

    private Post postAgo(int secondsAgo) {
        return new Post(now.minusSeconds(secondsAgo), "", "msg");
    }

}