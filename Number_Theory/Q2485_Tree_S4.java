package Number_Theory;

import java.io.*;

public class Q2485_Tree_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int tree[] = new int[n];
		int gap[] = new int[n - 1];

		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n - 1; i++) {
			gap[i] = tree[i + 1] - tree[i];
		}

		int g = gap[0];

		for (int i = 0; i < n - 1; i++) {
			if (gap[i] % g != 0) {
				g--;
				i = -1;
			}
		}

		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			res += (gap[i] / g) - 1;
		}

		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}
