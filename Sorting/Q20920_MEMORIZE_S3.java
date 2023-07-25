package Sorting;

import java.io.*;
import java.util.*;

public class Q20920_MEMORIZE_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // �Է��� �ޱ� ���� BufferedReader ��ü ����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ����� ���� BufferedWriter ��ü ����

		String inp[] = br.readLine().split(" "); // ù��° �� �Է°��� ������ �������� �и��Ͽ� inp �迭�� ����

		int n = Integer.parseInt(inp[0]); // �ܾ��� ����
		int m = Integer.parseInt(inp[1]); // �ܿ� �ܾ��� �ּ� ����
		int idx = n;

		ArrayList<String> word = new ArrayList<String>(); // �ܾ���� ������ ArrayList
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); // �ܾ�� �ش� �ܾ��� ���� Ƚ���� ������ HashMap

		// n�� �ݺ��ϸ鼭 �ܾ �Է� �ް� ó��
		for (int i = 0; i < n; i++) {
			String temp = br.readLine(); // �ܾ �Է� ����
			if (temp.length() >= m) { // �ܾ��� ���̰� m �̻��� ��
				hm.put(temp, hm.getOrDefault(temp, 0) + 1); // HashMap�� �ܾ Ű�� ���� Ƚ���� ������ ����
				if (hm.get(temp) == 1)
					word.add(temp); // �ܾ ó�� �����ϸ� ArrayList�� �߰�
				else
					idx--; // �ܾ �ߺ��Ǹ� idx ���� ����
			} else
				idx--; // �ܾ��� ���̰� m �̸��� ��� idx ���� ����
		}

		// �ܾ Ư���� ���ؿ� ���� ����
		Collections.sort(word, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (hm.get(o1) < hm.get(o2))
					return 1;
				else if (hm.get(o1) == hm.get(o2)) {
					if (o1.length() < o2.length())
						return 1;
					else if (o1.length() == o2.length()) {
						return o1.compareTo(o2); // �� �ܾ��� ���̿� ���� Ƚ���� �����ϸ� ���� ������ ��
					} else
						return -1;
				} else
					return -1;
			}
		});

		// ���ĵ� �ܾ ���
		for (int i = 0; i < idx; i++) {
			bw.write(word.get(i) + "\n");
		}

		bw.flush();
		bw.close(); // BufferedWriter ����
	}
}