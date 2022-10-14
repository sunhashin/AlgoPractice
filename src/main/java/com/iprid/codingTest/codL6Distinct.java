package com.iprid.codingTest;

import java.util.HashSet;
import java.util.Set;

//참고 : https://app.codility.com/programmers/lessons/6-sorting/distinct/
//코딜리티 : Distinct, 문제에서 요구하는 것이 예를 들면 {2,1,1,2,3,1} 이란 배열이 있을 때 
// 서로 구분되는 정수 1, 2, 3 이렇게 3개가 있다고 return하는 것이다.


public class codL6Distinct {

	public static void main(String[] args) {
		System.out.print("Distinct : test case 1's  result : ");
		System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1}));  // 3
 
	}	
 
	private static int solution(int[] A) {
        Set<Integer> chekcSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (!chekcSet.contains(A[i]))
                chekcSet.add(A[i]);

        }
        return chekcSet.size();
    }
}
