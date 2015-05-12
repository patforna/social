package social.friends;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Friends {

    private final Map<String, List<String>> store = new HashMap<>();

    public void follow(String user, String friend) {
        if (!store.containsKey(user))
            store.put(user, new ArrayList<>(asList(friend)));
        else
            store.get(user).add(friend);
    }

    public List<String> find(String user) {
        return store.get(user);
    }
}
