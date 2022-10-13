package com.iprid.codingTest;

import java.util.Stack;

//참고 : https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
// 코딜리티 : Brackets
public class codL7Brackets {

	public static void main(String[] args) {
		System.out.print("bracket : test case 1's  result : ");
		System.out.println(solution("{[()()]}"));  // 1
		
		System.out.print("bracket : test case 2's  result : ");
		System.out.println(solution("([)()]"));  // 0
	}
	
	private static int solution(String S) {
        Stack<Character> stk = new Stack<>();
        char openValue;

        for (char ch : S.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stk.push(ch);
            } else {
                if (stk.empty()) return 0;

                openValue = stk.pop();

                if (ch == ']' && openValue != '[') return 0;
                if (ch == '}' && openValue != '{') return 0;
                if (ch == ')' && openValue != '(') return 0;

            }
        }
        return stk.isEmpty() ? 1 : 0;
    }

}
