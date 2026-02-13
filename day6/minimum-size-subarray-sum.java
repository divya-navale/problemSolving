// https://leetcode.com/problems/minimum-size-subarray-sum/description/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Use two nested loops to calculate the sum of every possible subarray and keep track of the minimum length of those whose sum is greater than or equal to the target.

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int n = nums.length;

            for(int i=0; i<n; i++){
                int sum = 0;
                for(int j=i; j<n; j++){
                    sum += nums[j];
                    if(sum >= target){
                        ans = Math.min(ans, (j-i+1));
                    }
                }
            }

            return (ans == Integer.MAX_VALUE) ? 0 : ans;
        }
    }

Optimized Approach (Two Pointers):
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int n = nums.length;

            int p1 = 0;
            int p2 = 0;
            int sum = 0;

            while(p2 < n){
                sum += nums[p2];
                p2++;

                while (sum >= target){
                    ans = Math.min(ans, p2-p1);
                    sum -= nums[p1];
                    p1++;
                }
            }

            return (ans == Integer.MAX_VALUE) ? 0 : ans;
        }
    }

Optimized Approach 2:
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    // binary search + sliding window
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int low = 0;
            int high = n;
            int ans = 0;

            while(low <= high){
                int mid = (low + high) /2;
                if(isValid(nums, mid, n, target)){
                    high = mid - 1;
                    ans = mid;
                } else {
                    low = mid + 1;
                }
            }

            return ans;
        }

        public boolean isValid(int[] nums, int mid, int n, int target){
            int sum = 0;
            for(int i=0; i<mid; i++){
                sum += nums[i];
            }

            if(sum >= target){
                return true;
            }

            for(int i=mid; i<n; i++){
                sum = sum - nums[i-mid] + nums[i];
                if(sum >= target){
                    return true;
                }
            }

            return false;
        }
    }


Optimized Approach 3:
    // Time Complexity: O(n)
    // Space Complexity: O(n+1)
    // prefix sum + binary search

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n+1];
            int ans = Integer.MAX_VALUE;

            prefix[0] = 0;
            for(int i=1; i<n+1; i++){
                prefix[i] = prefix[i-1] + nums[i-1];
            }

            for(int i=0; i<n+1; i++){
                // prefixSum1 - prefixSum2 >= target
                // prefixSum1 >= target + prefixSum2

                int newTarget = target + prefix[i];
                int idx = useBinarySearch(prefix, newTarget, i+1, n);
                if(idx != Integer.MAX_VALUE){
                    ans = Math.min(ans, idx - i);
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }

        public int useBinarySearch(int[] prefix, int newTarget, int low, int high){
            int ans = Integer.MAX_VALUE;

            while(low <= high){
                int mid = (low + high)/2;
                if(prefix[mid] >= newTarget){
                    ans = Math.min(ans, mid);
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return ans;
        }
    }