package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q11070_Pythagorean_Expectation_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		
		for( int i = 0 ; i < t ; i++ ) {
			String nm[] = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int team[][] = new int[n][2];
			
			for( int j = 0 ; j < m ; j++ ) {
				String inp[] = br.readLine().split(" ");
				int a = Integer.parseInt(inp[0]);
				int b = Integer.parseInt(inp[1]);
				int c = Integer.parseInt(inp[2]);
				int d = Integer.parseInt(inp[3]);
				
				team[a-1][0] += c;
				team[a-1][1] += d;
				team[b-1][0] += d;
				team[b-1][1] += c;
			}
			
			double pe[] = new double[n];
			
			for( int j = 0 ; j < n ; j++ ) {
				if( team[j][0] == 0 && team[j][1] == 0 ) pe[j] = 0;
				else pe[j] = (Math.pow(team[j][0], 2)) / (Math.pow(team[j][0], 2) + Math.pow(team[j][1], 2));
			}
			Arrays.sort(pe);
			
			bw.write( (int)(pe[n-1]*1000) + "\n" + (int)(pe[0]*1000) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
