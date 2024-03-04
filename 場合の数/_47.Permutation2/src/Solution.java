import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        boolean[] isOverlap = new boolean[nums.length];

        Arrays.sort(nums);

        doBacktrack(nums, isOverlap, res, element);

        return res;
    }

    private void doBacktrack(int[] nums, boolean[] isOverlap, List<List<Integer>> res, List<Integer> element) {
        // { 1, 1, 3, 4}
        if (element.size() == nums.length) {
            res.add(new ArrayList<>(element));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
//            int[] nums = {1, 1, 2, 3};
            if (isOverlap[i] == true) {
                continue;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            element.add(nums[i]);
            isOverlap[i] = true;

            doBacktrack(nums, isOverlap, res, element);

            element.remove(element.size() - 1);
            isOverlap[i] = false;
        }
    }
}