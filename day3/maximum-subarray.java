// https://leetcode.com/problems/maximum-subarray/
Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - 2 for loops to check each subarray sum.

Optimized Approach 1:
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Kadane`s Algorithm to find maximum subarray sum in a single pass.

    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSoFar = nums[0];
            int maxEndingHere = nums[0];

            for(int i=1; i<nums.length; i++){
                maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            return maxSoFar;
        }
    }


Optimized Approach 2:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Prefix and suffix sums to find maximum subarray sum.
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];
            for(int i=1; i<n; i++){
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }

            int maxSum = nums[0];
            for(int i=0; i<n; i++){
                for(int j=i; j<n; j++){
                    int curSum = prefixSum[j] - (i == 0 ? 0 : prefixSum[i-1]);
                    maxSum = Math.max(maxSum, curSum);
                }
            }
            return maxSum;
        }
    }