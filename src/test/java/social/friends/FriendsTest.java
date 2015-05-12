package social.friends;

import org.junit.Test;
import social.friends.Friends;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class FriendsTest {

    private Friends friends = new Friends();
    private String user = "user", friendOne = "f1", friendTwo = "f2";

    @Test
    public void shouldFollowMultipleFriends() {
        friends.follow(user, friendOne);
        friends.follow(user, friendTwo);
        assertThat(friends.find(user), hasItems(friendOne, friendTwo));
    }
}