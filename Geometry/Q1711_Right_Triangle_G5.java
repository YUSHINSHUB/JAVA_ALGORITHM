package Geometry;

/*
commented by ChatGPT
This Java code calculates the number of right-angled triangles that can be formed using n given 2D points.
이 Java 코드는 주어진 n개의 2D 점을 사용하여 생성할 수 있는 직각삼각형의 수를 계산합니다.
*/

import java.io.*;
import java.util.*;

public class Q1711_Right_Triangle_G5 {
	// 두 정수의 최대 공약수를 반환 (Return Greatest Common Divisor of two integers)
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

		// 점의 개수 n을 읽어들임 (Read the number of points n)
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		pos p[] = new pos[n];

		// n개의 점의 좌표를 읽어들임 (Read coordinates for n points)
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			p[i] = new pos(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
		}

		// 각 점에 대해 벡터 관계를 분석하며 직각 삼각형을 찾음 (Analyze vector relationships for each point
		// to find right-angled triangles)
		for (int i = 0; i < n; i++) {
			pos t[] = p;
			pos temp = t[i];
			t[i] = t[0];
			t[0] = temp;

			HashMap<pos, Integer> hm = new HashMap<>();

			// 기준이 되는 점에 대한 다른 점들과의 벡터를 분석 (Analyze vectors with other points with respect
			// to the reference point)
			for (int j = 1; j < n; j++) {
				int x = t[j].x - t[0].x;
				int y = t[j].y - t[0].y;
				int g;
				g = Math.abs(getGCD(x, y)); // x와 y의 최대공약수를 구함 (Get the GCD of x and y)
				x /= g;
				y /= g;
				hm.put(new pos(x, y), hm.getOrDefault(new pos(x, y), 0) + 1);
			}

			// 해시맵을 통해 직각 삼각형을 찾음 (Find right-angled triangles through the hashmap)
			for (Map.Entry<pos, Integer> en : hm.entrySet()) {
				// 직각삼각형의 조건을 확인 (Check condition for right-angled triangle)
				if (hm.containsKey(new pos(-en.getKey().y, en.getKey().x))) {
					res += en.getValue() * hm.get(new pos(-en.getKey().y, en.getKey().x));
				}
			}
		}

		// 결과를 출력 (Output the result)
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
