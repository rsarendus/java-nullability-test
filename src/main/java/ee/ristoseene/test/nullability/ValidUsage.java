package ee.ristoseene.test.nullability;

import ee.ristoseene.test.nullability.stuff.Extractor;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Objects;

@NullMarked
public class ValidUsage {

    public static void callWithAcceptedArgument() {
        Examples.acceptNonNull(new Object());

        Object argument = new Object();
        Examples.acceptNonNull(argument);

        Examples.acceptNullable(new Object());
        Examples.acceptNullable(null);

        Examples.acceptNonNull(Examples.returnNonNull());
        Examples.acceptNullable(Examples.returnNonNull());
        Examples.acceptNullable(Examples.returnNullable());
    }

    public static void processConditionallyNullable() {
        Object nonNull = Examples.processConditionallyNullable(Examples.returnNonNull());
        Examples.acceptNonNull(nonNull);

        Object nullable = Examples.processConditionallyNullable(Examples.returnNullable());
        Examples.acceptNullable(nullable);
    }

    public static void usingUnconditionallyNullableReturnValue() {
        int length = Objects.requireNonNull(Examples.getLengthIfPresent("test"));
    }

    public static void extractNonNull() {
        List<Extractor<Object, Object>> extractors = List.of();
        Object container = new Object();

        List<Object> extracted = Examples.extract(container, extractors);
    }

    public static void extractNullable() {
        List<Extractor<Object, @Nullable Object>> extractors = List.of();
        Object container = new Object();

        List<@Nullable Object> extracted = Examples.extract(container, extractors);
    }

}
