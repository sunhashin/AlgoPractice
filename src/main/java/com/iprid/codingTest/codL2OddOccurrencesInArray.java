package com.iprid.codingTest;

import java.util.HashSet;
import java.util.Set;

//참고 : https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
// 코딜리티 : OddOccurrencesInArray , 홀수 배열이  주어졌을 때 pair가 맞지 않는 숫자를 return하는 문제

public class codL2OddOccurrencesInArray {

	public static void main(String[] args) {
		System.out.print("OddOccurrencesInArray : test case 1's  result : ");
		System.out.println(solution(new int[] {9, 3, 9, 3, 9, 7, 9}));  // 7
		
		System.out.print("OddOccurrencesInArray : test case 2's  result : ");
		System.out.println(solution2(new int[] {9, 3, 9, 3, 9, 7, 9}));  // 7
	}
	
	// 해시 셋 이용 - set 은 값 중복 안되는 성질 이용
	private static  int solution(int[] A) {
        Set<Integer> checkSet = new HashSet<>();

        for (int i : A) {
            if (checkSet.contains(i))
                checkSet.remove(i);
            else
                checkSet.add(i);
        }
        
        return checkSet.iterator().next();
    }
	
	// 비트 연산자 이용 - XOR 연산자 - 각 비트를 비교하여 같으면 0 리턴, 다르면 1 리턴
	private static  int solution2(int[] A) {
		int odd = A[0];

        for (int i = 1; i < A.length; i++) {
            odd = odd ^ A[i];
        }
        return odd;
    }

}
