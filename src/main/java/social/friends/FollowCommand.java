package social.friends;

import social.app.Command;

public class FollowCommand implements Command {

    private final Friends friends;
    private final String user;
    private final String friend;

    public FollowCommand(Friends friends, String user, String friend) {
        this.friends = friends;
        this.user = user;
        this.friend = friend;
    }

    @Override
    public Object execute() {
        friends.follow(user, friend);
        return null;
    }
}
