package Backtracking;

/*
commented by ChatGPT
This Java code generates and prints all possible combinations of m-length numbers from a given range [1, n] without repetition. 
It uses backtracking to generate combinations with a certain order. This variation of the code also ensures combinations are generated in increasing order.
�� Java �ڵ�� �־��� ���� [1, n]���� �ߺ� ���� m-������ ������ �����ϰ� ����մϴ�.
�ڵ�� ��Ʈ��ŷ�� ����Ͽ� ������ ������ ������ �����մϴ�. �� �ڵ��� ������ ������ �����ϴ� ������ �����ǵ��� �����մϴ�.
*/

import java.io.*;
import java.util.*;

public class Q15650_NM_2_S3 {

	static int n, m; // Declaring variables for the range and length of combinations
						// ������ ������ ���̸� ���� ���� ����
	static boolean visited[] = new boolean[9]; // Array to keep track of the visited numbers
												// �湮�� ���ڸ� �����ϱ� ���� �迭
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Deque<Integer> dq = new LinkedList<>(); // Use Deque to store the current combination
													// ���� ������ �����ϱ� ���� Deque ���

	static void bt(int idx) throws IOException {
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
			for (int i = idx + 1; i <= n; i++) {

				if (visited[i]) // If the number is already in the combination, skip it
								// ���ڰ� �̹� ���տ� �ִٸ� �ǳʶ�
					continue;

				dq.addLast(i); // Add the number to the current combination
								// ���ڸ� ���� ���տ� �߰�
				visited[i] = true; // Mark the number as visited
									// ���ڸ� �湮�������� ǥ��
				bt(i); // Recursive call with incremented index to ensure increasing order
						// �����ϴ� ������ �����ϱ� ���� ������ �ε����� ��� ȣ��
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

		bt(0); // Start the backtracking process with initial index 0

		bw.flush();
		bw.close();
	}
}
