package com.iprid.codingTest;

import java.util.Arrays;

// 참고 : https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
// 코딜리티 : PermCheck, N 개의 정수로 이루어진 non-empty 배열, 
//                                          순열이란 1에서 N까지의 요소를 오직 한번만 포함하는 수
//                                          순열이면 1, 아니면 0 반환
//                                         배열을 정렬한 후 1,2,3,4 처럼 진행되지 않으면 0, 수가 모두 연속하면 1 반환

public class codL4PermCheck {

	public static void main(String[] args) {
		System.out.print("PermCheck : test case 1's  result : ");
		System.out.println(solution(new int[] {4, 1, 3, 2}));  // 1
		
		System.out.print("PermCheck : test case 2's  result : ");
		System.out.println(solution(new int[] {4, 1, 3}));  // 0
	}
 
	private static int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0 ; i < A.length; i++) {
            if (i + 1 != A[i])
                return 0;
        }
        return 1;
    }
}
