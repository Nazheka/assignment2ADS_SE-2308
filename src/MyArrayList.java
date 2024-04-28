import java.util.Iterator;

public class MyArrayList <T> implements MyList <T> {
    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }


    @Override
    public void add(T item) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void set(int index, T item) {
        try {
            arr[index] = item;
        } catch (Exception e) {
            System.out.println("Wrong index");
        }
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index, size);
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = item;
        for (int i = index + 1; i <= size; i++) {
            newArr[i] = arr[i - 1];
        }
        size++;
        arr = newArr;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index, size);
        return arr[index];
    }

    @Override
    public T getFirst() {
        checkIndex(0, size);
        return arr[0];
    }

    @Override
    public T getLast() {
        checkIndex(0, size);
        return arr[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index, size);
        T[] newArr = (T[]) new Object[arr.length];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for (int i = index; i < size - 1; i++) {
            newArr[i] = arr[i + 1];
        }
        size--;
        arr = newArr;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println('\n');
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int last = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                last = i;
            }
        }
        return last;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        T[] newArr = (T[]) new Object[arr.length];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public void clear() {
        T[] newArr = (T[]) new Object[5];
        size = 0;
        arr = newArr;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
    private void checkIndex(int index, int size) {
        if (index < 0 || index >= size)  {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }
}
