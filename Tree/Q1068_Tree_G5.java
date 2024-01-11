package Tree;

/*
commented by ChatGPT
This Java code implements a tree structure to simulate the deletion of a node and its descendants in a tree. 
The program reads a list of parent-child relationships to construct the tree, then removes a specified node and all its descendants. 
Finally, it counts the remaining leaf nodes. 
The Tree class represents each node with a parent ID and a list of children. 
The remove function recursively deletes a node and its children by setting their parent ID to -2.
이 Java 코드는 트리에서 노드와 그 자손을 삭제하는 것을 시뮬레이션하기 위해 트리 구조를 구현합니다. 
프로그램은 부모-자식 관계 목록을 읽어 트리를 구성한 다음, 지정된 노드와 그 자손을 모두 제거합니다. 
마지막으로 남아 있는 리프 노드의 수를 계산합니다. 
Tree 클래스는 각 노드를 부모 ID와 자식 목록으로 나타냅니다. 
remove 함수는 재귀적으로 노드와 그 자식을 삭제하여 부모 ID를 -2로 설정합니다.
*/

import java.io.*;
import java.util.*;

public class Q1068_Tree_G5 {

	static class Tree {
		int parent; // Parent of the current node (현재 노드의 부모)
		ArrayList<Integer> child = new ArrayList<>(); // List of children of the current node (현재 노드의 자식 목록)

		Tree() { // Constructor (생성자)
		}

		void setPar(int parent) { // Set the parent of the current node (현재 노드의 부모 설정)
			this.parent = parent;
		}

		void addChild(int child) { // Add a child to the current node (현재 노드에 자식 추가)
			this.child.add(child);
		}

		int NumberOfChild() { // Return the number of children (자식의 수 반환)
			return this.child.size();
		}
	}

	static int N; // Number of nodes in the tree (트리의 노드 수)
	static Tree tree[]; // Array to store tree nodes (트리 노드를 저장하는 배열)

// Function to remove a node and its descendants (노드와 그 자손을 제거하는 함수)
	static void remove(int idx) {
		tree[idx].parent = -2; // Mark the node as removed (노드를 제거된 것으로 표시)
		for (int i = 0; i < tree[idx].NumberOfChild(); i++) {
			remove(tree[idx].child.get(i)); // Recursively remove all children (모든 자식을 재귀적으로 제거)
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int res = 0; // Variable to count the number of leaf nodes (리프 노드의 수를 세는 변수)
		int rem; // Node to be removed (제거할 노드)

		N = Integer.parseInt(br.readLine()); // Read the number of nodes (노드 수 읽기)
		tree = new Tree[N]; // Initialize the tree array (트리 배열 초기화)

		for (int i = 0; i < N; i++)
			tree[i] = new Tree(); // Initialize each tree node (각 트리 노드 초기화)

		String inp[] = br.readLine().split(" "); // Read parent-child relationships (부모-자식 관계 읽기)
		for (int i = 0; i < N; i++) {
			int par = Integer.parseInt(inp[i]); // Parent of the current node (현재 노드의 부모)
			tree[i].setPar(par); // Set the parent of the current node (현재 노드의 부모 설정)
			if (par >= 0)
				tree[par].addChild(i); // Add the current node as a child to its parent (현재 노드를 부모의 자식으로 추가)
		}
		rem = Integer.parseInt(br.readLine()); // Read the node to be removed (제거할 노드 읽기)
		remove(rem); // Remove the specified node and its descendants (지정된 노드와 그 자손 제거)

		for (int i = 0; i < N; i++) {
			if (tree[i].parent < -1) // Skip removed nodes (제거된 노드 건너뛰기)
				continue;
			if (tree[i].child.size() == 0 || (tree[i].child.size() == 1 && tree[i].child.get(0) == rem)) // Count leaf
																											// nodes (리프
																											// 노드 세기)
				res++;
		}

		bw.write(res + ""); // Write the number of remaining leaf nodes (남아 있는 리프 노드의 수 작성)
		bw.flush(); // Flush the BufferedWriter (BufferedWriter 플러시)
		bw.close(); // Close the BufferedWriter (BufferedWriter 닫기)
	}
}