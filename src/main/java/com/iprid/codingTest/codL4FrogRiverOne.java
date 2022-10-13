package com.iprid.codingTest;

import java.util.HashSet;
import java.util.Set;

// 참고 : https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
// 코딜리티 : FrogRiverOne, 개구리가 X+1 지점까지 가고 싶은데, 1부터 X지점을 무조건 거쳐야 한다
//      A = {1, 3, 1, 4, 2, 3, 5, 4} 이고 X=5 일 때 A[6] 위치까지 갔을 때 1~5까지 다 거쳤으므로 return 6
//                                              > HashSet 이용해서 X보다 작은 값 있을 경우 값을 채워주고
//                                                HashSet의 사이즈가 X와 같을 경우 그때의 index를 리턴

public class codL4FrogRiverOne {

	public static void main(String[] args) {
		System.out.print("FrogRiverOne : test case 1's  result : ");
		System.out.println(solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));  // 6
	}
 
	private static int solution(int X, int[] A) {
        int answer = -1;
        Set<Integer> checkSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                if (!checkSet.contains(A[i]))
                    checkSet.add(A[i]);
                
                if (checkSet.size() == X)
                    return i;
            }
        }
        return answer;
    }
}
