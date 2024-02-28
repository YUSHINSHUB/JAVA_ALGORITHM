package Simulation;

/*
commented by ChatGPT
This Java code calculates the total amount of rainwater trapped between towers of varying height on a 2D grid. 
The grid's width and height are given as input, followed by the heights of the towers. 
The algorithm fills the grid based on these heights, then iterates through each level of the grid to calculate trapped water by finding enclosed spaces between towers.
이 Java 코드는 서로 다른 높이의 탑 사이에 갇힌 총 비의 양을 2D 그리드에서 계산합니다. 그리드의 너비와 높이가 입력으로 주어지고, 그 다음에는 탑의 높이가 주어집니다. 
알고리즘은 이러한 높이를 기반으로 그리드를 채운 다음, 탑 사이에 둘러싸인 공간을 찾아 각 그리드 레벨을 반복하여 갇힌 물의 양을 계산합니다.
*/

import java.io.*;
import java.util.*;

public class Q14719_Rainwater_G5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[]; // Array to store split input strings
		int res = 0; // Variable to store the total amount of trapped rainwater
		int grid[][] = new int[500][500]; // 2D grid representing the area
		int H, W; // Variables for grid height and width

		// Reading grid dimensions from input
		inp = br.readLine().split(" ");
		H = Integer.parseInt(inp[0]); // Height of the grid
		W = Integer.parseInt(inp[1]); // Width of the grid

		// Initializing the grid with zeros
		for (int i = 0; i < H; i++)
			Arrays.fill(grid[i], 0);

		// Filling the grid with tower heights
		inp = br.readLine().split(" ");
		for (int i = 0; i < W; i++) {
			int cur = Integer.parseInt(inp[i]); // Current tower height
			for (int j = 0; j < cur; j++) {
				grid[j][i] = 1; // Marking the presence of a tower
			}
		}

		// Calculating trapped rainwater
		for (int i = 0; i < H; i++) {
			int idx = 0; // Index to start searching for towers from left
			// Finding the first tower in the current row
			while (grid[i][idx] == 0) {
				idx++;
				if (idx == W) // If no tower is found, move to the next row
					break;
			}
			int temp = 0; // Temporary variable to count trapped water between towers
			for (int j = idx + 1; j < W; j++) {
				if (grid[i][j] == 0) // If there's no tower, increment trapped water count
					temp++;
				if (grid[i][j] == 1) { // If a tower is found, add trapped water to the result and reset temp
					res += temp;
					temp = 0;
				}
			}
		}

		// Writing the result to the output
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}