package Ad_hoc;

import java.io.*;

public class Q1402_It_Seems_A_Level_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int a, b;
			String in[] = br.readLine().split(" ");
			a = Integer.parseInt(in[0]);
			b = Integer.parseInt(in[1]);
			bw.write("yes\n");
		}

		bw.flush();
		bw.close();
	}
}