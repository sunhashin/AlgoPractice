package com.iprid.codingTest;

import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
// 코딜리티 : MinPerimeterRectangle , N 이 주어졌고, i * j = N 인 i, j 중에 i + j 가 가장 작은 쌍을 구하라

public class codLL10MinPerimeterRectangle {

	public static void main(String[] args) {
		System.out.print("MinPerimeterRectangle : test case 1's  result : ");
		System.out.println(solution(30));  // 22
	}
	
	private static int solution(int N) {
        int i = 1;
        int j;
        int min = Integer.MAX_VALUE;

        while ((float) i * i <= N) {
            if (N % i == 0) {
                j = N / i;
                min = Math.min(i + j, min);
            }
            i++;
        }

        if (min == Integer.MAX_VALUE) {
            min = 2;
        }
        return min * 2;
    }
}