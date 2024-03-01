import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(nums, 0, path, res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        // 現在のパスのコピーを会のリストに追加
        res.add(new ArrayList<>(path));

        // [1, 2, 3, 4]

        //　配列の残りの要素についてループ
        for (int i = start; i < nums.length; i++) {
            //　現在の予想をパスに追加
            path.add(nums[i]);

            //　次の要素を選択するために再帰的にバックトラック
            backtrack(nums, i + 1, path, res);

            // パックトラック：最後に追加した要素をパスから削除
            path.remove(path.size() - 1);
        }

        // バックトラック　ー＞　ただ　再帰の一部分？？？　何が違い？
        //　再帰を利用して渦巻きように下のくりかえるループを作る
    }
}