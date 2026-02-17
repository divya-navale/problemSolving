// https://leetcode.com/problems/3sum/description/

Brute Force Approach:
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    - Use three nested loops to check every possible triplet and add those whose sum is zero to a set to avoid duplicates.

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> hs = new HashSet<>();
            int n = nums.length;

            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    for(int k=j+1; k<n; k++){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> ans = new ArrayList<>();
                            ans.add(nums[i]);
                            ans.add(nums[j]);
                            ans.add(nums[k]);
                            Collections.sort(ans);
                            hs.add(ans);
                        }
                    }
                }
            }

            return new ArrayList<>(hs);
        }
    }

Optimized Approach (Two Pointers):
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    - Sort the array and use two pointers to find pairs that sum up to the negative of the current element.

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> hs = new HashSet<>();
            int n = nums.length;

            Arrays.sort(nums);

            for(int i=0; i<n; i++){
                int p1 = i+1;
                int p2 = n-1;

                while(p1 < p2){
                    if(nums[p1] + nums[p2] + nums[i] == 0){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[p1]);
                        ans.add(nums[p2]);
                        Collections.sort(ans);
                        hs.add(ans);
                        p1++;
                        p2--;
                    } else if (nums[p1] + nums[p2] + nums[i] < 0){
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }

            return new ArrayList<>(hs);
        }
    }


Optimized Approach 2:
    // Time Complexity: O(n^2 log n)
    // Space Complexity: O(1)
    // binary search + two loops

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> hs = new HashSet<>();
            int n = nums.length;

            Arrays.sort(nums);

            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    int k = binarySearch(nums, j+1, n-1, -(nums[i] + nums[j]));
                    if(k != -1){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        Collections.sort(ans);
                        hs.add(ans);
                    }
                }
            }

            return new ArrayList<>(hs);
        }

        public int binarySearch(int[] nums, int low, int high, int target){
            while(low <= high){
                int mid = (low + high)/2;

                if(nums[mid] == target){
                    return mid;
                } else if(nums[mid] < target){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }

            return -1;
        }
    }

