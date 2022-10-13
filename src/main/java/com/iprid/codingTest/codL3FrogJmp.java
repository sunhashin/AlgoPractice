package com.iprid.codingTest;

import java.util.HashSet;
import java.util.Set;

//참고 : https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
// 코딜리티 : FrogJmp , 구리가 X에 위치해 있고 Y로 이동하려고 한다. 한번에 이동할 수 있는 거리(D)가 주어졌을 때,
// 목표하는 좌표로 이동할 수 있는 최소 이동 횟수 구하는 문제 : 거리 구해서 나누기


public class codL3FrogJmp {

	public static void main(String[] args) {
		System.out.print("OddOccurrencesInArray : test case 1's  result : ");
		System.out.println(solution(10, 85, 30));  //3
	}
	 
	private static  int solution(int X, int Y, int D) {
        int answer = 0;
        int distance = Y - X;
        answer = (distance % D == 0 ) ? distance / D : distance / D + 1;

        return answer;
    }

}
