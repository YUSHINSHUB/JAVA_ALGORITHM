package Mathematics;

import java.io.*;
import java.util.*;

public class Q2476_Dice_Game_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int a, b, c;
		int res = 0;
		int temp = 0;

		for (int i = 0; i < n; i++) {

			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());

			if (a == b && b == c)
				temp = 10000 + (a * 1000);
			else if (a == b || a == c)
				temp = 1000 + (a * 100);
			else if (b == c)
				temp = 1000 + (b * 100);
			else {
				temp = Math.max(a, Math.max(b, c)) * 100;
			}

			res = Math.max(res, temp);

		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}