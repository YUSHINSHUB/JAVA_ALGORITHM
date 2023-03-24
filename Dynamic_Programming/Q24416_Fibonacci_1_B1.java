package Dynamic_Programming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Q24416_Fibonacci_1_B1 {
	
	static int cnt1 = 0;
	static int cnt2 = 0;
	
	static int fib(int n) {
	    if (n == 1 || n == 2) {
	    	cnt1++;
	    	return 1;  // 코드1
	    }
	    else return (fib(n - 1) + fib(n - 2));
	}
	//위의 재귀호출을 사용한 메소드에서는 n이 30이라 했을 떄 이를 구하기 위해서 fib(29), fib(28)을 구해야 하고 fib(29)를 위해서 fib(28), fib(27)을 연산하고
	//이것이 반복되면 최종적으로 fib(1)과 fib(2)를 832040 연산하는 매우 비효율적인 결과가 도출된다.
	//다이나믹 프로그래밍은 큰 문제를 작은문제로 나누어서 연산하는 분할정복 기법을 사용할 떄 같은 작은문제는 재연산하지 않도록 값을 저장해 두었다가 재사용하는 기법이다.
	//아래의 메소드가 그 예시이다. 메소드를 반복적으로 호출하지 않고 피보나치 값을 배열의 요소로 저장해 두었다가 바로 사용한다.

	static int fibonacci(int n) {
		int f[] = new int[n+1];
	    f[1] = f[2] = 1;
	    for (int i = 3 ; i <= n ; i++) {
	    	cnt2++;
	        f[i] = f[i - 1] + f[i - 2];  // 코드2
	    }
	    return f[n];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);
		
		bw.write(String.valueOf(cnt1) + " " + String.valueOf(cnt2));
		
		bw.flush();
		bw.close();
}
}
