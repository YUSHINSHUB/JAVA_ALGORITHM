package Data_Structures;

//Commented by ChatGPT
//Summary: This Java program reads an input of key-value pairs, stores them in a HashMap, and then looks up and outputs the values for a specified set of keys.

import java.io.*;
import java.util.*;

public class Q17219_Find_Password_S4 {

	public static void main(String[] args) throws IOException {
		// Set up buffered readers and writers for input and output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the input for the number of key-value pairs (n) and the number of keys
		// to look up (m)
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]); // Number of key-value pairs
		int m = Integer.parseInt(inp[1]); // Number of keys to look up

		// Initialize a HashMap to store the key-value pairs
		HashMap<String, String> hm = new HashMap<>();

		// Read the key-value pairs and store them in the HashMap
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" "); // Read the next key-value pair
			hm.put(inp[0], inp[1]); // Store the key-value pair in the HashMap
		}

		// Look up the values for the specified keys and write them to the output
		for (int i = 0; i < m; i++) {
			bw.write(hm.get(br.readLine()) + "\n"); // Look up the value for the key and write it to the output
		}

		// Flush and close the output writer
		bw.flush();
		bw.close();
	}
}
