import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        HashSet<Integer> isWidthOverlap = new HashSet<>();
        HashSet<Integer> isStemOverlap = new HashSet<>();

        Arrays.sort(nums);

        doBacktrack(0, nums, isWidthOverlap, isStemOverlap, res, element);

        return res;
    }

    private void doBacktrack(int start, int[] nums, HashSet<Integer> isWidthOverlap, HashSet<Integer> isStemOverlap, List<List<Integer>> res, List<Integer> element) {
        if (element.size() == nums.length) {
            res.add(new ArrayList<>(element));
            return ;
        }

        // 1 2 2 2 3
        //
        for (int index = 0; index < nums.length; index++)
        {
            //index %= nums.length;

            if (index > start && nums[index - 1] == nums[index]) {
                continue;
            }

            if (isWidthOverlap.contains(index) ) {
                continue;
            }

            element.add(nums[index]);
            isWidthOverlap.add(index);

            // 課程
            doBacktrack(index + 1, nums, isWidthOverlap, isStemOverlap, res, element);

            element.remove(element.size() - 1);
            isWidthOverlap.remove(index);
        }
    }
}