package Dynamic_Programming;

/*
commented by ChatGPT
This Java code determines if a substring of a given sequence of numbers is a palindrome. It utilizes dynamic programming for efficiency.
이 Java 코드는 주어진 숫자 시퀀스의 부분 문자열이 회문인지 여부를 결정합니다. 효율성을 위해 동적 프로그래밍을 사용합니다.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10942_Palindrome_G4 {

	static int n; // 숫자의 개수 (Number of digits in the sequence)
	static int pal[]; // 주어진 숫자 시퀀스 (The given sequence of numbers)
	static boolean mem[][]; // 메모이제이션을 위한 배열 (Array for memoization)
	static boolean visited[][]; // 해당 인덱스의 값이 계산되었는지 확인하는 배열 (Array to check if the value for the index has been
								// computed)

// s부터 e까지의 숫자가 회문인지 결정하는 함수 (Function to determine if the numbers from s to e form a palindrome)
	static boolean dp(int s, int e) {

		if (visited[s][e])
			return mem[s][e];
		else if (s == e - 1) {
			visited[s][e] = true;
			if (pal[s] == pal[e])
				mem[s][e] = true;
			else
				mem[s][e] = false;
		} else if (pal[s] != pal[e]) {
			mem[s][e] = false;
			visited[s][e] = true;
		} else {
			mem[s][e] = dp(s + 1, e - 1);
			visited[s][e] = true;
		}

		return mem[s][e];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine()); // 첫 번째 숫자의 개수를 입력 (Input the count of first set of numbers)
		pal = new int[n + 1];
		mem = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		String inp[] = br.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			pal[i] = Integer.parseInt(inp[i - 1]);
			mem[i][i] = true; // 같은 인덱스에서는 항상 회문 (A palindrome for the same indices)
			visited[i][i] = true;
		}

		n = Integer.parseInt(br.readLine()); // 두 번째 숫자의 개수를 입력 (Input the count of second set of numbers)

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			int s = Integer.parseInt(inp[0]);
			int e = Integer.parseInt(inp[1]);
			if (dp(s, e))
				bw.write("1\n"); // 회문인 경우 (In case it's a palindrome)
			else
				bw.write("0\n"); // 회문이 아닌 경우 (In case it's not a palindrome)
		}

		bw.flush();
		bw.close();

	}
}