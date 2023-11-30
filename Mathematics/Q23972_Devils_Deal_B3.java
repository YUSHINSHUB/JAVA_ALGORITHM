package Mathematics;

/*
commented by ChatGPT
This Java code calculates the smallest integer res for given N and K values where res * (K - 1) is greater than or equal to N * K. 
If K is equal to 1, the code outputs -1 as it is not possible to find a valid res. 
The code ensures that res is the smallest possible value that meets the condition, by checking if (N * K) % (K - 1) is zero or not. 
If it is zero, res is (N * K) / (K - 1), otherwise, res is ((N * K) / (K - 1)) + 1.

이 Java 코드는 주어진 N과 K 값에 대해 res * (K - 1)이 N * K보다 크거나 같은 가장 작은 정수 res를 계산합니다. 
K가 1과 같으면, 유효한 res를 찾을 수 없으므로 코드는 -1을 출력합니다. 
코드는 (N * K) % (K - 1)이 0인지 아닌지를 확인하여 res가 조건을 만족하는 가능한 가장 작은 값임을 보장합니다. 
0이면 res는 (N * K) / (K - 1)이고, 그렇지 않으면 res는 ((N * K) / (K - 1)) + 1입니다.
*/

import java.io.*;

public class Q23972_Devils_Deal_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N, K; // N과 K 변수 선언
		long res; // 결과값을 저장할 변수

		// 입력값을 받아 N과 K에 할당
		String inp[] = br.readLine().split(" ");
		N = Long.parseLong(inp[0]);
		K = Long.parseLong(inp[1]);

		// K가 1인 경우, 유효한 res 값을 찾을 수 없으므로 -1 출력
		if (K == 1) {
			bw.write("-1");
		} else {
			// res 값을 계산
			if ((N * K) % (K - 1) != 0) // N * K가 K - 1로 나누어 떨어지지 않으면 1을 더해줌
				res = ((N * K) / (K - 1)) + 1;
			else // 나누어 떨어지면 그대로 계산
				res = (N * K) / (K - 1);

			bw.write(res + ""); // 결과값 출력
		}

		bw.flush();
		bw.close();

	}
}