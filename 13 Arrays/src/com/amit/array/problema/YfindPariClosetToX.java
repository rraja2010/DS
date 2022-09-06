package com.amit.array.problema;
/*
Given a sorted array and a number x, find the pair in array whose sum is closest to x

Problem :
Given a sorted array,we need to find a pair whose sum is closed to number X in Array.

For example:
array[]={-40,-5,1,3,6,7,8,20};
The pair whose sum is closest to 5 :  1 and 3
 
*/
public class YfindPariClosetToX {
	public static void main(String[] args) {
		int array[] = { -40, -5, 1, 3, 6, 7, 8, 20 };
		findPairWithClosestToXBruteForce(array, 5);
		findPairWithClosestToX(array, 5);
	}

	//Time complexity : O(n^2)
	public static void findPairWithClosestToXBruteForce(int arr[], int X) {
		if (arr.length < 2)
			return;
		// Suppose 1st two element has minimum diff with X
		int minimumDiff = Math.abs(arr[0] + arr[1] - X);
		int pair1stIndex = 0;
		int pair2ndIndex = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tempDiff = Math.abs(arr[i] + arr[j] - X);

				if (tempDiff < minimumDiff) {
					pair1stIndex = i;
					pair2ndIndex = j;
					minimumDiff = tempDiff;
				}
			}
		}
		System.out.println(" The pair whose sum is closest to X using brute force method: " + arr[pair1stIndex] + " "
				+ arr[pair2ndIndex]);
	}

	//Time complexity : O(NLogN)
	public static void findPairWithClosestToX(int arr[], int X) {
		int minimumDiff = Integer.MAX_VALUE;
		int n = arr.length;
		if (n < 0)
			return;
		// left and right index variables
		int l = 0, r = n - 1;

		// variable to keep track of the left and right pair for minimumSum
		int minLeft = l, minRight = n - 1;

		while (l < r) {

			int currentDiff = Math.abs(arr[l] + arr[r] - X);
			/* If abs(diff) is less than min dif, we need to update sum and pair */
			if (currentDiff < minimumDiff) {
				minimumDiff = currentDiff;
				minLeft = l;
				minRight = r;
			}
			if (arr[l] + arr[r] < X)
				l++;
			else
				r--;
		}

		System.out.println(" The pair whose sum is closest to X : " + arr[minLeft] + " " + arr[minRight]);
	}
}
