package social.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.stream.Stream;

public class SocialApp {

    private final CommandParser parser;
    private final Serializer serializer;

    public SocialApp(CommandParser parser, Serializer serializer) {
        this.parser = parser;
        this.serializer = serializer;
    }

    public void run(Reader in, PrintWriter out) throws IOException {
        Stream<Command> commands =  new BufferedReader(in).lines().map(x -> parser.parse(x));
        commands.forEach(c -> out.println(serializer.serialize(c.execute())));
    }

}
