import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> element = new ArrayList<>();

        HashSet<Integer> isWidthOverlap = new HashSet<>();
        Arrays.sort(nums);

        doBacktrack(nums, isWidthOverlap, res, element);

        return res;
    }

    private void doBacktrack(int[] nums, HashSet<Integer> isWidthOverlap, List<List<Integer>> res, List<Integer> element) {
        if (element.size() == nums.length) {
            res.add(new ArrayList<>(element));
            return ;
        }

        // 1 2 2 2 3
        boolean isStartOn = false;
        for (int index = 0; index < nums.length; index++)
        {
            if (isWidthOverlap.contains(index)) {
                continue;
            }

            // 含めている？　ー＞　!isWidthOverlap.contains(index - 1)　
            if (index > 0 && !isWidthOverlap.contains(index - 1)) {
                if (nums[index - 1] == nums[index]) {
                    continue;
                }
            }

            element.add(nums[index]);
            isWidthOverlap.add(index);

            // startはすすんてる　→ 事実上のstartポイント　伝えば
            // こっちでfor loop?
            doBacktrack(nums, isWidthOverlap, res, element);

            element.remove(element.size() - 1);
            isWidthOverlap.remove(index);
        }
    }
}