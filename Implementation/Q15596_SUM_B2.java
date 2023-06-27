package Implementation;

public class Q15596_SUM_B2 {

	long sum(int[] a) {
		long ans = 0;

		for (int i = 0; i < a.length; i++) {
			ans += a[i];
		}

		return ans;
	}
}