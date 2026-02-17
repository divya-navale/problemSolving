// https://leetcode.com/problems/container-with-most-water/description/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Use two nested loops to check every possible pair of lines and calculate the area formed by them, keeping track of the maximum area.

    class Solution {
        public int maxArea(int[] height) {
            int ans = 0;
            int n = height.length;

            for(int i=0;i <n; i++){
                for(int j=i+1; j<n; j++){
                    ans = Math.max(ans, Math.min(height[i], height[j]) * (j-i));
                }
            }
            return ans;
        }
    }

Optimized Approach (Two Pointers):
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Use two pointers, one at the beginning and one at the end of the array, and move the pointer that points to the shorter line inward, calculating the area at each step and keeping track of the maximum area.

    class Solution {
    public int maxArea(int[] height) {
            int ans = 0;
            int n = height.length;
            int left = 0;
            int right = n-1;

            while(left < right){
                ans = Math.max(ans, Math.min(height[left], height[right]) * (right-left));

                if(height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return ans;
        }
    }