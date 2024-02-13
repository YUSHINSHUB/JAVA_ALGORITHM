package Backtracking;

/*
commented by ChatGPT
This Java code attempts to find the minimum number of additional ladders needed to ensure that each player ends up in their respective position after traversing a ladder game. 
It uses backtracking to place ladders and check if the condition is met, and it limits the search to a maximum of 3 additional ladders to avoid an intractable problem.
이 Java 코드는 사다리 게임을 통과한 후 각 플레이어가 각자의 위치에서 끝나도록 보장하기 위해 필요한 추가 사다리의 최소 수를 찾으려고 시도합니다. 
사다리를 배치하고 조건이 충족되는지 확인하기 위해 백트래킹을 사용하며, 문제를 다루기 어렵게 만드는 것을 피하기 위해 최대 3개의 추가 사다리로 검색을 제한합니다.
*/

import java.io.*;
import java.util.*;

public class Q15684_Ladder_G3 {

	static int ladd[][]; // Array representing ladders (사다리를 나타내는 배열)
	static int res = 0; // The result, number of additional ladders needed (결과, 필요한 추가 사다리의 수)
	static int N, M, H; // N: number of vertical lines, M: number of existing ladders, H: number of
						// horizontal lines (N: 수직선의 수, M: 기존 사다리의 수, H: 수평선의 수)
	static boolean out = false; // Flag to indicate if the correct ladder setup is found (올바른 사다리 설정을 찾았는지를 나타내는
								// 플래그)

	// Recursive function to place ladders and check if the condition is met (사다리를
	// 배치하고 조건이 충족되는지 확인하는 재귀 함수)
	static boolean bt(int ypos, int xpos, int idx) {

		if (idx == res) { // If the current number of ladders equals the required additional ladders (현재
							// 사다리 수가 필요한 추가 사다리 수와 같으면)
			out = true;
			// Check if each player ends up in their starting position (각 플레이어가 시작 위치에서 끝나는지
			// 확인)
			for (int i = 0; i < N; i++) {
				int x = i;
				for (int j = 0; j < H; j++) {
					x += ladd[j][x]; // Traverse the ladder game (사다리 게임을 진행)
				}
				if (x != i) { // If a player does not end up in the starting position (플레이어가 시작 위치에서 끝나지 않으면)
					out = false;
					break;
				}
			}
			return out;
		}

		// Attempt to place a ladder at each possible position (가능한 각 위치에 사다리를 배치하려고 시도)
		for (int i = ypos; i < H; i++) {
			if (xpos == N && i == ypos) {
				i++;
				if (i == H)
					break;
			}
			for (int j = 1; j < N; j++) {
				if (j == 1 && i == ypos)
					j = xpos;
				// Ensure that placing a ladder here is valid (여기에 사다리를 놓는 것이 유효한지 확인)
				if (ladd[i][j] == 0 && ladd[i][j - 1] == 0) {
					ladd[i][j] = -1; // Place a ladder (사다리 배치)
					ladd[i][j - 1] = 1;
					bt(i, j + 1, idx + 1); // Continue backtracking (백트래킹 계속)
					if (out)
						return true; // If a valid setup is found, stop (유효한 설정을 찾으면 중지)
					// Undo the ladder placement (사다리 배치 취소)
					ladd[i][j] = 0;
					ladd[i][j - 1] = 0;
				}
			}
		}

		return false; // Return false if no valid setup is found (유효한 설정을 찾지 못하면 false 반환)
	}

	// Function to initiate backtracking search (백트래킹 검색을 시작하는 함수)
	static void search() {

		while (true) {
			if (bt(0, 1, 0))
				break; // If a valid setup is found, exit the loop (유효한 설정을 찾으면 루프를 종료)
			else
				res++; // Otherwise, increase the number of ladders and try again (그렇지 않으면 사다리 수를 증가시키고
						// 다시 시도)

			if (res > 3) { // Limit the search to 3 additional ladders (검색을 3개의 추가 사다리로 제한)
				res = -1;
				break;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		N = Integer.parseInt(inp[0]); // Number of vertical lines (수직선의 수)
		M = Integer.parseInt(inp[1]); // Number of existing ladders (기존 사다리의 수)
		H = Integer.parseInt(inp[2]); // Number of horizontal lines (수평선의 수)

		ladd = new int[H][N]; // Initialize the ladder array (사다리 배열 초기화)

		for (int i = 0; i < H; i++) {
			Arrays.fill(ladd[i], 0); // Fill the ladder array with 0 (사다리 배열을 0으로 채우기)
		}

		// Read the existing ladders (기존 사다리 읽기)
		for (int i = 0; i < M; i++) {
			inp = br.readLine().split(" ");
			int y = Integer.parseInt(inp[0]); // Horizontal position (수평 위치)
			int x = Integer.parseInt(inp[1]); // Vertical position (수직 위치)

			// Mark the ladder on the array (배열에 사다리 표시)
			ladd[y - 1][x - 1] = 1;
			ladd[y - 1][x] = -1;
		}

		search(); // Start the backtracking search (백트래킹 검색 시작)

		bw.write(res + ""); // Write the result (결과 작성)

		bw.flush();
		bw.close(); // Close the writer (작성기를 닫기)

	}

}
