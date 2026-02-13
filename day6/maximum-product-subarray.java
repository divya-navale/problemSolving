https://leetcode.com/problems/maximum-product-subarray/description/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Use two nested loops to calculate the product of every possible subarray and keep track of the maximum product.

Optimized Approach 1:
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    - Use two variables to track the maximum and minimum product at each step, since a negative number can turn a minimum product into a maximum product.

    class Solution {
        public int maxProduct(int[] nums) {
            long maxProduct = nums[0];
            long minProduct = nums[0];
            long result = nums[0];
            
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    long temp = maxProduct;
                    maxProduct = minProduct;
                    minProduct = temp;
                }
                
                maxProduct = Math.max((long)nums[i], maxProduct * nums[i]);
                minProduct = Math.min((long)nums[i], minProduct * nums[i]);
                
                result = Math.max(result, maxProduct);
            }
            
            return (int)result;
        }
    }
