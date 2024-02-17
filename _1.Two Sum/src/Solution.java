import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums = [2,7,11,15], target = 9
        // nums = [3, 3], target = 6
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}