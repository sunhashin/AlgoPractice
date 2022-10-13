package com.iprid.codingTest;

import java.util.Arrays;

public class Camouflage {
	
	// 참고 : https://school.programmers.co.kr/tryouts/42744/challenges
	// 프로그래머스 - 위장
	public static void main(String[] args) {
		 System.out.print("위장 : test case 1's  result : ");
		System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));  // 5
		
		System.out.print("위장 : test case 2's  result : ");
		System.out.println(solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));  // 3
		 
	}
	
	private static int solution(String[][] clothes) {
        int answer = Arrays.stream(clothes)
            .map(c -> c[1])
            .distinct()
            .map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())
            .map(c -> c + 1)
            .reduce(1, (c, n) -> c * n);
            // reduce 초기값 1, c : front, n : end // front 와 end 가 들어오면 누적해서 곱해줘라
        
        return answer -1;   // 입지 않는 케이스들도 위에서 1회 더해줘서 곱해줬으므로 1빼줌
 
    }

}
