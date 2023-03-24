package Dynamic_Programming;

import java.io.*;
import java.util.*;



public class Q9095_Add_From_One_to_Three_S3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int dp[] = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for( int i = 4 ; i <= 10 ; i++ ) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		//4를 만드는 경우의 수에는 1+3 / 2+2 / 3+1이 있는데 이는 각각 1+1+1+1 / 1+1+2 / 1+2+1 / 1+3, 2+2 / 2+1+1 , 3+1 로 표현이 가능하다.
		//즉, dp[n]은 dp[n-1] + dp[n-2] + dp[n-3]과 같다. 
		//본 문제에서는 n값이 최대 10이기 떄문에 dp[]에 모든 결과값을 모두 넣어주고 시작했지만 n이 커질 경우에는 
		//재귀와 메모이제이션을 활용해야 한다.
		
		int t = Integer.parseInt(br.readLine());
		
		for( int i = 0 ; i < t ; i++ ) {
			int temp = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(dp[temp]) + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
