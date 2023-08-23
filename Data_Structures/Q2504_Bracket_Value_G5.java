//This program calculates the sum of the pairs of parentheses according to certain rules:
//If a '(' is followed by a ')', the pair is worth twice the value of what's inside it or 2 if it's empty.
//If a '[' is followed by a ']', the pair is worth three times the value of what's inside it or 3 if it's empty.
//It also ensures that the parentheses are balanced correctly by checking whether the top of the stack matches the expected closing parenthesis.

package Data_Structures;

import java.io.*;
import java.util.*;

public class Q2504_Bracket_Value_G5 {

	public static void main(String[] args) throws IOException {
		// Use BufferedReader for fast input and BufferedWriter for fast output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the input string
		String in = br.readLine();

		// Stack for storing the parentheses
		Stack<Character> stk = new Stack<Character>();

		// Initialize result and multiplier
		int res = 0;
		int mul = 1;

		// Traverse the string
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == '(') {
				// For '(', multiply mul by 2 and push '(' to stack
				mul *= 2;
				stk.push(in.charAt(i));
			} else if (in.charAt(i) == '[') {
				// For '[', multiply mul by 3 and push '[' to stack
				mul *= 3;
				stk.push(in.charAt(i));
			} else if (in.charAt(i) == ')') {
				if (stk.isEmpty() || stk.peek() == '[') {
					// If stack is empty or the top of the stack is '[', reset result and break the
					// loop
					res = 0;
					break;
				} else if (in.charAt(i - 1) == '(') {
					// If the previous character is '(', add 2*mul to the result and adjust mul
					mul /= 2;
					res += 2 * mul;
					stk.pop();
				} else {
					// If the previous character is not '(', just adjust mul
					mul /= 2;
					stk.pop();
				}
			} else if (in.charAt(i) == ']') {
				if (stk.isEmpty() || stk.peek() == '(') {
					// If stack is empty or the top of the stack is '(', reset result and break the
					// loop
					res = 0;
					break;
				} else if (in.charAt(i - 1) == '[') {
					// If the previous character is '[', add 3*mul to the result and adjust mul
					mul /= 3;
					res += 3 * mul;
					stk.pop();
				} else {
					// If the previous character is not '[', just adjust mul
					mul /= 3;
					stk.pop();
				}
			}
		}

		// If the stack is not empty after traversing the string, reset the result
		if (!stk.isEmpty())
			res = 0;

		// Write the result to the output
		bw.write(String.valueOf(res));

		// Flush the buffer and close the BufferedWriter
		bw.flush();
		bw.close();
	}
}