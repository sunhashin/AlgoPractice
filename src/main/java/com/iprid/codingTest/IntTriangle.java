package com.iprid.codingTest;

public class IntTriangle {

	// 참고 : https://school.programmers.co.kr/tryouts/42747/challenges
	// 프로그래머스 - 정수 삼각형
	public static void main(String[] args) {
		System.out.print("정수 삼각형 : test case 1's  result : ");
		System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));  // 30
		
	}
	
	 // 상향식 접근
    private static int solution(int[][] triangle) {
        
        // 길이 -2부터 순회하는 이유는 맨 아래줄을 제외하고 시작
        // => 아래와 비교해서 위로 울라가므로
         for (int i = triangle.length -2; i >= 0; i--) {  
             
             // 한 행내에서 오른쪽 끝까지 돔
             for (int j = 0; j < triangle[i].length; j++) {
                 
                 // 현재값의 아랫열 왼쪽 값과 더해봄
                 int left = triangle[i][j] + triangle[i+1][j];
                 
                 // 현재값의 아랫열 오른쪽 값과 더해봄
                 int right = triangle[i][j] + triangle[i+1][j+1];
                 
                 // 현재의 왼쪽 갑소가 오른쪽 갑 중 큰 값을 대채해서 넣음
                 triangle[i][j] = Math.max(left, right);
             }
         }
         // 이런식으로 반복하면 최종 값은 맨 위 루트 노드에 존재하게 됨(루프를 아래서부터 돌려서 올라가므로)
        return triangle[0][0];
    }
}
