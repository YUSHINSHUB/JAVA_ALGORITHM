package Sliding_Window;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q12891_DNA_PW_S2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int s, p;
		String inp[] = br.readLine().split(" ");

		s = Integer.parseInt(inp[0]);
		p = Integer.parseInt(inp[1]);

		String st = br.readLine();
		int acnt = 0;
		int ccnt = 0;
		int gcnt = 0;
		int tcnt = 0;

		inp = br.readLine().split(" ");
		int at = Integer.parseInt(inp[0]);
		int ct = Integer.parseInt(inp[1]);
		int gt = Integer.parseInt(inp[2]);
		int tt = Integer.parseInt(inp[3]);
		int res = 0;

		for (int i = 0; i < p; i++) {
			if (st.charAt(i) == 'A') {
				acnt++;
			} else if (st.charAt(i) == 'C') {
				ccnt++;
			} else if (st.charAt(i) == 'G') {
				gcnt++;
			} else if (st.charAt(i) == 'T') {
				tcnt++;
			}
		}

		if (at <= acnt && ct <= ccnt && gt <= gcnt && tt <= tcnt) {
			res++;
		}

		for (int z = p; z < s; z++) {
			if (st.charAt(z - p) == 'A') {
				acnt--;
			} else if (st.charAt(z - p) == 'C') {
				ccnt--;
			} else if (st.charAt(z - p) == 'G') {
				gcnt--;
			} else if (st.charAt(z - p) == 'T') {
				tcnt--;
			}

			if (st.charAt(z) == 'A') {
				acnt++;
			} else if (st.charAt(z) == 'C') {
				ccnt++;
			} else if (st.charAt(z) == 'G') {
				gcnt++;
			} else if (st.charAt(z) == 'T') {
				tcnt++;
			}
			if (at <= acnt && ct <= ccnt && gt <= gcnt && tt <= tcnt) {
				res++;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}