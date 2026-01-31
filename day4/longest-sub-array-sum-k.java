// https://www.geeksforgeeks.org/dsa/longest-sub-array-sum-k/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Use two nested loops to consider all sub-arrays and calculate their sums.

    class Solution {
        public int longestSubarray(int[] arr, int k) {
            // code here
            int n = arr.length;
            int ans = 0;
            
            for (int i=0; i<n; i++){
                int cur = 0;
                for(int j=i; j<n; j++){
                    cur += arr[j];
                    if(cur == k){
                        ans = Math.max(ans, j-i+1);
                    }
                }
            }
            
            return ans;
            
        }
    }

// binary search wont work here because its not F F F T T T pattern it can be F T F T F

Optimized Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a HashMap to store cumulative sums and their earliest indices.

    // User function Template for Java

    class Solution {
        public int longestSubarray(int[] arr, int k) {
            // code here
            int n = arr.length;
            int ans = 0;
            int preSum = 0;
            
            HashMap<Integer,Integer> hm = new HashMap<>();
            hm.put(0, -1);
            
            for(int i=0; i<n; i++){
                preSum += arr[i];

                if(hm.containsKey(preSum - k)){
                    ans = Math.max(ans, i - hm.get(preSum-k));
                }
                
                hm.put(preSum, hm.getOrDefault(preSum, i));
                
            }
            
            return ans;
            
        }
    }
