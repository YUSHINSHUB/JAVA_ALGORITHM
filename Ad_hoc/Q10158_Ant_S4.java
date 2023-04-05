package Ad_hoc;

import java.io.*;
import java.util.*;

public class Q10158_Ant_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();
		StringTokenizer stk = new StringTokenizer(in);

		int w = Integer.parseInt(stk.nextToken());
		int h = Integer.parseInt(stk.nextToken());

		in = br.readLine();
		stk = new StringTokenizer(in);

		int p = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());

		int t = Integer.parseInt(br.readLine());
		p = (p + t) % (2 * w);
		p = w - Math.abs(w - p);

		q = (q + t) % (2 * h);
		q = h - Math.abs(h - q);

		bw.write(p + " " + q);
		bw.flush();
		bw.close();

	}
}