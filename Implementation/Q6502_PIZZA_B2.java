package Implementation;

/*
commented by ChatGPT
Summary: The program determines whether various pizzas can fit on a table based on the given radius of the table and the dimensions of the pizzas.
*/

import java.io.*;
import java.util.*;

public class Q6502_PIZZA_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int r; // Table's radius.
		double x, y; // Dimensions of the pizza.
		String temp; // Temporarily storing input line.
		int index = 0; // Counter for the number of pizzas.

		while (true) {
			temp = br.readLine(); // Read the input line.
			// If input is '0', break the loop.
			if (temp.equals("0")) {
				break;
			}
			index++; // Increase the pizza counter.

			// Tokenizing the input string to extract values.
			StringTokenizer stk = new StringTokenizer(temp, " ");

			r = Integer.parseInt(stk.nextToken()); // Parsing the table's radius.
			x = Double.parseDouble(stk.nextToken()); // Parsing the pizza's width.
			y = Double.parseDouble(stk.nextToken()); // Parsing the pizza's height.

			// If the diagonal of the pizza is smaller than or equal to the table's
			// diameter, the pizza fits.
			if (Math.sqrt(Math.pow(x / 2, 2) + Math.pow(y / 2, 2)) <= r) {
				bw.write("Pizza " + String.valueOf(index) + " fits on the table.\n");
			} else {
				bw.write("Pizza " + String.valueOf(index) + " does not fit on the table.\n");
			}
		}

		bw.flush(); // Flushes the stream to ensure all data is written.
		bw.close(); // Close the BufferedWriter stream.
	}
}
