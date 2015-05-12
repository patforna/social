package social.posts;

import social.app.Command;

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
        return posts.find(user);
    }
}
