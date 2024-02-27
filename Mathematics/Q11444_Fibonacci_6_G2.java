package Mathematics;

/*
commented by ChatGPT
This Java code calculates the nth Fibonacci number using matrix exponentiation. 
It optimizes the process by utilizing the property that Fibonacci numbers can be generated by raising a specific matrix to the nth power. 
The code employs recursion and modulo operation to handle large numbers efficiently and avoid integer overflow.
이 Java 코드는 행렬 거듭제곱을 사용하여 n번째 피보나치 수를 계산합니다. 특정 행렬을 n번 거듭제곱하여 피보나치 수를 생성할 수 있는 속성을 활용하여 프로세스를 최적화합니다. 
코드는 재귀와 모듈로 연산을 사용하여 큰 숫자를 효율적으로 처리하고 정수 오버플로를 방지합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q11444_Fibonacci_6_G2 {

	static int init[][] = { { 1, 1 }, { 1, 0 } }; // Initial matrix for Fibonacci sequence generation
	static long matrix[][] = { { 1, 1 }, { 1, 0 } }; // Matrix used for exponentiation

// Squares the matrix and applies modulo to prevent overflow
	static void square() {
		long temp[][] = new long[2][2]; // Temporary matrix to hold the result

		// Matrix multiplication and modulo operation
		temp[0][0] = ((matrix[0][0] * matrix[0][0]) + (matrix[0][1] * matrix[1][0])) % 1000000007;
		temp[0][1] = ((matrix[0][0] * matrix[0][1]) + (matrix[0][1] * matrix[1][1])) % 1000000007;
		temp[1][0] = ((matrix[1][0] * matrix[0][0]) + (matrix[1][1] * matrix[1][0])) % 1000000007;
		temp[1][1] = ((matrix[1][0] * matrix[0][1]) + (matrix[1][1] * matrix[1][1])) % 1000000007;

		// Copying the result back to the original matrix
		matrix[0][0] = temp[0][0];
		matrix[0][1] = temp[0][1];
		matrix[1][0] = temp[1][0];
		matrix[1][1] = temp[1][1];
	}

// Multiplies the matrix with the initial matrix for odd powers
	static void mul() {
		long temp[][] = new long[2][2]; // Temporary matrix to hold the result

		// Matrix multiplication and modulo operation
		temp[0][0] = ((matrix[0][0] * init[0][0]) + (matrix[0][1] * init[1][0])) % 1000000007;
		temp[0][1] = ((matrix[0][0] * init[0][1]) + (matrix[0][1] * init[1][1])) % 1000000007;
		temp[1][0] = ((matrix[1][0] * init[0][0]) + (matrix[1][1] * init[1][0])) % 1000000007;
		temp[1][1] = ((matrix[1][0] * init[0][1]) + (matrix[1][1] * init[1][1])) % 1000000007;

		// Copying the result back to the original matrix
		matrix[0][0] = temp[0][0];
		matrix[0][1] = temp[0][1];
		matrix[1][0] = temp[1][0];
		matrix[1][1] = temp[1][1];
	}

// Recursive function to efficiently calculate the power of the matrix
	static void recur(long cur) {
		if (cur == 1) // Base case: if power is 1, no operation needed
			return;
		if (cur % 2 == 0) {
			recur(cur / 2); // If power is even, square the matrix
			square();
		} else {
			recur(cur / 2); // If power is odd, square the matrix and multiply by the initial matrix
			square();
			mul();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine()); // Reading the input for which Fibonacci number to calculate
		recur(n); // Calculating the nth power of the matrix

		bw.write(matrix[1][0] % 1000000007 + ""); // Writing the nth Fibonacci number to the output

		bw.flush();
		bw.close();
	}
}