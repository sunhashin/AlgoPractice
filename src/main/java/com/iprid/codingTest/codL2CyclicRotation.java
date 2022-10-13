package com.iprid.codingTest;

import java.util.Arrays;

//참고 : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
// 코딜리티 : CyclicRotation , 배열(N)과 숫자(K)가 주어지면 주어진 숫자만큼 배열의 index가 shift되는 문제
//                                              배열이 전부 0이면 0을 리턴

public class codL2CyclicRotation {

	public static void main(String[] args) {
		System.out.print("CyclicRotation : test case 1's  result : ");
		System.out.println(solution(new int[] {3, 8, 9, 7, 6}, 3));  // [9, 7, 6, 3, 8]
		System.out.print("CyclicRotation : test case 2's  result : ");
		System.out.println(solution(new int[] {0, 0, 0}, 1));  //[0, 0, 0]
		System.out.print("CyclicRotation : test case 3's  result : ");
		System.out.println(solution(new int[] {1, 2, 3, 4}, 4));  // [1, 2, 3, 4]
 
	}
	
	private static  int[] solution(int[] A, int K) {
        if (K == 0) return A;

        int arrLen = A.length;
        int[] resultArray = new int[arrLen];

        for (int i = 0; i < arrLen; i++) {
            resultArray[(i + K) % arrLen] = A[i];
        }
        System.out.println(" test result array data : " + Arrays.toString(resultArray));
        
        return resultArray;
    }

}
