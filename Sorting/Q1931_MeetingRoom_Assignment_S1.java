package Sorting;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1931_MeetingRoom_Assignment_S1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//시작시간이 아무리 빨라도 종료시간이 늦으면 그 사이에 많은 예약을 채울 수 없다.
		//그러므로 종료시간이 빠른순으로 정렬하여 최대한 채우는 것이 하루에 최대개수의 예약을 받는 방법이다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int ca[][] = new int[n][2];
		
		for( int i = 0 ; i < n ; i++ ) {
			String[] c = br.readLine().split(" ");
			ca[i][0] = Integer.parseInt(c[0]);
			ca[i][1] = Integer.parseInt(c[1]);
		}
		
		Arrays.sort(ca, (o1, o2) ->{
			if( o1[1] == o2[1] ) {
				return o1[0] - o2[0];
			}else {
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 1;
		int stime = ca[0][1];
		
		for( int i = 1 ; i < n ; i++ ) {
			if( ca[i][0] >= stime ) {
				stime = ca[i][1];
				cnt++;
			}
			//시작시간은 무조건 종료시간보다 과거이다. 그러므로 종료시간 순으로 정렬되어 있는 ca배열에서 
			//제일 앞에 있는 ca[i]의 종료시간을 무조건 첫 예약으로 잡고 루프를 돌면서 시작시간은 앞 예약의 종료시간 이후이면서도
			//종료시간은 최대한 빠른 예약의 수를 찾는다.
			
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();

	}

}
