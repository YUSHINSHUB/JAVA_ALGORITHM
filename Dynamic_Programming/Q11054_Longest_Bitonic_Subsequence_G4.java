package Dynamic_Programming;

/*
commented by ChatGPT
This Java code finds the maximum length of a subsequence that appears both as a contiguous increasing subsequence and as a contiguous decreasing subsequence within a sequence of numbers. 
The program uses dynamic programming and array manipulation techniques.
이 Java 코드는 숫자 시퀀스 내에서 연속적으로 증가하는 부분 시퀀스 및 연속적으로 감소하는 부분 시퀀스로 모두 나타나는 부분 시퀀스의 최대 길이를 찾습니다. 
프로그램은 동적 프로그래밍 및 배열 조작 기술을 사용합니다.
*/

import java.io.*;
import java.util.*;

public class Q11054_Longest_Bitonic_Subsequence_G4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // 숫자의 개수 입력 (Input the number count)
		int res = 0; // 결과값 초기화 (Initialize the result)
		int bi[] = new int[n];
		int mem[][] = new int[n][2]; // 메모이제이션 배열 (Memoization array)
		int chk[] = new int[1001]; // 각 숫자에 대한 체크 배열 (Check array for each number)
		Arrays.fill(chk, 0); // 초기화 (Initialization)

		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			bi[i] = Integer.parseInt(inp[i]);

			// 연속된 증가 부분 시퀀스에 대한 처리 (Handling for the contiguous increasing subsequence)
			chk[bi[i]] = chk[bi[i] - 1] + 1;
			mem[i][0] = chk[bi[i]];

			for (int j = bi[i] + 1; j <= 1000; j++) {
				if (chk[j] < chk[bi[i]])
					chk[j] = chk[bi[i]];
				else
					break;
			}

		}

		Arrays.fill(chk, 0); // 초기화 (Initialization)

		for (int i = n - 1; i >= 0; i--) {

			// 연속된 감소 부분 시퀀스에 대한 처리 (Handling for the contiguous decreasing subsequence)
			chk[bi[i]] = chk[bi[i] - 1] + 1;
			mem[i][1] = chk[bi[i]];

			for (int j = bi[i] + 1; j <= 1000; j++) {
				if (chk[j] < chk[bi[i]])
					chk[j] = chk[bi[i]];
				else
					break;
			}

			// 최대 길이 업데이트 (Updating the maximum length)
			if (mem[i][0] + mem[i][1] > res)
				res = mem[i][0] + mem[i][1] - 1;
		}

		bw.write(res + ""); // 결과 출력 (Output the result)

		bw.flush();
		bw.close();
	}
}