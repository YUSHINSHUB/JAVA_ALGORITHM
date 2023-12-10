package Bruteforcing;

/*
commented by ChatGPT
This Java code implements a backtracking solution to find the largest and smallest numbers that can be formed according to given inequality constraints. 
The problem involves a sequence of '<' and '>' symbols representing inequalities between consecutive digits of the number. 
The code generates all possible numbers that satisfy these constraints and finds the maximum and minimum values among them.
이 Java 코드는 주어진 부등식 제약 조건에 따라 형성될 수 있는 가장 크고 작은 숫자를 찾기 위한 백트래킹 솔루션을 구현합니다. 
이 문제는 숫자의 연속적인 숫자 사이의 부등식을 나타내는 '<' 및 '>' 기호의 시퀀스를 포함합니다. 
코드는 이러한 제약 조건을 만족하는 모든 가능한 숫자를 생성하고 그 중 최대 및 최소 값을 찾습니다.
*/

import java.io.*;
import java.util.*;

public class Q2529_Inequality_S1 {

	static ArrayList<Character> sym = new ArrayList<>(); // List to store inequality symbols
	static int K; // Number of inequality symbols
	static long low = Long.MAX_VALUE, hig = Long.MIN_VALUE; // Variables to store smallest and largest numbers
	static String lout, hout; // Strings to store smallest and largest numbers as string
	static boolean visited[] = new boolean[10]; // Array to keep track of visited digits

// Backtracking function to generate numbers according to the inequalities
	static void bt(int idx, String res, int cur) {

		// Base case: if all inequalities are processed
		if (idx == K) {
			long temp = Long.parseLong(res); // Convert the current result string to a number
			// Update lowest and highest numbers if necessary
			if (low > temp) {
				lout = res;
				low = temp;
			}

			if (hig < temp) {
				hout = res;
				hig = temp;
			}
			return;
		}

		// If the current symbol is '>', find a smaller digit than the current one
		if (sym.get(idx) == '>') {
			for (int i = cur - 1; i >= 0; i--) {
				if (visited[i]) // Skip if the digit is already used
					continue;
				visited[i] = true;
				bt(idx + 1, res + i, i); // Call backtracking for the next symbol
				visited[i] = false; // Backtrack
			}
		}
		// If the current symbol is '<', find a larger digit than the current one
		else {
			for (int i = cur + 1; i <= 9; i++) {
				if (visited[i]) // Skip if the digit is already used
					continue;
				visited[i] = true;
				bt(idx + 1, res + i, i); // Call backtracking for the next symbol
				visited[i] = false; // Backtrack
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(visited, false); // Initialize all digits as not visited
		K = Integer.parseInt(br.readLine()); // Read the number of symbols
		String in = br.readLine();
		// Read the inequality symbols and add them to the list
		for (int i = 0; i <= K * 2 - 2; i += 2) {
			sym.add(in.charAt(i));
		}

		// Start backtracking from each digit
		for (int i = 0; i <= 9; i++) {
			visited[i] = true;
			bt(0, "" + i, i);
			visited[i] = false;
		}

		bw.write(hout + "\n" + lout); // Write the largest and smallest numbers
		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter

	}
}
