package Greedy;

/*
commented by ChatGPT
This Java code solves the problem of finding the maximum sum that can be obtained by assigning unique decimal values to the alphabets of a set of input words. 
It prioritizes alphabets by their positional values in the words, making sure the most significant alphabets get the highest values.
이 Java 코드는 입력된 단어들의 알파벳에 고유한 십진 값들을 할당함으로써 얻을 수 있는 최대 합을 찾는 문제를 해결합니다. 
코드는 단어 내에서의 알파벳의 위치 값에 따라 알파벳들을 우선 순위를 매기며, 가장 중요한 알파벳에 가장 높은 값을 부여합니다.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1339_Word_Math_G4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // Number of words (단어의 수)
		String inp[] = new String[N]; // Array to store words (단어를 저장하는 배열)
		int res = 0; // Resulting maximum sum (결과적인 최대 합)
		int cnt[] = new int[26]; // Array to store positional values of each alphabet (각 알파벳의 위치 값 저장 배열)
		int conv[] = new int[26]; // Conversion array to assign unique values to alphabets (알파벳에 고유한 값을 할당하기 위한 변환
									// 배열)
		int idx = 9; // Starting index for assigning unique values (고유 값을 할당하기 위한 시작 인덱스)
		Arrays.fill(cnt, 0); // Initializing cnt array with zeros (cnt 배열을 0으로 초기화)

		// Calculate positional value for each alphabet in the input words
		// 입력 단어의 각 알파벳에 대한 위치 값 계산
		for (int i = 0; i < N; i++) {
			inp[i] = br.readLine();
			for (int j = 0; j < inp[i].length(); j++) {
				cnt[inp[i].charAt(j) - 'A'] += Math.pow(10, inp[i].length() - j);
			}
		}

		// Assign unique decimal values to alphabets based on their positional
		// importance
		// 위치 값 중요도를 기반으로 알파벳에 고유한 십진 값을 할당
		while (true) {
			int hig = 0;
			int hidx = -1;
			// Find alphabet with highest positional value
			// 가장 높은 위치 값의 알파벳 찾기
			for (int i = 0; i < 26; i++) {
				if (cnt[i] > hig) {
					hig = cnt[i];
					hidx = i;
				}
			}
			if (hig == 0) // Exit condition once all positional values are considered
				break;
			conv[hidx] = idx; // Assign the current highest available value
			cnt[hidx] = 0;
			idx--;
		}

		// Calculate the final sum using the assigned values
		// 할당된 값들을 사용하여 최종 합계 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < inp[i].length(); j++) {
				res += Math.pow(10, inp[i].length() - j - 1) * conv[inp[i].charAt(j) - 'A'];
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}