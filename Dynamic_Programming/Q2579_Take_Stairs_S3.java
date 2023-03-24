package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2579_Take_Stairs_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//DP란 하나의 문제를 단 한번만 풀도록 하는 알고리즘이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] stair = new int[n];
		int[] max = new int[n];
		
		for( int i = 0 ; i < n ; i++ ) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		max[0] = stair[0];
		
		if( n > 1 ) {
			max[1] = stair[1] + stair[0];
		}
		
		if( n > 2 ) {
			max[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
		}
		
		if( n > 3 ) {
			for( int i = 3 ; i < n ; i++ ) {
				max[i] = Math.max(max[i-3] + stair[i-1] + stair[i], max[i-2] + stair[i] );
			}
		}
		
		//DP는 두가지 가정하에 사용된다. 첫번쨰, 큰 문제를 작은 문제로 나눈다. 해당 문제에서는 n번째 계단까지 오를때의 최대 점수를 구하는 큰 문제를
		// i번째 계단까지의 최대점을 구하는 작은 문제로 나누었다.
		//두번째, 작은 문제에서 구한 정답은 이를 포함하는 큰 문제에서도 동일하다. 이 때 메모이제이션(Memoization)이 사용된다는 점에서
		// DP와 일반적인 분할정복 방식의 차이가 나타난다. 메모이제이션은 계산의 결과를 배열에 저장함으로써 나중에 동일한 계산이 필요할 떄에는
		// 다시 계산하지 않고 배열의 저장값을 불러와 효율을 개선하는 방식이다.
		// 해당 코드에서는 max[i]에 i번쨰 계단까지의 최대점수를 저장하였다.
		
		bw.write(String.valueOf(max[n-1]));
		
		bw.flush();
		bw.close();
	}
}
