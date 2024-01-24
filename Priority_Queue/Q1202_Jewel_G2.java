package Priority_Queue;

import java.io.*;
import java.util.*;
import java.math.*;

/*
commented by ChatGPT
This Java code is designed to solve a problem related to maximizing the value of jewels that can be carried in bags of given capacities. 
The jewel class holds the mass (m) and value (v) of each jewel. 
The program uses three PriorityQueues: jpq for sorting jewels by their mass, bpq for the capacities of the bags, and tq for temporarily holding the values of jewels that can fit in the current bag being processed. 
The algorithm reads the number of jewels (N) and bags (K), and then inputs the jewels into jpq and the bag capacities into bpq. 
For each bag, the code polls jewels from jpq that can fit in the bag (based on mass) and adds their values to tq. 
The highest value jewel that can fit in the bag is added to the total result (res). The process repeats until all bags are processed. 
The total value of the jewels that can be carried is then output.
이 Java 코드는 주어진 가방의 용량에 따라 보석의 가치를 최대화하는 문제를 해결하기 위해 설계되었습니다. jewel 클래스는 각 보석의 질량(m)과 가치(v)를 보유합니다. 
프로그램은 세 개의 PriorityQueue를 사용합니다: 보석을 그들의 질량에 따라 정렬하는 jpq, 가방의 용량을 위한 bpq, 그리고 현재 처리되고 있는 가방에 맞을 수 있는 보석들의 가치를 임시로 보관하는 tq. 
알고리즘은 보석의 수(N)와 가방의 수(K)를 읽고, 그 다음 jpq에 보석들을 입력하고 bpq에 가방 용량을 입력합니다. 
각 가방에 대해, 코드는 가방에 맞을 수 있는(질량 기준) 보석들을 jpq에서 가져와 그들의 가치를 tq에 추가합니다. 가방에 맞는 가장 높은 가치의 보석은 총 결과(res)에 추가됩니다. 
이 과정은 모든 가방이 처리될 때까지 반복됩니다. 그 후, 운반할 수 있는 보석들의 총 가치가 출력됩니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q1202_Jewel_G2 {

	static class jewel {
		int m, v; // m: 질량, v: 가치

		jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long res = 0; // 운반할 수 있는 보석들의 총 가치
		int N, K; // N: 보석의 수, K: 가방의 수
		String inp[];
		PriorityQueue<jewel> jpq = new PriorityQueue<>((jewel o1, jewel o2) -> o1.m - o2.m); // 질량에 따라 보석 정렬
		PriorityQueue<Integer> bpq = new PriorityQueue<>(); // 가방 용량 정렬
		PriorityQueue<Integer> tq = new PriorityQueue<>(Collections.reverseOrder()); // 보석 가치 임시 저장

		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		K = Integer.parseInt(inp[1]);

		// 보석 입력
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			jpq.add(new jewel(Integer.parseInt(inp[0]), Integer.parseInt(inp[1])));
		}

		// 가방 용량 입력
		for (int i = 0; i < K; i++) {
			bpq.add(Integer.parseInt(br.readLine()));
		}

		// 각 가방에 대해 처리
		while (!bpq.isEmpty()) {
			int cap = bpq.poll(); // 현재 가방 용량
			// 용량에 맞는 보석 처리
			while (!jpq.isEmpty()) {
				jewel j = jpq.poll();
				if (j.m > cap) {
					jpq.add(j); // 용량보다 큰 보석 되돌림
					break;
				}
				tq.add(j.v); // 용량에 맞는 보석 가치 추가
			}
			if (!tq.isEmpty()) {
				res += tq.poll(); // 가장 가치 있는 보석 추가
			}
		}

		bw.write(res + ""); // 결과 출력
		bw.flush();
		bw.close();
	}
}