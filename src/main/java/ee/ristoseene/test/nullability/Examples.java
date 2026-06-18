package ee.ristoseene.test.nullability;

import ee.ristoseene.test.nullability.stuff.Extractor;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Objects;

@NullMarked
public class Examples {

    public static void acceptNonNull(Object parameter) {
        Objects.requireNonNull(parameter);
    }

    public static void acceptNullable(@Nullable Object parameter) {
        // No-op
    }

    public static Object returnNonNull() {
        return new Object();
    }

    public static @Nullable Object returnNullable() {
        return null;
    }

    public static <T extends @Nullable Object> T processConditionallyNullable(T parameter) {
        return parameter;
    }

    public static @Nullable Integer getLengthIfPresent(@Nullable String input) {
        return (input != null) ? input.length() : null;
    }

    public static <T, E extends @Nullable Object> List<E> extract(T object, List<Extractor<T, E>> extractors) {
        return extractors.stream()
                .map(e -> e.extract(object))
                .toList();
    }

}
