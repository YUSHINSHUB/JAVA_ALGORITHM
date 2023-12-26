package Backtracking;

import java.io.*;
import java.util.*;

public class Q12100_2048_Easy_G2 {

	static ArrayList<Integer> pick = new ArrayList<>();
	static int grid[][];
	static int temp[][];
	static int N;
	static int res = 0;

	static void bt() {

		if (pick.size() == 5) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					temp[i][j] = grid[i][j];
			}

			for (int tc = 0; tc < 5; tc++) {

				int pos = pick.get(tc);

				switch (pos) {
				case 1:

					for (int i = 0; i < N; i++) {
						for (int j = 1; j < N; j++) {
							if (temp[j][i] > 0) {
								int t = temp[j][i];
								temp[j][i] = 0;
								while (temp[j][i] == 0) {
									j--;
									if (j < 0) {
										j++;
										break;
									}
								}
								if (temp[j][i] > 0)
									j++;
								temp[j][i] = t;
							}
						}
					}

					for (int i = 0; i < N; i++) {
						for (int j = 1; j < N; j++) {
							if (temp[j][i] == 0)
								break;
							if (temp[j][i] == temp[j - 1][i]) {
								temp[j - 1][i] *= 2;
								temp[j][i] = 0;
								for (int k = j + 1; k < N; k++) {
									if (temp[k][i] == 0)
										break;
									temp[k - 1][i] = temp[k][i];
									temp[k][i] = 0;
								}
							}
						}
					}

					break;
				case 2:

					for (int i = 0; i < N; i++) {
						for (int j = 1; j < N; j++) {
							if (temp[i][j] > 0) {
								int t = temp[i][j];
								temp[i][j] = 0;
								while (temp[i][j] == 0) {
									j--;
									if (j < 0) {
										j++;
										break;
									}
								}
								if (temp[i][j] > 0)
									j++;
								temp[i][j] = t;
							}
						}
					}

					for (int i = 0; i < N; i++) {
						for (int j = 1; j < N; j++) {
							if (temp[i][j] == 0)
								break;
							if (temp[i][j] == temp[i][j - 1]) {
								temp[i][j - 1] *= 2;
								temp[i][j] = 0;
								for (int k = j + 1; k < N; k++) {
									if (temp[i][k] == 0)
										break;
									temp[i][k - 1] = temp[i][k];
									temp[i][k] = 0;
								}
							}
						}
					}

					break;
				case 3:

					for (int i = 0; i < N; i++) {
						for (int j = N - 2; j >= 0; j--) {
							if (temp[i][j] > 0) {
								int t = temp[i][j];
								temp[i][j] = 0;
								while (temp[i][j] == 0) {
									j++;
									if (j >= N) {
										j--;
										break;
									}
								}
								if (temp[i][j] > 0)
									j--;
								temp[i][j] = t;
							}
						}
					}

					for (int i = 0; i < N; i++) {
						for (int j = N - 2; j >= 0; j--) {
							if (temp[i][j] == 0)
								break;
							if (temp[i][j] == temp[i][j + 1]) {
								temp[i][j + 1] *= 2;
								temp[i][j] = 0;
								for (int k = j - 1; k >= 0; k--) {
									if (temp[i][k] == 0)
										break;
									temp[i][k + 1] = temp[i][k];
									temp[i][k] = 0;
								}
							}
						}
					}

					break;
				case 4:

					for (int i = 0; i < N; i++) {
						for (int j = N - 2; j >= 0; j--) {
							if (temp[j][i] > 0) {
								int t = temp[j][i];
								temp[j][i] = 0;
								while (temp[j][i] == 0) {
									j++;
									if (j >= N) {
										j--;
										break;
									}
								}
								if (temp[j][i] > 0)
									j--;
								temp[j][i] = t;
							}
						}
					}

					for (int i = 0; i < N; i++) {
						for (int j = N - 2; j >= 0; j--) {
							if (temp[j][i] == 0)
								break;
							if (temp[j][i] == temp[j + 1][i]) {
								temp[j + 1][i] *= 2;
								temp[j][i] = 0;
								for (int k = j - 1; k >= 0; k--) {
									if (temp[k][i] == 0)
										break;
									temp[k + 1][i] = temp[k][i];
									temp[k][i] = 0;
								}
							}
						}
					}

					break;
				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					res = Math.max(res, temp[i][j]);
			}

		} else {
			for (int i = 1; i <= 4; i++) {
				pick.add(i);
				bt();
				pick.remove(pick.size() - 1);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(inp[j]);
			}
		}

		bt();
		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
