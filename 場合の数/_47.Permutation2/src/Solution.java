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

        for (int index = 0; index < nums.length; index++)
        {
            if (isWidthOverlap.contains(index)) {
                continue;
            }
            // 1 2 3 4

            // Subset2のstartによって始まりを決めてはいけない
            // この場合配列のあらゆる値を巡回しないといけないので
            // !isWidthOverlap.contains(index - 1)　ー＞　上位のノードに属してるかないか見分けてくれる
            if (index > 0 && !isWidthOverlap.contains(index - 1)) {
                if (nums[index - 1] == nums[index]) {
                    continue;
                }
            }

            element.add(nums[index]);
            isWidthOverlap.add(index);

            // こっちでfor loop -> for loopはトーリの幹を各段階ごと倍に増やす
            doBacktrack(nums, isWidthOverlap, res, element);

            element.remove(element.size() - 1);
            isWidthOverlap.remove(index);
        }
    }
}