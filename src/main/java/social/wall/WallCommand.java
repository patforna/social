package social.wall;

import social.app.Command;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WallCommand implements Command {

    private final Wall wall;
    private final String user;

    public WallCommand(Wall wall, String user) {
        this.wall = wall;
        this.user = user;
    }

    @Override
    public List<WallPost> execute() {
        return wall.find(user).stream().map(p -> new WallPost(p)).collect(toList());
    }

}
