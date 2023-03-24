package Dynamic_Programming;

import java.io.*;
import java.math.*;

public class Q1003_Fibonacci_Method_S3 {
	
	int zindex;
	int oindex;
	
	public Q1003_Fibonacci_Method_S3 (int zindex, int oindex) {
		this.zindex = zindex;
		this.oindex = oindex;
		//클래스의 생성자. 메소드의 매개변수로 클래스의 객체를 사용하면 해당 객체의 멤버를 call by reference 형태로 사용할 수 있다.
		// call by reference: call by value는 매개변수의 값만 복사해서 쓰지만 call by reference는 해당 매개변수를 직접 참조(reference)
		// 하여 메소드 내에서 값이 변할 경우 원본의 값도 함께 변한다.
	}
	
	public static int fibonacci(int n, Q1003_Fibonacci_Method_S3 a) {
		int temp = 0;
	    if (n == 0) {
	    	a.zindex++;
	        return 0;
	    } else if (n == 1) {
	    	a.oindex++;
	        return 1;
	    } else {
	    	a.oindex = 1;
	        for( int i = 1 ; i < n ; i++ ) {
	        	temp = a.zindex + a.oindex;
	        	a.zindex = a.oindex;
	        	a.oindex = temp;
	        }
	        // n이 2 이상일 때 n-1번째 피보나치 수와 n번쨰 피보나치 수를 구하는 알고리즘.
	        return 0;
	    }
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for( int i = 0 ; i < t ; i++ ) {
			Q1003_Fibonacci_Method_S3 a = new Q1003_Fibonacci_Method_S3(0, 0);
			int n = Integer.parseInt(br.readLine());
			int z = fibonacci(n, a);
			bw.write(String.valueOf(a.zindex) + " " + String.valueOf(a.oindex) + "\n");
		}
		
		
		
		bw.flush();
		bw.close();

	}

}
