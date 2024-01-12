package Number_Theory;

import java.io.*;

public class Q2609_GCD_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// https://m.blog.naver.com/dylan0301/221785998279 참고

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a, b;
		int temp = 0;
		int max, min;

		String s[] = br.readLine().split(" ");

		a = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);

		temp = Math.min(a, b);
		while (true) {
			if (a % temp == 0 && b % temp == 0) {
				max = temp;
				break;
			}
			temp--;
		}

		temp = Math.max(a, b);
		while (true) {
			if (temp % a == 0 && temp % b == 0) {
				min = temp;
				break;
			}
			temp += Math.max(a, b);
		}

		bw.write(String.valueOf(max) + " " + String.valueOf(min));

		bw.flush();
		bw.close();

	}

}
