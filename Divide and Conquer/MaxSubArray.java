public class MaxSubArray {
  // Solution 2: Divide and Conquer (TLE)
  // time: T(n) = 2 * T(n/2) + n -> O(nlogn)
  // space: logn calls -> O(logn)
  public int maxSubArray(int[] nums) {
      return helper(nums, 0, nums.length - 1);
  }
  public int helper(int[] nums, int start, int end) {
      if (start == end) {
          return nums[start];
      }
      int mid = (start + end) / 2;
      int left = helper(nums, start, mid); // maxSubArray from left half [start, mid]
      int right = helper(nums, mid + 1, end); // maxSubArray from right half [mid + 1, end]
      int leftMax = nums[mid], rightMax = nums[mid + 1];
      int leftSum = nums[mid], rightSum = nums[mid + 1];
      // find the max sum of left half starting from nums[mid] to left
      for (int i = mid - 1; i >= start; i--) {
          leftSum += nums[i];
          if (leftSum > leftMax) {
              leftMax = leftSum;
          }
      }
      // find the max sum of right half starting from num[mid + 1] to right
      for (int i = mid + 2; i <= end; i++) {
          rightSum += nums[i];
          if (rightSum > rightMax) {
              rightMax = rightSum;
          }
      }
      return Math.max(Math.max(left, right), leftMax + rightMax);
  }
}
