package Primality_Test;

import java.io.*;
import java.math.*;
import java.util.*;

// dfs, dp, 백트래킹 개념 
// https://velog.io/@codren/DP-DFS-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9

public class Q2023_Weird_Primer_Numbers_G5 {
	static int n;

	static void bt(int cnt, int x) {
		boolean chk = true;
		if (cnt == n)
			System.out.println(x);
		else {
			cnt++;
			for (int i = x * 10; i <= (x * 10) + 9; i++) {
				chk = true;
				for (int z = 2; z <= i / 2; z++) {
					if (i % z == 0) {
						//함수의 재귀호출을 사용하여 그래프를 완전탐색하는 중에 불필요한 부분은 건너뛰는 백트래킹 기법 사용
						chk = false;
						break;
					}
				}
				if (chk)
					bt(cnt, i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		bt(1, 2);
		bt(1, 3);
		bt(1, 5);
		bt(1, 7);

		bw.flush();
		bw.close();

	}
}
