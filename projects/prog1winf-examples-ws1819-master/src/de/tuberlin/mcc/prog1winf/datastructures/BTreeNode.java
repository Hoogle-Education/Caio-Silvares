/**
 * 
 */
package de.tuberlin.mcc.prog1winf.datastructures;

/**
 * @author Dave
 * @author Caio
 */
public class BTreeNode<T extends Comparable<T>> {

	public T value;

	public BTreeNode<T> left;

	public BTreeNode<T> right;

	/**
	 * @param value
	 */
	public BTreeNode(T value) {
		super();
		this.value = value;
	}

}
