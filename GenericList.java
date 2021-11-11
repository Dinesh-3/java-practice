import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        int[] nums = {1,2,3};
        Arrays.sort(nums);
        return Arrays.toString(this.list);
    }
}
