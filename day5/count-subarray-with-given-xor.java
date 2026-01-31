// https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor

Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Use two nested loops to consider all subarrays and calculate their XOR.

    class Solution {
        public long subarrayXor(int arr[], int k) {
            // code here
            long ans = 0;
            int n = arr.length;
            
            for(int i=0; i<n; i++){
                int xor = 0;
                for(int j=i; j<n; j++){
                    xor = xor ^ arr[j];
                    if(xor == k){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

Optimized Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    - Use a HashMap to store the cumulative XOR frequencies.

    class Solution {
        public long subarrayXor(int arr[], int k) {
            // code here
            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(0, 1); // default value so that when i get prefix xor = k i count it as one
            int prefixXor = 0;
            long ans = 0;
            for(int i=0; i<arr.length; i++){
                prefixXor = prefixXor ^ arr[i];
                ans += hm.getOrDefault(prefixXor ^ k, 0);
                hm.put(prefixXor, hm.getOrDefault(prefixXor, 0)+1);
            }
            return ans;
        }
    }