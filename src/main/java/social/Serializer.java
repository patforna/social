package social;

import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Serializer {

    public String serialize(Object o) {
        if (o instanceof Collection) {
            Stream<String> stream = ((Collection) o).stream().map(String::valueOf);
            return stream.collect(joining("\n"));
        }

        return String.valueOf(o);
    }

}
