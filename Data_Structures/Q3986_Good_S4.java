package Data_Structures;

/*
commented by ChatGPT
This Java code implements a solution to count the number of strings that can be entirely removed by deleting pairs of identical adjacent characters. 
It reads a series of strings and uses a stack to track character pairings. 4
If a character matches the top of the stack, both are removed, simulating the deletion of adjacent matching pairs. 
The program outputs the count of strings that can be completely emptied in this manner, indicating they are made entirely of such pairs.
이 Java 코드는 인접한 동일한 문자 쌍을 삭제하여 완전히 제거할 수 있는 문자열의 수를 세는 솔루션을 구현합니다. 일련의 문자열을 읽고 스택을 사용하여 문자 쌍을 추적합니다. 
문자가 스택의 맨 위와 일치하면 둘 다 제거되어 인접한 일치하는 쌍의 삭제를 시뮬레이션합니다. 
이 방식으로 완전히 비워질 수 있는 문자열의 수를 출력하는 프로그램은 그러한 쌍으로만 구성되어 있음을 나타냅니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q3986_Good_S4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> stk = new Stack<>(); // Stack to hold characters for pairing check

		String in; // Input string
		int N; // Number of strings
		int res = 0; // Result counter for completely removable strings

		N = Integer.parseInt(br.readLine()); // Reading the number of strings

		for (int i = 0; i < N; i++) {
			stk.clear(); // Clear stack for the new string
			in = br.readLine(); // Read next string
			// If the string length is odd, it cannot be fully paired and removed
			if (in.length() % 2 == 1)
				continue;

			for (int j = 0; j < in.length(); j++) {
				// If stack is not empty and the top element matches the current character, pop
				// it to simulate removal
				if (!stk.isEmpty() && stk.peek() == in.charAt(j))
					stk.pop();
				else
					stk.add(in.charAt(j)); // Otherwise, push the character onto the stack
			}

			// If stack is empty after processing, all characters have been paired and
			// removed
			if (stk.isEmpty())
				res++; // Increment result counter
		}

		bw.write(res + ""); // Write result
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close BufferedWriter to free resources
	}
}
