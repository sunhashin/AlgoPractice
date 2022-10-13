package com.iprid.codingTest;
import java.util.Queue;
import java.util.LinkedList;

class Position {
    int x, y;
    Position (int x, int y) {
        this.x = x;
        this.y = y;
    }
    boolean isValid(int width, int height) {
        if (x < 0 || x >= width) return false;
        if (y < 0 || y >= height) return false;
        return true;
    }
}

public class ShortestMapPath {

	// 참고 : https://school.programmers.co.kr/tryouts/42746/challenges
	// BFS : 프로그래머스 - 게임 맵 최단거리
	public static void main(String[] args) {
		
		System.out.print("게임 맵 최단거리 : test case 1's  result : ");
		System.out.println(solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));  // 11
		
		System.out.print("게임 맵 최단거리 : test case 2's  result : ");
		System.out.println(solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}}));  // -1
	}

    private static int solution(int[][] maps) {
        // 변수선언
        int answer;
        int mapHeight = maps.length;
        int mapWidth = maps[0].length;
        
        // 초기화
        Queue<Position> que = new LinkedList<>();       // BFS
        int[][] count = new int[mapHeight][mapWidth];   // 방문 카운트
        boolean[][] visited = new boolean[mapHeight][mapWidth];  // 방문배열
        
        // 현재 위치 셋팅
        que.offer(new Position(0, 0));
        count[0][0] = 1;
        visited[0][0] = true;
        
        while (! que.isEmpty()) {
            
            Position current = que.poll();
            int currentCount = count[current.y][current.x];
            
            // 동서남북 순회 위해서 방향 배열선언해서 루프
            final int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            for (int i = 0; i < direction.length; i++) {
                
                // 다음 위치 position 객체 생성
                Position moved = new Position(current.x + direction[i][0], current.y + direction[i][1]);
                
                // 다음번 위치들에 대한 유효성 체크
                if (! moved.isValid(mapWidth, mapHeight)) continue;          // 올바른 길의 범위가 아니면 패스
                if (visited[moved.y][moved.x]) continue;               // 이미 방문했으면 패스
                if (maps[moved.y][moved.x] == 0) continue;                  // 벽 0, 길 1 (벽이면 패스)
                
                // 정상 방문인 경우 로직 처리 (currentCount 올리고, 방문처리하고, 신규 이동한 객체를 큐에 담기)
                count[moved.y][moved.x] = currentCount + 1;
                visited[moved.y][moved.x] = true;
                que.offer(moved);
            }
            
        }
        
        // 마지막 위치가 모두 방문한 카운트 수, 없는 경우 -1 리턴
        answer = count[mapHeight-1][mapWidth-1];
        if (answer == 0) return -1;
        return answer;
        
    }

}
