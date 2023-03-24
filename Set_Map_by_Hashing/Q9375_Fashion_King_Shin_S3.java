package Set_Map_by_Hashing;

import java.io.*;
import java.util.*;

public class Q9375_Fashion_King_Shin_S3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int res = 1;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for( int i = 0 ; i < t ; i++ ) {
			int c = Integer.parseInt(br.readLine());
			res = 1;
			hm.clear();
			//hashmap 비우기
			for( int z = 0 ; z < c ; z++ ) {
				String inp[] = br.readLine().split(" ");
				hm.put(inp[1], hm.getOrDefault(inp[1], 0)+1 );
				// 해당 옷의 종류를 key로 갖는 value가 있을 경우 1을 더해주고 없을경우 default 0에 1을 더하여 1을 넣어준다.
			}
			
			for( int temp : hm.values() ) {
				res *= temp + 1;
			}
			
			res--;
			//아무것도 입지 않는 한가지 경우를 제외해야 하므로 1을 뺸다.
			bw.write(res + "\n");
			
		}
		
		
		bw.flush();
		bw.close();
	}
}
