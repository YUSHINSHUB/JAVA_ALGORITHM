package Set_Map_By_Hashing;

/*
commented by ChatGPT
This Java code implements a social network analysis where it calculates the size of friend groups based on new friendships formed. 
It uses Union-Find data structure to efficiently merge groups and find the representative (parent) of each group. 
Each test case represents a scenario where friendships are formed, and the program outputs the size of the resulting friend group for each new friendship.
이 Java 코드는 새로운 우정이 형성됨에 따라 친구 그룹의 크기를 계산하는 소셜 네트워크 분석을 구현합니다.
그룹을 효율적으로 병합하고 각 그룹의 대표(부모)를 찾기 위해 Union-Find 자료 구조를 사용합니다.
각 테스트 케이스는 우정이 형성되는 시나리오를 나타내며, 프로그램은 새로운 우정마다 결과적인 친구 그룹의 크기를 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q4195_FriendsNetwork_G2 {

	static int parent[] = new int[200000]; // Stores the parent of each node
	static int groupcnt[] = new int[200000]; // Stores the size of the group each node belongs to

	static int find_parent(int no) {
		if (parent[no] == no) { // If the node is a parent of itself
			return no;
		}
		// Path compression: make the found parent the direct parent of 'no'
		return parent[no] = find_parent(parent[no]);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T; // Number of test cases

		T = Integer.parseInt(br.readLine());

		for (int c = 0; c < T; c++) {
			Arrays.fill(parent, 0);
			Arrays.fill(groupcnt, 0);
			HashMap<String, Integer> hm = new HashMap<>(); // Maps each person to a unique integer
			int F = Integer.parseInt(br.readLine()); // Number of friendships
			int cnt = 0; // Counter for unique integers
			for (int i = 0; i < F; i++) {
				String inp[] = br.readLine().split(" ");
				// For each person, assign a unique integer if not already assigned
				if (!hm.containsKey(inp[0])) {
					hm.put(inp[0], cnt);
					parent[cnt] = cnt; // Make the person a parent of itself
					groupcnt[cnt] = 1; // Initialize group size as 1
					cnt++;
				}
				int a = hm.get(inp[0]);
				if (!hm.containsKey(inp[1])) {
					hm.put(inp[1], cnt);
					parent[cnt] = cnt; // Make the person a parent of itself
					groupcnt[cnt] = 1; // Initialize group size as 1
					cnt++;
				}
				int b = hm.get(inp[1]);
				// Union operation: merge the two groups if they are different
				if (find_parent(a) != find_parent(b)) {
					groupcnt[find_parent(a)] += groupcnt[find_parent(b)];
					// After merging, set the group size of the merged group to 0
					groupcnt[find_parent(b)] = 0;
					// Update the parent of the merged group
					parent[find_parent(b)] = find_parent(a);
				}
				// Output the size of the group after each friendship is formed
				bw.write(groupcnt[find_parent(a)] + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
