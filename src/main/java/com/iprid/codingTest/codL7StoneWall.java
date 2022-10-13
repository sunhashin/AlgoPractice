package com.iprid.codingTest;

import java.util.Stack;

//참고 : https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
// 코딜리티 : StoneWall , 돌담을 구성하는데 필요한 최소 블럭을 구하기
public class codL7StoneWall {

	public static void main(String[] args) {
		System.out.print("StoneWall : test case 1's  result : ");
		System.out.println(solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}));  // 7
		 
 
	}
	
	private static int solution(int[] H) {
		 Stack<Integer> stk = new Stack<>();

	        int count = 0;
	        for (int i = 0; i < H.length; i++) {

	            // 이전 높이  stk.peek() 보다 현재 높이가 낮으면 현재 높이가 H[i] 높아질 때까지 스택 제거
	            while (!stk.isEmpty() && stk.peek() > H[i]) { 
	                stk.pop();
	            }

	            // 이전 높이 stk.peek() 보다 현재 높이 H[i] 가 높으면 카운트 증가, 스택 추가
	            if (stk.isEmpty() || stk.peek() < H[i]) {
	                stk.push(H[i]);
	                count++;
	            }
	        }
	        return count;
    }

}
