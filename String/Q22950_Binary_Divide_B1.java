package String;

/*
commented by ChatGPT
This Java program reads an integer N, a string M representing a number, and an integer K, then checks if the last K digits of M are all zeros. 
If they are, it outputs "YES"; otherwise, it outputs "NO".
이 Java 프로그램은 정수 N, 숫자를 나타내는 문자열 M, 그리고 정수 K를 읽고, M의 마지막 K자리가 모두 0인지 확인합니다. 
모두 0이면 "YES"를 출력하고, 그렇지 않으면 "NO"를 출력합니다.
*/

import java.io.*;

public class Q22950_Binary_Divide_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, K; // N: Length of the number, K: Number of digits to check (N: 숫자의 길이, K: 확인할 숫자의
					// 자릿수)
		String M; // M: The number as a string (M: 문자열로 된 숫자)
		Boolean yes = true; // Flag to indicate if condition is met (조건이 충족되었는지 나타내는 플래그)
		int idx = 0; // Index counter (인덱스 카운터)

		N = Integer.parseInt(br.readLine()); // Read the length of the number (숫자의 길이 읽기)
		M = br.readLine(); // Read the number as a string (문자열로 숫자 읽기)
		K = Integer.parseInt(br.readLine()); // Read the number of digits to check (확인할 자릿수 읽기)

		// Loop to check the last K digits of M
		for (int i = N - 1; i >= 0; i--) {
			idx++; // Increment index counter (인덱스 카운터 증가)
			if (idx > K) // If checked enough digits, break (충분한 자릿수를 확인했다면 중단)
				break;
			if (M.charAt(i) != '0') { // If a non-zero digit is found, set flag to false and break (0이 아닌 숫자가 발견되면
										// 플래그를 false로 설정하고 중단)
				yes = false;
				break;
			}
		}

		// Write the result based on the flag
		if (yes)
			bw.write("YES");
		else
			bw.write("NO");

		bw.flush(); // Flush the output stream (출력 스트림 플러시)
		bw.close(); // Close the output stream (출력 스트림 닫기)

	}

}
