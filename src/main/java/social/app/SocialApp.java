package social.app;

import java.io.*;
import java.util.Optional;

public class SocialApp {

    private final CommandParser parser;
    private final Serializer serializer;
    private final boolean interactive;

    public static void main(String[] args) throws Exception {
        new Config().socialApp().run(new InputStreamReader(System.in), System.out);
    }

    public SocialApp(CommandParser parser, Serializer serializer, boolean interactive) {
        this.parser = parser;
        this.serializer = serializer;
        this.interactive = interactive;
    }

    public void run(Reader in, PrintStream out) throws IOException {
        banner(out);
        prompt(out);
        new BufferedReader(in).lines().forEach(line -> {
            try {
                Optional.ofNullable(run(line)).ifPresent(out::println);
            } catch (Exception e) {
                out.printf("Oops: %s. Try again or type Ctrl-C to quit.\n", e.getMessage());
            }
            prompt(out);
        });
    }

    public String run(String input) {
        return serializer.serialize(parser.parse(input).execute());
    }

    private void banner(PrintStream out) {
        if (interactive)
            out.println("" +
                    "------------------------------------------------------------------------\n" +
                    " Hi! Please type some commands:\n" +
                    "------------------------------------------------------------------------\n" +
                    " <user> -> <msg>           Post a new message\n" +
                    " <user>                    Read posts\n" +
                    " <user> follows <other>    Follow other user\n" +
                    " <user> wall               Read wall posts\n" +
                    " Ctrl-C                    Quit.\n" +
                    "------------------------------------------------------------------------\n");
    }

    private void prompt(PrintStream out) {
        if (interactive) out.print("> ");
    }
}
