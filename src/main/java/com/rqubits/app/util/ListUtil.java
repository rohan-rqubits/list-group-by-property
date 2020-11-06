package com.rqubits.app.util;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ListUtil {
    public static <T> T findByOneProperty(Collection<T> col, Predicate<T> filter) {
        return col.stream().filter(filter).findFirst().orElse(null);
    }

    public static <T> List<T> findByProperty(Collection<T> col, Predicate<T> filter) {
        return col.stream().filter(filter).collect(Collectors.toList());
    }

    public static <T> T aggregateByProperty(Collection<T> col, T identity,
                                            BiFunction<T, ? super T, T> accumulator,
                                            BinaryOperator<T> combiner) {
        return col.stream().reduce(identity, accumulator, combiner);
    }

}