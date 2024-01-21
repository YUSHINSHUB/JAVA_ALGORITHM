package Dynamic_Programming;

/*
commented by ChatGPT
This Java code implements a solution to find the longest common subsequence (LCS) between two strings using dynamic programming. 
The main function reads two strings and initializes a 2D array mem to store the lengths of common subsequences at different points. 
The dp function recursively calculates the length of the LCS and stores it in mem. 
It compares characters at the current indices of both strings. If they match, it increments the count of the LCS. 
If they don't match, it finds the maximum LCS length possible by either skipping a character from the first string or the second string. 
The code then reconstructs the LCS from the mem table by tracing back from the end of the strings and appending matching characters to a StringBuilder. 
Finally, it outputs the length and content of the LCS.
이 Java 코드는 동적 프로그래밍을 사용하여 두 문자열 간의 최장 공통 부분 수열(LCS)을 찾는 솔루션을 구현합니다. 
메인 함수는 두 문자열을 읽고 mem 2차원 배열을 초기화하여 다양한 지점에서 공통 부분 수열의 길이를 저장합니다. 
dp 함수는 재귀적으로 LCS의 길이를 계산하고 mem에 저장합니다. 이는 현재 두 문자열의 인덱스에서 문자를 비교합니다. 
문자가 일치하면 LCS의 카운트를 증가시킵니다. 일치하지 않으면 첫 번째 문자열 또는 두 번째 문자열에서 문자를 건너뛰어 가능한 최대 LCS 길이를 찾습니다. 
코드는 mem 테이블에서 문자열의 끝에서 거슬러 올라가 일치하는 문자를 StringBuilder에 추가함으로써 LCS를 재구성합니다. 
마지막으로 LCS의 길이와 내용을 출력합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q9252_LCS_2_G4 {
	static char str[][] = new char[2][1000]; // 두 문자열을 저장할 2차원 배열
	static int mem[][] = new int[1000][1000]; // 동적 프로그래밍을 위한 메모이제이션 배열

// LCS 길이를 계산하는 재귀 함수
	static int dp(int idx1, int idx2) {
		if (mem[idx1][idx2] >= 0) // 이미 계산된 값이 있는 경우 해당 값을 반환
			return mem[idx1][idx2];

		if (str[0][idx1] == str[1][idx2]) { // 두 문자가 일치하는 경우
			if (idx1 == 0 || idx2 == 0)
				mem[idx1][idx2] = 1; // 첫 번째 문자일 경우 1로 초기화
			else
				mem[idx1][idx2] = dp(idx1 - 1, idx2 - 1) + 1; // 두 문자가 일치하면 이전 문자까지의 LCS에 1을 추가
		} else { // 두 문자가 일치하지 않는 경우
			if (idx1 == 0 && idx2 == 0)
				mem[idx1][idx2] = 0; // 두 문자열의 시작 부분이면 0으로 초기화
			else if (idx1 == 0)
				mem[idx1][idx2] = dp(idx1, idx2 - 1); // 첫 번째 문자열의 첫 문자에 도달한 경우
			else if (idx2 == 0)
				mem[idx1][idx2] = dp(idx1 - 1, idx2); // 두 번째 문자열의 첫 문자에 도달한 경우
			else
				mem[idx1][idx2] = Math.max(dp(idx1 - 1, idx2), dp(idx1, idx2 - 1)); // 최대 LCS 길이 계산
		}

		return mem[idx1][idx2];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in;
		StringBuilder sb = new StringBuilder("");
		int alen, blen;

		// 첫 번째 문자열 읽기 및 저장
		in = br.readLine();
		alen = in.length() - 1;
		for (int i = 0; i <= alen; i++)
			str[0][i] = in.charAt(i);

		// 두 번째 문자열 읽기 및 저장
		in = br.readLine();
		blen = in.length() - 1;
		for (int i = 0; i <= blen; i++)
			str[1][i] = in.charAt(i);

		// 메모이제이션 배열 초기화
		for (int i = 0; i < 1000; i++) {
			Arrays.fill(mem[i], -1);
		}

		// LCS 계산 및 재구성
		if (alen != -1 && blen != -1) {
			int len = dp(alen, blen);
			while (len > 0) {
				for (int i = alen; i >= 0; i--) {
					if (mem[i][blen] == len && str[0][i] == str[1][blen]) {
						sb.append(str[1][blen]);
						alen = i - 1;
						len--;
						break;
					}
				}
				blen--;
			}
			bw.write(sb.toString().length() + "\n" + sb.reverse().toString());
		} else {
			bw.write("0");
		}

		bw.flush();
		bw.close();
	}
}