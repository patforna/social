package social.app;

import social.friends.Friends;
import social.posts.Posts;
import social.wall.Wall;

import java.time.Clock;

public class Config {

    public SocialApp socialApp() {
        Clock clock = Clock.systemDefaultZone();
        Posts posts = new Posts();
        Friends friends = new Friends();
        Wall wall = new Wall(friends, posts);
        CommandParser parser = new CommandParser(posts, friends, wall, clock);
        Serializer serializer = new Serializer();
        return new SocialApp(parser, serializer, true);
    }
}
