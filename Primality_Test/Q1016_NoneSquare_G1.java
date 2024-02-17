package Primality_Test;

/*
commented by ChatGPT
This Java program calculates the count of numbers within a given range [low, high] that are not divisible by any perfect square greater than 1. 
It utilizes an Eratosthenes sieve-like method to mark numbers that are divisible by a perfect square. 
The era array represents whether a number in the range has been marked as divisible by a perfect square. 
The program iterates through potential divisors starting from 2 up to the square root of the high limit, marking multiples of the divisor's square within the range. 
The goal is to identify numbers that remain unmarked, as these are not divisible by any perfect square other than 1, thereby counting them towards the result.
이 Java 프로그램은 주어진 범위 [low, high] 내에서 1보다 큰 완전 제곱수로 나눌 수 없는 숫자의 수를 계산합니다. 
완전 제곱수로 나눌 수 있는 숫자를 표시하기 위해 에라토스테네스의 체 방법과 유사한 방식을 사용합니다. era 배열은 범위 내의 숫자가 완전 제곱수로 나눌 수 있는지 여부를 나타냅니다. 
프로그램은 2부터 high 제한의 제곱근까지의 가능한 나눗수를 순회하면서 범위 내에서 나눗수의 제곱의 배수를 표시합니다. 
목표는 표시되지 않은 숫자를 식별하는 것이며, 이러한 숫자는 1 이외의 어떤 완전 제곱수로도 나눌 수 없으므로 결과에 계산됩니다.
*/

import java.io.*;
import java.util.*;

public class Q1016_NoneSquare_G1 {

	static Boolean era[] = new Boolean[1000001]; // Boolean array to mark numbers divisible by a perfect square

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		long low, hig;
		int res = 0; // Result variable to store the count of numbers

		inp = br.readLine().split(" ");
		low = Long.parseLong(inp[0]);
		hig = Long.parseLong(inp[1]);
		Arrays.fill(era, false); // Initialize all values to false indicating unmarked

		// Iterate through potential divisors
		for (long i = 2; i * i <= hig; i++) {
			// Start marking from the lowest multiple of i*i within the range
			long start = low + (i * i) - (low % (i * i));
			if (low % (i * i) == 0)
				start = low; // If low is divisible by i*i, start from low
			for (long j = start; j <= hig; j += i * i) {
				era[(int) (j - low)] = true; // Mark numbers divisible by i*i
			}
		}

		// Count unmarked numbers
		for (int i = 0; i <= hig - low; i++) {
			if (!era[i])
				res++; // Increment result for unmarked numbers
		}

		bw.write(res + ""); // Output the result
		bw.flush();
		bw.close();
	}
}
