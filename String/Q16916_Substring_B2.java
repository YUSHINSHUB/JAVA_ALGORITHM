package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;

//KMP알고리즘을 이용해 해결
//https://bowbowbow.tistory.com/6 참고
public class Q16916_Substring_B2 {

	protected static int[] getlps(String pattern) { // LPS(Longest Prefix which is also Suffix)
		// lps의 n번 자리에는 pattern의 n+1자리의 접두사(pattern이 abc일 경우 a, ab, abc)
		// 에서 해당 접두사의 접두사와 접미사가 일치한 부분 문자열의 최대 길이가 들어간다.
		// ex) pattern이 abababc일 때, lps[5] 는 abababc의 접두사 ababab에서
		// 해당 접두사의 접두사와 접미사가 같은 가장 긴 부분 문자열은 abab이므로 4가 들어간다.
		int m = pattern.length();
		int lps[] = new int[m];

		int i = 1;
		int len = 0;
		lps[0] = 0;

		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}

			if (i < m && pattern.charAt(i) != pattern.charAt(len)) {
				if (len == 0) {
					lps[i] = 0;
					i++;
				} else {
					len = lps[len - 1];
				}
			}
		}

		return lps;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String text = br.readLine();
		String pattern = br.readLine();

		int lps[] = getlps(pattern);

		boolean res = false;
		int i = 0;
		int j = 0;
		int n = text.length();
		int m = pattern.length();

		while (i < n) {

			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = lps[j - 1];
					// 부분 문자열이 부분적으로 달라서 답이 아닐 경우 lps값을 이용하여
					// 앞부분을 건너뛰고 검사할 수 있다.
				}
			}

			if (j == m) {
				res = true;
				break;
			}
		}

		if (res)
			bw.write("1");
		else
			bw.write("0");

		bw.flush();
		bw.close();

	}
}
