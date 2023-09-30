package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

class pos {
	int x;
	int y;

	pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	boolean comp(int x, int y) {
		if (this.x == x && this.y == y)
			return true;
		else
			return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		pos position = (pos) o;
		return x == position.x && y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}

public class notepad {

	static int getGCD(int x, int y) {
		while (y != 0) {
			int n = x % y;
			x = y;
			y = n;
		}

		return x;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int res = 0;
		pos p[] = new pos[n];

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			p[i] = new pos(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
		}

		for (int i = 0; i < n; i++) {
			pos t[] = p;
			pos temp = t[i];
			t[i] = t[0];
			t[0] = temp;
			HashMap<pos, Integer> hm = new HashMap<>();
			for (int j = 1; j < n; j++) {
				int x = t[j].x - t[0].x;
				int y = t[j].y - t[0].y;
				int g;
				g = Math.abs(getGCD(x, y));
				x /= g;
				y /= g;
				hm.put(new pos(x, y), hm.getOrDefault(new pos(x, y), 0) + 1);
			}

			for (Map.Entry<pos, Integer> en : hm.entrySet()) {
				if (hm.containsKey(new pos(-en.getKey().y, en.getKey().x))) {
					res += en.getValue() * hm.get(new pos(-en.getKey().y, en.getKey().x));
				}
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
