package com.iprid.codingTest;

import java.util.HashSet;
import java.util.Set;

// 참고 : https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
// 코딜리티 : TapeEquilibrium, 배열이 주어지고 Split 할 숫자(P)가 주어지면 
//                                                split된 두 배열 각 합의 사이값 중 제일 작은 차이값을 구하는 문제
//                                               > 전체 합을 구한 뒤 LeftSum, RightSum을 구해서 diff를 구해서 min값을 구함
public class codL3TapeEquilibrium {

	public static void main(String[] args) {
		System.out.print("TapeEquilibrium : test case 1's  result : ");
		System.out.println(solution(new int[] {3, 1, 2, 4, 3}));  // 1
	}
 
	private static  int solution(int[] A) {
		int leftSum = 0, rightSum = 0, totalSum = 0, minVal = Integer.MAX_VALUE;

        for (int i : A) {
            totalSum += i;
        }

        for (int i = 0; i < A.length -1; i++) {
            leftSum += A[i];
            rightSum = totalSum - leftSum;
            minVal = Math.min(minVal, Math.abs(leftSum - rightSum));

           // System.out.println("leftSum : " + leftSum + ", rightSum : " + rightSum + ", totalSum : " + totalSum + ", Math.abs(leftSum - rightSum) : " + Math.abs(leftSum - rightSum) + " , minVal : " + minVal);
        }
        return minVal;
    }
}
