package Ad_hoc;

/*
commented by ChatGPT
This Java program reads an integer from the standard input and writes a specific output based on the read integer's value.
If the integer is less than 3, it writes "4". If the integer is even, it writes the integer itself. If the integer is odd, it writes the integer plus one.
이 Java 프로그램은 표준 입력에서 정수를 읽고 읽은 정수의 값에 따라 특정 출력을 작성합니다.
정수가 3보다 작으면 "4"를 씁니다. 정수가 짝수이면 정수 자체를 씁니다. 정수가 홀수이면 정수에 1을 더한 값을 씁니다.
*/

import java.io.*;

public class Q27465_Not_Prime_B3 {

	public static void main(String[] args) throws IOException {
		// Set up to read input from the console and write output to the console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read a line from the console and parse it as an integer
		int n = Integer.parseInt(br.readLine());

		// Check if the input integer is less than 3
		if (n < 3) {
			// If n is less than 3, write "4" to the output
			bw.write("4");
		}
		// Check if the input integer is an even number
		else if (n % 2 == 0) {
			// If n is even, write the integer itself to the output
			bw.write(n + "");
		}
		// If the input integer is not less than 3 or even, it must be odd
		else {
			// If n is odd, write the integer plus one to the output
			bw.write((n + 1) + "");
		}

		// Flush the output stream to ensure all data is written out
		bw.flush();
		// Close the output stream
		bw.close();
	}
}
