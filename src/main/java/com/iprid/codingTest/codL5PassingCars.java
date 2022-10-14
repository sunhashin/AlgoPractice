package com.iprid.codingTest;

import java.util.Arrays;

// 참고 : https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
// 코딜리티 : PassingCars, 0은 차가 동쪽, 1은 서쪽으로 가는 것을 의미, 지나가는 차의 pair가 1,000,000,000을 초과하면 -1 return
/*
		1. zero, sums라는 이름의 변수를 만들고 0으로 초기화
		2. for문으로 A를 돌려줌 (for x in A), x = 0 일때 zero += 1,  x = 1 일땐 sums +=  zero
		3. sums 가 1,000,000,000보다 커지면 -1 return
		4. 1,000,000,000 이하일 경우 sums 최종적으로 return
		
		or
		
		지나가는 차량 (P, Q)를 만들기 위해 동쪽(0) 을 기준으로  서쪽(1) 으로 지나가는 차량의 수를 차례로 셈하여 더함
		이를 위해 최초 배얼에서 서쪽(1) 으로 가는 차량의 수를 셈하여 저장하고 배열을 반복하여 0일경우
		이후 1의 전체수를 더하고 1일 경우엔 전체 1의 수를 하나 빼면 됨
 */

public class codL5PassingCars {

	public static void main(String[] args) {
		System.out.print("PassingCars : test case 1's  result : ");
		System.out.println(solution(new int[] {0, 1, 0, 1, 1}));  // 5
 
	}
 
	private static int solution(int[] A) {
        int count = 0, one_count = 0;

        for (int i : A) {
            if (i == 1) one_count++;
        }
        
        for (int i = 0 ; i < A.length; i++) {
            if (A[i] == 0) {
                count += one_count;
                 if (count > 1_000_000_000) return -1;
            } else {
                one_count--;
            }
        }
        return count;
    }
}
