package Data_Structures;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q20923_HalliGalli_S1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		String res = "";

		Deque<Integer> d = new LinkedList<>(); //������ ��
		Deque<Integer> s = new LinkedList<>(); //�������� ��
		Deque<Integer> dg = new LinkedList<>(); //������ �׶���
		Deque<Integer> sg = new LinkedList<>(); //�������� �׶���

		for (int i = 0; i < n; i++) {
			//ī����̸� �ո��� ���ΰ����� ���������� �� ������ First, �Ʒ����� Last�� ����.
			inp = br.readLine().split(" ");
			d.addLast(Integer.parseInt(inp[0]));
			s.addLast(Integer.parseInt(inp[1]));
		}

		for (int i = 0; i < m; i++) {

			if (i % 2 == 0) {
				dg.addFirst(d.pollLast());

				if (d.isEmpty()) {
					res = "su";
					break;
				}

				if (!sg.isEmpty()) {
					if (dg.getFirst() + sg.getFirst() == 5) {
						while (!dg.isEmpty())
							s.addFirst(dg.pollLast());
						while (!sg.isEmpty())
							s.addFirst(sg.pollLast());
					}
				}
				if (!dg.isEmpty()) {
					if (dg.getFirst() == 5) {
						while (!sg.isEmpty())
							d.addFirst(sg.pollLast());
						while (!dg.isEmpty())
							d.addFirst(dg.pollLast());
					}
				}
			} else {
				sg.addFirst(s.pollLast());
				if (d.isEmpty()) {
					res = "su";
					break;
				}
				if (!dg.isEmpty()) {
					if (dg.getFirst() + sg.getFirst() == 5) {
						while (!dg.isEmpty())
							s.addFirst(dg.pollLast());
						while (!sg.isEmpty())
							s.addFirst(sg.pollLast());
					}
				}
				if (!sg.isEmpty()) {
					if (sg.getFirst() == 5) {
						while (!sg.isEmpty())
							d.addFirst(sg.pollLast());
						while (!dg.isEmpty())
							d.addFirst(dg.pollLast());
					}
				}
			}

			if (d.isEmpty() && s.isEmpty()) {
				res = "dosu";
				break;
			} else if (d.isEmpty()) {
				res = "su";
				break;
			} else if (s.isEmpty()) {
				res = "do";
				break;
			}

		}

		if (res.equals("")) {
			//���� M���� �ߵ� ���� ���� ��� �����Ͽ������� ���ڸ� ������.
			if (d.size() > s.size())
				res = "do";
			else if (d.size() < s.size())
				res = "su";
			else
				res = "dosu";
		}

		bw.write(res);

		bw.flush();
		bw.close();
	}
}
