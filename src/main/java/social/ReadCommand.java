package social;

import java.util.List;

public class ReadCommand implements Command {
    private final Posts posts;
    private final String user;

    public ReadCommand(Posts posts, String user) {
        this.posts = posts;
        this.user = user;
    }

    @Override
    public List<Post> execute() {
        return posts.read(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReadCommand that = (ReadCommand) o;

        if (!user.equals(that.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }
}
