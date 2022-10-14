package com.iprid.codingTest;

import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/8-leader/equi_leader/
// 코딜리티 : EquiLeader , Boyer-Moore Majority Vote Algorithm을 사용하여 leader element를 찾고, 
//                                         배열을 순회하면서 EquiLeader를 찾는 문제이다.
/*
  풀이 : 가장 많이 나오는 숫자의 카운트를 알아내고,
            순회하면서 가장 많이 나오는 숫자이면 조건을 체크하여 카운트 한다.
 */

public class codL8EquiLeader {

	public static void main(String[] args) {
		System.out.print("EquiLeader : test case 1's  result : ");
		System.out.println(solution(new int[] {4, 3, 4, 4, 4, 2}));  // 2
	}
	
	private static int solution(int[] A) {
        int cnt = 1, totalCnt = 0, cntLeftPart = 0;
        int el = A[0];

        for (int i  = 1; i < A.length; i++) {
            if (A[i] == el) cnt++;
            else cnt--;

            if (cnt == 0) {
                cnt = 1;
                el = A[i];
            }
        }
        // check el is a leader
        cnt = 0;
        for (int n : A) {
            if (n == el) cnt++;
        }
        if (cnt <= (A.length / 2)) return 0;

        // find # of equi-leader case
        for (int i = 0; i < A.length; i++) {
            if (A[i] == el) cntLeftPart++;

            int cntRightPart = cnt - cntLeftPart;
            
            if (cntLeftPart > (i + 1) / 2 &&
                cntRightPart > (A.length -1 -i) / 2) {
                    totalCnt++;
            }
        }
        return totalCnt;
    }
}
