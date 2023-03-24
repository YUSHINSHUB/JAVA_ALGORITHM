package Implementation;

import java.io.*;
import java.math.*;

public class Q14935_FA_B4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String s1 = "";
		s1 += s.charAt(0);
		//Integer.parseInt�� �Ű������� charŸ���� �� �� ���� ������ �� ���ڿ� s1�� s�� ù�ڸ� ���� ����ش�.
		
		int fa = s.length() * Integer.parseInt(s1);
		
		while( fa / 10 != 0 ) {
			fa = ( fa / 10 ) * (int)(Math.log10(fa) + 1);
			//logx(a)�� x�� a�� ǥ���Ϸ��� �������� �ؾ��ϴ����� ��ȯ�Ѵ�. x�� 10�ϰ�� 10�� n�����̱� ������
			// 1�� ���ϰ� int������ ġȯ�Ͽ� 1�� ���ϸ� a�� �ڸ����� ���´�.
			// https://namu.wiki/w/%EB%A1%9C%EA%B7%B8%ED%95%A8%EC%88%98 ������Ű ����
		}
		
		if( fa / 10 == 0 ) {
			bw.write("FA");
		}else {
			bw.write("NFA");
		}
		
		bw.flush();
		bw.close();

	}

}
