package Bruteforcing;

import java.io.*;
import java.util.*;


public class Q3085_Candy_Game_S2 {
	
	public char bo[][];

	Q3085_Candy_Game_S2(char bo[][] ){
		this.bo = bo;
	}
	
	
	static void swap( Q3085_Candy_Game_S2 at , int a, int b ) {
		char temp = at.bo[a][b];
		at.bo[a][b] = at.bo[a][b+1];
		at.bo[a][b+1] = temp;;
	}
	
	static void swapy( Q3085_Candy_Game_S2 at , int a, int b ) {
		char temp = at.bo[a][b];
		at.bo[a][b] = at.bo[a+1][b];
		at.bo[a+1][b] = temp;
	}
	
	static int chk( Q3085_Candy_Game_S2 a, int n, int max ) {
		//해당 문제는 해가 있을 것으로 예상되는 영역을 모두 탐색하는 브루트포스 알고리즘을 사용해야 한다.
		// 사탕의 위치를 바꿀 수 있는것은 모두 바꿔보고 모든 경우의 해를 구하여 그중 최댓값을 도출한다.
		int cnt = 1;
		
		for( int i = 0 ; i < n ; i++ ) {
			for( int z = 1 ; z < n ; z++ ) {
				if( a.bo[i][z] == a.bo[i][z-1] ) {
					cnt++;
					max = Math.max(cnt, max);
				}else {
					cnt = 1;
				}
			}
			cnt = 1;
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			for( int z = 1 ; z < n ; z++ ) {
				if( a.bo[z][i] == a.bo[z-1][i] ) {
					cnt++;
					max = Math.max(cnt, max);
				}else {
					cnt = 1;
				}
			}
			cnt = 1;
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int max = 1;
		char tbo[][] = new char[n][n];
		
		
		for( int i = 0 ; i < n ; i++ ) {
			String temp = br.readLine();
			for (int z = 0 ; z < n ; z++ ) {
				tbo[i][z] = temp.charAt(z);
			}
		}
		
		Q3085_Candy_Game_S2 a = new Q3085_Candy_Game_S2(tbo);
		
		max = chk(a, n, max);
		
		for( int i = 0 ; i < n ; i++ ) {
			for( int z = 0 ; z < n-1 ; z++ ) {
				if( a.bo[i][z] != a.bo[i][z+1] ) {
					swap(a, i, z);
					max = chk(a, n, max);
					swap(a, i, z);
				}
			}
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			for( int z = 0 ; z < n-1 ; z++ ) {
				if( a.bo[z][i] != a.bo[z+1][i] ) {
					swapy(a, z, i);
					max = chk(a, n, max);
					swapy(a, z, i);
				}
			}
		}
		
		bw.write(String.valueOf(max));
		
		bw.flush();
		bw.close();
		
	}
}
