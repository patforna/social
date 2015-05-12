package social.wall;

import social.friends.Friends;
import social.posts.Post;
import social.posts.Posts;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Wall {

    private final Friends friends;
    private final Posts posts;

    public Wall(Friends friends, Posts posts) {
        this.friends = friends;
        this.posts = posts;
    }

    public List<Post> find(String user) {
        List<Post> result = new ArrayList<>();
        result.addAll(posts.find(user));
        result.addAll(friends.find(user).stream().flatMap(f -> posts.find(f).stream()).collect(toList()));
        return result;
    }
}
