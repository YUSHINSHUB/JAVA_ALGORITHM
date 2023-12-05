package Implementation;

import java.io.*;
import java.util.*;

public class Q2851_Super_Mario_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ins[] = new int[10];
		Stack<Integer> stk = new Stack<Integer>();

		for (int i = 0; i < 10; i++) {
			ins[i] = Integer.parseInt(br.readLine());
		}

		int sum = 0;

		int a = 0;
		int b = 0;
		boolean chk = true;

		for (int i = 0; i < 10; i++) {
			sum += ins[i];
			stk.push(sum);
			if (sum >= 100) {
				a = stk.pop();
				if (!stk.isEmpty()) {
					b = stk.pop();
				}
				chk = false;
				break;
			}
		}

		if (chk == false) {
			a -= 100;
			b = 100 - b;

			if (a > b) {
				bw.write(String.valueOf(100 - b));
			} else {
				bw.write(String.valueOf(a + 100));
			}
		} else {
			bw.write(String.valueOf(stk.pop()));
		}

		bw.flush();
		bw.close();
	}
}