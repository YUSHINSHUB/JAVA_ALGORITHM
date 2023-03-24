package Binary_Search;

import java.io.*;
import java.math.*;
import java.util.*;



public class Q10815_Number_Card_S5 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int nc[] = new int[n]; 
		String temp[] = br.readLine().split(" ");
		for( int i = 0 ; i < n ; i++ ) {
			nc[i] = Integer.parseInt(temp[i]);
		}
		int m = Integer.parseInt(br.readLine());
		int mc[] = new int[m];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		temp = br.readLine().split(" ");
		for( int i = 0 ; i < m ; i++ ) {
			mc[i] = Integer.parseInt(temp[i]);
			hm.put(mc[i], i); //각 숫자를 정렬할 것이기 떄문에 원래 위치를 미리 맵에 저장
			res.put(i, 0);    // 결과값. 가지고 있는 카드의 순번에는 1이 들어갈 예정
		}
		
		int cnt = 0;
		
		Arrays.sort(nc);
		Arrays.sort(mc);
		
		for( int i = 0 ; i < n ; i++ ) {
			if( nc[i] == mc[cnt] ) {
				res.put(hm.get(mc[cnt]), 1); //숫자카드의 숫자를 hm의 key값으로 주면 해당 카드의 정렬전 원래 순서를 가져온다. 이 순서를 key로
				cnt++;						 //갖는 결과 맵의 value를 1로 바꿔준다.
			}else if( nc[i] > mc[cnt] ){
				while( nc[i] > mc[cnt]) {
				cnt++;
				if( cnt == m ) break;
				if( mc[cnt] == nc[i] ) {
					res.put(hm.get(mc[cnt]), 1);
					mc[cnt] = 1;
					cnt++;
					break;
				}
				}
			}
			
				if( cnt == m ) break;
				
		}
		
		for( int i = cnt ; i < m ; i++ ) {
			res.put(hm.get(mc[i]), 0);
		}
		
		for( int i = 0 ; i < m ; i++ ) bw.write(res.get(i) + " ");
		
		bw.flush();
		bw.close();
	}
}
