package Stack;

import java.io.*;
import java.util.*;


public class Q17298_NGE_G4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String in[] = br.readLine().split(" ");
		int num[] = new int[n];
		
		Stack stk = new Stack<Integer>();
		
		for( int i = 0 ; i < n ; i++ ) {
			num[i] = Integer.parseInt(in[i]);
		}
		
		int cnt = 1;
		
		while(true) {
			if( stk.isEmpty() ) {
				stk.push(cnt);
				cnt++;
				if( cnt > n ) {
					break;
				}
			}else {
				if( num[(int)(stk.peek())-1] < num[cnt-1] ) {
					num[(int)stk.pop()-1] = num[cnt-1];
				}else {
					stk.push(cnt);
					cnt++;
					if( cnt > n ) {
						break;
					}
				}
			}
		}
		
		//수열의 요소가 스택에 쌓여있는 요소보다 클 때까지 수열의 index를 스택에 쌓아준다.
		// 수열의 요소가 스택에 쌓여있는요소보다 클 경우 스택의 요소가 더 클 때까지 스택을 pop 해주면서 pop한 index의 수열 값을 
		// 해당 우큰수로 바꿔준다. 
		
		while( !stk.isEmpty() ) {
			num[(int)stk.pop()-1] = -1;
		}
		
		//마지막까지 스택에 남아있는 index의 요소들은 우측에 더 큰수가 없음을 의미하므로 -1을 대입해준다.
		
		for( int i = 0 ; i < n ; i++ ) {
			bw.write(String.valueOf(num[i]) + " ");
		}
		
		bw.flush();
        bw.close();

	
}
}
