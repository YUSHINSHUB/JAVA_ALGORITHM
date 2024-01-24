package Graph_Theory;

/*
commented by ChatGPT
This Java code is designed to solve a problem where students are to be divided into teams based on their choices. 
Each student chooses one other student they want to be in a team with. The code calculates the number of students who cannot be part of any team.

dfs(int idx) function: A depth-first search function to explore team formations.

Marks the current student (idx) as visited.
Recursively calls itself for the chosen student of the current student (nidx).
If the chosen student has been visited but not part of a loop, increments out (the count of students not in any team) for the current student and all students in the chain leading to a loop.
Marks the current student as part of a loop to prevent reprocessing.
search() function: Calls dfs for each student and returns the total count of students not in any team.

main method: Processes multiple test cases (T).

Reads n (number of students) and their choices.
Initializes arrays visited and loop for each test case.
Computes and writes the number of students not in any team for each test case.
The program's logic revolves around identifying loops in choices (indicating a team) and counting students not part of these loops.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q9466_Term_G3 {

	static int n; // Number of students
	static int out; // Count of students not in any team
	static int[] choice = new int[100001]; // Student choices
	static Boolean[] visited = new Boolean[100001]; // Visited status of each student
	static Boolean[] loop = new Boolean[100001]; // Whether a student is part of a loop (team)

// Depth-first search function to explore team formations
	static void dfs(int idx) {
		if (visited[idx])
			return; // If already visited, return
		visited[idx] = true;
		int nidx = choice[idx]; // Next student in choice

		if (!visited[nidx])
			dfs(nidx); // Visit next student if not visited

		// If next student visited but not in a loop, count all students in this chain
		if (visited[nidx] && !loop[nidx]) {
			out++; // Current student not in any team
			for (int i = nidx; i != idx; i = choice[i])
				out++; // Count students in the chain
		}

		loop[idx] = true; // Mark current student as part of a loop
	}

// Search for students not in any team
	static int search() {
		for (int i = 1; i <= n; i++) {
			dfs(i); // Apply DFS on each student
		}
		return out; // Return count of students not in any team
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T; // Number of test cases
		T = Integer.parseInt(br.readLine());

		for (int cs = 0; cs < T; cs++) {
			n = Integer.parseInt(br.readLine()); // Number of students in the test case
			out = 0; // Reset out for each test case
			Arrays.fill(loop, false); // Reset loop status
			Arrays.fill(visited, false); // Reset visited status
			String[] inp = br.readLine().split(" "); // Read student choices
			for (int i = 1; i <= n; i++) {
				choice[i] = Integer.parseInt(inp[i - 1]);
			}
			bw.write(n - search() + "\n"); // Write the number of students not in any team
		}

		bw.flush();
		bw.close();
	}
}