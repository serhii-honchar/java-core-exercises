package ua.procamp;


import ua.procamp.exception.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    private LinkedList<T> list = new LinkedList<T>();

    @Override
    public void push(T element) {
        list.add(element);
    }

    @Override
    public T pop() {
        //todo: according to interface this method should return null if stack is empty
        if (isEmpty()) throw new EmptyStackException();

        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
