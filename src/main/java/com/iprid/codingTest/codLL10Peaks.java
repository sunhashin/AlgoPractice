package com.iprid.codingTest;

import java.util.ArrayList;
import java.util.List;

//참고 : https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
// 코딜리티 : Peaks ,  
/*
			우선 봉우리가 될 수 있는 위치를 먼저 계산하여 변수 peaks에 저장한다.
			봉우리가 될 수 있는 기본 조건은 해당 높이가 전후 높이보다 커야 한다.
			특정 위치에 봉우리가 될 수 있는지가 중요하므로, 배열이 아니라 컬렉션으로 인덱스만 저장한다.
			반복문을 통해서 봉우리를 포함하여 나눌 수 있는 최대 블록의 수를 구한다.
			동일한 숫자의 블록으로 나눠야 하므로, 주어진 배열 A의 크기와 블록의 수를 표현하는 idx를 나눈 값이 
			정수인 경우에만 확인한다.
			
			봉우리의 위치를 저장한 변수 peaks를 반복하여 동일한 숫자의 블록이 가능한지 계산을 하고, 
			가능한 블록의 숫자가 확인되면 해당 값을 주어진 문제의 결과로 반환한다.
			반복이 끝나면 동일한 숫자의 블록으로 나눌 수 없다는 의미이므로, 0을 주어진 문제의 결과로 반환한다.
			
			or
			
			첨점을 구하는데, 해당 인덱스에 도달했을 때 첨점수를 저장한다.
			이렇게 하면 인덱스만 확인하면 첨점이 그 구간에 있는지 알 수 있다.
			이후 최대로 나눌 수 있는 블럭의 수부터 체크하면 된다.
			N은 답이 아니다. 모든 원소가 첨점이 될 수 없기 때문에, 따라서 N/2 부터 체크해 나가면 됨
*/

public class codLL10Peaks {

	public static void main(String[] args) {
		System.out.print("Peaks : test case 1's  result : ");
		System.out.println(solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));  // 3
	}
	
	private static int solution(int[] A) {
        List<Integer> peaks = getPeaks(A);

        for (int idx = A.length; idx >= 1; idx--) {
            if (A.length % idx == 0) {
                int blockSize = A.length / idx;
                int blockCount = 0;

                for (int peakIndex : peaks) {
                    if (peakIndex / blockSize == blockCount) blockCount++;
                }
                if (blockCount == idx) return blockCount;
            }
        }
        // 만약 A를 어떤 블록으로도 나눌 수 없으면 0 리턴
        return 0;
    }

    private static List<Integer> getPeaks(int[] A) {
        List<Integer> peaks = new ArrayList<>();

        for (int idx = 1; idx < A.length -1; idx++) {
            if (A[idx -1] < A[idx] && A[idx] > A[idx + 1])
                peaks.add(idx);
        }
        return peaks;
    }
}