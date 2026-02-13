// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Use two nested loops to calculate the XOR of every possible pair and keep track of the maximum XOR.

    class Solution {
        public int findMaximumXOR(int[] nums) {
            int n = nums.length;
            int ans = 0;

            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    ans = Math.max(ans, nums[i] ^ nums[j]);
                }
            }

            return ans;
        }
    }

Optimized Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a Trie (prefix tree) to store the binary representation of the numbers. For each number, we try to find the maximum XOR by traversing the Trie in a way that we always try to take the opposite bit if it exists, which would contribute to a higher XOR value.
    
    class Solution {
        static class Trie {
            Trie[] children = new Trie[2];
        }

        public int findMaximumXOR(int[] nums) {
            Trie root = new Trie();
            int max = 0;

            insert(root, nums[0]);

            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, query(root, nums[i]));
                insert(root, nums[i]);
            }

            return max;
        }

        private void insert(Trie root, int num) {
            Trie node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.children[bit] == null) {
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
            }
        }

        private int query(Trie root, int num) {
            Trie node = root;
            int maxXor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = 1 - bit;

                if (node.children[opposite] != null) {
                    maxXor |= (1 << i);
                    node = node.children[opposite];
                } else {
                    node = node.children[bit];
                }
            }

            return maxXor;
        }
    }