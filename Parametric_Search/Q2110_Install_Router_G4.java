package Parametric_Search;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2110_Install_Router_G4 {
	
	static int home[];
	
	protected static int get(int dist) {
		
		int cur = 0;
		int temp = 1;
		
		for( int i = 1 ; i < home.length ; i++ ) {
			if( home[i] - home[cur] >= dist ) {
				cur = i;
				temp++;
			}
		}
		
		return temp;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String inp[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(inp[0]);
		int c = Integer.parseInt(inp[1]);
		home = new int[n];
		
		for( int i = 0 ; i < n ; i++ ) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		
		int lo = 1; // 공유기 사이 최소거리의 최소값은 1로 잡는다.
		int hi = home[n-1] - home[0] + 1; // 공유기 사이 최소거리의 최댓값 
		int md = (lo + hi) / 2; // 공유기 사이 최소거리의 중간값
		
		while( true ) {
			
			if( get(md) < c ) {
				//md만큼 거리를 최소거리로 두었을 때 공유기를 설치할 수 있는 집의 수가 c보다 적을 경우 거리를 줄여서 설치 가능한 집의 수를 늘려야 한다.
				hi = md;
				md = (hi+lo)/2;
			}else {
				lo = md+1;
				md = (hi+lo)/2;
			}
			
			if( lo == hi ) break;
			
		}
		
		bw.write( (lo-1) + "");
		
		bw.flush();
		bw.close();
		
		}
}
