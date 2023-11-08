package Breadth_first_Search;

/*
commented by ChatGPT
This Java code performs a breadth-first search (BFS) to find the shortest sequence of commands to transform an initial number (A) into a target number (B). 
The commands are represented as "D", "S", "L", and "R" operations that manipulate the number as per given rules. 
It uses a queue to track the numbers generated at each step and a hashmap to store the corresponding sequence of commands leading to those numbers. 
When the target number is found, the sequence of commands is returned.
이 Java 코드는 초기 숫자(A)를 목표 숫자(B)로 변환하는 명령어들의 최단 시퀀스를 찾기 위해 너비 우선 탐색(BFS)을 수행합니다. 
명령어들은 주어진 규칙에 따라 숫자를 조작하는 "D", "S", "L", "R" 연산으로 표현됩니다. 
이 코드는 각 단계에서 생성된 숫자들을 추적하기 위해 큐를 사용하고, 해당 숫자로 이어지는 명령어 시퀀스를 저장하기 위해 해시맵을 사용합니다. 
목표 숫자를 찾으면 해당 명령어 시퀀스가 반환됩니다.
*/

import java.io.*;
import java.util.*;

public class Q9019_DSLR_G4 {

	static int A; // 초기 숫자
	static int B; // 목표 숫자

	static String bfs() {
		Queue<Integer> q = new LinkedList<>(); // BFS를 위한 큐
		HashMap<Integer, String> hm = new HashMap<>(); // 각 숫자에 대한 명령어 시퀀스를 저장하는 해시맵

		if (A == B)
			return ""; // 초기 숫자와 목표 숫자가 같으면 빈 문자열 반환

		// 초기 명령어들을 큐에 추가하고 해시맵에 저장
		int t = A * 2 % 10000;
		q.add(t);
		hm.put(t, "D");
		if (t == B)
			return "D";

		t = (A == 0) ? 9999 : A - 1;
		q.add(t);
		hm.put(t, "S");
		if (t == B)
			return "S";

		t = A / 1000 + (A % 1000) * 10;
		q.add(t);
		hm.put(t, "L");
		if (t == B)
			return "L";

		t = A / 10 + (A % 10) * 1000;
		q.add(t);
		hm.put(t, "R");
		if (t == B)
			return "R";

		// BFS 루프 시작
		while (!q.isEmpty()) {
			t = q.poll();

			// "D" 명령어 수행
			int temp = t * 2 % 10000;
			if (temp == B)
				return hm.get(t) + "D";
			else if (!hm.containsKey(temp)) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "D");
			}

			// "S" 명령어 수행
			temp = (t == 0) ? 9999 : t - 1;
			if (temp == B)
				return hm.get(t) + "S";
			else if (!hm.containsKey(temp)) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "S");
			}

			// "L" 명령어 수행
			temp = t / 1000 + (t % 1000) * 10;
			if (temp == B)
				return hm.get(t) + "L";
			else if (!hm.containsKey(temp)) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "L");
			}

			// "R" 명령어 수행
			temp = t / 10 + (t % 10) * 1000;
			if (temp == B)
				return hm.get(t) + "R";
			else if (!hm.containsKey(temp)) {
				q.add(temp);
				hm.put(temp, hm.get(t) + "R");
			}
		}

		return ""; // 탐색 실패 시 빈 문자열 반환
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		for (int i = 0; i < T; i++) {
			String[] inp = br.readLine().split(" ");
			A = Integer.parseInt(inp[0]); // 초기 숫자
			B = Integer.parseInt(inp[1]); // 목표 숫자
			bw.write(bfs() + "\n"); // 결과 출력
		}

		bw.flush();
		bw.close();
	}
}