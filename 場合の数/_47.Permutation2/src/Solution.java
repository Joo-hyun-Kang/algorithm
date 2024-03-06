import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        HashSet<Integer> isWidthOverlap = new HashSet<>();
        HashSet<Integer> isStemOverlap = new HashSet<>();

        Arrays.sort(nums);

        doBacktrack(nums, isWidthOverlap, isStemOverlap, res, element);

        return res;
    }

    private void doBacktrack(int[] nums, HashSet<Integer> isWidthOverlap, HashSet<Integer> isStemOverlap, List<List<Integer>> res, List<Integer> element) {
        if (element.size() == nums.length) {
            res.add(new ArrayList<>(element));
            return ;
        }

        // 1 2 2 2 3
        boolean isStartOn = false;
        int start = -1;
        for (int index = 0; index < nums.length; index++)
        {
            if (isWidthOverlap.contains(index)) {
                continue;
            } else if (!isStartOn) {
                start = index;
                isStartOn = true;
            }

            // 含めている？　ー＞　!isWidthOverlap.contains(index - 1)　
            if (isStartOn && index > start && !isWidthOverlap.contains(index - 1)) {
                if (nums[index - 1] == nums[index]) {
                    continue;
                }
            }

            element.add(nums[index]);
            isWidthOverlap.add(index);

            // startはすすんてる　→ 事実上のstartポイント　伝えば
            // こっちでfor loop?
            doBacktrack(nums, isWidthOverlap, isStemOverlap, res, element);

            element.remove(element.size() - 1);
            isWidthOverlap.remove(index);
        }
    }
}