// https://www.geeksforgeeks.org/dsa/largest-subarray-with-equal-number-of-0s-and-1s/

Brute Force Approach:
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    - Use 2 nested loops to generate all subarrays.
    - For each subarray, count 0s and 1s and check if they are equal.

    class Solution {
        public int maxLen(int[] arr) {
            int n = arr.length;
            int ans = 0;
            for(int i=0; i<n; i++){
                int cur = arr[i];
                for(int j=i+1; j<n; j++){
                    cur += arr[j];
                    if(cur * 2 == (j-i+1)){
                        ans = Math.max(j-i+1, ans);
                    }
                }
            }
            
            return ans;
        }
    }

Optimized Approach 1:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Replace 0s with -1s.
    - Use a HashMap to store the first occurrence of each prefix sum.
    
    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            // Replace 0s with -1s
            for(int i=0; i<n; i++){
                if(nums[i] == 0){
                    nums[i] = -1;
                }
            }
            HashMap<Integer, Integer> prefixSumIndexMap = new HashMap<>();
            int prefixSum = 0;
            int maxLength = 0;
            prefixSumIndexMap.put(0, -1); // To handle the case when subarray starts from index 0
            for(int i=0; i<n; i++){
                prefixSum += nums[i];
                if(prefixSumIndexMap.containsKey(prefixSum)){
                    int prevIndex = prefixSumIndexMap.get(prefixSum);
                    maxLength = Math.max(maxLength, i - prevIndex);
                } else {
                    prefixSumIndexMap.put(prefixSum, i);
                }
            }
            return maxLength;
        }
    }

Optimized Approach 2:
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)

    - binary search to find the array size + silding window to check
    - low = 0 , high = n