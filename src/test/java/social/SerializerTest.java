package social;

import org.junit.Test;

import java.util.Collection;

import static java.lang.String.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SerializerTest {

    private Serializer serializer = new Serializer();

    @Test
    public void shouldUseToStringByDefault() {
        assertThat(serializer.serialize("foo"), is("foo"));
        assertThat(serializer.serialize(42), is("42"));
    }

    @Test
    public void shouldJoinCollectionItemsWithNewline() {
        assertThat(asList("a", "b"), instanceOf(Collection.class));

        assertThat(serializer.serialize(asList("foo", "bar")), is("foo\nbar"));
    }

}