package Queue;

import java.io.*;
import java.util.*;

public class Q13335_Truck_S1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String inp[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(inp[0]);
		int w = Integer.parseInt(inp[1]);
		int l = Integer.parseInt(inp[2]);
		int time = 0;
		Queue<Integer> q   = new LinkedList<Integer>(); //지나가야 할 트럭
		Queue<Integer> brg = new LinkedList<Integer>(); //다리위의 상황
		
		inp = br.readLine().split(" ");
		int trc[] = new int[n];
		
		for( int i = 0 ; i < n ; i++ ) q.offer(Integer.parseInt(inp[i]));
		for( int i = 0 ; i < w ; i++ ) brg.offer(0); //트럭이 존재하는 부분은 트럭의 무게로, 그렇지 않은 부분은 0으로 넣는다.
													 //처음에는 다리가 비어있기 떄문에 모두 0이다.
		
		int wei = 0;
		
		while( !brg.isEmpty() ) {
			time++;
			wei -= brg.poll(); 
			if( !q.isEmpty() ) {
				if( wei + q.peek() <= l ) {
					wei += q.peek();
					brg.offer(q.poll());
				}else {
					brg.offer(0);
				}
				//시간이 지날때마다 최대하중을 초과하지 않는다면 새로운 트럭을 다리에 올리고
			}	// 그렇지 않다면 빈공간이 되기 떄문에 0을 올린다.
		}
		
		
		bw.write(time + "");
		
		
		bw.flush();
		bw.close();
	}
}
