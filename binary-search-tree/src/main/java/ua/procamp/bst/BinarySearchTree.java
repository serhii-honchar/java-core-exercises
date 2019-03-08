package ua.procamp.bst;

import java.util.function.Consumer;

/**
 * Binary search tree API
 */
public interface BinarySearchTree<T> {
	boolean insert(T element);

	boolean search(T element);

	int size();

	int height();

	void inOrderTraversal(Consumer<T> consumer);
}
