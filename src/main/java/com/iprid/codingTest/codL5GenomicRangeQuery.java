package com.iprid.codingTest;

import java.util.Arrays;

// 참고 : https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
// 코딜리티 : MinAvgTwoSlice, String 에 대응하는 sub string 최소값 구하기
/*  	접근방법: 
			Symbol A,C,G,T중 impact factors가 가장 낮은 A(1), C(2), G(3), T(4)순으로 처리한다.
			4가지 중 1개는 무조건 출현하므로 A, C, G만 메모리에 저장하고 출현하지 않은 경우 T로 본다.
			연속된 범위에 대한 조회이므로 Range Query Start index, End index 특정값의 차이로 출현여부를 알 수 있도록
			 각 Symbol별 출현횟수를 누적으로 저장하고 계산한다.
			
			주의사항:
			Range Query Start index부터 조회하면 해당 index를 반영하지 못하므로 바로 이전 index부터 계산한다.
 */

public class codL5GenomicRangeQuery {

	public static void main(String[] args) {
		System.out.print("MinAvgTwoSlice : test case 1's  result : ");
		System.out.println(solution("CAGCCTA", new int[] {2, 5, 0}, new int[]{4, 5, 6}));  // [2, 4, 1]
 
	}
 
	private static int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int[] A = new int[N + 1];
        int[] C = new int[N + 1];
        int[] G = new int[N + 1];

        char[] ch = S.toCharArray();
  
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'A') {
                A[i+1] = A[i] + 1; 
                C[i+1] = C[i]; 
                G[i+1] = G[i];
            } else if (ch[i] == 'C') {
                A[i+1] = A[i]; 
                C[i+1] = C[i] + 1; 
                G[i+1] = G[i];
            } else if (ch[i] == 'G') {
                A[i+1] = A[i]; 
                C[i+1] = C[i]; 
                G[i+1] = G[i] + 1;
            } else {
                A[i+1] = A[i]; 
                C[i+1] = C[i]; 
                G[i+1] = G[i];
            }
        }
 
        int M = Q.length;
        int[] minFactor = new int[M];
        int start, end, factor;

        for (int i = 0; i < M; i++) {
            start = P[i];
            end = Q[i] + 1;
             
            if (A[end] > A[start]) {         
                factor = 1;
            } else if (C[end] > C[start]) {
                factor = 2;
            } else if (G[end] > G[start]) {
                factor = 3;
            } else {
                factor = 4;
            }
            minFactor[i] = factor;
        }
         System.out.println(Arrays.toString(minFactor));
        return minFactor;

    }
}
