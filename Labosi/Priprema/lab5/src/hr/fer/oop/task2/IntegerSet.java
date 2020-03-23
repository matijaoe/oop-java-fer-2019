package hr.fer.oop.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class IntegerSet implements Iterable<MyNumber> {
	Set<Integer> set = new TreeSet<>();

	public void add(int i) {
		set.add(i);
	}

	@Override
	public Iterator<MyNumber> iterator() {
		return new SetEntry();
	}

	private class SetEntry implements Iterator<MyNumber> {
		Iterator<Integer> it;

		public SetEntry() {
			it = set.iterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public MyNumber next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return new MyNumber(it.next());
		}
	}

}
