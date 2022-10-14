package com.iprid.codingTest;

import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
// 코딜리티 : MaxSliceSum , 부분합을 구하는 알고리즘을 구현하라는 건데, 그 부분합들 중 최대값을 찾으면 된다.
// for 문을 두번 써야하나 생각하다가, 어차피 "값" 만 찾으면 되니까 한방에 다 돌려버렸다.
/*
  풀이 :   	양수그룹, 음수그룹으로 그룹화하여 어렵게 최대값을 구하기 보다
				2개 변수를 잘 활용하면 단일 반복문으로 해결할 수 있다.(Kadane's algorithm)
				순방향(왼쪽에서 오른쪽)으로 진행하면서 Element값과 누적한 값 중 더 큰 값을 구한다.(가)
				순방향(왼쪽에서 오른쪽)으로 진행하면서 지금까지 나온 최대 (가)값을 기록한다.(나)
 */

public class codL9MaxSliceSum {

	public static void main(String[] args) {
		System.out.print("MaxSliceSum : test case 1's  result : ");
		System.out.println(solution(new int[] {3, 2, -6, 4, 0}));  // 5
	}
	
	private static int solution(int[] A) {
        if (A.length == 1) return A[0];

        // 첫번째 값 설정
        int max_end = A[0];

        // 두번째 값 설정
        int max_far = A[0];

        for (int i = 1; i < A.length; i++) {
            // 순방향(왼쪽에서 오른쪽)으로 진행하면서 Element값과 누적한 값 중 더 큰 값을 구한다.(가)
           max_end = Math.max(A[i], max_end + A[i]);

            // 순방향(왼쪽에서 오른쪽)으로 진행하면서 지금까지 나온 최대 (가)값을 기록한다.(나)
           max_far = Math.max(max_far, max_end);
        }
        return max_far;
    }
}
