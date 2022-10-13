package com.iprid.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsTest {

	public static void main(String[] args) {
		String[] arr = {"A", "B", "C"};
		// 1. 배열 -> List (primitive type 제외)
		// 1-1 . Arrays.asList(arr) : 동기화 이슈
		// 1-2. new ArrayList<>(Arrays.asList(arr));
		// 1-3. Collections.toList()  : java 8 이상
		List<String> list = Arrays.asList(arr);
		
		List<String> list2 = new ArrayList<>(Arrays.asList(arr));
		
		List<String> list3 = Stream.of(arr).collect(Collectors.toList());
		
		// 2. List -> 배열
		// 리스트.toArray()
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("A");
		arrList.add("B");
		arrList.add("C");
		
		int arrListSize = arrList.size();
		String[] arr2 = arrList.toArray(new String[arrListSize]);
		String[] arr3 = arrList.toArray(new String[0]);
		
		
		// 3. 배열 -> List (primitive type인 경우)
		// 3-1. 반복문 for () List.add()
		// 3-2. Stream 사용
		int[] checkArray = new int[] {1, 2,  5, 20, 20};
		
		List<Integer> intList = new ArrayList<>();
		for (int element : checkArray) {
			intList.add(element);
		}
		System.out.println("intList size " + intList.size() + "\n intList : " + intList);
		
		List<Integer> intList2 = Arrays.stream(checkArray)
														.boxed()
														.collect(Collectors.toList());
		
		System.out.println("--------------------------");
		 
		// Collections.sort 사용 테스트 1
		List<String> checks = Arrays.asList("아침", "점심", "저녁", "간식", "야식", "굶기");
		Collections.sort(checks, new Comparator<String>() {
			 @Override
			public int compare(String o1, String o2) {
				 return o1.length() - o2.length();  // 문자열 길이
			}
		});
		
		for (String chk : checks) {
			System.out.println(chk);
		}
		System.out.println("--------------------------");
		
		List<String> checks2 = Arrays.asList("아침", "점심", "저녁", "간식", "야식", "굶기");
		Collections.sort(checks2, new Comparator<String>() {
			 @Override
			public int compare(String o1, String o2) {
				 return o1.compareTo(o2);  // 사전 순 정렬 (알파벳 순)
			}
		});
		
		for (String chk2 : checks2) {
			System.out.println(chk2);
		}
		System.out.println("--------------------------");
		 
		List<String> checks3 = Arrays.asList("아침", "점심", "저녁", "간식", "야식", "굶기");
		Collections.sort(checks3, (String a, String b) -> {
			return a.compareTo(b);
		});
		
		for (String chk3 : checks3) {
			System.out.println(chk3);
		}
		System.out.println("--------------------------");
		
		 
		List<String> checks4 = Arrays.asList("아침", "점심", "저녁", "간식", "야식", "굶기");
		Collections.sort(checks4, (a,  b) ->  a.compareTo(b));
		
		for (String chk4 : checks4) {
			System.out.println(chk4);
		}
		System.out.println("--------------------------");
	}
	
}
