package social.friends;

import org.junit.Test;
import social.friends.FollowCommand;
import social.friends.Friends;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FollowCommandTest {

    private Friends friends = mock(Friends.class);

    private FollowCommand cmd = new FollowCommand(friends, "user", "friend");

    @Test
    public void shouldSaveRelationship() {
        cmd.execute();
        verify(friends).follow("user", "friend");
    }

}