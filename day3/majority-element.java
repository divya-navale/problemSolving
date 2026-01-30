// https://leetcode.com/problems/majority-element/description/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - For each element, count its occurrences in the array.

Optimized Approach 1:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a HashMap to count occurrences of each element.

    class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            int n = nums.length;
            for(int num : nums){
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                if(countMap.get(num) > n/2){
                    return num;
                }
            }
            return -1; // This line will never be reached as per problem constraints
        }
    }

Optimized Approach 2:
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    - Sorting the array and returning the middle element.

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

Optimized Approach 3:
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Boyer-Moore Voting Algorithm.
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
    }