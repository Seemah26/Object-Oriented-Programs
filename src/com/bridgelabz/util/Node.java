package com.bridgelabz.util;
public class Node<E> {
	public E value;
	public Node<E> nextRef;
	public String data1;
	public int data;
	public Node<E> nextNode;

	public static int size = 0;

	public Node() {
		value = null;
		nextRef = null;
	}

	public Node(E data, Node<E> next) {
		this.value = data;
		this.nextRef = next;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E share) {
		this.value = share;
	}

	public Node<E> getNextRef() {
		return nextRef;
	}

	public void setNextRef(Node<E> ref) {
		this.nextRef = ref;
	}

	public Node<E> getSize() {
		return this.getSize();
	}

	public void setSize(Node<E> size) {
		this.nextRef = size;

	}
}