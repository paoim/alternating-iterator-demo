package com.exercise.sampleone;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AlternatingIterator<E> implements Iterator<E> {

	private Node<E> head;

	public AlternatingIterator(Iterator<E>... iterators) {
		if (null != iterators) {
			for (int i = 0; i < iterators.length; i++) {
				Node<E> position = getNodeToInsertFirstElementInIterator(i);
				while (iterators[i].hasNext()) {
					E data = iterators[i].next();
					if (isValidData(data)) {
						position = insert(position, i, data);
					}
				}
			}
		}
	}

	@Override
	public boolean hasNext() {
		return (null != head);
	}

	@Override
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		E data = head.getData();
		head = head.getNext();
		return data;
	}
	
	private boolean isValidData(E data) {
		if (null != data) {
			String str = data.toString();
			return (null != str && !str.isEmpty());
		}
		return false;
	}

	private Node<E> getNodeToInsertFirstElementInIterator(int listIndex) {
		Node<E> node = head;
		while (listIndex > 1 && null != node) {
			node = node.getNext();
			listIndex--;
		}
		return node;
	}

	private Node<E> insert(Node<E> position, int jumps, E data) {
		Node<E> newNode = new Node<>(data);
		if (null == position) {
			head = newNode;
		} else {
			if (null != position.getNext()) {
				newNode.setNext(position.getNext());
			}
			position.setNext(newNode);

			while (jumps > 0 && null != newNode.getNext()) {
				newNode = newNode.getNext();
				jumps--;
			}
		}
		return newNode;
	}
}
