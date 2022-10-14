package com.iprid.codingTest;

import java.util.ArrayList;
import java.util.List;

//참고 : https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
// 코딜리티 : Flags , 반감법(bisection)
/*
				이전 풀었던 peaks 문제와 비슷, 먼저 주어진 배열 A에서 peak을 구한다.
				각 peak에는 깃발을 꽂을 수 있는데,  peak에 깃발을 꽂을 수 있는 조건은 다음과 같다.
				
				1. peak P와 Q사이의 거리(배열 A에서 index)가 챙겨간 깃발의 갯수보다 크거나 같아야 깃발을 꽂을 수 있다.
				2. 이 때, 배열 A의 peak에 꽂을 수 있는 가장 큰 깃발의 수를 구하면 된다
*/

public class codLL10Flags {

	public static void main(String[] args) {
		System.out.print("Flags : test case 1's  result : ");
		System.out.println(solution(new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));  // 3
	}
	
	private static int solution(int[] A) {
        List<Integer> peekList = new ArrayList<>();

        for (int i = 1; i < A.length -1; i++) {
            if (A[i] > A[i -1] && A[i] > A[i + 1]) {
                peekList.add(i);
                i++;
            }
        }

        int maxFlagCount = 0, start = 0, end = peekList.size();

        if (end < 2) return end;

        while (start <= end) {
            int flag = (start + end) / 2;
            int count = 1;
            int prevIndex = peekList.get(0);

            for (int j = 1; j < peekList.size() && count < flag; j++) {
                if (peekList.get(j) - prevIndex >= flag) {
                    count++;
                    prevIndex = peekList.get(j);
                }
            }

            if (count == flag) {
                start = flag + 1;
                maxFlagCount = count;
            } else {
                end = flag -1;
            }
        }
        return maxFlagCount;
    }
}