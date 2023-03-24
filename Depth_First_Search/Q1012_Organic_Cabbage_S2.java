package Depth_First_Search;

import java.io.*;
import java.util.*;

public class Q1012_Organic_Cabbage_S2 {

	protected static Boolean pos[][];
	protected static Boolean visited[][];
	protected static int xpos[] = {1, -1, 0, 0};
	protected static int ypos[] = {0, 0, 1, -1};
	protected static int m, n;
	
	protected static void dfs(int y, int x) {
		int xp, yp;
		for( int i = 0 ; i < 4 ; i++ ) {
			xp = x + xpos[i];
			yp = y + ypos[i];
			if( xp >= 0 && xp < m && yp >= 0 && yp < n ) {
				if( pos[yp][xp] && !visited[yp][xp]) {
					visited[yp][xp] = true;
					dfs(yp, xp);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine());
		int k;
		String inp[] = new String[3];
		int x, y, res;
		
		for( int i = 0 ; i < t ; i++ ) {
			res = 0;
			inp = br.readLine().split(" ");
			m = Integer.parseInt(inp[0]);
			n = Integer.parseInt(inp[1]);
			k = Integer.parseInt(inp[2]);
			pos = new Boolean[n][m];
			visited = new Boolean[n][m];
			
			for( int j = 0 ; j < n ; j++ ) {
				Arrays.fill(pos[j], false);
				Arrays.fill(visited[j], false);
			}
			for( int j = 0 ; j < k ; j++ ) {
				inp = br.readLine().split(" ");
				x = Integer.parseInt(inp[0]);
				y = Integer.parseInt(inp[1]);
				pos[y][x] = true;
			}
			
			for( int j = 0 ; j < n ; j++ ) {
				for( int l = 0 ; l < m ; l++ ) {
					if( pos[j][l] && !visited[j][l] ) {
						visited[j][l] = true;
						dfs(j, l);
						res++;
					}
				}
			}
			
			bw.write(res + "\n");
		}
		
		bw.flush();
		bw.close();
		
		}
}
