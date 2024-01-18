package Tree;

/*
commented by ChatGPT
This Java code implements a tree-like structure processing using recursion and a queue. 
It reads integer inputs to form a binary search tree (BST), then traverses it in a specific order to reconstruct the BST, ensuring each node is within a defined range. 
The recursion function 'recur' is used to traverse the tree, and the StringBuilder 'sb' collects the output in the specified traversal order. 
The main function reads inputs until EOF, initializes the tree with the first element, and then calls 'recur' to process the remaining elements.
이 Java 코드는 재귀 및 큐를 사용하여 트리 구조를 처리합니다. 
정수 입력을 받아 이진 탐색 트리(BST)를 형성한 다음, 정의된 범위 내에서 각 노드를 재구성하도록 특정 순서로 탐색합니다. 
'recur' 재귀 함수는 트리를 탐색하는 데 사용되며, StringBuilder 'sb'는 지정된 순서대로 출력을 수집합니다. 
메인 함수는 EOF까지 입력을 읽고, 첫 번째 요소로 트리를 초기화한 다음, 'recur'를 호출하여 나머지 요소를 처리합니다.
*/

import java.io.*;
import java.util.*;

public class Q5639_BST_G5 {

	static Queue<Integer> input = new LinkedList<>(); // 입력된 정수를 저장할 큐
	static StringBuilder sb = new StringBuilder(""); // 결과 문자열을 저장할 StringBuilder

// 재귀 함수 'recur' 정의
	static void recur(int node, int hig, int low) {
		// 큐가 비어있는 경우, 현재 노드를 StringBuilder에 추가하고 함수 종료
		if (input.isEmpty()) {
			sb.append(node + "\n");
			return;
		}

		int cur = input.peek(); // 큐의 첫 번째 요소 확인
		// 현재 요소가 지정된 범위 내에 있고 node보다 작은 경우
		if (cur < hig && cur > low) {
			if (cur < node) {
				input.poll(); // 큐에서 요소 제거
				recur(cur, node, low); // 좌측 자식 노드로 재귀 호출
			}
		}

		// 큐가 비어있는 경우, 현재 노드를 StringBuilder에 추가하고 함수 종료
		if (input.isEmpty()) {
			sb.append(node + "\n");
			return;
		}

		cur = input.peek(); // 큐의 첫 번째 요소 재확인
		// 현재 요소가 지정된 범위 내에 있고 node보다 큰 경우
		if (cur < hig && cur > low) {
			if (cur > node) {
				input.poll(); // 큐에서 요소 제거
				recur(cur, hig, node); // 우측 자식 노드로 재귀 호출
			}
		}

		// 현재 노드를 StringBuilder에 추가
		sb.append(node + "\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp;

		// 입력된 모든 줄을 읽어 큐에 추가
		while ((inp = br.readLine()) != null) {
			input.add(Integer.parseInt(inp));
		}

		int top = input.poll(); // 큐의 첫 번째 요소(루트 노드)를 제거하고 변수에 저장

		recur(top, 1000000, -1); // 재귀 함수 호출

		bw.write(sb.toString() + ""); // StringBuilder의 내용을 출력

		bw.flush();
		bw.close();
	}
}
