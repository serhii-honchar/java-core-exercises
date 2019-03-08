package ua.procamp;


import ua.procamp.exception.EmptyStackException;

import java.util.Objects;

public class LinkedStack<T> implements Stack<T> {
	private Node<T> head;
	private int size = 0;

	@Override
	public void push(T element) {
		Objects.requireNonNull(element);
		Node<T> newNode = Node.valueOf(element);
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
		size++;
	}

	@Override
	public T pop() {
		if (head != null) {
			size--;
			return retrieveHead();
		} else {
			throw new EmptyStackException();
		}
	}

	private T retrieveHead() {
		T element = head.element;
		this.head = head.next;
		return element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	private static class Node<T> {
		T element;
		Node<T> next;

		static <T> Node<T> valueOf(T element) {
			return new Node<>(element);
		}

		Node(T element) {
			this.element = element;
		}
	}
}
