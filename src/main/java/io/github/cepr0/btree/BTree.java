package io.github.cepr0.btree;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class BTree<K extends Comparable<K>, V> {

	private Node<K, V> root;

	public BTree() {
	}

	public BTree(@NonNull Node<K, V> root) {
		this.root = root;
	}

	public Node<K, V> insert(@NonNull K key, @NonNull V value) {
		Node<K, V> node = new Node<>(key, value);
		if (root == null) {
			root = node;
		} else {
			insert(root, node);
		}
		return node;
	}

	private void insert(Node<K, V> parent, Node<K, V> node) {
		if (node.compareTo(parent) == 0) {
			parent.setValue(node.getValue());
			return;
		}
		if (node.compareTo(parent) > 0) {
			Node<K, V> right = parent.getRight();
			if (right == null) {
				parent.setRight(node);
			} else {
				insert(right, node);
			}
		}
		if (node.compareTo(parent) < 0) {
			Node<K, V> left = parent.getLeft();
			if (left == null) {
				parent.setLeft(node);
			} else {
				insert(left, node);
			}
		}
	}

	public V find(@NonNull K key) {
		if (root == null) return null;
		return find(root, key);
	}

	private V find(Node<K, V> parent, K key) {
		if (parent != null) {
			if (key.compareTo(parent.getKey()) == 0) {
				return parent.getValue();
			}

			if (key.compareTo(parent.getKey()) > 0) {
				return find(parent.getRight(), key);
			}

			if (key.compareTo(parent.getKey()) < 0) {
				return find(parent.getLeft(), key);
			}
		}
		return null;
	}

	public boolean remove(K key) {
		return false;
	}

	public void traverse(@NonNull BiConsumer<K, V> consumer) {
		traverse(root, consumer);
	}

	private void traverse(Node<K, V> parent, BiConsumer<K, V> consumer) {
		if (parent != null) {
			traverse(parent.getLeft(), consumer);
			consumer.accept(parent.getKey(), parent.getValue());
			traverse(parent.getRight(), consumer);
		}
	}
}
