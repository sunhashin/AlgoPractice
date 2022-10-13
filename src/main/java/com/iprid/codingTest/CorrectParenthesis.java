package com.iprid.codingTest;

import java.util.Stack;

class P {
    int open, close;
    
    P (int open, int close) {
        this.open = open;
        this.close = close;
    }
 }

public class CorrectParenthesis {
	// 참고 : https://school.programmers.co.kr/tryouts/42745/challenges
	// 프로그래머스 - 올바른 괄호의 갯수
	public static void main(String[] args) {
		System.out.print("올바른 괄호의 갯수 : test case 1's  result : ");
		System.out.println(solution(2));  // 2
		
		System.out.print("올바른 괄호의 갯수 : test case 2's  result : ");
		System.out.println(solution(3));  // 5
	}

	 private static int solution(int n) {
	        int answer = 0;
	        Stack<P> stk = new Stack<>();
	        stk.push(new P(0, 0));  //  시작값, 괄호의 개수가 0개부터 시작하므로
	        
	        while (! stk.isEmpty()) {
	            P p = stk.pop();
	            
	            // 닫히는 괄호 개수는 N보다 커질 수 없음
	            if (p.open > n) continue;
	            
	            // 열리는 괄호 개수가 닫히는 개수보다 크면 안됨
	            if (p.open < p.close) continue;
	            
	            // 열리고 닫힌 횟수가  전체 개수 초과하면 더 이상 수행할 필요가 없음(n은 괄호상의 갯수 -> 전체 괄호수는 2배)
	            if (p.open + p.close == 2 * n) {
	                answer++;
	                continue;
	            }
	            
	            stk.push(new P(p.open + 1, p.close));   // open count 증가
	            stk.push(new P(p.open , p.close + 1));  // close count 증가
	        }
	        return answer;
	    }
}
