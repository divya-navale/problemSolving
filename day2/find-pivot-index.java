// https://leetcode.com/problems/find-pivot-index/description/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - For each index, calculate the sum of elements on the left and right sides.

Optimized Approach 1:
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Calculate the total sum of the array.
    - Iterate through the array, maintaining a running sum of the left side.
    - right part + pivot + leftpart = totalSum where right part = left part

    class Solution {
        public int pivotIndex(int[] nums) {
            int totalSum = 0;
            for(int num : nums){
                totalSum += num;
            }

            int leftSum = 0;
            for(int i=0; i<nums.length; i++){
                if(leftSum == totalSum - leftSum - nums[i]){
                    return i;
                }
                leftSum += nums[i];
            }
            return -1;
        }
    }

Optimized Approach 2:
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Prefix sum approach.
    
    class Solution {
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];
            for(int i=1; i<n; i++){
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }
            for(int i=0; i<n; i++){
                int leftSum = i == 0 ? 0 : prefixSum[i-1];
                int rightSum = prefixSum[n-1] - prefixSum[i];
                if(leftSum == rightSum){
                    return i;
                }
            }
            return -1;
        }
    }