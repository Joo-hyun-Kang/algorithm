import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 2, 2, 4};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);

        }

    }
}