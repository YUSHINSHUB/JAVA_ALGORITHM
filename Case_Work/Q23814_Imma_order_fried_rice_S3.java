package Case_Work;

import java.io.*;

public class Q23814_Imma_order_fried_rice_S3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//군만두를 받는데 필요한 단위량은 세 메뉴가 모두 같기 때문에 볶음밥의 수가 최소가 되는 경우는 짬뽕, 짜장을 군만두 하나 더받을 만큼만 더 시키는 경우이다.
		long d = Long.parseLong(br.readLine());
		long n, m, k;
		String in[] = br.readLine().split(" ");
		
		n = Long.parseLong(in[0]);
		m = Long.parseLong(in[1]);
		k = Long.parseLong(in[2]);
		
		long max = ( n + m + k ) / d;
		long np = d - (n%d);
		long mp = d - (m%d);
		
		if( k >= np+mp ) { 
			k -= np+mp; //짬뽕과 짜장으로 각각 군만두를 하나씩 더 받기 위해 필요한 양을 합한 값이 안시킨 사람보다 적을 경우 
						//일단 필요한만큼을 더 시켰다 가정하고 k에서 합을 뺴준다.
			long kp = d - (k%d); 
			if( d + kp <= np+mp ) k += np+mp; //볶음밥으로 군만두를 두개 더 받을 수 있는 필요량이 짜장과 짬뽕의 추가량보다 적거나 같을 경우
											  // 짜장, 짬뽕의 추가 주문량을 모두 볶음밥으로 전환해도 군만두의 개수는 유지된다.
			else if( kp <= np || kp <= mp ) k += Math.max(np, mp); //짜장의 주문량 혹은 짬뽕의 주문량 둘중 하나라도 볶음밥의 군만두 1개 추가를
																   // 위한 필요 주문량보다 많을 경우 더 큰쪽을 볶음밥 주문으로 전환하면 군만두의
																   // 개수가 유지된다.
		}else if( k >= np && k >= mp ) {
			long ktempn = k;
			long ktempm = k;
			ktempn -= np;
			long nkp = d - (ktempn % d);
			if( nkp <= np ) ktempn += np;
			
			ktempm -= mp;
			long mkp = d - (ktempm % d);
			if( mkp <= mp ) ktempm += mp;
			
			k = Math.max(ktempn, ktempm);
		}else if( k >= np ) {
			k -= np;
			long kp = d - (k%d);
			if( kp <= np ) k += np;
		}else if( k >= mp ) {
			k -= mp;
			long kp = d - (k%d);
			if( kp <= mp ) k += mp;
		}
		
		bw.write(k + "");
		
		bw.flush();
		bw.close();

	}}
