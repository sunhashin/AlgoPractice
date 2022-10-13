package com.iprid.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 참고 : https://nanamare.tistory.com/162
// DFS : 완전 탐색으로 섬 개수와 섬을 둘러싼 둘레 구하기
public class IslandCountAndLength {

	public static void main(String[] args) {
		System.out.print("섬 개수 구하기 : ");
		System.out.println(solution(new int[][] {{1, 0, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 1, 1}}));  // 3
		System.out.print("섬 둘레 길이 구하기 : ");
		System.out.println(solution2(new int[][] {{1, 0, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 1, 1}}));  // 18
	}
	
	// 둘레 구하기
	private static int solution2(int[][] island) {
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		int n = island.length;
		
		List<Integer> checked = new ArrayList<>();
		
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island.length; j++) {
				if (island[i][j] == 1) {
					int nearBy = 0;
					
					for (int direction = 0; direction < 4; direction++) {
						int ny = i + dx[direction];
						int nx = j + dy[direction];
						
						if (0 <= ny && ny < n && 0 <= nx && nx < n) {
							if (island[ny][nx] == 1)
								nearBy++;
						}
					}
					// 선분 계산
					checked.add(4  - nearBy);
				}
			}
		}
		return checked.stream().reduce(0,  Integer::sum);
	}
	
	// 섬 갯수 구하기
	private static int solution(int[][] sum) {
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		int n = sum.length;
		
		boolean[][] checked = new boolean[n][n];
		int[] groups = new int[n * n];
		int idx = -1;
		for (int sy = 0; sy < sum.length; sy++) {
			for (int sx = 0; sx < sum.length; sx++) {
				if (sum[sy][sx] == 1 && ! checked[sy][sx]) {
					idx++;
					dfs(sum, sy, sx, idx, checked, groups, dy, dx);
				}
			}
		}
		return (int) Arrays.stream(groups).filter(group -> group != 0).count();
	}
	
	private static void dfs(int[][] sum, int sy, int sx, int idx, boolean[][] checked, int[] group, int[] dy, int[] dx) {
		checked[sy][sx] = true;
		group[idx]++;
		
		for (int i = 0; i < 4; i++) {
			int ny = sy + dy[i];
			int nx = sx + dx[i];
			
			if (ny < 0 || ny >= sum.length || nx < 0 || nx >= sum.length) continue;
			
			if (sum[ny][nx] == 1 && ! checked[ny][nx]) {
				dfs(sum, ny, nx, idx, checked, group, dy, dx);
			}
		}
	}
}
