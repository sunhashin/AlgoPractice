package com.iprid.codingTest;

import java.util.Stack;

//참고 : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
// 코딜리티 : BinaryGap , 문제의 내용은 10진수를 2진수로 바꾸는데, 1과 1 사이의 0이 가장 긴 length 를 반환
public class codL1BinaryGap {

	public static void main(String[] args) {
		System.out.print("BinaryGap : test case 1's  result : ");
		System.out.println(solution(1041));  // 5
		System.out.print("BinaryGap : test case 2's  result : ");
		System.out.println(solution(15));  // 0
		System.out.print("BinaryGap : test case 3's  result : ");
		System.out.println(solution(32));  // 5
 
	}
	
	private static int solution(int N) {
        int flag = 0, answer = 0, maxCount = 0;

        while (N > 1) {
            if (N % 2 == 1) {
                if (flag < 1) flag = 1;
                answer = 0;
            } else {
                if (flag == 1) {
                    answer++;
                    if (answer > maxCount)  maxCount = answer;
                }
            }
            N = N / 2;
        }
        return (flag > 0) ? maxCount : 0;

    }

}
