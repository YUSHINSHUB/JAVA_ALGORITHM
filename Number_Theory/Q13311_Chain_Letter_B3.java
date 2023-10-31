package Number_Theory;

/*
commented by ChatGPT
This Java program simply writes "-1" to the standard output and then closes the output stream.
이 Java 프로그램은 단순히 표준 출력에 "-1"을 쓴 후 출력 스트림을 닫습니다.
*/

import java.io.*;

public class Q13311_Chain_Letter_B3 {

	public static void main(String[] args) throws IOException {

		// Create a BufferedReader to read from the standard input (표준 입력에서 읽기 위한
		// BufferedReader를 생성합니다)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Create a BufferedWriter to write to the standard output (표준 출력에 쓰기 위한
		// BufferedWriter를 생성합니다)
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Write "-1" to the output stream (출력 스트림에 "-1"을 씁니다)
		bw.write("-1");

		// Flush the output stream to ensure all data is written out (모든 데이터가 쓰여졌는지 확인하기
		// 위해 출력 스트림을 flush합니다)
		bw.flush();
		// Close the output stream (출력 스트림을 닫습니다)
		bw.close();
		// The BufferedReader 'br' is not used and therefore not closed, which could be
		// considered a resource leak (사용되지 않은 BufferedReader 'br'은 닫히지 않으므로 리소스 누수로 간주될
		// 수 있습니다)
	}

}
