package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2579_Climb_Stairs_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] stair = new int[n];
		int[] max = new int[n];
		
		for( int i = 0 ; i < n ; i++ ) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		max[0] = stair[0];
		
		if( n > 1 ) {
			max[1] = stair[1] + stair[0];
		}
		
		if( n > 2 ) {
			max[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
		}
		
		if( n > 3 ) {
			for( int i = 3 ; i < n ; i++ ) {
				max[i] = Math.max(max[i-3] + stair[i-1] + stair[i], max[i-2] + stair[i] );
			}
		}
		
		bw.write(String.valueOf(max[n-1]));
		
		bw.flush();
		bw.close();
	}
}