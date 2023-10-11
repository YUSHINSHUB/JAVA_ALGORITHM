package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int n;
	static int pal[];
	static int dp[][];
	static boolean visited[][];
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		pal = new int[n+1];
		dp = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		
		String inp[] = br.readLine().split(" ");
		
		for( int i = 0 ; i < n ; i++ ) {
			pal[i] = Integer.parseInt(inp[i]);
		}
		
		
		
		bw.flush();
		bw.close();

	}
}
