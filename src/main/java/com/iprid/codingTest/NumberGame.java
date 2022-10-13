package com.iprid.codingTest;

import java.util.Arrays;

public class NumberGame {
	// 참고 : https://school.programmers.co.kr/tryouts/42738/challenges
	// 프로그래머스 - 숫자 게임
	public static void main(String[] args) {
		
		System.out.print("숫자 게임 : test case 1's  result : ");
		System.out.println(solution(new int[] {5,1,3,7}, new int[]{2,2,6,8}));  // 3
		
		System.out.print("숫자 게임 : test case 2's  result : ");
		System.out.println(solution(new int[] {2,2,2,2}, new int[]{1,1,1,1}));  // 0

	}
	
	 private static int solution(int[] A, int[] B) {
	        int answer = 0;
	        
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        int index = B.length -1;
	        for (int i = A.length -1; i >= 0; i--) {
	            if (A[i] < B[index]) {
	                index--;
	                answer++;
	            }
	            
	        }
	        return answer;
	    }

}
