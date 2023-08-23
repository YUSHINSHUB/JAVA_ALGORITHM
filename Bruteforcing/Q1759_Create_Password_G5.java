package Bruteforcing;

//Commented by ChatGPT
//This program generates and prints all possible passwords of given length from given characters, with the condition 
//that they must contain at least one vowel and at least two consonants.

import java.io.*;
import java.util.*;

public class Q1759_Create_Password_G5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the first line to get the length of password (l) and number of
		// characters (c)
		String inp[] = br.readLine().split(" ");
		int l = Integer.parseInt(inp[0]);
		int c = Integer.parseInt(inp[1]);

		// Read and process the given characters
		String ialp[] = br.readLine().split(" ");
		char alp[] = new char[c];

		// Convert input string array to character array
		for (int i = 0; i < c; i++) {
			alp[i] = ialp[i].charAt(0);
		}

		// Array to keep track of current password combination
		int cnt[] = new int[l];
		for (int i = 0; i < l; i++) {
			cnt[i] = i;
		}

		// Sort the characters alphabetically
		Arrays.sort(alp);

		Boolean end = false;

		// Define an array of vowels
		char chk[] = { 'a', 'e', 'i', 'o', 'u' };
		Boolean pass = true;

		int c1 = 0, c2 = 0;

		// Loop to generate passwords
		while (true) {
			c1 = 0;
			c2 = 0;

			// Count the number of vowels and consonants in current combination
			for (int i = 0; i < l; i++) {
				if (alp[cnt[i]] == 'a' || alp[cnt[i]] == 'e' || alp[cnt[i]] == 'i' || alp[cnt[i]] == 'o'
						|| alp[cnt[i]] == 'u') {
					c1++;
				} else {
					c2++;
				}
			}

			// Check the condition of having at least 1 vowel and 2 consonants
			if (c1 >= 1 && c2 >= 2) {
				pass = false;
				// If password is valid, write to output
				for (int i = 0; i < l; i++) {
					bw.write(Character.toString(alp[cnt[i]]));
				}
				bw.write("\n");
			}

			pass = true;

			// Move to the next possible password combination
			cnt[l - 1]++;

			// Handle the overflow by carrying over to the previous digits
			if (cnt[l - 1] >= c) {
				cnt[l - 1]--;
				int temp = l - 2;
				while (cnt[temp] == cnt[temp + 1] - 1) {
					temp--;
					if (temp == -1) {
						end = true;
						break;
					}
				}
				if (end == false) {
					cnt[temp]++;
					for (int i = temp + 1; i < l; i++)
						cnt[i] = cnt[i - 1] + 1;
				} else {
					break;
				}
			}
		}

		// Flush and close the BufferedWriter
		bw.flush();
		bw.close();
	}
}
