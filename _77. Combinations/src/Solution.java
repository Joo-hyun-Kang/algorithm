import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> element = new ArrayList<>();

        getBacktrack(1, n, 0, k, res, element);

        return res;
    }

    private void getBacktrack(int start, int end, int current, int maxDepths, List<List<Integer>> res, List<Integer> element) {
        if (current == maxDepths) {
            res.add(new ArrayList<>(element));
            return ;
        }

        for (int i = start; i <= end; i++) {
            element.add(i);

            getBacktrack(i + 1, end, current + 1, maxDepths, res, element);

            element.remove(element.size() - 1);
        }

    }
}