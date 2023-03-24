package String;

import java.io.*;

public class Q17202_Compatibility_by_Phone_Number_B1 {
	
	static String dp[] = new String[100];
	
	public static String recur(String n) {
		String res = "";
		while( n.length() != 2 ) {
			res = "";
			for( int i = 0 ; i < n.length()-1 ; i++ ) {
				int temp = (n.charAt(i) - 48) * 10 + (n.charAt(i+1) - 48);
				if( dp[temp] == null ) dp[temp] = String.valueOf( ( (temp / 10) + (temp % 10) ) % 10 );
				//7과 0의 조합일 경우 dp[70]에 결과값인 7을 넣어준 후 나중에 7, 0의 조합이 다시 필요해진다면 다시 연산하지 않고 저장된 값을 가져온다.
				//이와 같은 방식을 메모이제이션(memoization)이라고 한다.
				res += dp[temp];
			}
			n = res;
		}
		return res;
		}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();
		String c = "";
		
		for( int i = 0 ; i < 8 ; i++ ) {
			c += a.charAt(i);
			c += b.charAt(i);
		}
		
		c = recur(c);
		
		bw.write(c);
		
		bw.flush();
		bw.close();
	}
}
