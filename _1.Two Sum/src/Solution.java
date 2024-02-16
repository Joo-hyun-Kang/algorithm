class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums = [2,7,11,15], target = 9

        int index1 = 0;
        int index2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j])    {
                    index1 = i;
                    index2 = j;
                }
            }
        }

        return new int[]{index1, index2};
    }
}