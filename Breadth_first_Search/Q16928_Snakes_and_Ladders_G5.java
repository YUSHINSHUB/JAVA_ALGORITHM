package Breadth_first_Search;

/*
commented by ChatGPT
This Java code simulates a game similar to "Snakes and Ladders". 
Given a board with some ladders and snakes, the code calculates the minimum number of dice rolls required to reach the 100th cell starting from the 1st cell. 
If a player lands on the start of a ladder or snake, they immediately move to its end.

�� Java �ڵ�� "��� ��ٸ�"�� ������ ������ �ùķ��̼��մϴ�. 
����� ��ٸ��� ���� �ִ� ���尡 �־��� ���, �ڵ�� 1�� ĭ���� �����Ͽ� 100�� ĭ�� �����ϱ� ���� �ʿ��� �ֻ��� ������ �ּ� Ƚ���� ����մϴ�. 
�÷��̾ ��ٸ��� ���� ���� �κп� �����ϸ� ��� �� ������ �̵��մϴ�.
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q16928_Snakes_and_Ladders_G5 {

	static HashMap<Integer, Integer> hm = new HashMap<>(); // ��ٸ��� ���� ���۰� ���� ���� (Stores the start and end of ladders and
															// snakes)
	static int grp[] = new int[101]; // �� ĭ�� �����ϴ� �� �ʿ��� �ּ� �ֻ��� ���� Ƚ�� ���� (Stores the minimum dice rolls required to
										// reach each cell)

	// ���� ���带 Ž���ϴ� �Լ� (Function to search the game board)
	static void search(int idx) {

		for (int i = idx; i <= 100; i++) {

			// �ش� ��ġ�� ���̳� ��ٸ��� ���� ��� (If there's no snake or ladder at the current position)
			if (hm.getOrDefault(i, -1) == -1) {
				for (int j = i; j <= i + 6; j++) {
					if (j > 100)
						break;
					grp[j] = Math.min(grp[i] + 1, grp[j]);
				}
			}

			// �ش� ��ġ�� ���̳� ��ٸ��� �ִ� ��� (If there's a snake or ladder at the current position)
			if (hm.getOrDefault(i, -1) != -1) {
				int s = hm.get(i);
				if (grp[s] > grp[i]) {
					grp[s] = grp[i];
					search(s); // �ش� ���̳� ��ٸ��� ���������� Ž�� ��� (Continue the search from the end of the snake or
								// ladder)
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]); // ��ٸ��� ���� (Number of ladders)
		int m = Integer.parseInt(inp[1]); // ���� ���� (Number of snakes)

		int x, y;

		Arrays.fill(grp, 100); // �ִ� ������ �ʱ�ȭ (Initialize with maximum values)
		grp[1] = 0;

		// ��ٸ� ���� �Է� (Input ladder information)
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			hm.put(x, y);
		}

		// �� ���� �Է� (Input snake information)
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			hm.put(x, y);
		}

		// ���带 Ž���Ͽ� 100�� ĭ���� �ʿ��� �ּ� Ƚ�� ��� (Search the board to calculate the minimum
		// rolls required to reach the 100th cell)
		search(1);

		bw.write(grp[100] + ""); // ��� ��� (Output the result)

		bw.flush();
		bw.close();
	}
}
