package Backtracking;

/*
commented by ChatGPT
This Java code generates all possible combinations of m-length numbers from a given range [1, n] and prints them. 
Using backtracking, the code explores every possible combination without repetition.
�� Java �ڵ�� �־��� ���� [1, n]���� ������ ��� m-���� ������ �����ϰ� ����մϴ�. 
��Ʈ��ŷ�� ����Ͽ� �ߺ� ���� ��� ������ ������ Ž���մϴ�.
*/

import java.io.*;
import java.util.*;

public class Q15649_NM_1_S3 {

	static int n, m; // Declaring variables for the range and length of combinations
						// ������ ������ ���̸� ���� ���� ����
	static boolean visited[] = new boolean[9]; // Array to keep track of the visited numbers
												// �湮�� ���ڸ� �����ϱ� ���� �迭
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Deque<Integer> dq = new LinkedList<>(); // Use Deque to store the current combination
													// ���� ������ �����ϱ� ���� Deque ���

	static void bt() throws IOException {
		// Backtracking function to generate combinations
		// ������ �����ϱ� ���� ��Ʈ��ŷ �Լ�

		if (dq.size() == m) { // If the current combination has the required length
								// ���� ������ �ʿ��� ���̸� ������
			for (int i = 0; i < dq.size(); i++) {
				int t = dq.pollFirst(); // Get and remove the first element from the deque
										// deque���� ù ��° ��Ҹ� ������ ����
				bw.write(t + " ");
				dq.addLast(t); // Add the element back to the end
								// ��Ҹ� �ٽ� ���� �߰�
			}
			bw.write("\n");
		} else {
			for (int i = 1; i <= n; i++) {

				if (visited[i]) // If the number is already in the combination, skip it
								// ���ڰ� �̹� ���տ� �ִٸ� �ǳʶ�
					continue;

				dq.addLast(i); // Add the number to the current combination
								// ���ڸ� ���� ���տ� �߰�
				visited[i] = true; // Mark the number as visited
									// ���ڸ� �湮�������� ǥ��
				bt(); // Recursive call to continue building the combination
						// ������ ��� �����ϱ� ���� ��� ȣ��
				dq.pollLast(); // Remove the last added number to backtrack
								// ��Ʈ��ŷ�� ���� �������� �߰��� ���� ����
				visited[i] = false; // Mark the number as unvisited for the next iteration
									// ���� �ݺ��� ���� ���ڸ� �湮���� �ʾ������� ǥ��
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Arrays.fill(visited, false); // Initialize the visited array with false values
										// �湮 �迭�� false ������ �ʱ�ȭ
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);

		bt(); // Start the backtracking process

		bw.flush();
		bw.close();
	}
}
