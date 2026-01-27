// https://leetcode.com/problems/find-the-duplicate-number/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - 2 for loops to compare each element with every other element.

Optimized Approach 1:
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    - Sort the array and check for adjacent duplicates.
    class Solution {
        public int findDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i=1; i<nums.length; i++){
                if(nums[i] == nums[i-1]){
                    return nums[i];
                }
            }
            return -1;
        }
    }

Optimized Approach 2:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a HashSet to track seen elements.
    class Solution {
        public int findDuplicate(int[] nums) {
            HashSet<Integer> hs = new HashSet<>();
            for(int i=0; i<nums.length; i++){
                if(hs.contains(nums[i])){
                    return nums[i];
                }
                hs.add(nums[i]);
            }
            return -1;
        }
    }

Optimized Approach 3 (Floyd`s Tortoise and Hare):
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Use two pointers to detect the cycle.
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[0];
            // Finding the intersection point in the cycle
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            // Finding the entrance to the cycle
            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }

Optimized Approach 4 (Negative Marking):
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Use the input array to mark visited numbers by negating the value at the index corresponding to the number.
    class Solution {
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]);
                if (nums[index] < 0) {
                    return index;
                }
                nums[index] = -nums[index];
            }
            return -1;
        }
    }

Optimized Approach 5 (Binary Search):
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    - Use binary search on the range of numbers to count how many numbers are less than or equal to mid.
    class Solution {
        public int findDuplicate(int[] nums) {
            int left = 1;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        count++;
                    }
                }
                if (count > mid) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

Optimized Approach 6 (Bit Manipulation):
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    - Use bit manipulation to reconstruct the duplicate number bit by bit.
    class Solution {
        public int findDuplicate(int[] nums) {
            int n = nums.length - 1;
            int duplicate = 0;
            for (int bit = 0; bit < 32; bit++) {
                int countNums = 0;
                int countRange = 0;
                for (int num : nums) {
                    if ((num & (1 << bit)) != 0) {
                        countNums++;
                    }
                }
                for (int i = 1; i <= n; i++) {
                    if ((i & (1 << bit)) != 0) {
                        countRange++;
                    }
                }
                if (countNums > countRange) {
                    duplicate |= (1 << bit);
                }
            }
            return duplicate;
        }
    }