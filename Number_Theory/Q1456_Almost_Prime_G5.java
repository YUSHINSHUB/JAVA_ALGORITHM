package Number_Theory;

/*
commented by ChatGPT
This Java code counts how many numbers between A and B are "almost prime". 
A number is "almost prime" if it is a power of a prime number with the exponent greater than or equal to 2.
이 Java 코드는 A와 B 사이에 몇 개의 숫자가 "거의 소수"인지 계산합니다. 
"거의 소수"란, 지수가 2 이상인 소수의 거듭제곱인 숫자를 말합니다.
*/

import java.io.*;
import java.util.*;

public class Q1456_Almost_Prime_G5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 받은 문자열을 나누고 A와 B를 파싱
		String[] inp = br.readLine().split(" ");
		long A = Long.parseLong(inp[0]); // 범위의 시작 숫자 A
		long B = Long.parseLong(inp[1]); // 범위의 끝 숫자 B
		int sq = (int) Math.sqrt(B) + 1; // B의 제곱근을 계산하여 체의 크기를 정함
		int[] era = new int[sq]; // 에라토스테네스의 체를 구현하기 위한 배열
		int res = 0; // "거의 소수"의 수를 세는 카운터

		// 에라토스테네스의 체 초기화
		Arrays.fill(era, 0); // 배열을 0으로 초기화
		era[0] = 1; // 0은 소수가 아님
		era[1] = 1; // 1은 소수가 아님

		// 2부터 시작하여 소수를 찾고 체에 기록
		for (int i = 2; i < sq; i++) {
			if (era[i] == 0) { // i가 소수라면
				for (int j = i * 2; j < sq; j += i) {
					era[j] = 1; // i의 배수들은 소수가 아님
				}
			}
		}

		// 거의 소수를 세기 위한 반복문
		for (long i = 2; i < sq; i++) {
			if (era[(int) i] == 0) { // 소수인 경우
				long temp = i * i; // 소수의 제곱부터 시작
				while (true) {
					if (temp >= A) { // A 이상이면 카운트 증가
						res++;
					}
					if (temp > B / i) { // B를 넘어서면 루프 종료
						break;
					}
					temp *= i; // 다음 거듭제곱 계산
				}
			}
		}

		// 결과 출력
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
