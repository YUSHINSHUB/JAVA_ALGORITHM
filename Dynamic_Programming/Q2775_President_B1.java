package Dynamic_Programming;

import java.io.*;

public class Q2775_President_B1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int room[][] = new int[15][15];

		for (int i = 1; i < 15; i++) {
			room[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {
			room[i][1] = 1;
			for (int z = 2; z < 15; z++) {
				room[i][z] = room[i][z - 1] + room[i - 1][z];
			}
		}

		int n = Integer.parseInt(br.readLine());

		int f[] = new int[n];
		int r[] = new int[n];

		for (int i = 0; i < n; i++) {
			f[i] = Integer.parseInt(br.readLine());
			r[i] = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(room[f[i]][r[i]]) + "\n");
		}

		bw.flush();
		bw.close();

	}

}
