package Sorting;

import java.io.*;
import java.util.*;

public class Q2752_Sort_ThreeNumbers_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String numbers = br.readLine();
		
		StringTokenizer stk = new StringTokenizer(numbers, " ");
		
		int index = stk.countTokens();
		//countTokens 메소드는 남은 토큰의 개수를 반환해준다.
		// 이를 for문 조건에 그대로 쓰면 반복문이 진행되는 과정에서 토큰의 개수가 변함에 따라 조건이 바뀔 수 있기 떄문에
		// 미리 index에 담아두고 쓴다.
		
		int[] num = new int[index];
		
		for( int i = 0 ; i < index ; i++ ) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(num);
		// java.util 패키지의 arrays 클래스에 있는 sort 메소드를 사용하면 배열의 요소들을 오름차순으로 정렬해준다.
		
		//bw.write(Arrays.toString(num));
		// Arrays.toString 메소드를 사용할 경우 배열을 string 형태로 반환해준다.
		// 예시: int배열에 요소가 1, 2, 3일 경우 {1, 2, 3}의 형태로 반환된다.
		// 해당 문제에서는 출력형식이 맞지 않기 떄문에 사용하지 않는다.
		
		for( int i = 0 ; i < index ; i++ ) {
			bw.write( String.valueOf(num[i]) + " " );
		}
		
		bw.flush();
		bw.close();
		
	}

}
