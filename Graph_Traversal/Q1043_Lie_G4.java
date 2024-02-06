package Graph_Traversal;

/*
commented by ChatGPT
This Java code aims to determine the number of parties that a person can attend without coming into contact with known truth-tellers. 
It models a scenario where parties are held, and some attendees may know a secret truth. 
The objective is to avoid parties where this truth might be revealed. 
The solution involves tracking attendees who know the truth and iteratively marking party members as truth-knowers if they attend a party with a known truth-knower, thereby filtering out parties that are safe to attend.
이 Java 코드는 알려진 진실을 아는 사람과 접촉하지 않고 참석할 수 있는 파티의 수를 결정하는 것을 목표로 합니다. 일부 참석자가 비밀 진실을 알고 있을 수 있는 파티가 열리는 상황을 모델링합니다. 
목표는 이 진실이 밝혀질 수 있는 파티를 피하는 것입니다. 
해결 방법은 진실을 아는 참석자를 추적하고 알려진 진실을 아는 사람과 파티에 참석하는 경우 파티 멤버를 진실을 아는 사람으로 반복적으로 표시하여 안전하게 참석할 수 있는 파티를 필터링하는 것입니다.
*/

import java.io.*;
import java.util.*;
import java.math.*;

public class Q1043_Lie_G4 {

	static class party {
		ArrayList<Integer> mem = new ArrayList<>(); // List to store party members

		party() { // Constructor for party class

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M; // N: Number of people, M: Number of parties
		Boolean know[] = new Boolean[51]; // Tracks people who know the truth
		String inp[];
		ArrayList<party> plist = new ArrayList<>(); // List of parties

		Arrays.fill(know, false); // Initially, nobody is marked as knowing the truth
		inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]); // Number of people
		M = Integer.parseInt(inp[1]); // Number of parties

		inp = br.readLine().split(" ");
		for (int i = 1; i <= Integer.parseInt(inp[0]); i++) {
			know[Integer.parseInt(inp[i])] = true; // Mark people who initially know the truth
		}

		for (int i = 0; i < M; i++) {
			party p = new party(); // Create a new party instance
			Boolean b = false; // Flag to indicate if any party member knows the truth
			inp = br.readLine().split(" ");
			for (int j = 1; j <= Integer.parseInt(inp[0]); j++) {
				p.mem.add(Integer.parseInt(inp[j])); // Add members to the party
				if (know[Integer.parseInt(inp[j])])
					b = true; // If a member knows the truth, set flag to true
			}
			if (b) { // If any member knows the truth, update the truth knowledge for all members
				for (int j = 1; j <= Integer.parseInt(inp[0]); j++) {
					know[Integer.parseInt(inp[j])] = true;
				}
				M--; // Adjust the count of parties
				i--; // Adjust loop index to account for removed party
			} else {
				plist.add(p); // Add the party to the list if no member initially knows the truth
			}
		}

		// Iterate over parties to further filter out parties with truth-knowers
		for (int i = 0; i < M; i++) {
			party p = plist.get(i);
			Boolean b = false;
			for (int j = 0; j < p.mem.size(); j++) {
				if (know[p.mem.get(j)]) { // Check if any member knows the truth
					b = true;
					break;
				}
			}
			if (b) { // If found, update knowledge and remove the party from consideration
				for (int j = 0; j < p.mem.size(); j++) {
					know[p.mem.get(j)] = true;
				}
				plist.remove(i); // Remove the party
				M--; // Decrement party count
				i = -1; // Reset loop to start from the beginning
				// Note: This resetting process ensures that changes in truth knowledge are
				// accounted for in subsequent iterations
			}
		}

		bw.write(M + ""); // Output the number of parties that can be safely attended
		bw.flush();
		bw.close();
	}
}
