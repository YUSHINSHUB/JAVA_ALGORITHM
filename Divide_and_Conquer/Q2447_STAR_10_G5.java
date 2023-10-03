package Divide_and_Conquer;

/*
commented by ChatGPT
This Java code is designed to generate a fractal pattern similar to the Sierpinski carpet. 
Based on user input, the code constructs and prints the fractal pattern using recursive function calls.
�� Java �ڵ�� Sierpinski ī��� ������ ����Ż ������ �����ϱ� ���� ����Ǿ����ϴ�. 
����� �Է��� ������� �ڵ�� ��� �Լ� ȣ���� ����Ͽ� ����Ż ������ �����ϰ� ����մϴ�.
*/

import java.io.*;

public class Q2447_STAR_10_G5 {

	static String res = "*"; // Initialize the basic pattern
								// �⺻ ���� �ʱ�ȭ
	static int n;

	static void recur(int idx) {
		// Each function call expands the pattern
		// �� �Լ� ȣ���� ������ Ȯ���մϴ�.

		String temp[] = res.split("\n");
		StringBuilder t = new StringBuilder("");

		// Add the current pattern to the top and bottom of a 3x3 grid
		// 3x3 �׸����� ��ܰ� �ϴܿ� ���� ���� �߰�
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < 3; j++) {
				t.append(temp[i]);
			}
			t.append("\n");
		}

		// Add the current pattern to the sides and space in the center
		// ���ʿ� ���� ������ �߰��ϰ� �߾ӿ� ���� �߰�
		for (int i = 0; i < temp.length; i++) {
			t.append(temp[i]);
			for (int j = 0; j < idx / 3; j++)
				t.append(" ");
			t.append(temp[i]);
			t.append("\n");
		}

		// Again, add the current pattern to the top and bottom of a 3x3 grid
		// �ٽ�, 3x3 �׸����� ��ܰ� �ϴܿ� ���� ���� �߰�
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < 3; j++) {
				t.append(temp[i]);
			}
			t.append("\n");
		}

		res = t.toString(); // Update the final pattern
							// ���� ���� ������Ʈ
		if (n == idx)
			return;
		else
			recur(idx * 3); // Make a recursive call, increasing the size of the pattern threefold
							// ��� ȣ���� �����ϸ� ������ ũ�⸦ �� ��� �ø��ϴ�.
	}

	public static void main(String[] args) throws IOException {
		// Main execution part of the program
		// ���α׷��� �� ���� �κ�

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		recur(3);

		bw.write(res);
		bw.flush();
		bw.close();
	}
}
