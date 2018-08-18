package com.exercise.sampleone;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AlternatingIterator<E> implements Iterator {
	
	private E[] values;
	private int position;

	public AlternatingIterator(Iterator<E>... iterators) {
		values = AlternatingGenericUtil.getValues(iterators);
	}

	@Override
	public boolean hasNext() {
		return (null != values && position < values.length);
	}

	@Override
	public E next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		E object = values[position];
		position++;
		return object;
	}
}
