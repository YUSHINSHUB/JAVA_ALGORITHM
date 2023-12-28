package Sorting;

/*
commented by ChatGPT
This Java code is designed to sort a list of names based on specific criteria using a priority queue. 
The sorting criteria are: highest score in the first category, then lowest in the second category, and highest in the third category. 
If all scores are equal, names are sorted alphabetically. 
The code reads input for each name and their scores, then sorts and outputs the names according to these criteria.
이 Java 코드는 우선순위 큐를 사용하여 특정 기준에 따라 이름 목록을 정렬하도록 설계되었습니다. 
정렬 기준은 첫 번째 범주에서 가장 높은 점수, 두 번째 범주에서 가장 낮은 점수, 그리고 세 번째 범주에서 가장 높은 점수입니다. 
모든 점수가 동일한 경우 이름은 알파벳 순으로 정렬됩니다. 코드는 각 이름과 해당 점수에 대한 입력을 읽고 이러한 기준에 따라 이름을 정렬하여 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q10825_Score_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // The number of names to be sorted (정렬할 이름의 수)
		String name[]; // Array to store names (이름을 저장하는 배열)
		int scr[][]; // 2D array to store scores in three categories for each name (각 이름에 대한 세 범주의
						// 점수를 저장하는 2차원 배열)

		N = Integer.parseInt(br.readLine()); // Read the number of names (이름의 수를 읽음)
		name = new String[N]; // Initialize the name array (이름 배열 초기화)
		scr = new int[N][3]; // Initialize the scores array (점수 배열 초기화)

		// Priority Queue with a custom comparator to sort indices based on sorting
		// criteria (정렬 기준에 따라 인덱스를 정렬하기 위한 사용자 정의 비교자를 가진 우선순위 큐)
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			// Compare first scores (첫 번째 점수 비교)
			if (scr[o1][0] == scr[o2][0]) {
				// Compare second scores if first scores are equal (첫 번째 점수가 같으면 두 번째 점수 비교)
				if (scr[o1][1] == scr[o2][1]) {
					// Compare third scores if second scores are also equal (두 번째 점수도 같으면 세 번째 점수
					// 비교)
					if (scr[o1][2] == scr[o2][2]) {
						// Compare names alphabetically if all scores are equal (모든 점수가 같으면 이름을 알파벳 순으로
						// 비교)
						int len = Math.min(name[o1].length(), name[o2].length());
						for (int i = 0; i < len; i++) {
							if (name[o1].charAt(i) == name[o2].charAt(i))
								continue;
							return name[o1].charAt(i) > name[o2].charAt(i) ? 1 : -1;
						}
						return name[o1].length() > name[o2].length() ? 1 : -1;
					} else {
						return scr[o2][2] - scr[o1][2]; // Higher third score comes first if second scores are equal (두
														// 번째 점수가 같으면 세 번째 점수가 높은 순서대로)
					}
				} else {
					return scr[o1][1] - scr[o2][1]; // Lower second score comes first if first scores are equal (첫 번째
													// 점수가 같으면 두 번째 점수가 낮은 순서대로)
				}
			} else {
				return scr[o2][0] - scr[o1][0]; // Higher first score comes first (첫 번째 점수가 높은 순서대로)
			}
		});

		// Read names and their scores (이름과 그들의 점수 읽기)
		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			name[i] = inp[0];
			scr[i][0] = Integer.parseInt(inp[1]);
			scr[i][1] = Integer.parseInt(inp[2]);
			scr[i][2] = Integer.parseInt(inp[3]);
			pq.add(i); // Add index to the priority queue (인덱스를 우선순위 큐에 추가)
		}

		// Output sorted names (정렬된 이름 출력)
		while (!pq.isEmpty()) {
			int idx = pq.poll(); // Get the next index in sorted order (정렬된 순서대로 다음 인덱스 가져오기)
			bw.write(name[idx] + "\n"); // Write the name to the output (출력에 이름 작성)
		}

		bw.flush();
		bw.close();

	}
}
