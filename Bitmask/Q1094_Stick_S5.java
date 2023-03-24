package Bitmask;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1094_Stick_S5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine()); 
		
		int temp = 0;
		int sum = 64;
		
		int index = 0;
		
		PriorityQueue<Integer> stick = new PriorityQueue<Integer>();
		stick.offer(64);
		
		while(sum > x) {
			temp = stick.poll();
			stick.offer(temp/2);
			stick.offer(temp/2);
			
			if( sum - (temp/2) >= x ) {
				stick.poll();
				sum -= temp/2;
			}	
		}
		
		while( !stick.isEmpty() ) {
			stick.poll();
			index++;
		}
		
		
		
		bw.write(String.valueOf(index));
		
		bw.flush();
		bw.close();
		
	}
}
