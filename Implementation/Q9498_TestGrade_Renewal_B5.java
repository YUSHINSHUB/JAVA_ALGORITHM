package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q9498_TestGrade_Renewal_B5{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int grade = Integer.parseInt(br.readLine());
		
		switch( (int) grade / 10 ){		// grade / 10�� ���� int ���·� ĳ�����Ͽ� �Ҽ����� ����
		case 10: ;   					// switch-case����  ���ǿ� ������ �� break�� �ɸ��� ������
		case 9: bw.write("A"); break;	// �Ʒ��� �ִ� code�� ��� �����Ų��.
		case 8: bw.write("B"); break;
		case 7: bw.write("C"); break;
		case 6: bw.write("D"); break;
		default: bw.write("F"); break;
		}
		
		bw.flush();
		bw.close();

}
}
