package com.iprid.codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 참고 : https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
// 코딜리티 : MissingInteger 
/*
 *   풀이 방법은 인터넷 검색해서 가져온 것입니다. 링크 잊어벼러서 일단 풀이 설명은 올림
 
		특정 수열이 주어졌을 때 수열이 차례대로 꽉 차있으면, 
        공차 1인 등차수열이 주어지면(예: [1,2,3]) 그 다음 숫자인 4를 반환하면 되는 것이고, 
        만약에 중간에 빈 숫자가 있다면 그곳에 들어가야 할 숫자를 리턴해주고(예: [1, 3, 6, 4, 1, 2]면 5) 
       마지막 숫자가 음수라면 위 설명에 있는 smallest positive integer, 곧 1을 리턴하라는 의미이다.

		주어지는 배열 A의 최대 수 + 1만큼의 등차수열을 튜플로 만든다음에 
		튜플에서 A의 요소들을 하나하나 빼고 그 튜플에서 제일 작은 수를 반환하는 방법으로 해결하였다. 
		끝나는 수가 음수라면 튜플이 만들어지지 않기 때문에 
		튜플이 없으면 1을 리턴하는 식으로 음수에 대한 케이스도 적용하였다.
*/
public class codL4MissingInteger {

	public static void main(String[] args) {
		System.out.print("MissingInteger : test case 1's  result : ");
		System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2}));  // 5
		
		System.out.print("MissingInteger : test case 1's  result : ");
		System.out.println(solution(new int[] {1, 2, 3}));  // 4
		
		System.out.print("MissingInteger : test case 1's  result : ");
		System.out.println(solution(new int[] {-1, -3}));  // 1
		 
	}
 
	private static int solution(int[] A) {
        Arrays.sort(A);

        int maxVal = A[A.length -1];
        Map<Integer, Boolean> checkMap = new HashMap<>();
        for (int i : A) {
            checkMap.put(i, true);
        }
        for (int j = 1; j <= maxVal; j++) {
            if (!checkMap.containsKey(j)) return j;
        }
        if (maxVal < 1) return 1;
        return maxVal + 1;
    }
 
}
