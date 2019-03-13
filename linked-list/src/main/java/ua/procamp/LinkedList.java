package ua.procamp;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (head != null) {
            Node<T> headNode = head;
            Node<T> newNode = new Node<T>(element);
            newNode.prevNode = headNode;
            head = newNode;
        } else {
            head = new Node<T>(element);
        }
        size++;
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<T>(element);
        if (head == null) {
            head = newNode;
        } else if (index == size) {
            newNode.prevNode = head;
            head = newNode;
        } else {
            Node<T> node = head;
            for (int i = 0; i < size - index - 1; i++) {
                node = node.prevNode;
            }
            Node<T> prevNode = node.prevNode;
            node.prevNode = newNode;
            newNode.prevNode = prevNode;
        }
        size++;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        if (index >= size) throw new IndexOutOfBoundsException();
        Node<T> prevNode = head;
        for (int i = 0; i < size - index - 1; i++) {
            prevNode = prevNode.prevNode;
        }
        prevNode.value = element;
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        for (int i = 0; i < size - index - 1; i++) {
            node = node.prevNode;
        }
        return node.value;

    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        if (index == size - 1) {
            head = head.prevNode;
        } else {
            for (int i = 0; i < size - index - 1; i++) {
                node = node.prevNode;
            }
            if (index == 0) {
                node.prevNode = null;
            } else {
                Node<T> nodeToDelete = node.prevNode;
                node.prevNode = nodeToDelete.prevNode;
            }
        }
        size--;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        if (head == null) return false;
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(element)) {
                return true;
            }
            node = node.prevNode;
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private static class Node<T> {
        T value;
        Node<T> prevNode;

        Node(T element) {
            value = element;
        }
    }
}
