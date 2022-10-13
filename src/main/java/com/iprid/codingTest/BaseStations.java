package com.iprid.codingTest;

public class BaseStations {

	// 참고 : https://school.programmers.co.kr/tryouts/42735/challenges
	// 프로그래머스 - 기지국 설치
	public static void main(String[] args) {
		
		System.out.print("기지국 설치 : test case 1's  result : ");
		System.out.println(solution(11, new int[] {4, 11}, 1));  // 3
		
		System.out.print("기지국 설치 : test case 2's  result : ");
		System.out.println(solution(16, new int[] {9}, 2));  // 3
	}
	
	 private static int solution (int n, int[] stations, int w) {
	        int answer = 0;
	        int index = 1;
	        int stationIndex = 0;
	        
	        do {
	             
	            // 이미 기존 기지국이 있거나, 현재 위치가 왼쪽 전파범위 오른쪽에 있는 경우
	            if (stationIndex < stations.length &&  stations[stationIndex] - w <= index) {
	                index = stations[stationIndex] + w + 1;
	                stationIndex += 1;
	            } else {  // 최초의 기지국을 세우는 경우
	                answer++;
	                index += w * 2 + 1;
	            }

	        } while (index <= n);
	         
	        return answer;
	    }
}
