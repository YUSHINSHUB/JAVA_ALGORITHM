package Priority_Queue;
import java.io.*;
import java.util.*;

public class Q11920_BubbleSort_P3 {

	public static void main(String[] args) throws IOException {
		// �������� ����� �迭�� ��Ұ� ��� �ΰ��� ���Ͽ� �����ϱ� ������ ȿ���� �ſ� ��������.
		//�׷��Ƿ� �켱���� ť�� Ȱ���� �������� �߰��ܰ��� �迭�� ���غ� ���̴�.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1[] = br.readLine().split(" ");
		int[] nums = new int[2];
		
		nums[0] = Integer.parseInt(s1[0]);
		nums[1] = Integer.parseInt(s1[1]);
		
		String s2 = br.readLine();
		StringTokenizer stk = new StringTokenizer(s2, " ");
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		// ������ ť�� ���Լ��� (FIFO)�� ��Ģ�� ������ �־� ���� ���� ���� ���� �������� 
		// �켱���� ť�� �⺻������ ���� ���� �켱������ ���� ���� ������ �ȴ�.
		
		for( int i = 0 ; i < nums[0]; i++ ) {
			q.offer(Integer.parseInt(stk.nextToken()));
			
			if( i >= nums[1] ) {
				bw.write(q.poll() + " ");
			}
			// �迭�� ��Ҹ� K+1���� ť�� �װ� �켱���� ť�� ������ �̿��Ͽ� ���� ���������� �������� ������ָ�
			// ���������� K�� �������� ���� �迭�� ���� �� �ִ�.
			
		}
		
		while(!q.isEmpty()) {
			bw.write(q.poll() + " ");
		}
		//������ ��ģ �� ť���� �迭���� K������ ū ������ ���Եȴ�. �̸� ��� �������ָ� �ȴ�.
		
		bw.flush();
		bw.close();
	}
}