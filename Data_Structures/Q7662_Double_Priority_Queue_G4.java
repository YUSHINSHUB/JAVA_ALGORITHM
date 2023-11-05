package Data_Structures;

/*
commented by ChatGPT
This Java code implements a dual-priority queue system using a max-heap and a min-heap to support the insertion, deletion of maximum and minimum elements. 
It solves the problem where operations are performed on a dynamically changing dataset, and after all operations, the maximum and minimum elements are queried.
이 Java 코드는 최대 힙과 최소 힙을 사용하는 이중 우선순위 큐 시스템을 구현하여 삽입, 최대 및 최소 요소의 삭제를 지원합니다. 
이는 동적으로 변경되는 데이터 세트에 대해 연산을 수행하고, 모든 연산 후에 최대 및 최소 요소를 조회하는 문제를 해결합니다.
*/

import java.io.*;
import java.util.*;

public class Q7662_Double_Priority_Queue_G4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine()); // 연산의 개수
			HashMap<Integer, Integer> hm = new HashMap<>(); // 각 숫자의 개수를 기록하는 해시맵
			PriorityQueue<Integer> gr = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
			PriorityQueue<Integer> sm = new PriorityQueue<>(); // 최소 힙

			for (int j = 0; j < k; j++) {
				// 두 힙이 모두 비어있다면 불필요한 요소들을 제거
				if (gr.isEmpty()) {
					while (!sm.isEmpty())
						sm.poll();
				}
				if (sm.isEmpty()) {
					while (!gr.isEmpty())
						gr.poll();
				}

				String inp[] = br.readLine().split(" ");
				int temp = Integer.parseInt(inp[1]); // 숫자

				if (inp[0].equals("I")) { // 삽입 연산
					sm.add(temp);
					gr.add(temp);
					hm.put(temp, hm.getOrDefault(temp, 0) + 1);
				} else { // 삭제 연산
					if (temp == 1) { // 최대값 삭제
						if (gr.isEmpty())
							continue;
						else {
							while (hm.get(gr.peek()) == 0) {
								gr.poll();
								if (gr.isEmpty())
									break;
							}
							if (gr.isEmpty())
								continue;
							int t = gr.poll();
							hm.put(t, hm.get(t) - 1);
						}
					} else { // 최소값 삭제
						if (sm.isEmpty())
							continue;
						else {
							while (hm.get(sm.peek()) == 0) {
								sm.poll();
								if (sm.isEmpty())
									break;
							}
							if (sm.isEmpty())
								continue;
							int t = sm.poll();
							hm.put(t, hm.get(t) - 1);
						}
					}
				}
			}

			// 최종적으로 남은 최대값과 최소값을 확인
			if (!sm.isEmpty()) {
				while (hm.get(sm.peek()) == 0) {
					sm.poll();
					if (sm.isEmpty())
						break;
				}
			}
			if (!gr.isEmpty()) {
				while (hm.get(gr.peek()) == 0) {
					gr.poll();
					if (gr.isEmpty())
						break;
				}
			}
			// 결과 출력
			if (gr.isEmpty() || sm.isEmpty())
				bw.write("EMPTY\n");
			else
				bw.write(gr.poll() + " " + sm.poll() + "\n");
		}

		bw.flush();
		bw.close();
	}
}
