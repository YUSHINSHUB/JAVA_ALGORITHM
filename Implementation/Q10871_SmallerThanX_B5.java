package Implementation;

import java.io.*;
import java.util.Arrays;

public class Q10871_SmallerThanX_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int x = Integer.parseInt(str[1]);
		
		String[] arr = br.readLine().split(" ");
		int[] out = new int[n];
		
		int leng = 0;
		for( int a = 0 ; a < n ; a++ ) {
			if( Integer.parseInt(arr[a]) < x ) {
				out[leng] = Integer.parseInt(arr[a]);
				leng++;
			}
		}
		
		out = Arrays.copyOf(out, leng);
		//�迭�� ������ �� ���� �޼ҵ� Arrays.copyOf( ������ �迭, �����ϰ� ���� ��ҵ��� ���� )�� ����Ͽ� out�� ���̸�
		//�����ߴ�.
		
		for(int a = 0 ; a < leng ; a++) {
			bw.write(out[a] + " ");
		}
		
		bw.flush();
		bw.close();
		
	}

}
