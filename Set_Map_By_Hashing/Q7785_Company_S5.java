package Set_Map_By_Hashing;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q7785_Company_S5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap();
		ArrayList<String> list = new ArrayList();
		// 인덱스가 확실치 않은 배열을 정렬해야 하기 때문에 ArrayList 사용
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
		// 문자열 역순정렬

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}

		bw.flush();
		bw.close();

	}
}
