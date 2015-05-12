package social.posts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Posts {

    private final Map<String, List<Post>> store = new HashMap<>();

    public void save(Post post) {
        String user = post.getUser();
        if (!store.containsKey(user))
            store.put(user, new ArrayList<>(asList(post)));
        else
            store.get(user).add(post);
    }

    public List<Post> find(String user) {
        return store.get(user);
    }
}
