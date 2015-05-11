package social;

import java.util.*;

import static java.util.Arrays.asList;

public class Posts {

    private Map<String, List<Post>> store = new HashMap<>();

    public void save(Post post) {
        String user = post.getUser();
        if (!store.containsKey(user))
            store.put(user, new ArrayList<>(asList(post)));
        else
            store.get(user).add(post);
    }

    public List<Post> read(String user) {
        return store.get(user);
    }
}
