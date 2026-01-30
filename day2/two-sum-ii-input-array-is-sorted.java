// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - 2 for loops to check each pair of elements.

Optimized Approach 1:
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Use two pointers to find the target sum.

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[]{-1, -1};
        }
    }

Optimized Approach 2:
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    - For each element, use binary search to find the complement.
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            for(int i=0; i<n; i++){
                int idx = binarySearch(numbers, n-1, target-numbers[i], i+1);
                if(idx != -1){
                    return new int[] {i+1, idx +1};
                }
            }

            return new int[] {-1, -1};
        }

        public int binarySearch(int[] nums, int high, int val, int low){
            while(low <= high){
                int mid = (low + high)/2;
                if(nums[mid] == val){
                    return mid;
                } else if(nums[mid] < val){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            return -1;
        }
    }
