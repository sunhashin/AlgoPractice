package com.iprid.codingTest;

import java.util.Arrays;

//참고 : https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
//코딜리티 : NumberOfDiscIntersections,
/*

   J번째 디스크의 중심 : (J,0)과 반경 A[J]로 그려짐
   J번째랑 K번째 디스크가 J ≠ K 이고 적어도 하나의 공통점을 가지면 교차한다.
   배열A개 주어졌을 때 교차하는 디스크의 수를 반환하라!
   교차 쌍이 10,000,000을 초과하면 함수는 -1을 반환
   
    교차하거나 원을 포함하는 디스크의 개수를 구해야 함. ◦해당 위치에 도달하는 디스크들의 수
    현재 J 기준으로 반지름을 구해서 lower, upper 배열에 담는다. ◦lower 배열 : J - A[J]
	upper 배열: J + A[J]
	각 배열을 정렬한다.
	upper 보다 작은 lower 들은 반드시 가장 작은 upper 보다 큰 반지름을 갖는다. = 접점
	다음 upper 에서 겹치지 않게 현재 J 만큼 빼준다.
   
 */

public class codL6NumberOfDiscIntersections {

	public static void main(String[] args) {
		System.out.print("NumberOfDiscIntersections : test case 1's  result : ");
		System.out.println(solution(new int[] {1, 5, 2, 1, 4, 0}));  // 11
	}	
 
	private static int solution(int[] A) {
        int N = A.length, intersection = 0, j =0;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for (int i = 0; i < N; i++) {
            lower[i] = i - (long) A[i];
            upper[i] = i + (long) A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        for (int i = 0; i < N; i++) {
            while (j < N && upper[i] >= lower[j]) {
                intersection += j;
                intersection -= i;
                j++;
            }  
        }

        if (intersection > 10000000) return -1;
        return intersection;
    }
}
