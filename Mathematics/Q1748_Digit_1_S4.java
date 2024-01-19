package Mathematics;

/*
commented by ChatGPT
This Java code calculates the total number of digits required to write down all the numbers from 1 to N. 
The main function reads an integer N, calculates the number of digits in N, and then uses a loop to sum the total number of digits for each range of numbers. 
For example, for numbers less than 10, 1 digit each is required, for numbers less than 100, 2 digits each, and so on. 
The code accounts for the final range of numbers that might not complete the full cycle of 10s (like 100 to N, where N < 1000) and adds this count separately. 
A special case is handled when N is a single-digit number.
이 Java 코드는 1부터 N까지 모든 숫자를 작성하는데 필요한 숫자의 총 개수를 계산합니다. 
메인 함수는 정수 N을 읽고, N의 숫자 개수를 계산한 다음, 숫자의 각 범위에 대한 총 숫자 개수를 합산하기 위해 반복문을 사용합니다. 
예를 들어, 10 미만의 숫자에는 각각 1개의 숫자가 필요하고, 100 미만의 숫자에는 각각 2개의 숫자가 필요합니다. 
코드는 10의 완전한 사이클을 완성하지 않는 최종 숫자 범위(예: 100에서 N까지, N < 1000)에 대해 별도로 계산하여 추가합니다. 
N이 한 자리 숫자일 경우의 특별한 경우도 처리합니다.
*/

import java.io.*;
import java.math.*;

public class Q1748_Digit_1_S4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, len; // N: 입력받은 숫자, len: N의 자리수
		int pl = 9; // 10의 거듭제곱에서 -1한 값 (예: 9, 99, 999)
		int res = 0; // 결과값을 저장할 변수

		N = Integer.parseInt(br.readLine()); // N 입력 받기
		len = (int) Math.log10(N); // N의 자리수 계산

		// 1자리 수부터 (N의 자리수-1)까지 각 자리수별 숫자 개수 합산
		for (int i = 1; i <= len; i++) {
			res += pl * i;
			pl *= 10;
		}

		// 마지막 자리수 구간의 시작 숫자 계산 (예: 100, 1000)
		pl /= 10;
		pl += (pl / 9) - 1;

		// 마지막 자리수 구간에 대한 숫자 개수 추가
		res += (len + 1) * (N - pl);

		// N이 한 자리 숫자일 경우, N을 결과값으로 설정
		if (N / 10 == 0)
			res = N;

		bw.write(res + ""); // 결과 출력

		bw.flush();
		bw.close();
	}
}