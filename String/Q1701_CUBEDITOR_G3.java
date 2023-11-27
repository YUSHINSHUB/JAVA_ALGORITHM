package String;

/*
commented by ChatGPT
This Java program finds the length of the longest repeated substring within a given string using the Knuth-Morris-Pratt (KMP) algorithm. 
It iteratively generates substrings of the input string and applies the KMP algorithm to each substring to find the longest prefix that is also a suffix. 
The result is the length of the longest repeated substring in the entire string.
이 Java 프로그램은 Knuth-Morris-Pratt (KMP) 알고리즘을 사용하여 주어진 문자열 내에서 가장 긴 반복되는 부분 문자열의 길이를 찾습니다. 
입력 문자열의 부분 문자열을 반복적으로 생성하고 각 부분 문자열에 KMP 알고리즘을 적용하여 접두사이자 접미사인 가장 긴 부분을 찾습니다. 
결과는 전체 문자열에서 가장 긴 반복되는 부분 문자열의 길이입니다.
*/

import java.io.*;
import java.util.*;

public class Q1701_CUBEDITOR_G3 {

    static int res = 0;

    public static int kmp(String s) {
        int idx = 0;
        int out = 0;
        int[] pi = new int[s.length()];
        Arrays.fill(pi, 0);

        for (int i = 1; i < s.length(); i++) {
            // 현재 문자와 접미사의 다음 문자가 다를 경우, 이전 접미사 위치로 이동
            while (idx > 0 && s.charAt(idx) != s.charAt(i)) {
                idx = pi[idx - 1];
            }
            
            // 현재 문자와 접미사의 다음 문자가 같을 경우, 접미사 길이 증가
            if (s.charAt(idx) == s.charAt(i)) {
                idx++;
                pi[i] = idx;
                out = Math.max(out, idx); // 가장 긴 접미사 길이 갱신
            }
        }

        return out; // 가장 긴 접미사 길이 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in = br.readLine(); // 입력 문자열
        int res = 0;

        // 부분 문자열에 대해 KMP 알고리즘 적용
        for (int i = 0; i < in.length() - 1; i++) {
            String sub = in.substring(i, in.length());
            res = Math.max(res, kmp(sub)); // 가장 긴 반복 부분 문자열 길이 갱신
        }

        bw.write(res + ""); // 결과 출력

        bw.flush();
        bw.close();
    }
}
