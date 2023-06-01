package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;

//KMP�˰����� �̿��� �ذ�
//https://bowbowbow.tistory.com/6 ����
public class Q16916_Substring_B2 {

	protected static int[] getlps(String pattern) { // LPS(Longest Prefix which is also Suffix)
		// lps�� n�� �ڸ����� pattern�� n+1�ڸ��� ���λ�(pattern�� abc�� ��� a, ab, abc)
		// ���� �ش� ���λ��� ���λ�� ���̻簡 ��ġ�� �κ� ���ڿ��� �ִ� ���̰� ����.
		// ex) pattern�� abababc�� ��, lps[5] �� abababc�� ���λ� ababab����
		// �ش� ���λ��� ���λ�� ���̻簡 ���� ���� �� �κ� ���ڿ��� abab�̹Ƿ� 4�� ����.
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
					// �κ� ���ڿ��� �κ������� �޶� ���� �ƴ� ��� lps���� �̿��Ͽ�
					// �պκ��� �ǳʶٰ� �˻��� �� �ִ�.
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
