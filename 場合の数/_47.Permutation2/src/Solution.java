import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        HashSet<Integer> isWidthOverlap = new HashSet<>();
        HashSet<Integer> isStemOverlap = new HashSet<>();

        doBacktrack(nums, isWidthOverlap, isStemOverlap, res, element);

        return res;
    }

    private void doBacktrack(int[] nums, HashSet<Integer> isWidthOverlap, HashSet<Integer> isStemOverlap, List<List<Integer>> res, List<Integer> element) {
        // { 1, 1, 3, 4}
        if (element.size() == nums.length) {
            res.add(new ArrayList<>(element));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
//            int[] nums = {1, 2, 2, 3};
//            3 2 2 1
//            int[] nums = {1, 1, 3};
            if (isWidthOverlap.size() == 0 && isStemOverlap.contains(nums[i])) {
                continue;
            }

            if (isWidthOverlap.size() == 0) {
                isStemOverlap.add(nums[i]);
            }

            if (isWidthOverlap.contains(i) ) {
                continue;
            }

            element.add(nums[i]);
            isWidthOverlap.add(i);

            doBacktrack(nums, isWidthOverlap, isStemOverlap, res, element);

            element.remove(element.size() - 1);
            isWidthOverlap.remove(i);
        }
    }
}