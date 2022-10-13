package com.iprid.codingTest;

public class Budgets {
 
	// 참고 :  https://school.programmers.co.kr/tryouts/42737/challenges
	// 프로그래머스 - 예산
	public static void main(String[] args) {
		
		System.out.print("예산 : test case 1's  result : ");
		System.out.println(solution(new int[] {120, 110, 140, 150}, 485));  // 127
	}
	
	 private static int solution(int[] budgets, int M) {
	        int totalCity = budgets.length;
	        int averageBudget = M/totalCity;
	        int underBudget = 0;
	        int underBudgetCount = 0;
	        int biggestBudget = 0;
	        int totalBudget = 0;

	        for(int city = 0; city < totalCity; city++){
	            
	            totalBudget += budgets[city];
	            
	            if(budgets[city] < averageBudget){
	                underBudget += budgets[city];
	                underBudgetCount++;
	            }
	            
	            if(biggestBudget < budgets[city]){
	                biggestBudget = budgets[city];
	            }
	        }

	        if(totalBudget <= M)
	            return biggestBudget;

	        return (M - underBudget)/(totalCity - underBudgetCount);
	    }

}
