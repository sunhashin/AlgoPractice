package com.iprid.codingTest;

import java.util.HashSet;
import java.util.Set;

// 참고 :https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
// 코딜리티 : PermMissingElem , 주어진 배열(1~N) 중에서 없는 숫자 찾기
// 배열 길이 받아와서 1부터 배열길이+1만큼 sum 을 구한 뒤
// 배열 안의 수를 합한 숫자만큼의 차이를 구한다.

public class codL3PermMissingElem {

	public static void main(String[] args) {
		System.out.print("PermMissingElem : test case 1's  result : ");
		System.out.println(solution(new int[] {2, 3, 1, 5}));  // 4
	}
 
	private static  int solution(int[] A) {
	       
	        int totalSum = 0, aSum = 0, answer = 0;
	        for (int i = 1; i <= A.length + 1; i++) {
	            totalSum += i;
	        }
	         
	        for (int i = 0; i < A.length; i++) {
	            aSum += A[i];
	        } 
	        
	        answer =  totalSum - aSum;
	        return answer;
	    }
}
