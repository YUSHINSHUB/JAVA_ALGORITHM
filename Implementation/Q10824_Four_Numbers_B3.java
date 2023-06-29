package Implementation;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q10824_Four_Numbers_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nums = br.readLine().split(" ");

		String n1 = nums[0] + nums[1];
		String n2 = nums[2] + nums[3];

		BigInteger i1 = new BigInteger(nums[0] + nums[1]);
		BigInteger i2 = new BigInteger(nums[2] + nums[3]);

		i1 = i1.add(i2);

		bw.write(i1.toString());

		bw.flush();
		bw.close();

	}
}
