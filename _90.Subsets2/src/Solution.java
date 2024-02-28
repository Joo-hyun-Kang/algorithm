import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // 重複の確認ため、ソート
        Arrays.sort(nums);

        getOverlappHandleBacktracking(nums, 0, res, path);

        return res;
    }

    private void getOverlappHandleBacktracking(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {
        //　パスを登録する
        res.add(new ArrayList<>(path));

        //　幅の探索する
        for (int i = start; i < nums.length; i++) {
            //　重複ノード削除
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }

            //　パスを記録
            path.add(nums[i]);

            // 深さの探索する：再帰を利用する
            getOverlappHandleBacktracking(nums, i + 1, res, path);

            //　配列のはてにいらない要素削除
            path.remove(path.size() - 1);
        }
    }
}
