package Deque;

//Commented by ChatGPT
//Summary: Java program that simulates a double-ended queue (deque) and performs various 
//operations based on the user's input.

import java.io.*;
import java.util.*;

public class Q28279_DEQUE_2_S4 {

	public static void main(String[] args) throws IOException {

		// Initialize BufferedReader and BufferedWriter for input and output operations
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of operations to perform on the deque
		int n = Integer.parseInt(br.readLine());

		// Create a deque to store integers
		Deque<Integer> stk = new LinkedList<>();

		// Loop through each operation and execute accordingly
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" "); // Split input based on space
			int c = Integer.parseInt(inp[0]); // Read the operation code

			// Switch-case to determine which operation to execute
			switch (c) {
			case 1:
				// Add element to the front of the deque
				stk.addFirst(Integer.parseInt(inp[1]));
				break;
			case 2:
				// Add element to the end of the deque
				stk.addLast(Integer.parseInt(inp[1]));
				break;
			case 3:
				// Remove and display element from the front of the deque. If deque is empty,
				// display -1
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.pollFirst() + "\n");
				break;
			case 4:
				// Remove and display element from the end of the deque. If deque is empty,
				// display -1
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.pollLast() + "\n");
				break;
			case 5:
				// Display the current size of the deque
				bw.write(stk.size() + "\n");
				break;
			case 6:
				// Check if deque is empty and display 1 if true, 0 if false
				if (stk.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case 7:
				// Display the element at the front of the deque without removing it. If deque
				// is empty, display -1
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.peekFirst() + "\n");
				break;
			case 8:
				// Display the element at the end of the deque without removing it. If deque is
				// empty, display -1
				if (stk.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stk.peekLast() + "\n");
				break;
			}
		}

		// Flush and close the BufferedWriter to write all the output to the console
		bw.flush();
		bw.close();
	}
}
