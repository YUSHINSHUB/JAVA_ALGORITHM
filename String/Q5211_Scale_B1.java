package String;

/*
commented by ChatGPT
This Java code determines the key of a musical piece as either A-minor or C-major based on the notes used. 
The input is a string of notes, separated by "|". 
Each note increases the count for its respective key (A, D, E for A-minor; C, F, G for C-major). 
The key with the higher count is chosen. 
If the counts are equal, the last note in the piece decides the key, favoring A-minor for A, D, E, and C-major for other notes. 
This method assumes the piece is in either A-minor or C-major, with no consideration for other keys or modes.

이 Java 코드는 사용된 음표에 따라 음악 작품의 키를 A단조 또는 C장조로 결정합니다. 
입력은 "|"로 구분된 음표 문자열입니다. 
각 음표는 해당 키(A단조의 경우 A, D, E; C장조의 경우 C, F, G)에 대한 카운트를 증가시킵니다. 
더 높은 카운트를 가진 키가 선택됩니다. 카운트가 동일한 경우, 마지막 음표가 키를 결정하며, A, D, E는 A단조를, 그 외의 음표는 C장조를 선호합니다. 
이 방법은 작품이 A단조 또는 C장조 중 하나라고 가정하며, 다른 키나 모드에 대해서는 고려하지 않습니다.
*/

import java.io.*;
import java.util.Arrays;

public class Q5211_Scale_B1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt[] = new int[26]; // 알파벳 대문자의 카운트를 저장하는 배열
		int c = 0; // C장조에 해당하는 음표의 총합
		int a = 0; // A단조에 해당하는 음표의 총합

		Arrays.fill(cnt, 0); // 카운트 배열 초기화
		String inp[] = br.readLine().split("\\|"); // 입력된 음표를 "|" 기준으로 분리

		// 각 음표에 대한 카운트 증가
		for (int i = 0; i < inp.length; i++) {
			cnt[inp[i].charAt(0) - 'A']++;
		}

		// C장조에 해당하는 음표의 수 계산
		c += cnt[2]; // 'C'
		c += cnt[5]; // 'F'
		c += cnt[6]; // 'G'

		// A단조에 해당하는 음표의 수 계산
		a += cnt[0]; // 'A'
		a += cnt[3]; // 'D'
		a += cnt[4]; // 'E'

		// A단조와 C장조 중 더 높은 카운트를 가진 키 결정
		if (a > c)
			bw.write("A-minor");
		else if (c > a)
			bw.write("C-major");
		else {
			// 카운트가 같은 경우, 마지막 음표에 따라 키 결정
			if (inp[inp.length - 1].charAt(inp[inp.length - 1].length() - 1) == 'A'
					|| inp[inp.length - 1].charAt(inp[inp.length - 1].length() - 1) == 'D'
					|| inp[inp.length - 1].charAt(inp[inp.length - 1].length() - 1) == 'E')
				bw.write("A-minor");
			else
				bw.write("C-major");
		}

		bw.flush();
		bw.close();
	}
}