package io.github.cepr0.btree;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "key")
@ToString(of = "key")
public class Node<K extends Comparable<K>, V> {

	@NonNull private Node<K, V> left;
	@NonNull private Node<K, V> right;

	@NonNull private final K key;
	@NonNull private V value;

	public Node(final K key, final V value) {
		this.key = key;
		this.value = value;
	}

	public int compareTo(@NonNull Node<K, V> node) {
		return key.compareTo(node.getKey());
	}
}
