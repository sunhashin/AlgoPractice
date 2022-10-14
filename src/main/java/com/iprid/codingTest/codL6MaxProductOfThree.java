package com.iprid.codingTest;

import java.util.Arrays;

//참고 : https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
//코딜리티 : MaxProductOfThree, 삼중 항의 최대 값을 리턴해라!
/*
		 •우선 정렬 시킨다.
		•모두 양수 일 경우 ◦1 2 3 4 5 6 = A[N-1] * A[N-2] * A[N-3]
		•모두 음수 일 경우 ◦-6 -5 -4 -3 -2 -1 = A[N-1] * A[0] * A[1]
		•음수, 양수 혼합 일 경우 ◦-1 -2 -3 -4 -5 6 = A[N-1] * A[N-2] * A[N-3]
		
		•A[N-1] 은 항상 곱해진다.
		•A[N-1] 이 음수, 양수 여부에 따라 최소값, 최대값을 구해준다.

 */

public class codL6MaxProductOfThree {

	public static void main(String[] args) {
		System.out.print("MaxProductOfThree : test case 1's  result : ");
		System.out.println(solution(new int[] {-3, 1, 2, -2, 5, 6}));  // 60
	}	
 
	private static int solution(int[] A) {
        // 3중항의 곱 최대값 리턴
        // 1. 배열 오름차순 정렬
        // 2. 모두 양수/ 음양 혼합이면 : A[N-2] * A[N-1] * A[N-1]
        // 3. 모두 음수 : A[0] * A[1] * A[N-1]
        Arrays.sort(A);

        int n = A.length;
        int firstProduct = A[0] * A[1];
        int secondProduct = A[n-2] * A[n-3];
        int lastProduct = A[n-1];

        if (lastProduct < 0)
            return Math.min(firstProduct, secondProduct) * lastProduct;
        else
           return Math.max(firstProduct, secondProduct) * lastProduct;
    }
}
