package com.iprid.codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
// 코딜리티 : CountSemiprimes ,  
/*
			(에라토스테네스의) 체처럼 숫자들을 모두 체 위에 놓고 소수가 아닌 수들을 걸러내면 소수만 남는다.
			1 제외, 2 이상의 모든 숫자는 모두 소수라고 전제(prime)
			2 부터 시작하여 해당 수의 배수인 경우 소수에서 제외(no prime)
			단, 해당 수의 제곱부터 시작하여 배수를 더하며 검색하여 소수 중복검색을 최소화 한다.
			
			상세 설명 : 
			예를들어
			
			2 검색할 때 제곱인 4, 6, 8, 10, 12, 14, 16... 검색하여 소수에서 제외
			3 검색할 때 제곱인 9, 12, 15... 검색하여 소수에서 제외
			(만약, 3 배수로 검색했다면 6도 검색해야하지만 6은 2에서 이미 제외됨)
			4 이미 no prime이므로 제외
			5 검색할 때 제곱인 25, 30, 35, 40... 검색하여 소수에서 제외
			(만약, 5 배수를 검색했다면 10, 15, 20도 검색해야 하지만 10과 20은 2에서, 15는 3에서 이미 제외됨)
			비슷한 방법으로 prime이고 나누어지는 수도 prime인 경우 즉 prime 2개로 구성된 경우 (semi prime) 기록한다.
			
			semi prime을 PreSum으로 출현개수를 누적으로 저장한 후
			요청수에 따라 바로 계산식으로 계산 후 응답한다.

*/

public class codLL11CountSemiprimes {

	public static void main(String[] args) {
		System.out.print("CountSemiprimes : test case 1's  result : ");
		System.out.println(solution(26, new int[] {1, 4, 16}, new int[] {26, 10, 20}));  // [10, 4, 0]
	}
	
	private static int[] solution(int N, int[] P, int[] Q) {
	        int[] result = new int[P.length];
	        int[] flags = new int[N + 1];   //  0 : default
	        int[] presum = new int[N + 1];

	        // 0 : prime, 1 : no prime, 2 : semi prime
	        flags[0] = 1; flags[1] = 1;

	        for (int i = 2; i * i <= N; i++) {
	            if (flags[i] == 1) continue;

	            int k = i * i;
	            while (k <= N) {
	                flags[k] = 1;   // 1 : no prime
	                k = k + i;      // next multiple
	            }
	        }

	        for (int i = 2; i * i <= N; i++) {
	            if (flags[i] == 1) continue;

	            int k = i * i;
	            while (k <= N) {
	                if (flags[i] == 0 && flags[k / i] == 0) {
	                    flags[k] = 2;  // 2 : semi prime
	                }
	                k = k + i;          // next multiple
	            }
	        }

	        int semi_prime_counter = 0;
	        for (int i = 2; i <= N; i++) {
	            if (flags[i] == 2) {
	                semi_prime_counter++;
	            }
	            presum[i] = semi_prime_counter;
	        }

	        for (int i = 0; i < P.length;  i++) {
	            result[i] = presum[Q[i]] - presum[P[i] -1];
	        }
	        System.out.println(Arrays.toString(result));
	        return result;
	    }
}