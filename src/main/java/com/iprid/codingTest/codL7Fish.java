package com.iprid.codingTest;

import java.util.Stack;

//참고 : https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
// 코딜리티 : Fish , 살아 있는 물고기 수 반환하기
public class codL7Fish {

	public static void main(String[] args) {
		System.out.print("Fish : test case 1's  result : ");
		System.out.println(solution(new int[] {4, 3, 2, 1, 5}, new int[] {0, 1, 0, 0, 0}));  // 2
		 
 
	}
	
	private static int solution(int[] A, int[] B) {
        Stack<Integer> stk = new Stack<>();
        int lastSize = 0, aliveCount = 0;

        // 물고기 하류 : 1, 상류 : 0
        // 두 물고기가 서로 다른 방향으로 움직이고 서로 만날 때 큰 물고기가 작은 물고기 잡아먹음
        // 살아있는 물고기의 수를 반환하라
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                stk.push(A[i]);
            } else {
                while (!stk.isEmpty()) {
                    lastSize = stk.peek();

                    if (lastSize > A[i]) {
                        break;
                    } else {
                        stk.pop();
                    }
                }
                if (stk.isEmpty()) aliveCount++;
            }
        }
        return aliveCount + stk.size();
    }

}
