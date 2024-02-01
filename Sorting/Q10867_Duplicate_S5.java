package Sorting;

/*
commented by ChatGPT
This Java code reads an integer N and a list of N integers, then outputs the list with duplicates removed, maintaining the original order. 
The program uses a BufferedReader to read the inputs efficiently. The list of integers is sorted to group duplicates together.
 It iterates through the sorted list, writing each unique integer to the BufferedWriter and skipping over duplicates. 
 The BufferedWriter is then flushed to ensure all output is written to the console.

이 Java 코드는 정수 N과 N개의 정수 리스트를 읽은 후, 원래의 순서를 유지하며 중복을 제거한 리스트를 출력합니다. 이 프로그램은 BufferedReader를 사용하여 입력을 효율적으로 읽습니다. 
정수 리스트는 중복을 함께 그룹화하기 위해 정렬됩니다. 정렬된 리스트를 순회하면서 각 고유한 정수를 BufferedWriter에 쓰고 중복을 건너뜁니다. 
BufferedWriter는 콘솔에 모든 출력이 작성되도록 flush 됩니다.
*/

import java.io.*;
import java.util.*;

public class Q10867_Duplicate_S5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // Number of integers in the list
		String inp[]; // Array to store input strings
		ArrayList<Integer> list = new ArrayList<>(); // List to store integers

		N = Integer.parseInt(br.readLine()); // Read the number of integers
		inp = br.readLine().split(" "); // Read the integers as strings and split them

		// Parse integers from strings and add them to the list
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(inp[i]));
		Collections.sort(list); // Sort the list to group duplicates together

		// Iterate through the sorted list
		for (int i = 0; i < N; i++) {
			int out = list.get(i); // Current integer
			bw.write(out + " "); // Write the integer to BufferedWriter
			// Skip over duplicates
			while (list.get(i) == out) {
				i++;
				if (i == N)
					break;
			}
			if (i == N)
				break;
			i--; // Adjust index to stay within bounds
		}

		bw.flush(); // Flush the BufferedWriter to ensure output is written
		bw.close(); // Close the BufferedWriter
	}
}
