package datastructure;

/**
 * Created by lzz on 2017/3/11.
 */
public interface Iterator<T> {

    boolean hasNext();
    T next();
    void remove();
}
