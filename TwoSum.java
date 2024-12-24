
public class TwoSum {
    public static void main(String[] args) {
        // Brute Force Approach O(n^2)
        int n = nums.length;
        for(int i=0; i<n;i ++){
            for(int j=i+1; j<n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1, -1};

        // sorting + 2 pointers + finding index O(nlogn + n + n)
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = 0;
        int right = n-1;
        while(left < right){
            int curSum = sorted[left] + sorted[right];
            if(curSum == target){
                break;
            } else if (curSum < target){
                left++;
            } else {
                right--;
            }
        }

        int[] ans = new int[] {-1,-1};
        for(int i=0; i<n; i++){
            if( ans[0] == -1 && sorted[left] == nums[i]){
                ans[0] = i;
            }
            else if(ans[1] == -1 && sorted[right] == nums[i]){
                ans[1] = i;
            }
        }
        return ans;

        // Hashmap O(n)
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                return new int[] {i, hm.get(target-nums[i])};
            }
            hm.put(nums[i], i);
        }
        return new int[] {0,0};
    }
}