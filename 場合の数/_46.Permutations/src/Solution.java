import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();

        boolean[] flags = new boolean[nums.length];

        Backtrack(nums, res, elements, flags);
        return res;
    }

    private void Backtrack(int[] nums, List<List<Integer>> res, List<Integer> elements, boolean[] flags) {
        if (elements.size() == nums.length) {
            res.add(new ArrayList<>(elements));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (flags[i] == true) {
                continue;
            }

            elements.add(nums[i]);

            flags[i] = true;

            Backtrack(nums, res, elements, flags);

            elements.remove(elements.size() - 1);

            flags[i] = false;
        }
    }
}
