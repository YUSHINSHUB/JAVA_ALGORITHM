package Depth_First_Search;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2606_Virus_S3 {
	
	static int cnt = 0;
	static int conn[][];
	static int visited[];
	
	protected static void dfs(int s, int c) {
		
		visited[s] = 1;
		cnt++;
		
		for( int i = 0 ; i < c ; i++ ) {
			if( conn[s][i] == 1 && visited[i] != 1 ) dfs(i, c);
			//연결되어 있는 s번 노드에 연결되어 있는 노드가 아직 탐색되지 않았을 경우 dfs를 재귀호출하여 탐색하고 cnt (결과값)을 증가시킨다.
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		visited = new int[c];
		
		conn = new int[c][c];
		String inp[] = new String[2];
		
		for( int i = 0 ; i < c ; i++ ) {
			for( int j = 0 ; j < c ; j++ ) {
				conn[i][j] = 0;
			}
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			inp = br.readLine().split(" ");
			conn[Integer.parseInt(inp[0])-1][Integer.parseInt(inp[1])-1] = 1;
			conn[Integer.parseInt(inp[1])-1][Integer.parseInt(inp[0])-1] = 1;
		}
		
		dfs(0, c);
		
		bw.write( (cnt - 1) + "");
		
		bw.flush();
		bw.close();
		
		}
}
