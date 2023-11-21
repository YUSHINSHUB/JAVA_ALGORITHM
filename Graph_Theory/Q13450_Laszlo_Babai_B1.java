package Graph_Theory;

import java.io.*;

public class Q13450_Laszlo_Babai_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int a = Integer.parseInt(br.readLine());
			for (int j = 0; j < a; j++)
				br.readLine();

			int b = Integer.parseInt(br.readLine());
			for (int j = 0; j < b; j++)
				br.readLine();

			if (a == b)
				bw.write("yes\n");
			else
				bw.write("no\n");
		}

		bw.flush();
		bw.close();
	}
}