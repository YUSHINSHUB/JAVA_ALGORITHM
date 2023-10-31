package Number_Theory;

/*
commented by ChatGPT
This Java program implements the Sieve of Eratosthenes algorithm to find the k-th smallest prime number within a given range.
It starts by initializing an array to keep track of which numbers are prime (true) or not (false), then iteratively marks non-prime numbers.
The goal is to find the k-th number that gets marked as non-prime (composite number), and once it is found, the program terminates and prints the result.
이 Java 프로그램은 주어진 범위 내에서 k번째로 작은 소수를 찾기 위해 에라토스테네스의 체 알고리즘을 구현합니다.
소수(참)와 소수가 아닌 수(거짓)를 추적하기 위한 배열을 초기화한 후, 비소수를 순차적으로 표시합니다.
목표는 비소수(합성수)로 표시되는 k번째 수를 찾는 것이며, 이를 찾으면 프로그램은 종료되고 결과를 출력합니다.
*/

import java.io.*;

public class Q2960_Sieve_of_Eratosthenes_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in[] = br.readLine().split(" "); // Splitting the input line to get n and k
		int n = Integer.parseInt(in[0]); // The maximum number to check for primality
		int k = Integer.parseInt(in[1]); // The k-th non-prime number to find
		int cnt = 0; // Counter for the number of non-prime numbers found
		int res = 0; // The k-th non-prime number

		boolean chk[] = new boolean[n + 1]; // Boolean array to mark non-prime numbers
		boolean end = false; // Flag to indicate that the k-th non-prime number has been found

		// Initially mark all even numbers as non-prime
		for (int i = 2; i <= n; i += 2) {
			if (!chk[i]) {
				chk[i] = true;
				cnt++;
				if (cnt == k) {
					res = i;
					break;
				}
			}
		}

		// If k-th non-prime hasn't been found among evens, check the odds
		if (cnt != k) {
			for (int i = 3; i <= n; i += 2) {
				if (!chk[i]) {
					for (int z = i; z <= n; z += i) {
						if (!chk[z]) {
							chk[z] = true;
							cnt++;
							if (cnt == k) {
								res = z;
								end = true;
								break;
							}
						}
					}
					if (end)
						break; // Exit if k-th non-prime is found
				}
			}
		}

		bw.write(res + ""); // Write the result

		bw.flush();
		bw.close();
	}
}
