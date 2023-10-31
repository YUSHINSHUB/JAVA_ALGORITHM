package Number_Theory;

/*
commented by ChatGPT
This Java program calculates the sum of all positive divisors of a given number, multiplies it by 5, and then subtracts 24. 
The result is then output to the console.
이 Java 프로그램은 주어진 수의 모든 양의 약수의 합을 계산하고, 그것에 5를 곱한 다음 24를 빼서 결과를 콘솔에 출력합니다.
*/

import java.io.*;
import java.math.*;

public class Q15633_Fan_Death_B3 {

	public static void main(String[] args) throws IOException {

		// Setup buffered reader and writer for efficient I/O (효율적인 입출력을 위한 버퍼드 리더 및 라이터
		// 설정)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the integer from the user (사용자로부터 정수를 읽음)
		int n = Integer.parseInt(br.readLine());
		// Initialize the result variable (결과 변수 초기화)
		int res = 0;

		// Loop over all possible divisors up to the square root of n (n의 제곱근까지 모든 가능한
		// 약수에 대해 반복)
		for (int i = 1; i <= Math.sqrt(n); i++) {
			// If i is a divisor of n (i가 n의 약수인 경우)
			if (n % i == 0) {
				// Add the divisor to the result (약수를 결과에 추가)
				res += i;
				// Add the quotient to the result (몫을 결과에 추가)
				res += n / i;
				// If the divisor and quotient are the same, subtract it once as it was added
				// twice (약수와 몫이 같은 경우, 두 번 추가된 것을 한 번 빼줌)
				if (i == n / i)
					res -= i;
			}
		}

		// Calculate the final result by multiplying by 5 and subtracting 24 (최종 결과를 5를
		// 곱하고 24를 빼서 계산)
		bw.write(res * 5 - 24 + "");

		// Flush the buffer and close the writer (버퍼를 비우고 라이터를 닫음)
		bw.flush();
		bw.close();

	}

}
