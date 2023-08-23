package Data_Structures;

import java.io.*;
import java.util.*;

public class Q5430_AC_G5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Deque is used for easy manipulation of front and back of the list
		Deque<Integer> dq = new LinkedList<Integer>();

		// Number of test cases
		int n = Integer.parseInt(br.readLine());
		int p;
		String ac, inp;
		boolean err;
		boolean rev; // To keep track if the deque should be reversed or not

		for (int i = 0; i < n; i++) {
			rev = false; // Initializing it to false for each test case
			ac = br.readLine(); // Reading the commands string like 'RDD'
			p = Integer.parseInt(br.readLine()); // Number of integers in the array
			inp = br.readLine(); // Reading the input array string
			inp = inp.substring(1, inp.length() - 1); // Removing opening and closing brackets from the string
			String nums[] = inp.split(","); // Splitting the string to get individual numbers

			if (!inp.equals("")) { // If the input isn't an empty array
				for (int j = 0; j < nums.length; j++) {
					dq.addLast(Integer.parseInt(nums[j])); // Parsing and adding numbers to the deque
				}
			}
			err = false; // flag to check for errors

			for (int j = 0; j < ac.length(); j++) {
				if (ac.charAt(j) == 'R') { // If command is 'R'
					// Toggling the reverse flag
					if (rev)
						rev = false;
					else
						rev = true;
				} else {
					// If command is 'D'
					if (dq.isEmpty()) {
						err = true; // If the deque is empty, it's an error
						break;
					} else if (rev) {
						// If reverse flag is true, remove from the back
						dq.pollLast();
					} else {
						// Otherwise, remove from the front
						dq.pollFirst();
					}
				}
			}

			// Writing the output based on the final state of the deque
			if (err) {
				bw.write("error\n");
			} else if (!rev) {
				bw.write("[");
				if (!dq.isEmpty())
					bw.write(dq.pollFirst() + "");
				while (!dq.isEmpty()) {
					bw.write("," + dq.pollFirst());
				}
				bw.write("]\n");
			} else {
				bw.write("[");
				if (!dq.isEmpty())
					bw.write(dq.pollLast() + "");
				while (!dq.isEmpty()) {
					bw.write("," + dq.pollLast());
				}
				bw.write("]\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
