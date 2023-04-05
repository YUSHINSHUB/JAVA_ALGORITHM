package Data_Structures;

import java.io.*;
import java.util.*;

public class Q1927_Minimum_Heap_S2 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			temp = Integer.parseInt(br.readLine());
			if( temp == 0 && !pq.isEmpty() ) {
				bw.write(pq.poll() + "\n");
			}else if( temp == 0 && pq.isEmpty() ){
				bw.write("0\n");
			}else {
				pq.add(temp);
			}
			
		}
		
		bw.flush();
		bw.close();

	}
	}