package com.iprid.codingTest;

import java.util.Arrays;

// 참고 : https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
// 코딜리티 : MaxCounters , 크기 K인 배열 A[K]가 주어지고 N이 주어졌을 때
/*
				N 크기만큼 배열을 생성하고 A 배열의 원소를 count
				N보다 큰 원소값이 나오면 해당 배열의 최대값으로 초기화
				N보다 작은 원소값이 나오면 N크기 배열의 index 위치값 증가
				
				targetArray의 maxCount값을 기억하고 있다가 적용하는 것이 핵심
				for문 반복할 때마다 maxCount값 비교해서 갱신
				N+1 발생 시 이전 값으로 초기화 해야 하므로 tempMax값 올릴 필요 X
				1 <= A[i] <= N 일때는 maxCount 값보다 작은 경우
    			maxCount 값으로 초기화하고 해당 배열 값 1 증가 (targetArray[checkVal -1]++
*/
public class codL4MaxCounters {

	public static void main(String[] args) {
		System.out.print("MaxCounters : test case 1's  result : ");
		System.out.println(solution(5, new int[] {3, 4, 4, 6, 1, 4, 4}));  // [3, 2, 2, 4, 2]
		 
	}
 
	private static int[] solution(int N, int[] A) {
        int maxCount = 0, tempMax = 0;
        int[] targetArr = new int[N];

        for (int checkVal : A) {  
            if (checkVal > N) {  // maxCounter
                maxCount = tempMax;
            } else {
                if (targetArr[checkVal -1] < maxCount) 
                    targetArr[checkVal -1] = maxCount;
                
                targetArr[checkVal - 1]++;
                tempMax = Math.max(tempMax, targetArr[checkVal -1]);
            }
        }
        for (int i = 0; i < targetArr.length; i++) {
            if (targetArr[i] < maxCount) 
            targetArr[i] = maxCount;
        }
        System.out.println(Arrays.toString(targetArr));
        return targetArr;
    }
}
