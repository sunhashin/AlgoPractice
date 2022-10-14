package com.iprid.codingTest;

import java.util.Arrays;

//참고 : https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
//코딜리티 : MinAvgTwoSlice, String 에 대응하는 sub string 최소값 구하기
/*  	접근방법: 
		
		(P, Q)라는 slice로 list를 자를 수 있음 (0<= P < Q < N)
		예: A = [4, 2, 2, 5, 1, 5, 8], (1, 2) 이면 (2+2) / 2 = 2 (자른 list의 평균) 
		(1, 4): (2+2+5+1)/4 = 2.5 ==> 평균이 최소가 되는 slice의 시작점 찾기 (위의 예: return 1) 
		
		1.배열에서 범위를 정한 후 그 범위 안의 요소의 평균값이 가장 작은 경우의 시작 인덱스를 리턴하는 문제
		2.원소 2개와 3개의 경우만 평균을 구해서 최소값을 리턴한다.
*/

public class codL5MinAvgTwoSlice {

	public static void main(String[] args) {
		System.out.print("MinAvgTwoSlice : test case 1's  result : ");
		System.out.println(solution(new int[] {4, 2, 2, 5, 1, 5, 8}));  // 1
 
	}
 
	private static int solution(int[] A) {
        int startIndex = 0;
        float avg;
        float minValue = Float.MAX_VALUE;

        // 배열 범위를 정한 후 그 범위안의 요소의 평균값이 가장 작은 경우의 인덱스 리턴
        // 원소 2개와 3개의 평균을 구해서 최소값 리턴
        for (int i = 0; i < A.length; i++) {
            avg = 0;

            // 2의 평균
            if (i + 1 < A.length) {
                avg = (float)((A[i] + A[i+1]) / 2.0);
                if (avg < minValue) {
                    minValue = avg;
                    startIndex = i;
                }
                    
            }
            // 3의 평균
            if (i + 2 < A.length) {
                avg = (float)((A[i] + A[i + 1] + A[i + 2]) / 3.0);
                if (avg < minValue) {
                    minValue = avg;
                    startIndex = i;
                }
            }
             
        }
        return startIndex;
    }
}
