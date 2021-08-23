import java.util.Arrays;
import java.util.Iterator;

public class GenericList<T> implements Iterable<T>{
    private final T[] list = (T[]) new Object[10];
    private int count = 0;
    public void add(T item){
        list[count++] = item;
    }

    public T get(int index){
        return list[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public T next() {
            return list[index++];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
