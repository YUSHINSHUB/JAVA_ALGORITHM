//이 코드는 a, b, c를 입력받아 함수 recur을 호출하는 main 함수와, 재귀적으로 a^b를 계산하는 recur 함수로 이루어져 있습니다. 
//recur 함수는 b가 0일 경우 1을 반환하고, b가 짝수일 경우 a^(b/2)를 먼저 계산하여 그 결과를 제곱하고, 
//b가 홀수일 경우 a^(b/2)를 먼저 계산하여 그 결과를 제곱한 후 다시 a를 곱합니다. 
//모든 중간 결과는 c로 나눈 나머지를 사용하여 오버플로우를 방지합니다.
package Exponentiation_By_Squaring;

import java.io.*;

public class Q1629_MULTIPLICATION_S1 {

	static long recur(long a, long b, long c) { // a^b를 계산하되, 중간 계산 결과도 c로 나눈 나머지를 사용
		if (b == 0) { // 지수가 0이면 1을 반환
			return 1;
		} else if (b % 2 == 0) { // 지수가 짝수이면, a^(b/2)를 먼저 계산하여 그 결과를 제곱
			long re = recur(a, b / 2, c) % c;
			return (re * re) % c;
		} else { // 지수가 홀수이면, a^(b/2)를 먼저 계산하여 그 결과를 제곱한 다음 a를 곱함
			long re = recur(a, b / 2, c) % c;
			return (re * (((re) * (a % c)) % c)) % c;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" "); // 입력을 받아서

		long a = Long.parseLong(inp[0]);
		long b = Long.parseLong(inp[1]);
		long c = Long.parseLong(inp[2]); // a, b, c를 파싱

		bw.write(String.valueOf(recur(a, b, c))); // recur 함수를 호출하여 결과를 출력

		bw.flush();
		bw.close();

	}
}