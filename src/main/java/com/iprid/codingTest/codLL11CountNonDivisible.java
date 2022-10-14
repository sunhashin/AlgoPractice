package com.iprid.codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
// 코딜리티 : CountNonDivisible ,  
/*
			약수가 아닌 원소의 개수를 구하는것인데, 계산 단계의 수가 너무 많음
			따라서 존재하는 수를 먼저 카운트한 후 약수인 수들을 검색하여 그 수만큼 빼면 됨
			(약수가 아닌 원소의 개수 = 전체약수 - 약수의 수)
*/

public class codLL11CountNonDivisible {

	public static void main(String[] args) {
		System.out.print("CountNonDivisible : test case 1's  result : ");
		System.out.println(solution(new int[] {3, 1, 2, 3, 6}));  // [2, 4, 3, 2, 0]
	}
	
	private static int[] solution(int[] A) {
        int[] answer = new int[A.length];
        Map<Integer, Integer> uniqueMap = setUniqueMap(A);

        for (int i = 0; i < A.length; i++) {
            int count = 0;

            for (int j = 1; j * j <= A[i]; j++) {
            	
                if (A[i] % j == 0) {
                    count += uniqueMap.getOrDefault(j, 0);
                    
                    if (j != A[i] / j) 
                    	count += uniqueMap.getOrDefault(A[i] / j , 0);
                }
            }
            answer[i] = A.length - count;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static Map<Integer, Integer> setUniqueMap(int[] A) {
        Map<Integer, Integer> uniqueMap = new HashMap<>();
        for (int a : A) {
            uniqueMap.put(a, uniqueMap.getOrDefault(a, 0) + 1);
        }
        return uniqueMap;
    }
}