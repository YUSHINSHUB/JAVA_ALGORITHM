package String;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q6996_Anagram_B1 {

    private static boolean solveAnagrams(String first, String second ) {
        /* ------------------- INSERT CODE HERE --------------------
         *
         * Your code should return true if the two strings are anagrams of each other.
         *
         * */
		
			if( first.length() != second.length() ) {
				return false;
			}
			
			int cnt[] = new int[26];
			boolean chk = true;
			for( int z = 0 ; z < 26 ; z++ ) {
				cnt[z] = 0;
			}
			
			for( int z = 0 ; z < first.length() ; z++ ) {
				cnt[first.charAt(z)-97]++;
			}
			for( int z = 0 ; z < second.length() ; z++ ) {
				cnt[second.charAt(z)-97]--;
			}
			
			for( int z = 0 ; z < 26 ; z++ ) {
				if( cnt[z] != 0 ) {
					return false;
				}
			}
			return true;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}