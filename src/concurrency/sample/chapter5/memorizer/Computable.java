package concurrency.sample.chapter5.memorizer;

public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
