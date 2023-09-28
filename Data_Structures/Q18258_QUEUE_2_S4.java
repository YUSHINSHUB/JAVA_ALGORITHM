//�� ���α׷��� ����ڷκ��� �Է� ���� ��ɾ ���� ť�� ���Ҹ� �߰�(push)�ϰų� ����(pop)�ϰ�, ť�� ũ��(size), 
//��� �ִ��� ����(empty), ù ��° ����(front), ������ ����(back)�� ����մϴ�.
package Data_Structures;

import java.io.*;
import java.util.*;

public class Q18258_QUEUE_2_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // ����ڷκ��� �Է��� �ޱ� ���� BufferedReader ��ü
																					// ����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ����� ���� BufferedWriter ��ü ����

		int n = Integer.parseInt(br.readLine()); // ù ��° �Է����� ������ ���ڸ� �о�ɴϴ�. �� ���ڴ� �� ��ɾ��� �����Դϴ�.
		Deque<Integer> q = new LinkedList<>(); // ���� ���� ����Ʈ�� �̿��� ��(Deque)�� �����մϴ�. �� ���� ť(queue)�� ���˴ϴ�.

		for (int i = 0; i < n; i++) { // n�� ���� �ݺ��մϴ�.
			String in[] = br.readLine().split(" "); // ����ڷκ��� �Է��� �޾� �������� ������ �迭�� �����մϴ�.

			// ����ڷκ��� ���� ��ɾ ���� �۾��� �����մϴ�.
			if (in[0].equals("push")) // "push" ��ɾ �Էµ� ���
				q.addLast(Integer.parseInt(in[1])); // ť�� ���ڸ� �߰��մϴ�.
			else if (in[0].equals("pop")) { // "pop" ��ɾ �Էµ� ���
				if (q.isEmpty()) // ť�� ����ִ��� Ȯ���մϴ�. ����ִٸ�
					bw.write("-1\n"); // "-1"�� ����մϴ�.
				else // ������� �ʴٸ�
					bw.write(q.pollFirst() + "\n"); // ť�� ù ��° ���Ҹ� ������ ����ϰ�, ť���� �����մϴ�.
			} else if (in[0].equals("size")) // "size" ��ɾ �Էµ� ���
				bw.write(q.size() + "\n"); // ť�� ũ�⸦ ����մϴ�.
			else if (in[0].equals("empty")) { // "empty" ��ɾ �Էµ� ���
				if (q.isEmpty()) // ť�� ����ִ��� Ȯ���մϴ�. ����ִٸ�
					bw.write("1\n"); // "1"�� ����մϴ�.
				else // ������� �ʴٸ�
					bw.write("0\n"); // "0"�� ����մϴ�.
			} else if (in[0].equals("front")) { // "front" ��ɾ �Էµ� ���
				if (q.isEmpty()) // ť�� ����ִ��� Ȯ���մϴ�. ����ִٸ�
					bw.write("-1\n"); // "-1"�� ����մϴ�.
				else // ������� �ʴٸ�
					bw.write(q.getFirst() + "\n"); // ť�� ù ��° ���Ҹ� ����մϴ�.
			} else if (in[0].equals("back")) { // "back" ��ɾ �Էµ� ���
				if (q.isEmpty()) // ť�� ����ִ��� Ȯ���մϴ�. ����ִٸ�
					bw.write("-1\n"); // "-1"�� ����մϴ�.
				else // ������� �ʴٸ�
					bw.write(q.getLast() + "\n"); // ť�� ������ ���Ҹ� ����մϴ�.
			}
		}

		bw.flush(); // BufferedWriter�� �׿��ִ� ����� ��� ����մϴ�.
		bw.close(); // BufferedWriter�� �ݽ��ϴ�.

	}
}