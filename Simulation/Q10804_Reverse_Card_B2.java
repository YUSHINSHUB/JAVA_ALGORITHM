package Simulation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q10804_Reverse_Card_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int card[] = new int[20];
		int temp[] = new int[20];
		String inp[] = new String[2];
		int beg, end;
		
		for( int i = 0 ; i < 20 ; i++ ) {
			card[i] = i+1;
		}
		
		for( int i = 0 ; i < 10 ; i++ ) {
			inp = br.readLine().split(" ");
			beg = Integer.parseInt(inp[0]);
			end = Integer.parseInt(inp[1]);
			temp = Arrays.copyOfRange(card, beg-1, end);
			for( int j = 0 ; j < end-beg+1 ; j++ ) {
				card[beg-1+j] = temp[end-beg-j];
			}
		}
		
		for( int i = 0 ; i < 20 ; i++ ) {
			bw.write(card[i] + " ");
		}
		
		bw.flush();
		bw.close();
		
		}
}
