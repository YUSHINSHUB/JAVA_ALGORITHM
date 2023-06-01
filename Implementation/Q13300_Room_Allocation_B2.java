package Implementation;

import java.io.*;
import java.util.*;

public class Q13300_Room_Allocation_B2 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int a, b;
		int res = 0;
		int room[] = new int[12]; //각 학년 각 성별의 인원수
		
		for( int i = 0 ; i < n ; i++ ) {
			stk = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			room[ ( (b-1) * 2 ) + a ]++;
		}
		
		for( int i = 0 ; i < 12 ; i++ ) {
			res += room[i] / k;
			if( room[i] % k != 0 ) res++;
		}
		
		bw.write(res + "");
		
		bw.flush();
		bw.close();
		
	}
}
