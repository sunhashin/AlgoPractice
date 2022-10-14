package com.iprid.codingTest;

import java.util.Arrays;

//참고 : https://app.codility.com/programmers/lessons/6-sorting/triangle/
//코딜리티 : Triangle, 배열에 삼각형이 있으면 1, 없으면 0을 리턴하라!
/*
		배열 크기가 3이하 일 경우 처리 필요
		각 요소의 범위가 정수 최소 ~ 최대 이므로 더했을 경우 long 형으로 처리해야 함
		정렬을 우선 한다.
		정렬 된 상태 이면 아래는 무조건 만족하므로 A[P] + A[Q] > A[R] 에 대해서만 체크함.
		
		A[R] + A[P] > A[Q] (첫번째, 마지막 합은 중간보다 항상 큼)
		A[Q] + A[R] > A[P] (중간, 마지막 합은 첫번째보다 항상 큼)
 */

public class codL6Triangle {

	public static void main(String[] args) {
		System.out.print("Triangle : test case 1's  result : ");
		System.out.println(solution(new int[] {10, 2, 5, 1, 8, 20}));  // 1
		
		System.out.print("Triangle : test case 2's  result : ");
		System.out.println(solution(new int[] {10, 50, 5, 1}));  // 0
	}	
 
	private static int solution(int[] A) {
        int N = A.length;
        if (N < 3) return 0;
        
        Arrays.sort(A);

      // 정렬 된 상태 이면, A[P] + A[Q] > A[R] 에 대해서만 체크함.
        for (int i = 0; i < N -2; i++) {
            long P = A[i], Q = A[i +1], R = A[i + 2];
            if (P + Q > R) return 1;
        }
        return 0;
    }
}
