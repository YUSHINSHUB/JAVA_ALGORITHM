package Stack;

import java.io.*;
import java.util.*;

public class Q1874_Stack_Sequence_S3 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//큐(Queue)는 선입선출, Stack은 후입선출이므로 상황에 따라 잘 사용하자.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stk = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		char[] out = new char[n*2];
		int outcnt = 0;
		int cnt = 1;
		int numcnt = 0;
		int stkcnt = 0;
		
		boolean suc = true;
		
		for( int i = 0 ; i < n ; i++ ) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		while( numcnt < n ) {
			
			if( nums[numcnt] >= cnt) {
			while( nums[numcnt] >= cnt ) {
				stk.push(cnt);
				cnt++;
				out[outcnt] = '+';
				outcnt++;
			}
			}else {
				if( stk.isEmpty() ) {
					suc = false;
					break;
				}
				while( stk.peek().intValue() != nums[numcnt] ) {
					//int 말고 Integer형에 직접 == 이나 !=을 사용하여 비교할 경우 두 객체의 주소값이 같은지를 비교하는 것이기 때문에
					// 절대 사용하면 안되는 방식이다. Java에서 미리 만들어둔 객체 범위인 127을 넘어갈 경우 정상적으로 작동하지 않는다.
					//그러므로 Integer형에는 intvalue()를 붙여서 비교하도록 한다.
					stk.pop();
					out[outcnt] = '-';
					outcnt++;
					if( stk.isEmpty() ) {
						suc = false;
						break;
					}
				}
			}
			
			
			
			if( suc == false ){
				break;
			}else if( stk.peek().intValue() == nums[numcnt] ) {
				stk.pop();
				out[outcnt] = '-';
				outcnt++;
			}
			
			numcnt++;
			
		}
		
		if( suc == true ) {
			for( int i = 0 ; i < outcnt ; i++ ) {
				bw.write(out[i] + "\n");
			}
		}else {
			bw.write("NO");
		}
		
		bw.flush();
		bw.close();
		
	}
}
