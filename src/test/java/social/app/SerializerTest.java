package social.app;

import org.junit.Test;
import social.app.Serializer;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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