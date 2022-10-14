package com.iprid.codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//참고 : https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
// 코딜리티 : ChocolatesByNumbers ,   최대 공약수를 구해서 (초콜렛개수/최대공약수)
/*

			Euclidean Algorithm을 사용하는 문제이다.
			
			Euclidean Algorithm은 O(log(min(a, b)))의 시간복잡도를 가지며, 다음이 성립한다.
			f(a, b) = gcd(a, b)일 때, a mod b = 0이면 f(a, b) = b이고, 
			a mod b != 0이면 f(a, b) = f(b, a mod b)이다.
			그리고 최소 공배수의 성질에 따라 lcm(a, b) = a * b / gcd(a, b)이 성립한다.
			 
*/

public class codLL12ChocolatesByNumbers {

	public static void main(String[] args) {
		System.out.print("ChocolatesByNumbers : test case 1's  result : ");
		System.out.println(solution(10, 4));  // 5
	}
	
	private static int solution(int N, int M) {
        int gcd = gcd(N, M);

        return N / gcd;
    }
    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        
        return gcd(b, a % b);
    }
}