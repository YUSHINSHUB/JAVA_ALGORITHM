package Recursion;

/*
commented by ChatGPT
This Java code is an implementation of the Quadtree algorithm, which is used to compress a binary image (represented as a 2D grid). 
The algorithm recursively divides the image into four equal quadrants until each quadrant contains cells of the same value (either 0 or 1). 
The recur function performs this recursive division, checking if all cells in the current quadrant have the same value. 
If they do, it returns the value (0 or 1). 
If not, it divides the quadrant into four smaller quadrants and repeats the process. 
The result is a string that represents the compressed form of the image, where each set of four quadrants is enclosed in parentheses. 
The main function reads the image size and its data, and then it uses the recur function to compress the image.
이 Java 코드는 이진 이미지(2D 그리드로 표현됨)를 압축하는 데 사용되는 쿼드트리 알고리즘의 구현입니다. 
알고리즘은 각 사분면이 동일한 값을 갖는 셀(0 또는 1)로만 구성될 때까지 이미지를 네 개의 동일한 사분면으로 재귀적으로 나눕니다. 
recur 함수는 이 재귀적 분할을 수행하며, 현재 사분면의 모든 셀이 동일한 값을 가지고 있는지 확인합니다. 
그렇다면 해당 값을(0 또는 1) 반환합니다. 그렇지 않다면, 사분면을 네 개의 더 작은 사분면으로 나누고 과정을 반복합니다. 
결과는 이미지의 압축된 형태를 나타내는 문자열이며, 각 사분면 세트는 괄호 안에 묶여 있습니다. 
main 함수는 이미지의 크기와 데이터를 읽고, recur 함수를 사용하여 이미지를 압축합니다.
*/

import java.io.*;
import java.util.*;

public class Q1992_Quad_S1 {

	static int grid[][]; // 2D array to store the binary image (이진 이미지를 저장하는 2D 배열)

// Recursive function to perform Quadtree compression (쿼드트리 압축을 수행하는 재귀 함수)
	static String recur(int idx, int y, int x) {
		String res = ""; // String to store the result (결과를 저장할 문자열)
		int sym; // Variable to check if all cells in the quadrant have the same value (사분면의 모든
					// 셀이 동일한 값을 갖는지 확인하는 변수)
		if (grid[y][x] == 0)
			sym = 0;
		else
			sym = 1;

		// Check if all cells in the quadrant have the same value (사분면의 모든 셀이 동일한 값을 갖는지
		// 확인)
		for (int i = y; i < y + idx; i++) {
			for (int j = x; j < x + idx; j++) {
				if (grid[i][j] != sym) {
					sym = -1;
					break;
				}
			}
			if (sym < 0)
				break;
		}

		// If all cells have the same value, return the value; otherwise, divide and
		// recurse (모든 셀이 동일한 값을 갖으면 값을 반환하고, 그렇지 않으면 나누고 재귀)
		if (sym >= 0) {
			res += sym;
		} else {
			idx /= 2;
			res += "(";
			res += recur(idx, y, x);
			res += recur(idx, y, x + idx);
			res += recur(idx, y + idx, x);
			res += recur(idx, y + idx, x + idx);
			res += ")";
		}

		return res; // Return the compressed string (압축된 문자열 반환)
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // Variable for the size of the image (이미지 크기를 위한 변수)

		N = Integer.parseInt(br.readLine()); // Read the size of the image (이미지 크기 읽기)
		grid = new int[N][N]; // Initialize the grid (그리드 초기화)
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = inp.charAt(j) - '0'; // Read and store the image data (이미지 데이터 읽기 및 저장)
			}
		}

		bw.write(recur(N, 0, 0)); // Write the compressed image (압축된 이미지 작성)
		bw.flush();
		bw.close();
	}
}
