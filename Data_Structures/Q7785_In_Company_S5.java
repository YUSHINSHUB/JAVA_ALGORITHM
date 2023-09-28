package Data_Structures;

import java.io.*;
import java.util.*;

public class Q7785_In_Company_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap();
		ArrayList<String> list = new ArrayList();
		// �ε����� Ȯ��ġ ���� �迭�� �����ؾ� �ϱ� ������ ArrayList ���
		int idx = 0;

		String name, stat;

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			name = inp[0];
			stat = inp[1];
			if (stat.equals("enter"))
				hm.put(name, 1);
			else
				hm.put(name, 0);
		}

		for (HashMap.Entry<String, Integer> et : hm.entrySet()) {
			if (et.getValue() == 1) {
				list.add(et.getKey());
			}
		}

		Collections.sort(list, Comparator.reverseOrder());
		// ���ڿ� ��������

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}

		bw.flush();
		bw.close();

	}
}