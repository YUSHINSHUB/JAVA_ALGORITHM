package Pythagoras_Theorem;

/*
commented by ChatGPT
Summary: The program calculates and outputs two numbers based on three input numbers and a mathematical formula.
The formula involves using the Pythagorean theorem in a slightly modified form.
*/

import java.io.*;

public class Q1297_TV_Size_B2 {

public static void main(String[] args) throws IOException {
	
	// Setting up buffered readers and writers for input and output operations.
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	// Reading a line of input and splitting it based on spaces.
	String str[] = br.readLine().split(" ");
	int inp[] = new int[3];
	
	// Parsing the split strings into integers.
	for (int i = 0; i < 3; i++) {
		inp[i] = Integer.parseInt(str[i]);
	}
	
	// Computing the scaling factor 'index' using a modified Pythagorean theorem.
	Double index = Math.sqrt(Math.pow(inp[0], 2) / (Math.pow(inp[1], 2) + Math.pow(inp[2], 2)));
	
	// Writing the result to the output using the scaling factor.
	bw.write(String.valueOf((int)(index * inp[1])) + " " + String.valueOf((int)(index * inp[2])));
	
	// Flushing and closing the buffered writer.
	bw.flush();
	bw.close();
}
}
