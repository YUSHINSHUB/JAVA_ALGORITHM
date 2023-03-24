package Set_Map_by_Hashing;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q11478_Number_of_Substring_S3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in = br.readLine();
		
		HashSet<String> hset = new HashSet<String>();
		
		for( int i = 0 ; i < in.length() ; i++ ) {
			String temp = "";
			for( int j = i ; j < in.length() ; j++ ) {
				temp += in.charAt(j);
				hset.add(temp);
			}
		}
		//위와 같은 재귀 알고리즘으로 모든 부분문자열을 서치할 수 있다.
		// HashSet은 중복된 값을 갖지 않는다는 성질을 이용하여 중복되지 않은 값만 담아줄 수 있다.
		
		bw.write(hset.size() + "");
		
//		int cnt = 0;
//		Stack<String> stk = new Stack<String>();
//		
//		for( int i = 0 ; i < in.length() ; i++ ) {
//			cnt++;
//			for( int z = 0 ; z < in.length()-i ; z++ ) {
//				stk.push(in.substring(z, z+cnt));
//			}
//		}
//		String s[] = new String[cnt*cnt];
//		cnt = 0;
//		
//		while( !stk.isEmpty() ) {
//			s[cnt] = stk.pop();
//			cnt++;
//		}
//		
//		HashSet<String> set = new HashSet<String>(Arrays.asList(s));
//		s = set.toArray(new String[0]);
		
		//bw.write(String.valueOf(s.length-1));
		//주석처리된 방식은 java에서는 통하지만 C++에서는 시간초과가 난다.
		bw.flush();
		bw.close();
	}
}
