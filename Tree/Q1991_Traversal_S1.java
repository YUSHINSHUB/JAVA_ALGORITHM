package Tree;

/*
commented by ChatGPT
This Java code implements tree traversal algorithms (preorder, inorder, and postorder) for a binary tree. 
The tree is constructed based on input representing the nodes and their left and right children. 
The node class represents a tree node with left and right child indices. The tree traversal functions (pre, ino, pos) recursively visit nodes in different orders and append the node's character representation to the StringBuilder sb. 
After traversals are complete, the output for each traversal order is written to a BufferedWriter.

이 Java 코드는 이진 트리에 대한 트리 순회 알고리즘(전위, 중위, 후위 순회)을 구현합니다. 
노드와 그들의 왼쪽 및 오른쪽 자식을 나타내는 입력을 기반으로 트리가 구성됩니다. 
node 클래스는 왼쪽 및 오른쪽 자식 인덱스를 가진 트리 노드를 나타냅니다. 
트리 순회 함수(pre, ino, pos)는 다른 순서로 노드를 재귀적으로 방문하고 노드의 문자 표현을 StringBuilder sb에 추가합니다. 
순회가 완료되면 각 순회 순서에 대한 출력이 BufferedWriter에 작성됩니다.
*/

import java.io.*;
import java.util.*;

public class Q1991_Traversal_S1 {

	static int N; // 트리의 노드 수
	static StringBuilder sb = new StringBuilder(""); // 출력을 저장할 StringBuilder
	static node n[]; // 노드 배열

// 노드 클래스 정의: 왼쪽과 오른쪽 자식 노드의 인덱스를 저장
	static class node {
		int left = -1;
		int right = -1;

		node() {
		}
	}

// 전위 순회 함수
	static void pre(int idx) {
		sb.append((char) (idx + 'A')); // 노드 방문
		if (n[idx].left >= 0) // 왼쪽 자식 존재 시 순회
			pre(n[idx].left);
		if (n[idx].right >= 0) // 오른쪽 자식 존재 시 순회
			pre(n[idx].right);
	}

// 중위 순회 함수
	static void ino(int idx) {
		if (n[idx].left >= 0) // 왼쪽 자식 존재 시 순회
			ino(n[idx].left);
		sb.append((char) (idx + 'A')); // 노드 방문
		if (n[idx].right >= 0) // 오른쪽 자식 존재 시 순회
			ino(n[idx].right);
	}

// 후위 순회 함수
	static void pos(int idx) {
		if (n[idx].left >= 0) // 왼쪽 자식 존재 시 순회
			pos(n[idx].left);
		if (n[idx].right >= 0) // 오른쪽 자식 존재 시 순회
			pos(n[idx].right);
		sb.append((char) (idx + 'A')); // 노드 방문
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];
		int in1, in2, in3;

		N = Integer.parseInt(br.readLine()); // 노드 수 입력 받기
		n = new node[N]; // 노드 배열 초기화

		// 트리 구성
		for (int i = 0; i < N; i++)
			n[i] = new node();
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			in1 = inp[0].charAt(0) - 'A';
			in2 = inp[1].charAt(0) - 'A';
			in3 = inp[2].charAt(0) - 'A';

			if (in2 >= 0 && in2 <= 25) {
				n[in1].left = in2; // 왼쪽 자식 설정
			}
			if (in3 >= 0 && in3 <= 25) {
				n[in1].right = in3; // 오른쪽 자식 설정
			}
		}

		// 트리 순회
		pre(0); // 전위 순회
		sb.append("\n");
		ino(0); // 중위 순회
		sb.append("\n");
		pos(0); // 후위 순회
		sb.append("\n");

		// 결과 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}