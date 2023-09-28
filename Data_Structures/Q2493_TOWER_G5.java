package Data_Structures;

/*
commented by ChatGPT
Summary:
The program processes a list of towers, each with a height. For each tower, it determines 
the closest taller tower to its left and outputs its position or 0 if none exists.
*/

import java.io.*;
import java.util.*;

//Class to encapsulate the properties of a tower: its height and its position in the sequence.
class top {
	int hei; // Height of the tower.
	int pos; // Position of the tower in the sequence.

// Constructor initializing the height and position of the tower.
	top(int hei, int pos) {
		this.hei = hei;
		this.pos = pos;
	}
}

public class Q2493_TOWER_G5 {

	public static void main(String[] args) throws IOException {

		// Setup for reading input and writing output.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Stack to store towers in the order they're encountered, aiding in the search
		// process.
		Stack<top> stk = new Stack<>();

		int n = Integer.parseInt(br.readLine()); // Reading the number of towers.

		// Read the heights of all towers.
		String inp[] = br.readLine().split(" ");

		// Iterate through each tower to determine and write the position of the taller
		// tower to its left.
		for (int i = 1; i <= n; i++) {
			int t = Integer.parseInt(inp[i - 1]); // Current tower's height.

			// Continue popping towers from the stack until a taller tower is found.
			while (!stk.isEmpty()) {
				if (stk.peek().hei > t)
					break; // Stop if a taller tower is found.
				else
					stk.pop(); // Remove shorter or equal height towers from the stack.
			}

			// Write 0 if no taller tower exists to its left, otherwise, write the position
			// of the taller tower.
			if (stk.isEmpty())
				bw.write("0 ");
			else
				bw.write(stk.peek().pos + " ");

			// Add the current tower to the stack.
			stk.add(new top(t, i));
		}

		// Finish writing and close the writer.
		bw.flush();
		bw.close();
	}
}
