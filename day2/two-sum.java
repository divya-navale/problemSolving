// https://leetcode.com/problems/two-sum/description/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - 2 for loops to check each pair of elements.

Optimized Approach 1:
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    - Sort the array and use two pointers to find the target sum.

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            int[] sorted = nums.clone();
            Arrays.sort(sorted);
            int left = 0;
            int right = n-1;
            while(left < right){
                int curSum = sorted[left] + sorted[right];
                if(curSum == target){
                    break;
                } else if (curSum < target){
                    left++;
                } else {
                    right--;
                }
            }

            int[] ans = new int[] {-1,-1};
            for(int i=0; i<n; i++){
                if( ans[0] == -1 && sorted[left] == nums[i]){
                    ans[0] = i;
                }
                else if(ans[1] == -1 && sorted[right] == nums[i]){
                    ans[1] = i;
                }
            }
            return ans;
        }
    }

Optimized Approach 2:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a HashMap to store the complement and its index.

    import java.util.HashMap;
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<nums.length; i++){
                int complement = target - nums[i];
                if(map.containsKey(complement)){
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }