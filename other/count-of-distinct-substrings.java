// https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1


Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    - Generate all possible substrings and store them in a HashSet to count distinct substrings.

    class Solution {
        public static int countSubs(String s) {
            int n = s.length();
            HashSet<String> hs = new HashSet<>();
            
            for(int i=0; i<n; i++){
                for(int j=i; j<n; j++){
                    hs.add(s.substring(i, j+1));
                }
            }
            
            return hs.size();
        }
    }


Optimized Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)
    - Use a Trie (prefix tree) to store substrings. Each time we insert a new substring, we increment the count of distinct substrings.

    class Solution {
        static class Trie {
            Trie[] children = new Trie[26];
        }

        public static int countSubs(String s) {
            int n = s.length();
            int count = 0;
            Trie root = new Trie();


            for (int i = 0; i < n; i++) {
                Trie curr = root;
                
                for (int j = i; j < n; j++) {
                    int index = s.charAt(j) - 'a';
                    
                    if (curr.children[index] == null) {
                        curr.children[index] = new Trie();
                        count++;
                    }
                    
                    curr = curr.children[index];
                }
            }

            return count;
        }
    }