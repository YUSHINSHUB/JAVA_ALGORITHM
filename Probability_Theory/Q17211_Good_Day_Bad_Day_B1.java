package Probability_Theory;

import java.io.*;
import java.util.*;
import java.text.*;

public class Q17211_Good_Day_Bad_Day_B1 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		double gtog = Double.parseDouble(stk.nextToken());
		double gtob = Double.parseDouble(stk.nextToken());
		double btog = Double.parseDouble(stk.nextToken());
		double btob = Double.parseDouble(stk.nextToken());
		
		double gp, bp;
		
		if( d == 0 ) {
			gp = gtog;
			bp = gtob;
		}else {
			gp = btog;
			bp = btob;
		}
		
		double temp;
		for( int i = 1 ; i < n ; i++ ) {
			
			temp = gp;
			gp *= gtog;
			gp += bp * btog;
			
			bp *= btob;
			bp += temp*gtob;
			
		}
		
		bw.write( (int)(gp * 1000) + "\n" + (int)(bp * 1000) );
		
		bw.flush();
		bw.close();
		
	}
}
