package edu.disease.asn5;

import java.util.Arrays;
import java.util.List;

public class Container<T> {
	private List<T> t;

	/**
	 * constructor to accept generic type
	 * 
	 * @param t 
	 */
	public Container(T... t) {
		if (t.length==0) {
			throw new IllegalArgumentException("No Argument supplied");
		}
		this.t = Arrays.asList(t);
	}

	/**
	 * to get the size of the properties
	 * 
	 * @return
	 */
	public int size() {
		return t.size();
	}

	/**
	 * to retrieve the property from the given index
	 * 
	 * @param ind
	 * @return
	 */
	public T get(int index) {

		if (index < 0 || index >= t.size()) {
			throw new IllegalArgumentException();
		}
		return t.get(index);
	}
}