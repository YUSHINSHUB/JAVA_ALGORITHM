package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int b[][] = new int[n + 1][n + 1];
		int cy = 1;
		int cx = 1;
		int vec = 1;
		int res = 0;
		boolean pass = true;
		Queue<Integer> yq = new LinkedList<>();
		Queue<Integer> xq = new LinkedList<>();

		yq.add(1);
		xq.add(1);

		for (int i = 1; i <= n; i++)
			Arrays.fill(b[i], 0);

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			String inp[] = br.readLine().split(" ");
			int y = Integer.parseInt(inp[0]);
			int x = Integer.parseInt(inp[1]);
			b[y][x] = 1;
		}

		b[1][1] = 2;

		int l = Integer.parseInt(br.readLine());

		for (int i = 0; i < l; i++) {
			String inp[] = br.readLine().split(" ");
			int x = Integer.parseInt(inp[0]);
			String c = inp[1];
			switch (vec) {
			case 1:
				for (int j = res; j < x; j++) {
					cx++;
					res++;
					if (cx > n) {
						pass = false;
						break;
					} else if (b[cy][cx] == 2) {
						pass = false;
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			case 2:
				for (int j = res; j < x; j++) {
					cy++;
					res++;
					if (cy > n) {
						pass = false;
						break;
					} else if (b[cy][cx] == 2) {
						pass = false;
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			case 3:
				for (int j = res; j < x; j++) {
					cx--;
					res++;
					if (cx < 1) {
						pass = false;
						break;
					} else if (b[cy][cx] == 2) {
						pass = false;
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			case 4:
				for (int j = res; j < x; j++) {
					cy--;
					res++;
					if (cy < 1) {
						pass = false;
						break;
					} else if (b[cy][cx] == 2) {
						pass = false;
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			}
			if (!pass)
				break;

			if (c.equals("D")) {
				vec++;
				if (vec == 5)
					vec = 1;
			} else {
				vec--;
				if (vec == 0)
					vec = 4;
			}

		}

		if (pass) {
			switch (vec) {
			case 1:
				while (true) {
					cx++;
					res++;
					if (cx > n) {
						break;
					} else if (b[cy][cx] == 2) {
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			case 2:
				while (true) {
					cy++;
					res++;
					if (cy > n) {
						break;
					} else if (b[cy][cx] == 2) {
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			case 3:
				while (true) {
					cx--;
					res++;
					if (cx < 1) {
						break;
					} else if (b[cy][cx] == 2) {
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			case 4:
				while (true) {
					cy--;
					res++;
					if (cy < 1) {
						break;
					} else if (b[cy][cx] == 2) {
						break;
					}

					if (b[cy][cx] == 1) {
						b[cy][cx] = 2;
					} else {
						b[cy][cx] = 2;
						b[yq.poll()][xq.poll()] = 0;
					}
					yq.add(cy);
					xq.add(cx);
				}
				break;
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}

}
