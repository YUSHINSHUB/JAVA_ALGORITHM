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
		//countTokens �޼ҵ�� ���� ��ū�� ������ ��ȯ���ش�.
		// �̸� for�� ���ǿ� �״�� ���� �ݺ����� ����Ǵ� �������� ��ū�� ������ ���Կ� ���� ������ �ٲ� �� �ֱ� ������
		// �̸� index�� ��Ƶΰ� ����.
		
		int[] num = new int[index];
		
		for( int i = 0 ; i < index ; i++ ) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(num);
		// java.util ��Ű���� arrays Ŭ������ �ִ� sort �޼ҵ带 ����ϸ� �迭�� ��ҵ��� ������������ �������ش�.
		
		//bw.write(Arrays.toString(num));
		// Arrays.toString �޼ҵ带 ����� ��� �迭�� string ���·� ��ȯ���ش�.
		// ����: int�迭�� ��Ұ� 1, 2, 3�� ��� {1, 2, 3}�� ���·� ��ȯ�ȴ�.
		// �ش� ���������� ��������� ���� �ʱ� ������ ������� �ʴ´�.
		
		for( int i = 0 ; i < index ; i++ ) {
			bw.write( String.valueOf(num[i]) + " " );
		}
		
		bw.flush();
		bw.close();
		
	}

}
