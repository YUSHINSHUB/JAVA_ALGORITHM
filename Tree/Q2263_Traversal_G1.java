package Tree;

/*
commented by ChatGPT
This Java code reconstructs a binary tree from given inorder and postorder traversal sequences and then generates the preorder traversal sequence of the reconstructed tree. 
It uses indexing arrays to efficiently track the position of nodes in the inorder sequence and to build the binary tree structure by associating left and right children to each node. 
After constructing the tree, it traverses the tree in preorder and appends the values to a StringBuilder, which is finally outputted.
이 Java 코드는 주어진 중위 순회 및 후위 순회 시퀀스로부터 이진 트리를 재구성하고, 재구성된 트리의 전위 순회 시퀀스를 생성합니다. 
이 코드는 중위 순서에서 노드의 위치를 효율적으로 추적하고 각 노드에 왼쪽 및 오른쪽 자식을 연결하여 이진 트리 구조를 구축하기 위해 인덱싱 배열을 사용합니다. 
트리 구축 후, 전위 순회를 통해 트리를 탐색하고 값을 StringBuilder에 추가한 다음, 최종적으로 출력합니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q2263_Traversal_G1 {

	static int n; // Number of nodes in the tree
	static int idx; // Current index for postorder array processing
	static int in[] = new int[100001]; // Inorder traversal array
	static int post[] = new int[100001]; // Postorder traversal array
	static int inpos[] = new int[100001]; // Positions of nodes in inorder traversal
	static Boolean visited[] = new Boolean[100003]; // Visited nodes tracker
	static int left[] = new int[100001]; // Left children of nodes
	static int right[] = new int[100001]; // Right children of nodes
	static StringBuilder sb = new StringBuilder(""); // StringBuilder to store preorder traversal

	// Constructs the binary tree from inorder and postorder traversals
	static void make_tree() {

		if (idx == 0)
			return;

		int node = post[idx]; // Current node to process
		visited[inpos[node]] = true; // Mark the node as visited
		int next = post[idx - 1]; // Next node in postorder sequence

		// Attempt to find the right child of the current node
		for (int i = inpos[node] + 1; i < n; i++) {
			if (visited[i])
				break;
			if (in[i] == next) {
				right[node] = next;
				idx--;
				make_tree();
				break;
			}
		}

		if (idx == 0)
			return;
		next = post[idx - 1];

		// Attempt to find the left child of the current node
		for (int i = inpos[node] - 1; i >= 0; i--) {
			if (visited[i])
				break;
			if (in[i] == next) {
				left[node] = next;
				idx--;
				make_tree();
				break;
			}
		}
	}

	// Generates the preorder traversal of the tree and appends to StringBuilder
	static void get_pre(int node) {
		sb.append(node + " ");
		if (left[node] > 0)
			get_pre(left[node]);
		if (right[node] > 0)
			get_pre(right[node]);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(visited, false);
		Arrays.fill(left, 0);
		Arrays.fill(right, 0);

		n = Integer.parseInt(br.readLine()); // Read number of nodes
		idx = n - 1; // Set the index for postorder array
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(inp[i]);
			inpos[in[i]] = i; // Store the position of each node in inorder traversal
		}
		inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			post[i] = Integer.parseInt(inp[i]); // Read postorder traversal

		make_tree(); // Construct the tree
		get_pre(post[n - 1]); // Generate preorder traversal from the constructed tree

		bw.write(sb.toString()); // Write the preorder traversal to the output
		bw.flush();
		bw.close();
	}
}
