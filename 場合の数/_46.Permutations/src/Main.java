import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        Solution sol = new Solution();
        List<List<Integer>> combine = sol.permute(array);

        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
    }
}