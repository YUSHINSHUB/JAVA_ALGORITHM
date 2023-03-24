package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q9498_TestGrade_B5{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int grade = Integer.parseInt(br.readLine());
		
		//if ���ǹ��� ����ϴ� ���� �⺻���� ���
		if( grade >= 90 & grade <= 100) {
			//�������ڿ��� ���� &&, & (AND������), ���� ||, | (OR������)
			// ��Ÿ�� ���� ^ (���� �ٸ����� ��� true), ������ ! (NOT������)�� �ִ�.
			bw.write("A");
		} else if( grade >= 80 && grade < 90) {
			bw.write("B");
		} else if( grade >= 70 && grade < 80) {
			bw.write("C");
		} else if( grade >= 60 && grade < 70) {
			bw.write("D");
		} else {
			bw.write("F");
		}
		
		bw.flush();
		bw.close();

}
}
