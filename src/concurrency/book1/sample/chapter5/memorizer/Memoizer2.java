package concurrency.book1.sample.chapter5.memorizer;

import java.util.concurrent.ConcurrentHashMap;

public class Memoizer2<A, V> implements Computable<A, V> {

    private final ConcurrentHashMap<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
