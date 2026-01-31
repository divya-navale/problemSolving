// https://leetcode.com/problems/subarray-sum-equals-k/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Use two nested loops to consider all subarrays and calculate their sums.

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int n = nums.length;
            for(int i=0; i<n; i++){
                int sum = 0;
                for(int j=i; j<n; j++){
                    sum += nums[j];
                    if(sum == k){
                        count++;
                    }
                }
            }
            return count;
        }
    }

Optimized Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a HashMap to store the cumulative sum frequencies.
    
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // prefix Sum + HashMap<prefixSum, count>
            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(0,1); // default value so that when i get prefix sum = k i count it as one
            int prefixSum = 0;
            int ans = 0;
            for(int i=0; i<nums.length; i++){
                prefixSum += nums[i];
                ans += hm.getOrDefault(prefixSum - k, 0);
                hm.put(prefixSum, hm.getOrDefault(prefixSum, 0)+1);
            }
            return ans;
        }
    }