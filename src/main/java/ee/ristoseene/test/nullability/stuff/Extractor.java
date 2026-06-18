package ee.ristoseene.test.nullability.stuff;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public interface Extractor<T, R extends @Nullable Object> {

    R extract(T object);

}
