package String;

import java.io.*;

public class Q10988_Palindrome_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// https://m.blog.naver.com/dylan0301/221785998279 참고

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int res = 1;

		for (int i = 0; i <= s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				res = 0;
				break;
			}
		}

		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();

	}

}