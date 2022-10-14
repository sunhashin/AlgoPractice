package com.iprid.codingTest;

import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
// 코딜리티 : MaxDoubleSliceSum , 부분합을 구하는 알고리즘을 구현하라는 건데, 그 부분합들 중 최대값을 찾으면 된다.
// for 문을 두번 써야하나 생각하다가, 어차피 "값" 만 찾으면 되니까 한방에 다 돌려버렸다.
/*
			  배열이 있다. 이들 원소 중 3개를 제외하고 더했을때 가장 큰 값을 리턴하라
			 오른쪽 방향으로 더하는 배열 사용
			 왼쪽 방향으로 더하는 배열 사용
			 본 배열을 순회하면서 해당 인덱스의 오른쪽 방향 sum 과 왼쪽 방향 sum 을 구하고
			이전 max 값과 비교하여 max 값을 찾음
 */

public class codL9MaxDoubleSliceSum {

	public static void main(String[] args) {
		System.out.print("MaxDoubleSliceSum : test case 1's  result : ");
		System.out.println(solution(new int[] {3, 2, 6, -1, 4, 5, -1, 2}));  // 17
	}
	
	private static int solution(int[] A) {
        int N = A.length;
        int maxSum = 0;
        int[] rightSum = new int[N];
        int[] leftSum = new int[N];

        for (int i = 1, r = N; i < N -1; i++) {
            rightSum[i] = Math.max(rightSum[i - 1] + A[i], 0);

            r = N - 1 - i;

            leftSum[r] = Math.max(leftSum[r + 1] + A[r], 0);
        }

        for (int i = 1; i < N -1; i++) {
            maxSum = Math.max(rightSum[i - 1] + leftSum[i + 1], maxSum);
        }
        return maxSum;
    }
}
