package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates a game similar to "Snakes and Ladders". 
Given a board with some ladders and snakes, the code calculates the minimum number of dice rolls required to reach the 100th cell starting from the 1st cell. 
If a player lands on the start of a ladder or snake, they immediately move to its end.

이 Java 코드는 "뱀과 사다리"와 유사한 게임을 시뮬레이션합니다. 
몇몇의 사다리와 뱀이 있는 보드가 주어진 경우, 코드는 1번 칸에서 시작하여 100번 칸에 도달하기 위해 필요한 주사위 굴림의 최소 횟수를 계산합니다. 
플레이어가 사다리나 뱀의 시작 부분에 도착하면 즉시 그 끝으로 이동합니다.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q16928_Snakes_and_Ladders_G5 {

	static HashMap<Integer, Integer> hm = new HashMap<>(); // 사다리와 뱀의 시작과 끝을 저장 (Stores the start and end of ladders and
															// snakes)
	static int grp[] = new int[101]; // 각 칸에 도달하는 데 필요한 최소 주사위 굴림 횟수 저장 (Stores the minimum dice rolls required to
										// reach each cell)

	// 게임 보드를 탐색하는 함수 (Function to search the game board)
	static void search(int idx) {

		for (int i = idx; i <= 100; i++) {

			// 해당 위치에 뱀이나 사다리가 없는 경우 (If there's no snake or ladder at the current position)
			if (hm.getOrDefault(i, -1) == -1) {
				for (int j = i; j <= i + 6; j++) {
					if (j > 100)
						break;
					grp[j] = Math.min(grp[i] + 1, grp[j]);
				}
			}

			// 해당 위치에 뱀이나 사다리가 있는 경우 (If there's a snake or ladder at the current position)
			if (hm.getOrDefault(i, -1) != -1) {
				int s = hm.get(i);
				if (grp[s] > grp[i]) {
					grp[s] = grp[i];
					search(s); // 해당 뱀이나 사다리의 끝에서부터 탐색 계속 (Continue the search from the end of the snake or
								// ladder)
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]); // 사다리의 개수 (Number of ladders)
		int m = Integer.parseInt(inp[1]); // 뱀의 개수 (Number of snakes)

		int x, y;

		Arrays.fill(grp, 100); // 최대 값으로 초기화 (Initialize with maximum values)
		grp[1] = 0;

		// 사다리 정보 입력 (Input ladder information)
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			hm.put(x, y);
		}

		// 뱀 정보 입력 (Input snake information)
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			hm.put(x, y);
		}

		// 보드를 탐색하여 100번 칸까지 필요한 최소 횟수 계산 (Search the board to calculate the minimum
		// rolls required to reach the 100th cell)
		search(1);

		bw.write(grp[100] + ""); // 결과 출력 (Output the result)

		bw.flush();
		bw.close();
	}
}
