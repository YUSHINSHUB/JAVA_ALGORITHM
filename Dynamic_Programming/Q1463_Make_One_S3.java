package Dynamic_Programming;

import java.io.*;
import java.util.*;


public class Q1463_Make_One_S3 {
	
	static int dp[] = new int[1000001];
	static boolean chk[] = new boolean[1000001];
	static int task(int a) {
		
		if( chk[a] == false ) {
			if( a % 6 == 0 ) {
				dp[a] = Math.min(task(a-1), Math.min(task(a / 3), task(a / 2)) ) + 1;
			}else if( a % 3 == 0 ) {
				dp[a] = Math.min(task(a / 3), task(a-1)) + 1;
			}else if( a % 2 == 0 ) {
				dp[a] = Math.min(task(a / 2), task(a-1)) + 1;
			}else {
				dp[a] = task(a-1) + 1;
			}
		}
		
		chk[a] = true;
		return dp[a];
	}
	
	//a가 10일 경우 2로 나누거나 1을 뺴는 선택지가 존재한다. 이때, 2를 나눈 5의 연산횟수와 1을 뺀 9의 연산횟수를 구하여 더 작은쪽을 선택하도록 하면 된다.
	// 이렇게 10의 연산횟수를 구하는 큰 문제를 5, 9의 연산횟수를 구하는 두개의 작은 문제로 나누었다. 또한 체커 (boolean chk[])를 활용하여 이미 연산횟수를
	//구한 수에 해당하는 체커는 true값을 대입하여 같은 연산을 두번 하지 않게 하여 효율을 증가시킨다. 
	// 이러한 방법을 Dynamic Programming (DP) 이라고 한다. 
	// 위와 같이 계산한 값을 메모리에 저장하여 동일한 계산의 반복수행을 제거하는 것을 메모이제이션(memoization)이라고 한다.
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		dp[1] = 0;
		chk[1] = true;
		
		bw.write(String.valueOf(task(n)));
		
		
		bw.flush();
		bw.close();
		
	}
}
