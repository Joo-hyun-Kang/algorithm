import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 2, 1};

        List<List<Integer>> lists = sol.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}