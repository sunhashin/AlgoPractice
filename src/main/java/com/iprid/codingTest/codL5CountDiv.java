package com.iprid.codingTest;

import java.util.Arrays;

// 참고 : https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
// 코딜리티 : CountDiv, A, B, K 세 개의 정수가 주어졌을 때, 범위 [A .. B] 내에서 K로 나눌 수 있는 정수의 갯수를 반환하는 함수를 구현
/*  예를 들어, A = 6, B = 11, K = 2 일 때, 함수는 3을 반환해야한다. 
      왜냐하면 범위 [6 ..11] 내에서 2로 나누어지는 수는 6, 8, 10 으로 3개 이기 때문이다.
      
     ※나누어지는 수가 아니다.  
     즉 A=0, B=10, K=5 라면 5와 10을 구하는게 아니라 나머지가 0인 0, 5, 10을 구하는 문제 
     -> 0%5 = 0 이기 때문에 (return 3)
 */

public class codL5CountDiv {

	public static void main(String[] args) {
		System.out.print("CountDiv : test case 1's  result : ");
		System.out.println(solution(6, 11, 2));  // 3
 
	}
 
	private static int  solution(int A, int B, int K) {
        return  (B / K)  - (A / K) + (A % K == 0 ? 1 : 0);
    }
}
