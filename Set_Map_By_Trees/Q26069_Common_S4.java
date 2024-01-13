package Set_Map_By_Trees;

import java.io.*;
import java.util.*;

public class Q26069_Common_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 사용자로부터 쌍의 개수 n을 입력받음
		int n = Integer.parseInt(br.readLine());

		// 최종 결과를 저장하는 변수
		int res = 0;

		// 이름과 연결 여부를 저장하는 해쉬맵 (연결되어 있으면 1, 아니면 0)
		HashMap<String, Integer> hm = new HashMap<>();
		String a, b;

		// ChongChong은 항상 연결된 그룹에 포함되므로 1로 설정
		hm.put("ChongChong", 1);

		// n 개의 쌍을 입력받음
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			a = inp[0];
			b = inp[1];

			// a 또는 b가 해쉬맵에 없으면 추가하고 초기값을 0으로 설정
			if (!hm.containsKey(a)) {
				hm.put(a, 0);
			}
			if (!hm.containsKey(b)) {
				hm.put(b, 0);
			}

			// a가 연결된 그룹에 속하면, b도 그룹에 추가
			if (hm.get(a) == 1)
				hm.put(b, 1);
			// 반대의 경우도 마찬가지
			else if (hm.get(b) == 1)
				hm.put(a, 1);

		}

		// 모든 엔트리를 돌며 연결된 항목의 수를 카운트
		for (Map.Entry<String, Integer> en : hm.entrySet()) {
			if (en.getValue() == 1)
				res++;
		}

		// 결과를 출력
		bw.write(res + "");

		bw.flush();
		bw.close();

	}
}