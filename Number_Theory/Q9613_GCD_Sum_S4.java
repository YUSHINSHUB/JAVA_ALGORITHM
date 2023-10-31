package Number_Theory;

/*
commented by ChatGPT
This Java program calculates the sum of the greatest common divisors (GCDs) of all pairs in a list of integers.
For multiple test cases, it reads a list of integers and computes the sum of GCDs for each unique pair in the list.
The output is the sum of GCDs for each test case, printed on a new line.
이 Java 프로그램은 정수 리스트의 모든 쌍에 대한 최대공약수(GCD)의 합을 계산합니다.
여러 테스트 케이스에 대해, 정수 리스트를 읽고 리스트 안의 각 고유한 쌍에 대한 GCD의 합을 계산합니다.
출력은 각 테스트 케이스에 대한 GCD의 합으로, 새로운 줄에 출력됩니다.
*/

import java.io.*;
import java.util.*;

public class Q9613_GCD_Sum_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine()); // Number of test cases
		String s[] = new String[t]; // Array to hold each test case

		// Reading all test cases
		for (int i = 0; i < t; i++) {
			s[i] = br.readLine(); // Read each line as a test case
		}

		// Process each test case
		for (int i = 0; i < t; i++) {
			StringTokenizer stk = new StringTokenizer(s[i], " "); // Tokenizing the input
			int cnt = Integer.parseInt(stk.nextToken()); // Number of integers in this test case
			int temp[] = new int[cnt]; // Array to hold integers for the test case
			long res = 0; // Variable to store the sum of GCDs

			// Parse integers for the test case
			for (int z = 0; z < cnt; z++) {
				temp[z] = Integer.parseInt(stk.nextToken());
			}

			// Calculate GCD for each pair and add to the result
			for (int z = 0; z < cnt - 1; z++) {
				for (int x = z + 1; x < cnt; x++) {
					// Find GCD for the pair (temp[z], temp[x])
					for (int c = Math.min(temp[z], temp[x]); c >= 1; c--) {
						if (temp[z] % c == 0 && temp[x] % c == 0) {
							res += c; // Add the GCD to the result
							break; // Break out of the loop once GCD is found
						}
					}
				}
			}

			// Write the result of this test case to the output
			bw.write(String.valueOf(res) + "\n");
		}

		bw.flush(); // Ensure all outputs are written
		bw.close(); // Close the BufferedWriter
	}
}
