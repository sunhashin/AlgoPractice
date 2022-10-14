package com.iprid.codingTest;

import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
// 코딜리티 : MaxProfit , 배열이 있고, 원소들 중 가장 차이가 큰 값을 리턴한다. 없을 시에는 0을 리턴한다.
/*
  풀이 :   A[i] - A[i -1] 의 차이가 -로 발생하는 구간 중 가장 작은 값을 가지는 인덱스를 저장한다.
             그 인덱스와 가장 차이가 많이 나는 인덱스를 찾아서 리턴한다.
 */

public class codL9MaxProfit {

	public static void main(String[] args) {
		System.out.print("MaxProfit : test case 1's  result : ");
		System.out.println(solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367}));  // 356
	}
	
	private static int solution(int[] A) {
        int N = A.length;
        int profit = 0, maxProfit = 0, minIndex = 0;

        for (int i = 1; i < N; i++) {
            profit = A[i] - A[i -1];

            if (profit < 0 && A[minIndex] > A[i])
                minIndex = i;

            profit = A[i] - A[minIndex];
            maxProfit = Math.max(profit, maxProfit);
        }
        return (maxProfit < 0) ? 0 : maxProfit;
    }
}
