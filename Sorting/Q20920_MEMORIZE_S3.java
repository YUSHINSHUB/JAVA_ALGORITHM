package Sorting;

import java.io.*;
import java.util.*;

public class Q20920_MEMORIZE_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위한 BufferedWriter 객체 생성

		String inp[] = br.readLine().split(" "); // 첫번째 줄 입력값을 공백을 기준으로 분리하여 inp 배열에 저장

		int n = Integer.parseInt(inp[0]); // 단어의 개수
		int m = Integer.parseInt(inp[1]); // 외울 단어의 최소 길이
		int idx = n;

		ArrayList<String> word = new ArrayList<String>(); // 단어들을 저장할 ArrayList
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); // 단어와 해당 단어의 등장 횟수를 저장할 HashMap

		// n번 반복하면서 단어를 입력 받고 처리
		for (int i = 0; i < n; i++) {
			String temp = br.readLine(); // 단어를 입력 받음
			if (temp.length() >= m) { // 단어의 길이가 m 이상일 때
				hm.put(temp, hm.getOrDefault(temp, 0) + 1); // HashMap에 단어를 키로 등장 횟수를 값으로 저장
				if (hm.get(temp) == 1)
					word.add(temp); // 단어가 처음 등장하면 ArrayList에 추가
				else
					idx--; // 단어가 중복되면 idx 값을 감소
			} else
				idx--; // 단어의 길이가 m 미만일 경우 idx 값을 감소
		}

		// 단어를 특정한 기준에 따라 정렬
		Collections.sort(word, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (hm.get(o1) < hm.get(o2))
					return 1;
				else if (hm.get(o1) == hm.get(o2)) {
					if (o1.length() < o2.length())
						return 1;
					else if (o1.length() == o2.length()) {
						return o1.compareTo(o2); // 두 단어의 길이와 등장 횟수가 동일하면 사전 순으로 비교
					} else
						return -1;
				} else
					return -1;
			}
		});

		// 정렬된 단어를 출력
		for (int i = 0; i < idx; i++) {
			bw.write(word.get(i) + "\n");
		}

		bw.flush();
		bw.close(); // BufferedWriter 종료
	}
}