package Euclidean_Algorithm;
//참고자료 1 https://st-lab.tistory.com/155
//참고자료 2 https://blog.naver.com/PostView.naver?blogId=eandimath&logNo=221704180761
import java.io.*;
import java.math.*;
import java.util.*;

public class Q2981_Inspection_G4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int cards[] = new int[n];
		int nums[] = new int[n-1];
		
		for( int i = 0 ; i < n ; i++ ) {
			cards[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(cards);
		
		for( int i = 1 ; i < n ; i++ ) {
			nums[i-1] = cards[i] - cards[i-1];
		}
		
		// A, B, C가 있다. A = Ma + r, B = Mb + r일 떄 A와 B의 M과 r이 일치해야 하므로 
		// A - B = M(a-b)가 된다. A, B를 각각 M으로 나눈 몫인 a, b는 몇이든 상관이 없으므로 M은 A-B의 약수가 된다는 것에 집중한다.
		// 같은 논리로 M은 B-C의 약수도 된다. 즉 A-B. B-C의 공약수라는 뜻이며 최대공약수의 약수라는 것과 같은 말이 된다.
		// 6, 34, 38을 대입해 보면 28, 4의 최대 공약수인 4의 약수가 답이므로 2, 4라는 결과가 도출된다.
		
		Arrays.sort(nums);
		
		boolean out = true;
		
		int gdc = 0;
		
			for( int j = nums[0] ; j >= 0 ; j-- ) {
				out = true;
				for( int i = 0 ; i < n-1 ; i++ ) {
					if( nums[i] % j != 0 ) {
						out = false;
						break;
					}
			}
				if(out) {
					gdc = j;
					break;
				}
			}
			
			for( int i = 2 ; i < Math.sqrt(gdc) ; i++ ) {
				if( gdc % i == 0 ) bw.write(i + " ");
			}
			
			for( int i = (int)Math.sqrt(gdc) ; i >= 1 ; i-- ) {
				 if( gdc % i == 0 ) bw.write(gdc / i + " ");
			}
			
			//위의 방법으로 약수찾는 반복회수를 극단적으로 줄일 수 있다.
			
		bw.flush();
		bw.close();
		
		}
}
