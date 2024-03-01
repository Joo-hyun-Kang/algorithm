import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> combine = sol.combine(5, 3);

        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
    }
}