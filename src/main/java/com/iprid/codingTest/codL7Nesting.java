package com.iprid.codingTest;

import java.util.Stack;

//참고 : https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
// 코딜리티 : Nesting , 브라켓이 중첩되면 1, 아니면 0 반환
public class codL7Nesting {

	public static void main(String[] args) {
		System.out.print("Nesting : test case 1's  result : ");
		System.out.println(solution("(()(())())"));  // 1
		
		System.out.print("Nesting : test case 2's  result : ");
		System.out.println(solution("())"));  // 0
		 
	}
	
	private static int solution(String S) {
		// 중첩되면 1, 아니면 0 반환
        Stack<Character> stk = new Stack<>();
        char openValue;

        for (char ct : S.toCharArray()) {
            if (ct == '(') {
                stk.push(ct);
            } else {
                if (stk.empty()) return 0;
                openValue = stk.peek();

                if (ct == ')' && openValue != '(') {
                    return 0;
                } else {
                    stk.pop();
                }
                
            }
        }
        return stk.isEmpty() ? 1 : 0;
    }

}
