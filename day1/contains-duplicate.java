// https://leetcode.com/problems/contains-duplicate/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - 2 for loops to compare each element with every other element.

Optimized Approach 1:
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    - Sort the array and check for adjacent duplicates.

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i=1; i<nums.length; i++){
                if(nums[i] == nums[i-1]){
                    return true;
                }
            }
            return false;
        }
    }

Optimized Approach 2:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a HashSet to track seen elements.

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> hs = new HashSet<>();
            for(int i=0; i<nums.length; i++){
                if(hs.contains(nums[i])){
                    return true;
                }
                hs.add(nums[i]);
            }
            return false;
        }
    }
