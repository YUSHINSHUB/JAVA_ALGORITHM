package Greedy;

import java.io.*;
import java.math.*;

public class Q14659_HANJO_B1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		int hil[] = new int[n];
		int res = 0;
		int cnt = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			hil[i] = Integer.parseInt(inp[i]);
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			cnt = 0;
			for( int z = i+1 ; z < n ; z++ ) {
				if( hil[z] > hil[i] ) break;
				else cnt++;
			}
			res = Math.max(res, cnt);
		}
		
		bw.write(res + "");
		
		bw.flush();
		bw.close();
	}
}
