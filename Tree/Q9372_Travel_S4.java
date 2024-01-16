package Tree;

import java.io.*;

public class Q9372_Travel_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String inp[] = br.readLine().split(" ");
			int n = Integer.parseInt(inp[0]);
			int m = Integer.parseInt(inp[1]);
			for (int j = 0; j < m; j++)
				br.readLine();
			bw.write((n - 1) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
