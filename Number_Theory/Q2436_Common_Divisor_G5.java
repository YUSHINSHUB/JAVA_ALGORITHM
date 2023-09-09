package Number_Theory;

/*
commented by ChatGPT
Summary: This program computes two numbers whose GCD is 'a', LCM is the product of 'a' and 'b', and where the two numbers themselves lie between 'a' and the square root of 'a*b'.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2436_Common_Divisor_G5 {

// Recursive method to calculate the GCD (Greatest Common Divisor) of two numbers.
	static int check(long a, long b) {
		int m = (int) (a % b);
		if (m == 0)
			return (int) b;

		return check(b, m);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Parse input values 'a' and 'b'.
		String inp[] = br.readLine().split(" ");
		int a = Integer.parseInt(inp[0]);
		int b = Integer.parseInt(inp[1]);

		// Calculate the product of 'a' and 'b', which is used as the LCM.
		long mul = (long) a * (long) b;

		// Initialize the resulting numbers.
		long res1 = 0, res2 = 0;

		/*
		 * Iterate over numbers from 'a' up to the square root of 'mul', stepping by
		 * 'a'. For each number, if it divides 'mul' completely (is a factor of LCM),
		 * and the GCD of the number and its corresponding divisor is 'a', then update
		 * the resulting numbers 'res1' and 'res2'.
		 */
		for (int i = a; i <= Math.sqrt(mul); i += a) {
			if (mul % i == 0 && check(mul / i, i) == a) {
				res1 = i;
				res2 = mul / i;
			}
		}

		bw.write(res1 + " " + res2); // Write the resulting numbers.

		bw.flush();
		bw.close();
	}
}
