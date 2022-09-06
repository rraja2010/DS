package leet.code.general;
/*
You are given an integer array nums. 
	You are initially positioned at the array's first index, 
		and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 
Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


*/
public class MJumpGameI {
	public static void main(String[] args) {
		int [] nums1 = {2,3,1,1,4};
		int [] nums2 = {3,2,1,0,4};
		System.out.println(canJump(nums1));
		System.out.println(canJump(nums2));
	}
	
	public static boolean canJump(int[] nums) {
		int n = nums.length;

		// Considering Last index is the goodIndex
		int goodIndex = n - 1;

		for (int curPos = n - 2; curPos >= 0; curPos--) {
			if (curPos + nums[curPos] >= goodIndex) {
				goodIndex = curPos;
			}
		}
		if (goodIndex == 0)
			return true;
		return false;
	}
}
