import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    private class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> previous;
        public MyNode(T data) {
            this.data = data;
            next = null;
            previous = null;
        }
    }
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            MyNode<T> currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.previous = currentNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
       checkIndex(index);
       MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = item;
    }

    public void printList() {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.previous = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            MyNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
        }
    }

    @Override
    public void addFirst(T item) {
        checkIndex(0);
        add(0, item);
        size++;
    }

    @Override
    public void addLast(T item) {
        checkIndex(0);
        add(item);
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)  {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }
}
