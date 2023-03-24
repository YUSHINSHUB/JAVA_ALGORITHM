package Arithmetic;

import java.io.*;

public class Q13170_Fallen_Crystal_S4 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in[] = br.readLine().split(" ");
		
		int n, k, p, w;
		n = Integer.parseInt(in[0]);
		k = Integer.parseInt(in[1]);
		p = Integer.parseInt(in[2]);
		w = Integer.parseInt(in[3]);
		
		//수정의 강도와 내려치는 힘은 정수가 아니라 실수다. 그러므로 마나가 응집된 수정의 강도는 순위가 어떻게 되었든 상관없이
		//0에 한없이 수렴한 0.000..0001일 수 있다. 또한 이를 내려치는 힘은 0.00...001 + (위험 힘차이 w에 한없이 수렴하여 w를 4라고 가정 하였을 떄,
		// 3.999...999)일 수 있다. 이 때 최악의 경우를 가정해야 하므로 수정이 파괴되지 않았다면 수정의 강도는 4보다 작지만 한없이 수렴한 
		//3.999...999보다 큰 수라고 할 수 있다. 최대강도를 19라고 가정해보자. 가능한 최대강도로 다시 내려쳤을 때 파괴되지 않았을 경우 수정의 강도는
		// 8에 수렴한 수보다 큰 값이 되며 반복한다면 w씩 더하여 12에 수렴, 16에 수렴해지며 수정의 강도는 p 이하이기 떄문에 19의 힘으로 내려치면 
		//수정은 무조건 파괴되며 이때의 내려친 횟수는 5회이다. 만약 p가 16이었을 경우, 네번에 끝낼 수 있다. 이를 간략화 하면 필요한 값은 p/w을 올림한 값이고
		// n, k는 필요없는 값이다. 올림은 java.math 패키지의 Math.ceil()메소드를 사용하여 할 수 있다.
		
		int res = (int)Math.ceil((double) p / w);
		bw.write(res + "");
		
		bw.flush();
		bw.close();
	}
}
