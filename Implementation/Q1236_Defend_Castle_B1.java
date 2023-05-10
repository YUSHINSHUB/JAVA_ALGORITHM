package Implementation;

import java.io.*;

public class Q1236_Defend_Castle_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int x = Integer.parseInt(inp[1]);
		int y = Integer.parseInt(inp[0]);

		char pos[][] = new char[y][x];

		for (int i = 0; i < y; i++) {
			String temp = br.readLine();
			for (int j = 0; j < x; j++) {
				pos[i][j] = temp.charAt(j);
			}
		}

		int res = 0;
		boolean empty = true;

		for (int i = 0; i < y; i++) {
			empty = true;
			for (int j = 0; j < x; j++) {
				if (pos[i][j] == 'X') {
					empty = false;
					break;
				}
			}
			if (empty) {
				res++;
				for (int j = 0; j < x; j++) {
					empty = true;
					for (int k = 0; k < y; k++) {
						if (pos[k][j] == 'X') {
							empty = false;
							break;
						}
					}
					if (empty) {
						pos[i][j] = 'X';
						break;
					}
				}
				if (!empty)
					pos[i][0] = 'X';
			}
		}

		for (int i = 0; i < x; i++) {
			empty = true;
			for (int j = 0; j < y; j++) {
				if (pos[j][i] == 'X') {
					empty = false;
					break;
				}
			}
			if (empty) {
				res++;
				for (int j = 0; j < y; j++) {
					empty = true;
					for (int k = 0; k < x; k++) {
						if (pos[j][k] == 'X') {
							empty = false;
							break;
						}
					}
					if (empty) {
						pos[j][i] = 'X';
						break;
					}
				}
				if (!empty)
					pos[0][i] = 'X';
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}
