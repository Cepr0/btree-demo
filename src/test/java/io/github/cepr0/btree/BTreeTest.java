package io.github.cepr0.btree;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class BTreeTest {

	@Test
	public void test() {
		ThreadLocalRandom random = ThreadLocalRandom.current();

		BTree<Integer, Integer> tree = new BTree<>();

		for (int i = 0; i < 20; i++) {
			tree.insert(random.nextInt(-10, 11), 1);
		}

		tree.insert(0, 2);

		tree.traverse((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

		System.out.println("Found: " + tree.find(0));
	}
}