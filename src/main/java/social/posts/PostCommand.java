package social.posts;

import social.app.Command;

import java.time.Clock;

import static java.time.Instant.now;

public class PostCommand implements Command {

    private final Posts posts;
    private final Clock clock;
    private final String user;
    private final String message;

    public PostCommand(Posts posts, Clock clock, String user, String message) {
        this.posts = posts;
        this.clock = clock;
        this.user = user;
        this.message = message;
    }

    @Override
    public String execute() {
        posts.save(new Post(now(clock), user, message));
        return null;
    }
}
