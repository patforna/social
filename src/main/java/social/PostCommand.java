package social;

import java.time.Clock;
import java.time.Instant;

import static java.time.Instant.now;

public class PostCommand implements Command {
    private final Clock clock;
    private final Posts posts;
    private final String user;
    private final String message;

    public PostCommand(Posts posts, Clock clock, String user, String message) {
        this.clock = clock;
        this.posts = posts;
        this.user = user;
        this.message = message;
    }

    public String execute() {
        posts.save(new Post(now(clock), user, message));
        return ""; // FIXME
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostCommand that = (PostCommand) o;

        if (!message.equals(that.message)) return false;
        if (!user.equals(that.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}
