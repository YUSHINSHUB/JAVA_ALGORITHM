package Priority_Queue;
import java.io.*;
import java.util.*;

public class Q11920_BubbleSort_P3 {

	public static void main(String[] args) throws IOException {
		// 버블정렬 방식은 배열의 요소가 몇개든 두개씩 비교하여 정렬하기 떄문에 효율이 매우 떨어진다.
		//그러므로 우선순위 큐를 활용해 버블정렬 중간단계의 배열을 구해볼 것이다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1[] = br.readLine().split(" ");
		int[] nums = new int[2];
		
		nums[0] = Integer.parseInt(s1[0]);
		nums[1] = Integer.parseInt(s1[1]);
		
		String s2 = br.readLine();
		StringTokenizer stk = new StringTokenizer(s2, " ");
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		// 기존의 큐는 선입선출 (FIFO)의 원칙을 가지고 있어 먼저 들어온 값이 먼저 나가지만 
		// 우선순위 큐는 기본적으로 작은 수에 우선순위가 생겨 먼저 나가게 된다.
		
		for( int i = 0 ; i < nums[0]; i++ ) {
			q.offer(Integer.parseInt(stk.nextToken()));
			
			if( i >= nums[1] ) {
				bw.write(q.poll() + " ");
			}
			// 배열의 요소를 K+1개씩 큐에 쌓고 우선순위 큐의 성질을 이용하여 가장 작은값부터 내보내서 출력해주면
			// 버블정렬을 K번 수행했을 떄의 배열을 구할 수 있다.
			
		}
		
		while(!q.isEmpty()) {
			bw.write(q.poll() + " ");
		}
		//연산을 마친 후 큐에는 배열에서 K번쨰로 큰 수까지 남게된다. 이를 모두 내보내주면 된다.
		
		bw.flush();
		bw.close();
	}
}