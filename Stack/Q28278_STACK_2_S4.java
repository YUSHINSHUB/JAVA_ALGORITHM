package Stack;

/*
Commented by ChatGPT
Summary: This Java program simulates basic stack operations based on user input. 
The user specifies the desired operations on the stack and the program executes and outputs the 
results of these operations.
*/

import java.io.*;
import java.util.*;

public class Q28278_STACK_2_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // Number of operations to be performed
		Stack<Integer> stk = new Stack<>(); // Stack declaration

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" "); // Reading each operation
			int c = Integer.parseInt(inp[0]);

			switch (c) {
			case 1: // Push an element onto the stack
				stk.add(Integer.parseInt(inp[1]));
				break;
			case 2: // Pop an element from the stack
				if (stk.isEmpty())
					bw.write("-1\n"); // If stack is empty, print -1
				else
					bw.write(stk.pop() + "\n");
				break;
			case 3: // Print the size of the stack
				bw.write(stk.size() + "\n");
				break;
			case 4: // Check if stack is empty
				if (stk.isEmpty())
					bw.write("1\n"); // If empty, print 1
				else
					bw.write("0\n"); // If not empty, print 0
				break;
			case 5: // Peek the top element of the stack
				if (stk.isEmpty())
					bw.write("-1\n"); // If stack is empty, print -1
				else
					bw.write(stk.peek() + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
	}
}

