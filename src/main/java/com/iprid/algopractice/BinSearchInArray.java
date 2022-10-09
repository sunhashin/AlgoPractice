package com.iprid.algopractice;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class BinSearchInArray {
	
	static class PhysData {
		
		private String name;
		private int height;
		private double vision;
		
		public PhysData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		@Override
		public String toString() {
			return "PhysData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
		}
		
		// 오름차순 정렬 comparator
		public static final Comparator<PhysData> HEIGHT_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhysData> {
			public int compare(PhysData d1, PhysData d2) {
				return (d1.height > d2.height) ? 1 :
								(d1.height < d2.height) ? -1 : 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		PhysData[] x = {
			new PhysData("이나령", 162, 0.3),
			new PhysData("김민하", 168, 0.4),
			new PhysData("김한결", 169, 1.5),
			new PhysData("홍준기", 174, 0.7),
			new PhysData("전서현", 181, 0.8),
			new PhysData("이수민", 190, 0.5)
		};
		System.out.println("몇 cm인 사람을 찾고 있나요? : ");
		
		int height = stdIn.nextInt();
		
		int idx = Arrays.binarySearch(
				x,
				new PhysData("", height, 0.0), 
				PhysData.HEIGHT_ORDER
				);
		
		if (idx < 0) {
			System.out.println("요소가 없습니다.");
		} else {
			System.out.println("x[" + idx + "]에 있습니다.");
			System.out.println("찾은 데이터 : " + x[idx]);
		}
	}
	
}
