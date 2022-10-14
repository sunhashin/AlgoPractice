package com.iprid.codingTest;

import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/8-leader/dominator/
// 코딜리티 : Dominator , 배열A의 지배자 : A의 요소의 절반 이상에서 발생하는 값.
// 배열A의 지배자가 발생하는 요소의 인덱스 중 하나를 반환하라! ◦만약 지배자가 없으면 -1을 반환
/*

A에 포함되는 원소들에 대해 Count 를 해야하기 때문에 HashMap 구조를 이용함
HashMap의 put, get, containsKey는 O(1), worst O(n) 이기 때문에 유용함
containsValue = O(n) 

 */

public class codL8Dominator {

	public static void main(String[] args) {
		System.out.print("Dominator : test case 1's  result : ");
		System.out.println(solution(new int[] {3, 4, 3, 2, 3, -1, 3, 3}));  // 7
	}
	
	private static int solution(int[] A) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        int half = A.length;
        half /= 2;

        if (A.length == 1) return 0;
        for (int i = 0; i < A.length; i++) {

            if (cntMap.containsKey(A[i])) {
                cntMap.put(A[i], cntMap.get(A[i]) + 1);

                if (cntMap.get(A[i]) > half)
                    return i;

            } else {
                cntMap.put(A[i], 1);
            }
        }
        return -1;
    }
}
