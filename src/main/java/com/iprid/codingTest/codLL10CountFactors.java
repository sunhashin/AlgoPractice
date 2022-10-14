package com.iprid.codingTest;

import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
// 코딜리티 : CountFactors , ​1.제곱근까지 반복 / 2.제곱근이 약수가 되는 수는 카운트에서 차감 
/*
	풀이 : 
			1부터 N까지 검색하지 않도록 한다.
			N의 제곱근까지 검색해보면 제곱근 이전의 factor수(a)를 구할 수 있다.
			제곱근 이후의 factor수는 (a)와 동일한다.
			단, 제곱근이 정수인 경우 2개가 아닌 1개만 카운트한다.
			단, 1과 N도 각각 카운트한다.
 */

public class codLL10CountFactors {

	public static void main(String[] args) {
		System.out.print("CountFactors : test case 1's  result : ");
		System.out.println(solution(24));  // 8
	}
	
	private static int solution(int N) {
        
        int sqrt_num = (int) Math.sqrt(N);

        boolean isSquare = (sqrt_num * sqrt_num == N) ? true : false;
        int prime_cnt = 0;

        for (int i = 2; i <= sqrt_num; i++) {
            if (N % i == 0) prime_cnt++;
        }
        prime_cnt = prime_cnt * 2;  // Mod 0 number has pair

        if (isSquare) prime_cnt -= 1;  // Square num is only 1

        prime_cnt += 2; // number 1 and N include

        return prime_cnt;
    }
}
