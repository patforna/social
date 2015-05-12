package social.posts;

import org.ocpsoft.prettytime.PrettyTime;

import java.sql.Date;
import java.time.Instant;

public class Post {

    private final Instant created;
    private final String user;
    private final String message;

    public Post(Instant created, String user, String message) {
        this.created = created;
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (!created.equals(post.created)) return false;
        if (!message.equals(post.message)) return false;
        if (!user.equals(post.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = created.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", message, new PrettyTime().format(Date.from(created)));
    }

}
