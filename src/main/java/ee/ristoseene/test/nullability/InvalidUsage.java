package ee.ristoseene.test.nullability;

import ee.ristoseene.test.nullability.stuff.Extractor;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;

@NullMarked
public class InvalidUsage {

    public static void callNonNullableWithNullArgument() {
        Examples.acceptNonNull(null);

        Object argument = null;
        Examples.acceptNonNull(argument);

        Examples.acceptNonNull(Examples.returnNullable());
    }

    public static void processConditionallyNullable() {
        Object nullable = Examples.processConditionallyNullable(Examples.returnNullable());
        Examples.acceptNonNull(nullable);

        Object nonNull = Examples.<Object>processConditionallyNullable(Examples.returnNullable());
        Examples.acceptNullable(nonNull);

        Object nullable2 = Examples.<@Nullable Object>processConditionallyNullable(Examples.returnNonNull());
        Examples.acceptNonNull(nullable2);
    }

    public static void usingUnconditionallyNullableReturnValue() {
        int length = Examples.getLengthIfPresent("test");
    }

    public static void extractNonNull() {
        List<Extractor<Object, @Nullable Object>> extractors = List.of();
        Object container = new Object();

        List<Object> extracted = Examples.extract(container, extractors);
    }

}
