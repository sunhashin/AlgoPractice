package com.iprid.codingTest;

import java.util.Arrays;

public class TheMostBiggestNumber {

	// 참고 : https://school.programmers.co.kr/tryouts/42736/challenges
	// 프로그래머스 - 가장 큰수
	public static void main(String[] args) {
		
		System.out.print("가장 큰수 : test case 1's  result : ");
		System.out.println(solution(new int[] {6, 10, 2}));  // "6210"
		
		System.out.print("가장 큰수 : test case 2's  result : ");
		System.out.println(solution(new int[] {3, 30, 34, 5, 9}));  // "9534330"
	}
	
	 private static String solution(int[] numbers) {
	        String answer = "";
	        String[] numStr = new String[numbers.length];
	        
	        // 배열의 숫자 -> 문자로 -> 내림차순 정렬 -> 조합
	        for (int i = 0; i < numbers.length; i++) {
	            numStr[i] = numbers[i] + "";
	        }
	        
	        // 양수 : 오름차순, 음수 : 내림차순, 0 : 변동 없음
	        // (o1, o2) -> o1 - o2 : 오름차순
	        // (o1, o2) -> o2 - o1 : 내림차순
	        // 내림 차순으로 정렬하는 것이 목적
	        Arrays.sort(numStr, (o1, o2) -> {
	           if (o1.length() == o2.length())
	               return o2.compareTo(o1);
	            else
	                return (o2 + o1).compareTo(o1 + o2);
	        });
	       
	        for (String ck : numStr) {
	            answer = answer.concat(ck);
	        }
	        if (answer.charAt(0) == '0') return "0";        
	        return answer;
	    }
}
