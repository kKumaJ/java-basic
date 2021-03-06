package concurrency.book1.sample.chapter5.memorizer;

import concurrency.book1.sample.chapter5.future.Preloader;

import java.util.concurrent.*;

public class Memoizer<A, V> implements Computable<A, V> {


    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                throw Preloader.launderThrowable(e);
            }

        }
    }
}
