package Tree;

/*
commented by ChatGPT
This Java code checks whether there exists a phone number in a given list of phone numbers that is a prefix of another phone number. 
If such a number exists, it outputs "NO", otherwise it outputs "YES".
이 Java 코드는 주어진 전화번호 목록에서 하나의 전화번호가 다른 전화번호의 접두사인지 확인합니다. 
그런 번호가 있다면 "NO"를 출력하고, 그렇지 않으면 "YES"를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q5052_Number_List_G4 {

	public static void main(String[] args) throws IOException {

		// I/O Initialization (입출력 초기화)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the number of test cases (테스트 케이스의 수 읽기)
		int t = Integer.parseInt(br.readLine());

		// This variable stores the final answer for each test case (이 변수는 각 테스트 케이스에 대한
		// 최종 답을 저장합니다)
		Boolean out = true;

		// Iterate over all test cases (모든 테스트 케이스를 반복)
		for (int i = 0; i < t; i++) {

			// Reading the number of phone numbers for current test case (현재 테스트 케이스에 대한
			// 전화번호 수 읽기)
			int n = Integer.parseInt(br.readLine());

			// Storing phone numbers in an array (전화번호를 배열에 저장)
			String num[] = new String[n];

			// HashMap to keep track of the phone numbers we have seen so far (지금까지 본 전화번호를
			// 추적하기 위한 HashMap)
			HashMap<String, Boolean> hm = new HashMap<>();

			// Read and store phone numbers for current test case (현재 테스트 케이스에 대한 전화번호 읽기 및
			// 저장)
			for (int j = 0; j < n; j++) {
				num[j] = br.readLine();
			}

			// Sort phone numbers by their length to check prefixes (접두사를 확인하기 위해 전화번호를 길이별로
			// 정렬)
			Arrays.sort(num, Comparator.comparingInt(String::length));

			out = true;

			// Check if a number is a prefix of another number (번호가 다른 번호의 접두사인지 확인)
			for (int j = 0; j < n; j++) {
				StringBuilder sb = new StringBuilder("");
				for (int k = 0; k < num[j].length(); k++) {
					sb.append(num[j].charAt(k));
					// If we've seen this substring before, it means it's a prefix of another number
					// (이 서브스트링을 이전에 봤다면 다른 번호의 접두사라는 의미입니다)
					if (hm.getOrDefault(sb.toString(), false)) {
						out = false;
						break;
					}
				}
				// Storing the current number in the hashmap (현재 번호를 hashmap에 저장)
				hm.put(num[j], true);

				// If a prefix is found, break the loop (접두사가 발견되면 루프를 끊습니다)
				if (!out)
					break;
			}

			// Output the result for the current test case (현재 테스트 케이스에 대한 결과 출력)
			if (out)
				bw.write("YES\n");
			else
				bw.write("NO\n");

		}

		// Closing the BufferedWriter (BufferedWriter 종료)
		bw.flush();
		bw.close();
	}
}