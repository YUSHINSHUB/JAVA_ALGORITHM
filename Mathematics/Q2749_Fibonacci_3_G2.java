package Mathematics;

/*
commented by ChatGPT
This Java program calculates the nth Fibonacci number modulo 1,000,000, where n is a large number that can exceed the limits of typical computational approaches. 
To handle the large input efficiently, the program uses Pisano Period property, which for modulo 10^6 is 1,500,000. 
This means the Fibonacci sequence under modulo 1,000,000 repeats every 1,500,000 numbers. 
The program first reduces the large input n modulo 1,500,000 to find the equivalent smaller n within the repeating sequence. 
It then calculates the Fibonacci sequence up to this reduced n, using a modulo operation at each step to ensure numbers remain within the bounds of integer arithmetic. 
The final result is the nth Fibonacci number modulo 1,000,000, efficiently computed to handle large inputs.
이 Java 프로그램은 1,000,000으로 나눈 nth 피보나치 수를 계산합니다. 여기서 n은 전형적인 계산 접근 방식의 한계를 초과할 수 있는 큰 수입니다. 
이 프로그램은 대규모 입력을 효율적으로 처리하기 위해 피사노 주기 속성을 사용합니다. 1,000,000 모듈로의 경우 피사노 주기는 1,500,000입니다. 
이는 1,000,000 모듈로 하에 피보나치 수열이 1,500,000번 마다 반복된다는 것을 의미합니다. 
프로그램은 먼저 대규모 입력 n을 1,500,000으로 나누어 반복되는 수열 내에서 동등한 더 작은 n을 찾습니다. 
그런 다음 이 감소된 n까지 피보나치 수열을 계산하며, 각 단계에서 모듈로 연산을 사용하여 숫자가 정수 산술의 범위 내에 있도록 합니다. 
최종 결과는 대규모 입력을 효율적으로 처리하여 계산된 1,000,000으로 나눈 nth 피보나치 수입니다.
*/

import java.io.*;
import java.util.*;

public class Q2749_Fibonacci_3_G2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int fib[] = new int[1500000]; // Array to store Fibonacci numbers modulo 1,000,000
		int n; // Variable to store reduced n
		long inp; // Variable to read the input

		inp = Long.parseLong(br.readLine()); // Read input
		n = (int) (inp % 1500000); // Reduce input n modulo 1,500,000 due to Pisano Period
		Arrays.fill(fib, 0); // Initialize Fibonacci array
		fib[1] = 1; // Base case for Fibonacci sequence
		for (int i = 2; i <= n; i++) // Calculate Fibonacci numbers up to reduced n
			fib[i] = (fib[i - 1] + fib[i - 2]) % 1000000; // Ensure each number is modulo 1,000,000

		bw.write(fib[n] + ""); // Write the nth Fibonacci number modulo 1,000,000
		bw.flush();
		bw.close();
	}
}
