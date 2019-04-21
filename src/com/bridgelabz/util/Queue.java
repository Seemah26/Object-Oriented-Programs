package com.bridgelabz.util;

public class Queue<T> {

	public Node<T> front, rear;
	public int size = 0;

	public Queue() {
		front = null;
		rear = null;
		size = 0;
	}

	public boolean isQueueEmpty() {
		return front == null;
	}

	public int getSize() {
		return size;
	}

	/**
	 * Function to insert the specified element in the queue
	 *
	 * @param data
	 *            the element to be inserted into the queue
	 */
	public void insert(T data) {
		Node<T> node = new Node<T>(data, null);
		if (rear == null) {
			front = node;
			rear = node;
		} else {
			rear.setNextRef(node);
			rear = rear.getNextRef();
		}
		size++;
	}

	public T remove() {
		if (isQueueEmpty()) {
			System.out.println("Underflow");
		}
		Node<T> curr = front;
		front = curr.getNextRef();
		if (front == null) {
			rear = null;
			size--;
		}
		return curr.getValue();
	}

	public void display() {
		if (isQueueEmpty()) {
			System.out.println("Queue is empty");
			return;
		} else {
			Node<T> tNode = front;
			while (tNode != null) {
				System.out.print(tNode.getValue() + " ");
				tNode = tNode.getNextRef();
			}
		}
	}
}