package Tree;

/*
commented by ChatGPT
This Java code implements a Trie data structure to organize and display a hierarchical structure of strings. 
Each node in the Trie represents a string, and the children of each node represent strings that follow the parent string in the hierarchy. 
The program reads input strings, organizes them into a Trie, and then recursively prints the Trie in a hierarchical format with indentations.
이 Java 코드는 문자열의 계층 구조를 조직하고 표시하기 위해 Trie 데이터 구조를 구현합니다. 
Trie의 각 노드는 하나의 문자열을 나타내며, 각 노드의 자식들은 계층 구조에서 부모 문자열을 따르는 문자열들을 나타냅니다. 
프로그램은 입력 문자열을 읽고, 이를 Trie에 조직한 다음, 재귀적으로 Trie를 계층적 형식으로 들여쓰기하여 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q14725_ANTHILL_G3 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int K = 0; // K represents the number of strings in each input line.

	static class TrieNode {
		// Each node has a HashMap to store its children.
		HashMap<String, TrieNode> child = new HashMap<>();

		void input(String[] inp) {
			TrieNode node = this;

			// Iterates through each string in the input array and adds it to the Trie.
			for (int i = 0; i < K; i++) {
				node.child.putIfAbsent(inp[i], new TrieNode());
				node = node.child.get(inp[i]);
			}
		}
	}

// Recursive method to print the Trie.
	static void output(TrieNode node, int depth) throws IOException {
		// Sorts the child nodes alphabetically for ordered output.
		ArrayList<String> list = new ArrayList<>(node.child.keySet());
		Collections.sort(list);
		for (String str : list) {
			// Prints the current string with indentations based on its depth in the Trie.
			for (int j = 0; j < depth; j++)
				bw.write("--");
			bw.write(str + "\n");
			// Recursively prints child nodes.
			output(node.child.get(str), depth + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // Number of input lines.
		String[] in = new String[15];
		TrieNode node = new TrieNode();

		for (int i = 0; i < N; i++) {
			String[] inp = br.readLine().split(" ");
			K = Integer.parseInt(inp[0]); // First element represents the number of strings.
			for (int j = 1; j <= K; j++)
				in[j - 1] = inp[j];
			node.input(in);
		}

		output(node, 0); // Prints the Trie starting from the root node.

		bw.flush();
		bw.close();
	}
}