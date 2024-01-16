package Recursion;

/*
commented by ChatGPT
This Java code creates a pattern of stars in the form of a fractal, specifically a Sierpinski triangle. 
It uses recursion to divide the triangle into smaller triangles and fill them with stars. 
The base case of the recursion is when the size of the triangle is at its smallest (size 3), at which point the stars are placed in specific positions to form a mini triangle. 
The main function initializes a 2D character array and fills it with spaces. 
It then calls the recursive function to place stars in the array to form the fractal pattern. 
Finally, it prints the pattern using a StringBuilder.
이 Java 코드는 별들을 프랙탈 형태, 구체적으로는 시에르핀스키 삼각형 형태로 만드는 패턴을 생성합니다. 
이 코드는 재귀를 사용하여 삼각형을 더 작은 삼각형으로 나누고 그것들을 별로 채웁니다. 
재귀의 기본 케이스는 삼각형의 크기가 가장 작을 때 (크기 3)로, 이 때 특정 위치에 별들을 배치하여 작은 삼각형을 형성합니다. 
메인 함수는 2차원 문자 배열을 초기화하고 공백으로 채웁니다. 그런 다음 재귀 함수를 호출하여 배열에 별을 배치하여 프랙탈 패턴을 형성합니다. 
마지막으로 StringBuilder를 사용하여 패턴을 출력합니다.
*/

import java.io.*;
import java.util.*;

public class Q2448_Star_11_G4 {

	static char c[][]; // 2D char array to store the star pattern (별 패턴을 저장할 2차원 문자 배열)
	static int N; // The size of the pattern (패턴의 크기)

// Recursive function to create the star pattern
	public static void recur(int y, int x, int idx) {
		if (idx == 3) { // Base case: when the triangle size is 3, place stars to form a small triangle
			c[y][x] = '*';
			c[y + 1][x - 1] = '*';
			c[y + 1][x + 1] = '*';
			c[y + 2][x - 2] = '*';
			c[y + 2][x - 1] = '*';
			c[y + 2][x] = '*';
			c[y + 2][x + 1] = '*';
			c[y + 2][x + 2] = '*';
		} else { // Recursive case: divide the triangle into smaller ones and call the function
					// on each
			int nx = idx / 2;
			recur(y, x, nx); // Top triangle
			recur(y + nx, x - nx, nx); // Bottom left triangle
			recur(y + nx, x + nx, nx); // Bottom right triangle
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder(""); // StringBuilder to construct the pattern string

		N = Integer.parseInt(br.readLine()); // Read the size of the pattern
		c = new char[N][N * 2]; // Initialize the 2D char array with the appropriate size

		for (int i = 0; i < N; i++)
			Arrays.fill(c[i], ' '); // Fill the array with spaces

		recur(0, N - 1, N); // Start the recursive function to create the star pattern

		// Loop through the array and append each character to the StringBuilder
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2; j++)
				sb.append(c[i][j]);
			sb.append("\n"); // Add a newline character at the end of each row
		}

		bw.write(sb.toString()); // Write the string representation of the pattern to the BufferedWriter
		bw.flush(); // Flush the stream to ensure all data is written
		bw.close(); // Close the BufferedWriter
	}
}