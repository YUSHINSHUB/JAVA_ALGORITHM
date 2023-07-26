package Number_Theory;

import java.io.*;

public class Q6588_Goldbachs_Conjecture_S1 {

	public static void main(String[] args) throws IOException {
		// BufferedReader and BufferedWriter are used to read from and write to the
		// console respectively.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Boolean array to check if a number is prime or not.
		boolean chk[] = new boolean[1000001];
		chk[0] = true;
		chk[1] = true;

		// Using the Sieve of Eratosthenes to precompute all the primes up to 1,000,000.
		for (int i = 2; i * i <= 1000000; i++) {
			if (!chk[i]) { // If i is a prime,
				for (int j = i * i; j <= 1000000; j += i) { // mark multiples of i as non-prime.
					chk[j] = true;
				}
			}
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			// Break the loop if the input is 0.
			if (n == 0) {
				break;
			}
			boolean found = false;
			// Search for two primes whose sum is n.
			for (int i = 2; i <= n / 2; i++) {
				// If i and n-i are both primes, write the result and break the loop.
				if (!chk[i] && !chk[n - i]) {
					bw.write(n + " = " + i + " + " + (n - i) + "\n");
					found = true;
					break;
				}
			}
			// If no such pair of primes is found, write an error message.
			if (!found) {
				bw.write("Goldbach's conjecture is wrong.\n");
			}
		}
		// Flush the BufferedWriter to make sure all output has been written.
		bw.flush();
		bw.close();
	}
}