package Arithmetic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q1000_AplusB_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" "); // string Ŭ������ �޼ҵ� split()�� "" ���� string��
												// �������� ��Ƽ� string�� �迭�� �������ش�. �ش� �ڵ忡����
												//������ �������� �����ߴ�. 
		int in[] = new int[str.length];
		int res = 0;
		
		for( int i = 0 ; i < str.length ; i++ ) {
			in[i] = Integer.parseInt(str[i]);
			res = res + in[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();

	}

}
// �ش� �ڵ�� ���� ���� ������ ������ ���ٴ� ������ �ִ�. 

//	�޸�: 15852KB	�ð�: 152ms