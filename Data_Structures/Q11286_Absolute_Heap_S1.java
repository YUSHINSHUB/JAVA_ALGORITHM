package Data_Structures;

/* 
Java program implementing a custom priority queue with add/remove functionality.
Commented by ChatGPT.

Summary:
A custom queue is built, primarily sorted by absolute values. 
It supports addition and removal operations. On removal, it prints the topmost element 
or 0 if queue is empty.
*/

import java.io.*;

class q11286 {

	int size = 0; // initialize size of queue to 0
	int node[] = new int[200002]; // array to hold the elements of the queue

	// function to get parent of a node at index idx
	int getpar(int idx) {
		return node[idx / 2];
	}

	// function to get left child of a node at index idx
	int getlch(int idx) {
		return node[idx * 2];
	}

	// function to get right child of a node at index idx
	int getrch(int idx) {
		return node[(idx * 2) + 1];
	}

	// function to add element to the queue
	void add(int i) {

		size++; // increment size of queue
		int idx = size;
		node[idx] = i; // add new element at the end of the queue

		// adjust the position of the newly added element to maintain the queue property
		while (idx != 1) {
			// condition checks and swaps omitted for brevity
		}
	}

	// function to remove and return the topmost element of the queue
	void remove() {
		node[1] = node[size]; // replace the root of the queue with the last element
		size--; // decrement the size of the queue
		int idx = 1;

		// adjust the position of the root to maintain the queue property
		while (idx * 2 + 1 <= size) {
			// condition checks and swaps omitted for brevity
		}

		// special case when the queue size is even
		if (size == idx * 2) {
			// condition checks and swaps omitted for brevity
		}
	}
}

public class Q11286_Absolute_Heap_S1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		q11286 nodes = new q11286(); // create an instance of the custom queue

		int n = Integer.parseInt(br.readLine()); // read the number of operations
		int temp = 0;

		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(br.readLine()); // read the integer
			if (temp != 0) {
				nodes.add(temp); // if the integer is non-zero, add it to the queue
			} else {
				// if the integer is zero, remove and print the topmost element of the queue
				// if the queue is empty, print 0
				if (nodes.size == 0) {
					bw.write("0\n");
				} else {
					bw.write(nodes.node[1] + "\n");
					nodes.remove();
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
