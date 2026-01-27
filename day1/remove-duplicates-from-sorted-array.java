// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

Brute Force Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    - create a new array and copy only unique elements.
    - Finally, copy back the unique elements to the original array.

Optimized Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Use two pointers to overwrite duplicates in place.

    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int k = 0;
            int p1 = 0;
            int p2 = 0;
            while(p2 < n){
                while(p2 < n && p1 < n && nums[p1] == nums[p2]){
                    p2++;
                }
                nums[k] = nums[p1];
                p1 = p2;
                k++;
            }
            return k;
        }
    }