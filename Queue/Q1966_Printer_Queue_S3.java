package Queue;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q1966_Printer_Queue_S3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, m;
		int max = 0;
		int res = 0;
		
		int t = Integer.parseInt(br.readLine());
		
		for( int i = 0 ; i < t ; i++ ) {
			res = 0;
			max = 0;
			LinkedList<Integer> q = new LinkedList<Integer>();
			String nm[] = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			m++;
			int maxcnt = 0;
			
			String in[] = br.readLine().split(" ");

			for( int z = 0 ; z < n ; z++ ) {
				q.offer(Integer.parseInt(in[z]));
				if( max < Integer.parseInt(in[z]) ) {
					max = Integer.parseInt(in[z]);
					maxcnt = 1;
				}else if( max == Integer.parseInt(in[z]) ) {
					maxcnt++;
				}
			}
			
			while( true ) {
				int temp = q.poll();
				if( temp != max ) {
					q.offer(temp);
					m--;
					if( m == 0 ) {
						m = q.size();
					}
				}else {
					maxcnt--;
					m--;
					res++;
					if( m == 0 ) break;
					if( maxcnt == 0 ) {
						max = 0;
						for( int z = 0 ; z < q.size() ; z++ ) {
							int y = q.poll();
							q.offer(y);
							if( max < y ) {
								max = y;
								maxcnt = 1;
							}else if( max == y ) maxcnt++;
						}
					}
				}
			}
			//m이 0에 도달했을 경우 목표 문서에 도달했다는 의미이다. 이떄 poll()해줄 문서가 max값이 아닌 경우
			// 뒤에 아직 더 큰 중요도를 가진 문서가 남아있다는 뜻이기 떄문에 m을 큐의 사이즈만큼 다시 늘려준다.
			// 목표 문서를 poll() 해줄 차례가 되었을 때 max와 문서의 중요도가 일치할 경우 재귀를 멈추고 해당 차례까지의
			// 인쇄한 문서의 수가 결과값이 된다.
			bw.write(String.valueOf(res + "\n"));
		}
		
		
		
		bw.flush();
		bw.close();
	}
}
