package String;

/*
commented by ChatGPT
This Java code reads input strings and calculates the longest consecutive character sequence for each line. 
It outputs the maximum count of any repeated character in each string.
이 Java 코드는 입력 문자열을 읽고 각 줄에 대해 가장 긴 연속 문자 시퀀스를 계산합니다. 
각 문자열에서 반복되는 문자의 최대 개수를 출력합니다.
*/

import java.io.*;

public class Q2495_Consecutive_Sequence_B2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 3; i++) { // 각 줄에 대하여 실행
			String in = br.readLine(); // 한 줄을 읽음
			int idx = 1; // 연속된 문자의 현재 길이를 나타내는 변수
			int res = 1; // 최대 연속 문자 길이를 저장하는 변수

			for (int j = 1; j < 8; j++) { // 문자열의 각 문자를 순회
				if (in.charAt(j) == in.charAt(j - 1)) { // 현재 문자가 이전 문자와 같다면
					idx++; // 연속 길이 증가
					res = Math.max(res, idx); // 최대값 갱신
				} else {
					idx = 1; // 다른 문자가 나오면 연속 길이를 1로 초기화
				}
			}
			bw.write(res + "\n"); // 가장 긴 연속 길이를 출력
		}

		bw.flush();
		bw.close();
	}
}
