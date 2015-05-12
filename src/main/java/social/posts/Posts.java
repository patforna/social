package social.posts;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

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
        return store.containsKey(user) ? store.get(user) : emptyList();
    }
}
