import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 2, 3};

        List<List<Integer>> lists = sol.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}